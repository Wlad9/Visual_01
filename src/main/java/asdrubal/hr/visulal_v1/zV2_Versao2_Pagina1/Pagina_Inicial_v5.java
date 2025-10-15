package asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1;

import asdrubal.hr.visulal_v1.CopiaDeObjetoBiDimensional;
import asdrubal.hr.visulal_v1.classes_auxiliares.OrdenaMatriz;
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
import asdrubal.hr.visulal_v1.painel_Inicial.TituloPagina;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.LeftPaddingCellRenderer;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.RightPaddingCellRenderer;
import asdrubal.hr.visulal_v1.services.*;
import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;
import asdrubal.hr.visulal_v1.tabPesquisaAux.AuxPesquisa_mk2_v2;
import asdrubal.hr.visulal_v1.tabelas_class.AuxTabCompetidores;
import asdrubal.hr.visulal_v1.tabelas_class.AuxTabPareos;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_Competidores;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_Pareos;
import asdrubal.hr.visulal_v1.zV2_ClassesAuxiliares.SeparaDadosFiltroP3;
import asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01.Pag_Filtros_01;
import asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01.Pag_Filtros_01_v2;
import asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01.Pag_Filtros_01_v3;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.Tabela_Dados_1.Tabela_Dados_1;
import asdrubal.hr.visulal_v1.z_V2_TelasDeFiltros.JFrame_Filtro_GramaAreia;
//import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.Tabela_Dados_1.Tabela_Dados_1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pagina_Inicial_v5 extends JFrame {
    private final Map<Integer, ProgramaDTO> openPrograms;
    private final PareoService pareoService;
    private final CompetidorService competidorService;
    private final TempService tempService;

    private final IndicesService indicesService;
    private final IndicesGV_Service indicesGVService;
    private final IndicesOutrosService indicesOutrosService;

    private final CavaloService cavaloService;
    private final RaiaService raiaService;
    private final RegistroService registroService;
    private final AnaliseService analiseService;
    private final IndicesCJ_Service indicesCJ_service;
    private final IndicesPR_Service indicesPR_service;
    private final IndicesRS_Service indicesRS_service;
    private JPanel contentPane;
    private JPanel jp_Pareos;
    private JPanel jp_Dados;
    private JScrollPane js_Pareos;
    private JPanel jp_Botoes;
    private JButton bt_Pareos;
    private JButton bt_Show_A;
    private JButton bt_Show_B;
    private JButton bt_Show_C;
    private JButton bt_Show_D;
    private JButton bt_Show_E;
    private JPanel jp_Filtros;
    private JScrollPane js_Filtros;


    private JTable tb_Pareos;
    private JTable tb_Dados_1;
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
    private String[] titulosRaias;
    private String[] titulosPareos;
    private Set<Integer> negritoPareo;

    private int anoPesquisa;
    private Object[][] dadosMk3;
    private Object[][] dadosMk2;
    private Object[][] dadosBase;
    private String objEmUso = null;

    private JTable tabela2;
    private JScrollPane js_Dados;
    private Map<String, IndicesDTO> indicesGeral;
    private Map<String, IndicesDTO> indicesGV;
    private Map<String, IndicesDTO> indicesCJ;
    private Map<String, IndicesDTO> indicesRS;
    private Map<String, IndicesDTO> indicesPR;
    private Map<String, IndicesDTO> indicesOutros;


    //  Dados da tabela de páreos.
    private Object[][] dadosDaTabelaPareo;
    private String[] dadosColunasTabelaPareo;

    private String titPag;// título da página
    private DTO_JT_tabPareos dtoJtPareos;
    private DefaultTableCellRenderer centraliza = new DefaultTableCellRenderer();
    private RightPaddingCellRenderer alinhaDireita = new RightPaddingCellRenderer(15);
    private LeftPaddingCellRenderer alinhaEsquerda = new LeftPaddingCellRenderer(5);

    private String txt1_BtPareos = "Selecione Páreo";
    private String txt2_BtPareos = "PROGRAMAS";

    private final String FILTRO_TIPO_P1 = "P1";//Usa IndieceGera.
    private final String FILTRO_TIPO_P2 = "P2";//Usa Indices por hipodrômo
    private final String FILTRO_TIPO_P3 = "P3";// Somente raias na Grama
    private final String FILTRO_TIPO_P4 = "P3";// Somente raias na Areia


    public Pagina_Inicial_v5(Map<Integer, ProgramaDTO> openPrograms, PareoService pareoService, CompetidorService competidorService,
                             TempService tempService, IndicesService indicesService, CavaloService cavaloService,
                             RaiaService raiaService, RegistroService registroService, AnaliseService analiseService,
                             IndicesGV_Service indicesGV_service, IndicesOutrosService indicesOutrosService,
                             IndicesCJ_Service indicesCJ_service, IndicesPR_Service indicesPR_service, IndicesRS_Service indicesRS_service) {
        this.openPrograms = openPrograms;
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        this.tempService = tempService;

        this.cavaloService = cavaloService;
        this.raiaService = raiaService;
        this.registroService = registroService;
        this.analiseService = analiseService;

        this.indicesService = indicesService;
        this.indicesGVService = indicesGV_service;
        this.indicesCJ_service = indicesCJ_service;
        this.indicesPR_service = indicesPR_service;
        this.indicesRS_service = indicesRS_service;
        this.indicesOutrosService = indicesOutrosService;

        setContentPane(contentPane);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        programaMenu = new JMenu("PROGRAMAS");

        radioGruop = new ButtonGroup();
        indicesGeral = indicesService.findAll();
        indicesGV = indicesGV_service.findAll();
        indicesCJ = indicesCJ_service.findAll();
        indicesRS = indicesRS_service.findAll();
        indicesPR = indicesPR_service.findAll();


//        System.out.println("Lista indices da gávea:" + indicesGV.size());
//        for (Map.Entry<String, IndicesDTO> entry : indicesGV.entrySet()) {
//            System.out.println("\n" + entry.getKey() + "\n" + entry.getValue());
//        }
//        System.out.println("Lista indices outros:"+indicesOutros.size());
//        indicesOutros = indicesOutrosService.findAll();
//        for(Map.Entry<String, IndicesDTO>entry:indicesOutros.entrySet()){
//            System.out.println("Raia_Outros:"+ entry.getKey()+"\n"+entry.getValue());
//        }
//        indicesGV = indicesGVService.findAll_Gavea();
//        indicesOutros = indicesService.findAll_Outros();

        bt_Pareos.setEnabled(false);
        // construtor do menuProgramas
        montaMenu(openPrograms);// construtor do menuProgramas
        setResizable(true);
        setVisible(true);
        bt_Pareos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt_Pareos.setText(txt1_BtPareos);
                bt_Pareos.setEnabled(false);
                prepTabPareos(dadosDaTabelaPareo, dadosColunasTabelaPareo);
            }
        });
        bt_Show_A.addActionListener(new ActionListener() {// Lista as corridas usando a tabela de indices
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBt_Show_A();//Listar as corridas dos animais do páreo
            }
        });
        bt_Show_D.addActionListener(new ActionListener() {// Lista as corridas usando a tabela de indices de cada hipo
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBt_Show_D();
            }
        });
        bt_Show_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtroSoGrama();
            }
        });
        bt_Show_C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtroSoAreia();
            }
        });
    }


    private void listenerBt_Show_A() {
        int nrColunas = 10;
        mapa3 = new Mapa3_Montador(competidorService).montaMapa(mapa2);
        Mapa4_MontadorListaOrdenada mapa4Monta = new Mapa4_MontadorListaOrdenada();
        mapa4 = mapa4Monta.ordenaLista(mapa3);
        Map<Integer, List<CompetidorDTO>> mapa5 = mapa4Monta.getMapa5();
        OrdenaMapaPorDataDoPareo mapa6OderByData = new OrdenaMapaPorDataDoPareo();
        mapa6 = mapa6OderByData.ordena(mapa3);
        ShowObjectBiDim.show(dadosCavalosDoPareo, "dadosCavalosDoPareo ordenados");
        AuxPesquisa_mk2_v2 auxMk2v2 = new AuxPesquisa_mk2_v2(mapa6, dadosCavalosDoPareo, cavaloService);
        dadosMk2 = auxMk2v2.montaObjeto();
        CopiaDeObjetoBiDimensional copiador = new CopiaDeObjetoBiDimensional(dadosMk2);
        dadosBase = copiador.makeDeepCopy();
        ShowObjectBiDim.show(dadosBase, "OBJETO CÓPIA>");
        titulosPareos = auxMk2v2.getTitulos();
        negritoPareo = auxMk2v2.getNegrito();

        ShowObjetoUniDim.show(titulosPareos, "titulos-------------------------");

        tb_Dados_1 = new Tabela_Dados_1(dadosMk2, titulosPareos, negritoPareo, FILTRO_TIPO_P1,
                indicesGeral, indicesGV, indicesPR, indicesRS, indicesCJ, indicesOutros);

        js_Dados.setViewportView(tb_Dados_1);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    private void listenerBt_Show_D() {
        ((Tabela_Dados_1) tb_Dados_1).aplicaFiltroTipoP2();
    }

    private void filtroSoGrama() {
        SeparaDadosFiltroP3 sp3 = new SeparaDadosFiltroP3(dadosBase);
        Object[][] dadosFiltradosSoGrama = sp3.aplicaFiltroSoGrama();

        JFrame_Filtro_GramaAreia criaJFrame = new JFrame_Filtro_GramaAreia(dadosFiltradosSoGrama, titulosPareos,
                indicesGeral, indicesGV, indicesPR, indicesRS, indicesCJ);
        criaJFrame.inicia();
    }

    private void filtroSoAreia() {
        SeparaDadosFiltroP3 sp3 = new SeparaDadosFiltroP3(dadosBase);
        Object[][] dadosFiltradosSoAreia = sp3.aplicaFiltroSoAreia();
        JFrame_Filtro_GramaAreia criaJFrame = new JFrame_Filtro_GramaAreia(dadosFiltradosSoAreia, titulosPareos,
                indicesGeral, indicesGV, indicesPR, indicesRS, indicesCJ);
        criaJFrame.inicia();
//
//        Pag_Filtros_01_v2 pagFiltros01V2 = new Pag_Filtros_01_v2(indicesGeral,
//                indicesGV, indicesPR, indicesRS, indicesCJ);
//        pagFiltros01V2.inicia_mk1(dadosFiltradosSoAreia, titulosPareos);
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

        js_Pareos.setViewportView(tb_Pareos);
        js_Pareos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        js_Pareos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

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
        js_Pareos.setViewportView(tabelaCompetidores);
        js_Pareos.setVisible(true);
        contentPane.revalidate();
        contentPane.repaint();
        this.revalidate();
        this.repaint();
    }
}
