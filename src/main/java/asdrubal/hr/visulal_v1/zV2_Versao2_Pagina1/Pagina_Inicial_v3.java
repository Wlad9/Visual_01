package asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1;

import asdrubal.hr.visulal_v1.classes_auxiliares.OrdenaMatriz;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.frame1.MontaItensDoMenu;
import asdrubal.hr.visulal_v1.montadores.Mapa2Montador;
import asdrubal.hr.visulal_v1.painel_Inicial.TituloPagina;
import asdrubal.hr.visulal_v1.services.*;
import asdrubal.hr.visulal_v1.tabelas_class.AuxTabCompetidores;
import asdrubal.hr.visulal_v1.tabelas_class.AuxTabPareos;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_Competidores;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_Pareos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Pagina_Inicial_v3 extends JFrame {
    private final Map<Integer, ProgramaDTO> openPrograms;
    private final PareoService pareoService;
    private final CompetidorService competidorService;
    private final TempService tempService;
    private final IndicesService indicesService;
    private final CavaloService cavaloService;
    private final RaiaService raiaService;
    private final RegistroService registroService;
    private final AnaliseService analiseService;
    private JPanel contentPane;
    private JButton bt_Pareos;
    private JTable tb_Pareos;
    private JTable tb_Corridas;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JPanel jp_Pareos;
    private JScrollPane sc_TabPareos;
    private JPanel jp_Corridas;
    private JScrollPane js_Corridas;
    private JPanel jp_Filtros;
    private JScrollPane js_Filtros;

    private JMenuBar menuBar;
    private JMenu programaMenu;
    private JMenuItem itemMenu;
    private ButtonGroup radioGruop;

    private Map<Integer, DTO_JT_tabPareos> mapa1;
    private Map<Integer, DTO_TabelaCompetidores> mapa2;
    private Map<Integer, List<CompetidorDTO>> mapa3;
    private Map<Integer, List<CompetidorDTO>> mapa4;
    private Map<Integer, List<CompetidorDTO>> mapa6;

    private Object[][] dadosCavalosDoPareo;

    //  Dados da tabela de páreos.
    private Object[][] dadosDaTabelaPareo;
    private String[] dadosColunasTabelaPareo;

    private String titPag;// título da página
    private DTO_JT_tabPareos dtoJtPareos;

    private String txt1_BtPareos = "Selecione um dos PÁREOS";
    private String txt2_BtPareos = "Retornar para a lista de PROGRAMAS";

    public Pagina_Inicial_v3(Map<Integer, ProgramaDTO> openPrograms, PareoService pareoService, CompetidorService competidorService, TempService tempService, IndicesService indicesService, CavaloService cavaloService, RaiaService raiaService, RegistroService registroService, AnaliseService analiseService) {
        this.openPrograms = openPrograms;
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        this.tempService = tempService;
        this.indicesService = indicesService;
        this.cavaloService = cavaloService;
        this.raiaService = raiaService;
        this.registroService = registroService;
        this.analiseService = analiseService;

        setContentPane(contentPane);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        programaMenu = new JMenu("PROGRAMAS");

        radioGruop = new ButtonGroup();

        bt_Pareos.setEnabled(false);
        // construtor do menuProgramas
        montaMenu(openPrograms);// construtor do menuProgramas
        setResizable(true);
        setVisible(true);

        //  Listener do Botão bt_Pareos
        bt_Pareos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_Pareos.setText(txt1_BtPareos);
                bt_Pareos.setEnabled(false);
                prepTabPareos(dadosDaTabelaPareo, dadosColunasTabelaPareo);
            }
        });
    }

    private void montaMenu(Map<Integer, ProgramaDTO> programasOpen) {
        MontaItensDoMenu menu = new MontaItensDoMenu();
        for (Integer idPrograma : programasOpen.keySet()) {
            ProgramaDTO dto = programasOpen.get(idPrograma);
            JMenuItem item = new JMenuItem(menu.montaItemMenuPrograma(dto));
            item.setActionCommand(String.valueOf(dto.getIdPrograma()));
//  Menu Listener
            item.addActionListener(e -> {
                bt_Pareos.setText(txt1_BtPareos);
                Integer idSelecionado = Integer.valueOf(e.getActionCommand());
                ProgramaDTO programaSelecionadoDTO = programasOpen.get(idSelecionado);
                String listaIds = programaSelecionadoDTO.getStringIds();
                AuxTabPareos aux = new AuxTabPareos(pareoService);
                aux.preparaDados(listaIds);
                mapa1 = aux.getMapa1();
                dadosDaTabelaPareo = aux.getDadosTabela();
                dadosColunasTabelaPareo = aux.getColunas();
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
    }// Fim montaMenu()

    private void prepTabPareos(Object[][] dados, String[] colunas) {
        tb_Pareos = new Tabela_Pareos(dados, colunas);
        tb_Pareos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        sc_TabPareos.setViewportView(tb_Pareos);
        sc_TabPareos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc_TabPareos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        tb_Pareos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                // Ignora eventos múltiplos durante uma única seleção
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tb_Pareos.getSelectedRow();
                    if (selectedRow != -1) {
                        // Código a ser executado quando uma linha é selecionada
                        Integer ordem = (Integer) dados[selectedRow][0];
                        dtoJtPareos = mapa1.get(ordem);
                        Integer idPareo = dtoJtPareos.getIdPareo();
                        Integer idPrograma = dtoJtPareos.getIdPrograma();
                        bt_Pareos.setEnabled(true);
                        bt_Pareos.setText(txt2_BtPareos);
                        titPag = new TituloPagina(dtoJtPareos).montaTitulo();// titulo da proxima pagina-----------------------
                        preparaTabelaComCavalosDoPareo(idPareo, idPrograma);
                    }
                }
            }
        });


        contentPane.revalidate();
        contentPane.repaint();
        this.revalidate();  // <- revalida o JFrame (a própria janela)
        this.repaint();
    }

    private void preparaTabelaComCavalosDoPareo(Integer idPareo, Integer idPrograma) {
        Mapa2Montador mapa2Montador = new Mapa2Montador();
        mapa2 = mapa2Montador.montaMapa2(tempService, idPareo, idPrograma);
//        Mapa2_Show.show(mapa2, "Dados Mapa2");
        AuxTabCompetidores auxComp = new AuxTabCompetidores(mapa2);
        dadosCavalosDoPareo = auxComp.preparaDados();
        OrdenaMatriz.ordenaPelaPrimeiraColuna(dadosCavalosDoPareo);//TODO ALTERAR MÉTODO RETIRAR OBJETO CRIADO
//        showDados(dadosOrdenados);
//        ShowObjectBiDim.show(dadosCavalosDoPareo, "dadosCavalosDoPareo ordenados");
        Tabela_Competidores tabelaCompetidores = new Tabela_Competidores(dadosCavalosDoPareo, auxComp.getColunas());
        tabelaCompetidores.setRowSelectionAllowed(true);
        tabelaCompetidores.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sc_TabPareos.setViewportView(tabelaCompetidores);
        sc_TabPareos.setVisible(true);
        contentPane.revalidate();
        contentPane.repaint();
        this.revalidate();
        this.repaint();
    }

}
