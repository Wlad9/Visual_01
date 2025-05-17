package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.analise_de_corridas.AnaliseEntreCompetidores;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.frame1.MontaItensDoMenu;
import asdrubal.hr.visulal_v1.montadores.Mapa2Montador;
import asdrubal.hr.visulal_v1.montadores.Mapa3_Montador;
import asdrubal.hr.visulal_v1.montadores.Mapa4_MontadorListaOrdenada;
import asdrubal.hr.visulal_v1.montadores.OrdenaMapaPorDataDoPareo;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.LeftPaddingCellRenderer;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.RightPaddingCellRenderer;
import asdrubal.hr.visulal_v1.services.*;
import asdrubal.hr.visulal_v1.tabPesquisaAux.AuxPesquisa_Raias;
import asdrubal.hr.visulal_v1.tabPesquisaAux.AuxPesquisa_mk2;
import asdrubal.hr.visulal_v1.tabelas_class.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TelaInicial extends JFrame {
    private final PareoService pareoService;
    private final CompetidorService competidorService;
    private final TempService tempService;
    private final IndicesService indicesService;
    private final CavaloService cavaloService;

    private JPanel contentPane;
    private JScrollPane scrolTabPareos;
    private JTable tabPareos;
    private JButton btPareo;
    private JButton btAnalisa;
    private JPanel tabCompetidores;
    private JScrollPane scrolTabComp;
    private JTable tabela2;
    private JScrollPane scroll2;
    private JTextField txtPista;
    private JTextField txtDistancia;
    private JLabel lbPista;
    private JLabel lbDistancia;
    private JButton bt_A;
    private JButton bt_B;
    private JPanel jp_A;

    private JMenuBar menuBar;
    private JMenu programaMenu;
    private JMenuItem itemMenu;

    private Map<Integer, DTO_JT_tabPareos> mapa1;
    private Map<Integer, DTO_TabelaCompetidores> mapa2;
    private Map<Integer, List<CompetidorDTO>> mapa3;
    private Map<Integer, List<CompetidorDTO>> mapa4;
    private Map<Integer, List<CompetidorDTO>> mapa6;
    private Object[][] dadosCavalosDoPareo;
    private IndicesDTO dtoIndices;

    private DefaultTableCellRenderer centraliza = new DefaultTableCellRenderer();
    private RightPaddingCellRenderer alinhaDireita = new RightPaddingCellRenderer(15);
    private LeftPaddingCellRenderer alinhaEsquerda = new LeftPaddingCellRenderer(5);

    public TelaInicial(Map<Integer, ProgramaDTO> programasOpen, PareoService pareoService, CompetidorService competidorService,
                       TempService tempService, IndicesService indicesService, CavaloService cavaloService) {
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        this.tempService = tempService;
        this.indicesService = indicesService;
        this.cavaloService = cavaloService;
        setContentPane(contentPane);
        menuBar = new JMenuBar();
        programaMenu = new JMenu("Programas");
//  Listener dos Botões----------------------------------------------------------------------
        btPareoListener();
        btAnalisaListener();
        bt_B_Listener();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        montaMenu(programasOpen);// construtor do menuProgramas

        setResizable(true);
        setVisible(true);
        //        scrol1.setVisible(false);
    }

    private void bt_B_Listener() {//lista cavalos por raia e tempo
        bt_B.addActionListener(e -> montaPesquisaPorRaia());
    }

    private void montaPesquisaPorRaia() {
        String distancia = txtDistancia.getText();
        String pista = txtPista.getText();
        distancia = distancia.trim().toUpperCase();
        pista = pista.trim().toUpperCase();
        String raia = pista.concat(distancia);
        AuxPesquisa_Raias auxPesqRaias = new AuxPesquisa_Raias(mapa3, mapa4, mapa6, dadosCavalosDoPareo);
        Object[][] dadosMk3 = auxPesqRaias.inicia(raia);

        for (int i = 0; i < dadosMk3.length; i++) {
            System.out.print("Linha " + (i + 1) + ": [");
            for (int j = 0; j < dadosMk3[i].length; j++) {
                System.out.print(dadosMk3[i][j]);
                if (j < dadosMk3[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        String[] titulos = auxPesqRaias.getTitulos();
        System.out.println(titulos);
        System.out.println(dadosMk3);
//        tabela2 = new Tabela_AnalisePareos(dadosMk3, titulos);
//        tabela2.setFont(new Font("Arial", Font.PLAIN, 12));
//        tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tabela2.getColumnModel().getColumn(0).setPreferredWidth(120);
//        tabela2.getColumnModel().getColumn(1).setPreferredWidth(40);
//        tabela2.getColumnModel().getColumn(2).setPreferredWidth(80);
//        tabela2.getColumnModel().getColumn(3).setPreferredWidth(80);
//        tabela2.getColumnModel().getColumn(4).setPreferredWidth(80);
//        tabela2.getColumnModel().getColumn(5).setPreferredWidth(40);
//        tabela2.getColumnModel().getColumn(6).setPreferredWidth(100);
//        tabela2.getColumnModel().getColumn(7).setPreferredWidth(110);
//        tabela2.getColumnModel().getColumn(9).setPreferredWidth(30);
    }

    private void btAnalisaListener() {
        btAnalisa.addActionListener(e -> montaAnalisePareos(mapa2));
    }

    private void btPareoListener() {
//        btPareo.addActionListener(e -> new AnaliseDePareo(competidorService, mapa2).inicia());
        btPareo.addActionListener(e -> new AnaliseEntreCompetidores(competidorService, mapa2, cavaloService).inicia());
    }


    private void montaMenu(Map<Integer, ProgramaDTO> programasOpen) {
        MontaItensDoMenu menu = new MontaItensDoMenu();
        for (Integer idPrograma : programasOpen.keySet()) {
            ProgramaDTO dto = programasOpen.get(idPrograma);
            JMenuItem item = new JMenuItem(menu.montaItemMenuPrograma(dto));
            item.setActionCommand(String.valueOf(dto.getIdPrograma()));
//  Menu Listener
            item.addActionListener(e -> {
                Integer idSelecionado = Integer.valueOf(e.getActionCommand());
                ProgramaDTO programaSelecionadoDTO = programasOpen.get(idSelecionado);
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
        mapa3 = new Mapa3_Montador(competidorService).montaMapa(mapa2);
        Mapa4_MontadorListaOrdenada mapa4Monta = new Mapa4_MontadorListaOrdenada();
        mapa4 = mapa4Monta.ordenaLista(mapa3);
        Map<Integer, List<CompetidorDTO>> mapa5 = mapa4Monta.getMapa5();
        OrdenaMapaPorDataDoPareo mapa6OderByData = new OrdenaMapaPorDataDoPareo();
        mapa6 = mapa6OderByData.ordena(mapa3);
        AuxPesquisa_mk2 auxMk2 = new AuxPesquisa_mk2(mapa6, dadosCavalosDoPareo, cavaloService);
        Object[][] dadosMk2 = auxMk2.montaDadosDaTabela();
        String[] titulos = auxMk2.getTitulos();
        Set<Integer> negrito = auxMk2.getNegrito();
        Map<String, IndicesDTO> mapa1 = indicesService.findAll();
        tabela2 = new Tabela_AnalisePareos(dadosMk2, titulos, negrito, mapa1);
        tabela2.setFont(new Font("Arial", Font.PLAIN, 12));
        tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela2.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabela2.getColumnModel().getColumn(1).setPreferredWidth(40);
        tabela2.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabela2.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela2.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabela2.getColumnModel().getColumn(5).setPreferredWidth(40);
        tabela2.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(7).setPreferredWidth(110);
        tabela2.getColumnModel().getColumn(9).setPreferredWidth(30);

        centraliza.setHorizontalAlignment(SwingConstants.CENTER);
        alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        alinhaDireita.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        alinhaEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
        alinhaEsquerda.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

//        tabela2.getColumnModel().getColumn(0).setCellRenderer(alinhaDireita);
        tabela2.getColumnModel().getColumn(1).setCellRenderer(centraliza);// Pos
        tabela2.getColumnModel().getColumn(8).setCellRenderer(centraliza);//CorpoChegada
        tabela2.getColumnModel().getColumn(9).setCellRenderer(centraliza);// ER- EntradaReta
        tabela2.getColumnModel().getColumn(10).setCellRenderer(centraliza);//tempo

        scroll2.setViewportView(tabela2);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
}
