package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.analise_de_corridas.AnaliseDePareo;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.frame1.MontaItensDoMenu;
import asdrubal.hr.visulal_v1.montadores.Mapa2Montador;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.PareoService;
import asdrubal.hr.visulal_v1.services.TempService;
import asdrubal.hr.visulal_v1.tabelas_class.AuxTabCompetidores;
import asdrubal.hr.visulal_v1.tabelas_class.AuxTabPareos;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_Competidores;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_Pareos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private JMenuBar menuBar;
    private JMenu programaMenu;
    private JMenuItem itemMenu;

    private Map<Integer, DTO_JT_tabPareos> mapa1;
    private Map<Integer, DTO_TabelaCompetidores> mapa2;
    public TelaInicial(List<ProgramaDTO> programasOpen, PareoService pareoService, CompetidorService competidorService, TempService tempService) {
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        this.tempService = tempService;
        setContentPane(contentPane);
        menuBar = new JMenuBar();
        programaMenu = new JMenu("Programas");
        btPareoListener();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        montaMenu(programasOpen);// construtor do menuProgramas

        setResizable(true);
        setVisible(true);
        //        scrol1.setVisible(false);
    }

    private void btPareoListener() {
        btPareo.addActionListener(e-> new AnaliseDePareo(competidorService, mapa2).inicia());
    }



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
                aux.preparaDados(listaIds, idSelecionado);
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
                        // Para acessar os dados da linha selecionada:
                        // Object[] rowData = new Object[tabPareos.getColumnCount()];
                        // for (int i = 0; i < rowData.length; i++) {
                        //     rowData[i] = tabPareos.getValueAt(selectedRow, i);
                        //     System.out.println("Coluna " + i + ": " + rowData[i]);
                        // }

                        // Aqui você pode chamar outros métodos para processar a seleção
                        // Exemplo: exibir detalhes, habilitar botões, etc.
//                        processarSelecaoDaTabela(selectedRow);
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
        Object[][] dados = auxComp.preparaDados();
        Tabela_Competidores tabelaCompetidores = new Tabela_Competidores(dados, auxComp.getColunas());
        scrolTabComp.setViewportView(tabelaCompetidores);
//        contentPane.add(scrolTabComp);
        scrolTabComp.setVisible(true);
        contentPane.revalidate();
        contentPane.repaint();
        this.revalidate();
        this.repaint();
    }
}
