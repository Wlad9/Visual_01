package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.analise_de_corridas.AnaliseDePareo;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.frame1.MontaItensDoMenu;
import asdrubal.hr.visulal_v1.montadores.Mapa2Montador;
import asdrubal.hr.visulal_v1.montadores.Mapa3_Montador;
import asdrubal.hr.visulal_v1.montadores.Mapa4_MontadorListaOrdenada;
import asdrubal.hr.visulal_v1.montadores.Mapa6_OderByData;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.PareoService;
import asdrubal.hr.visulal_v1.services.TempService;
import asdrubal.hr.visulal_v1.tabPesquisaAux.AuxPesquisa_mk2;
import asdrubal.hr.visulal_v1.tabelas_class.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TelaInicial extends JFrame {
    private final PareoService pareoService;
    private final CompetidorService competidorService;
    private final TempService tempService;

    private JPanel contentPane;
    private JScrollPane scrolTabPareos;
    private JTable tabPareos;
    private JButton btPareo;
    private JButton btAnalisa;
    private JPanel tabCompetidores;
    private JScrollPane scrolTabComp;
    private JTable tabela2;
    private JScrollPane scroll2;

    private JMenuBar menuBar;
    private JMenu programaMenu;
    private JMenuItem itemMenu;

    private Map<Integer, DTO_JT_tabPareos> mapa1;
    private Map<Integer, DTO_TabelaCompetidores> mapa2;
    private Object[][] dadosCavalosDoPareo;

    public TelaInicial(List<ProgramaDTO> programasOpen, PareoService pareoService, CompetidorService competidorService, TempService tempService) {
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        this.tempService = tempService;
        setContentPane(contentPane);
        menuBar = new JMenuBar();
        programaMenu = new JMenu("Programas");
//        btPareoListener();
        btAnalisaListener();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        montaMenu(programasOpen);// construtor do menuProgramas

        setResizable(true);
        setVisible(true);
        //        scrol1.setVisible(false);
    }

    private void btAnalisaListener() {
        btAnalisa.addActionListener(e -> montaAnalisePareos(mapa2));
    }

//    private void btPareoListener() {
//        btPareo.addActionListener(e -> new AnaliseDePareo(competidorService, mapa2).inicia());
//    }


    private void montaMenu(List<ProgramaDTO> programasOpen) {
        Map<Integer, ProgramaDTO> mapaProgramas = new HashMap<>();
        MontaItensDoMenu menu = new MontaItensDoMenu();
        for (ProgramaDTO dto : programasOpen) {
            mapaProgramas.put(dto.getIdPrograma(), dto);
            JMenuItem item = new JMenuItem(menu.montaItemMenuPrograma(dto));
            item.setActionCommand(String.valueOf(dto.getIdPrograma()));
//  Menu Listener
            item.addActionListener(e -> {
                Integer idSelecionado = Integer.valueOf(e.getActionCommand());
                ProgramaDTO programaSelecionadoDTO = mapaProgramas.get(idSelecionado);
                String listaIds = programaSelecionadoDTO.getStringIds();
                AuxTabPareos aux = new AuxTabPareos(pareoService);
                aux.preparaDados(listaIds);
                mapa1 = aux.getMapa1();
                prepTabPareos(aux.getDadosTabela(), aux.getColunas());
            });
            programaMenu.add(item);
            programaMenu.addSeparator();
        }
        JMenuItem itemSair = new JMenuItem("Fim");
        itemSair.addActionListener(e -> System.exit(0));
        programaMenu.add(itemSair);
        menuBar.add(programaMenu);
        setJMenuBar(menuBar);

    }

    private void prepTabPareos(Object[][] dados, String[] colunas) {
        tabPareos = new Tabela_Pareos(dados, colunas);
        tabPareos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        scrolTabPareos.setViewportView(tabPareos);
        scrolTabPareos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrolTabPareos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

//        tabPareos.setPreferredScrollableViewportSize(new Dimension(600, 400));
        tabPareos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Ignora eventos múltiplos durante uma única seleção
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tabPareos.getSelectedRow();
                    if (selectedRow != -1) {
                        // Código a ser executado quando uma linha é selecionada
                        Integer ordem = (Integer) dados[selectedRow][0];
                        DTO_JT_tabPareos dto = mapa1.get(ordem);
                        Integer idPareo = dto.getIdPareo();
                        Integer idPrograma = dto.getIdPrograma();
                        btPareo.setVisible(true);
                        preparaTabelaCompetidores(idPareo, idPrograma);

                    }
                }
            }
        });


        contentPane.revalidate();
        contentPane.repaint();
        this.revalidate();  // <- revalida o JFrame (a própria janela)
        this.repaint();

//        scrol2PaneTabela.revalidate();
//        scrol2PaneTabela.repaint();
//        System.out.println("panelTabelaPareos visible: " + panelTabelaPareos.isShowing());
//        System.out.println("scrol2PaneTabela visible: " + scrol2PaneTabela.isShowing());
    }

    private void preparaTabelaCompetidores(Integer idPareo, Integer idPrograma) {
        Mapa2Montador mapa2Montador = new Mapa2Montador();
        mapa2 = mapa2Montador.montaMapa2(tempService, idPareo, idPrograma);
        AuxTabCompetidores auxComp = new AuxTabCompetidores(mapa2);
        dadosCavalosDoPareo = auxComp.preparaDados();
        Tabela_Competidores tabelaCompetidores = new Tabela_Competidores(dadosCavalosDoPareo, auxComp.getColunas());
        scrolTabComp.setViewportView(tabelaCompetidores);
//        contentPane.add(scrolTabComp);
        scrolTabComp.setVisible(true);
        contentPane.revalidate();
        contentPane.repaint();
        this.revalidate();
        this.repaint();
    }
//---------------------------- Tabela de corridas

    private void montaAnalisePareos(Map<Integer, DTO_TabelaCompetidores> mapa2) {
        Map<Integer, List<CompetidorDTO>> mapa3 = new Mapa3_Montador(competidorService).montaMapa(mapa2);
        Mapa4_MontadorListaOrdenada mapa4Monta = new Mapa4_MontadorListaOrdenada();
        Map<Integer, List<CompetidorDTO>> mapa4 = mapa4Monta.ordenaLista(mapa3);
        Map<Integer, List<CompetidorDTO>> mapa5 = mapa4Monta.getMapa5();
        Mapa6_OderByData mapa6OderByData = new Mapa6_OderByData();
        Map<Integer, List<CompetidorDTO>> mapa6 = mapa6OderByData.ordena(mapa3);
        AuxPesquisa_mk2 auxMk2 = new AuxPesquisa_mk2(mapa6, dadosCavalosDoPareo);
        String[] titulos = auxMk2.getTitulos();
        Object[][] dadosMk2 = auxMk2.montaDadosDaTabela();
        Set<Integer> negrito = auxMk2.getNegrito();
//        tabela2 = new JTable(dadosMk2, titulos);
        tabela2 = new Tabela_AnalisePareos(dadosMk2, titulos, negrito);
        tabela2.setFont(new Font("Arial", Font.PLAIN, 10));
        tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela2.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabela2.getColumnModel().getColumn(1).setPreferredWidth(90);
        tabela2.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabela2.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela2.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabela2.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(6).setPreferredWidth(100);
        scroll2.setViewportView(tabela2);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
}
