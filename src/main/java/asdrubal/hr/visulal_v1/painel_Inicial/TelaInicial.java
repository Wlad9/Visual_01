package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.classes_auxiliares.OrdenaMatriz;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.filtros_corridas_mesmo_pareo.IdentificaCorridasMesmoPareo;
import asdrubal.hr.visulal_v1.filtros_corridas_mesmo_pareo.MontaObjetoFiltradoPorData;
import asdrubal.hr.visulal_v1.filtros_corridas_mesmo_pareo.MontaObjetoFiltradoPorRaia;
import asdrubal.hr.visulal_v1.filtros_corridas_mesmo_pareo.Raias_Filtro;
import asdrubal.hr.visulal_v1.frame1.MontaItensDoMenu;
import asdrubal.hr.visulal_v1.montadores.*;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.LeftPaddingCellRenderer;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.RightPaddingCellRenderer;
import asdrubal.hr.visulal_v1.services.*;
import asdrubal.hr.visulal_v1.tabPesquisaAux.AuxMontaSetNegritoCorridasComuns;
import asdrubal.hr.visulal_v1.tabPesquisaAux.AuxPesquisa_mk2;
import asdrubal.hr.visulal_v1.tabelas_class.*;
import asdrubal.hr.visulal_v1.z_TesteTabela.Tela_Analise2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TelaInicial extends JFrame {
    private final PareoService pareoService;
    private final CompetidorService competidorService;
    private final TempService tempService;
    private final IndicesService indicesService;
    private final CavaloService cavaloService;
    private final RaiaService raiaService;
    private final ButtonGroup radioGruop;

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
    private JButton bt_B;
    private JPanel jp_A;
    private JList jlPista;
    private JList jlDistancia;
    private JScrollPane scrollPista;
    private JScrollPane scrollDistancia;
    private JPanel jpDiv;
    private JButton btPesq_X;
    private JButton jbFiltroData;
    private JButton btFiltroRaia;
    private JRadioButton rb23P;
    private JRadioButton rb25;
    private JRadioButton rb24P;
    private JRadioButton rbTodos;
    private JButton btComparaCavalos;

    private JMenuBar menuBar;
    private JMenu programaMenu;
    private JMenuItem itemMenu;

    private Map<String, IndicesDTO> indices;
    private Map<Integer, DTO_JT_tabPareos> mapa1;
    private Map<Integer, DTO_TabelaCompetidores> mapa2;
    private Map<Integer, List<CompetidorDTO>> mapa3;
    private Map<Integer, List<CompetidorDTO>> mapa4;
    private Map<Integer, List<CompetidorDTO>> mapa6;
    private Object[][] dadosCavalosDoPareo;
    private IndicesDTO dtoIndices;
    private String[] titulosRaias;
    private String[] titulosPareos;
    private Set<Integer> negritoPareo;

    private int anoPesquisa;
    private Object[][] dadosMk3;
    private Object[][] dadosMk2;
    private String objEmUso = null;

    private DefaultTableCellRenderer centraliza = new DefaultTableCellRenderer();
    private RightPaddingCellRenderer alinhaDireita = new RightPaddingCellRenderer(15);
    private LeftPaddingCellRenderer alinhaEsquerda = new LeftPaddingCellRenderer(5);

    public TelaInicial(Map<Integer, ProgramaDTO> programasOpen, PareoService pareoService, CompetidorService competidorService,
                       TempService tempService, IndicesService indicesService, CavaloService cavaloService, RaiaService raiaService) {
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        this.tempService = tempService;
        this.indicesService = indicesService;
        this.cavaloService = cavaloService;
        this.raiaService = raiaService;
        setContentPane(contentPane);
        menuBar = new JMenuBar();
        programaMenu = new JMenu("Programas");

        radioGruop = new ButtonGroup();
        radioGruop.add(rb25);
        radioGruop.add(rb24P);
        radioGruop.add(rb23P);
        radioGruop.add(rbTodos);
        indices = indicesService.findAll();

//  Listener dos Botões----------------------------------------------------------------------
        btPareoListener();
        btAnalisaListener();
//        bt_B_Listener();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        montaMenu(programasOpen);// construtor do menuProgramas

        jlPista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jlDistancia.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        setResizable(true);
        setVisible(true);
        //        scrol1.setVisible(false);

        jbFiltroData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb25.isSelected()) {
                    anoPesquisa = 25;
                    System.out.println("AnoPesquisa:" + anoPesquisa);
                } else if (rb24P.isSelected()) {
                    anoPesquisa = 24;
                    System.out.println("AnoPesquisa:" + anoPesquisa);
                } else if (rb23P.isSelected()) {
                    anoPesquisa = 23;
                } else if (rbTodos.isSelected()) {
                    anoPesquisa = 0;
                }
                Object[][] dadosFiltradosPorData = montaObjetoFiltradoPorData();
            }
        });
//  Listener Botão Filtro RAIAS
        btFiltroRaia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> pistasLista = jlPista.getSelectedValuesList();
                List<String> distanciasLista = jlDistancia.getSelectedValuesList();
                List<String> raiasFiltro = Raias_Montador.raiasMk1(pistasLista, distanciasLista);
//                Tela_RaiasFiltro trf = new Tela_RaiasFiltro(mapa1);
                montaAnaliseDeRaias(raiasFiltro);

//                showMapa3();


//                 new PesquisaRaias_ConfiguraTabela2(tabela2, scroll2, dadosMk3, titulos, negrito, indices, nrColunas).configura();

//                tabela2 = new Tabela_AnalisePareos(dadosMk3, titulos, negrito, indices, nrColunas);
//                new TelaFiltroRaias(dadosMk3, titulos, tabela2, negrito, indices, 9, scroll2);//TODO=========
            }
        });
        btComparaCavalos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tela_Analise2 tabTeste2 = new Tela_Analise2(dadosCavalosDoPareo, mapa3, indices, competidorService, raiaService);
            }
        });
    }

    private Object[][] montaObjetoFiltradoPorData() {
        switch (objEmUso) {
            case "Mk2" -> {
                Object[][] dadosFiltradosPorData = MontaObjetoFiltradoPorData.filtra(dadosMk2, anoPesquisa, objEmUso);
                Set<Integer> negritoPareoFiltroAno = MontaObjetoFiltradoPorData.getNegrito();
                montaAnalisePareosComFiltroTempo(dadosFiltradosPorData, negritoPareoFiltroAno);
//                showDados(dadosFiltradosPorData);
            }
            case "Mk3" -> {
                Object[][] raiasFiltradasPorData = MontaObjetoFiltradoPorData.filtra(dadosMk3, anoPesquisa, objEmUso);
                Set<Integer> negritoRaiaFiltroAno = MontaObjetoFiltradoPorData.getNegrito();
//                showDados(raiasFiltradasPorData);
                montaAnaliseDeRaiasComFiltroTempo(raiasFiltradasPorData, negritoRaiaFiltroAno);
            }
        }
        return null;
    }

    private void montaAnalisePareosComFiltroTempo(Object[][] dadosFiltradosPorData, Set<Integer> negritoPareoFiltroAno) {
        int nrColunas = 10;
        tabela2 = new Tabela_AnalisePareos(dadosFiltradosPorData, titulosPareos, negritoPareoFiltroAno, indices, nrColunas, "Páreos", null);
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

    private void montaAnaliseDeRaiasComFiltroTempo(Object[][] dadosFiltradosPorData, Set<Integer> negritoRaiaFiltroAno) {
        int nrColunas = 11;
        tabela2 = new Tabela_AnalisePareos(dadosFiltradosPorData, titulosRaias, negritoRaiaFiltroAno, indices, nrColunas, "Raias");
        tabela2.setFont(new Font("Arial", Font.PLAIN, 12));
        tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela2.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabela2.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabela2.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabela2.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(6).setPreferredWidth(40);
        tabela2.getColumnModel().getColumn(7).setPreferredWidth(80);
        tabela2.getColumnModel().getColumn(8).setPreferredWidth(130);

        scroll2.setViewportView(tabela2);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    private void montaAnaliseDeRaias(List<String> raiasFiltro) {
        int nrColunas = 11;
        dadosMk3 = Raias_Filtro.filtroMk3(raiasFiltro, mapa3);
        if (dadosMk3.length > 0) {
            objEmUso = "Mk3";
            System.out.println("USANDO O Obeto:" + objEmUso);
        }
        titulosRaias = Raias_Filtro.getTitulo();
        Set<Integer> negritoRaias = MontaObjetoFiltradoPorRaia.getNegrito();
        tabela2 = new Tabela_AnalisePareos(dadosMk3, titulosRaias, negritoRaias, indices, nrColunas, "Raias", raiasFiltro);
        tabela2.setFont(new Font("Arial", Font.PLAIN, 12));
        tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela2.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabela2.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabela2.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabela2.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(6).setPreferredWidth(40);
        tabela2.getColumnModel().getColumn(7).setPreferredWidth(80);
        tabela2.getColumnModel().getColumn(8).setPreferredWidth(130);

        scroll2.setViewportView(tabela2);

        this.setVisible(true);
        this.revalidate();
        this.repaint();

    }

    private void btAnalisaListener() {
        btAnalisa.addActionListener(e -> montaAnalisePareos(mapa2));
    }

    private void btPareoListener() {//Compara. Corridas em comum entre to
        btPareo.addActionListener(e -> analisaCorridasEntreCompetidores());
//        btPareo.addActionListener(e -> new AnaliseEntreCompetidores(competidorService, mapa2
//                , cavaloService).inicia());
    }
/// //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void analisaCorridasEntreCompetidores() {//comparando corridas - isso é gambiarra
        showDados(dadosCavalosDoPareo);
//        for(Map.Entry<Integer, DTO_TabelaCompetidores> entry: mapa2.entrySet()){
//            System.out.println("\nidCavalo:"+entry.getKey());
//            System.out.println(entry.getValue());
//        }
        IdentificaCorridasMesmoPareo idcorridas = new IdentificaCorridasMesmoPareo(competidorService, raiaService, mapa2);
        Object[][] corridasComuns = idcorridas.pesquisa();
        montaTabelaComCorridasComuns(corridasComuns);
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
        OrdenaMatriz.ordenaPelaPrimeiraColuna(dadosCavalosDoPareo);//TODO ALTERAR MÉTODO RETIRAR OBJETO CRIADO
//        showDados(dadosOrdenados);
        Tabela_Competidores tabelaCompetidores = new Tabela_Competidores(dadosCavalosDoPareo, auxComp.getColunas());
        tabelaCompetidores.setRowSelectionAllowed(true);
        tabelaCompetidores.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrolTabComp.setViewportView(tabelaCompetidores);
//        contentPane.add(scrolTabComp);
        scrolTabComp.setVisible(true);
        contentPane.revalidate();
        contentPane.repaint();
        this.revalidate();
        this.repaint();
    }

    private void showDados(Object[][] dados) {
        System.out.println("\n\nShow ObjetoFiltrado");
        for (int i = 0; i < dados.length; i++) {
            System.out.print("Linha " + i + ": [");
            if (dados[i] != null) {
                for (int j = 0; j < dados[i].length; j++) {
                    System.out.print(dados[i][j]);
                    if (j < dados[i].length - 1) {
                        System.out.print(", ");
                    }
                }
            } else {
                System.out.print("null");
            }
            System.out.println("]");
        }
    }
//---------------------------- Tabela de corridas

    private void montaAnalisePareos(Map<Integer, DTO_TabelaCompetidores> mapa2) {
        int nrColunas = 10;
        mapa3 = new Mapa3_Montador(competidorService).montaMapa(mapa2);
        Mapa4_MontadorListaOrdenada mapa4Monta = new Mapa4_MontadorListaOrdenada();
        mapa4 = mapa4Monta.ordenaLista(mapa3);
        Map<Integer, List<CompetidorDTO>> mapa5 = mapa4Monta.getMapa5();
        OrdenaMapaPorDataDoPareo mapa6OderByData = new OrdenaMapaPorDataDoPareo();
        mapa6 = mapa6OderByData.ordena(mapa3);
        AuxPesquisa_mk2 auxMk2 = new AuxPesquisa_mk2(mapa6, dadosCavalosDoPareo, cavaloService);
        dadosMk2 = auxMk2.montaDadosDaTabela();
        if (dadosMk2.length > 0) {
            objEmUso = "Mk2";
            System.out.println("USANDO O Obeto:" + objEmUso);
        }
        titulosPareos = auxMk2.getTitulos();
        negritoPareo = auxMk2.getNegrito();
        tabela2 = new Tabela_AnalisePareos(dadosMk2, titulosPareos, negritoPareo, indices, nrColunas, "Páreos"
                , null);
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
    private void montaTabelaComCorridasComuns(Object[][] corridasComuns) {
        int nrColunas = 11;
        String[] titulo = new String[]{"Crono", "Pos", "Cavalo", "Data", "Jóquei", "Treinador", "Rateio","Prova","Corp","ER","Tempo"};
        Set<Integer> negrito = AuxMontaSetNegritoCorridasComuns.inicia(corridasComuns);
        tabela2 = new Tabela_AnalisePareos(corridasComuns, titulo, negrito, indices, nrColunas, "CorridasComuns", null);
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
        tabela2.getColumnModel().getColumn(10).setPreferredWidth(30);
        scroll2.setViewportView(tabela2);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    private void showMapa3() {
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa3.entrySet()) {
            System.out.println("\n-----------------------------idCavalo:" + entry.getKey());
            List<CompetidorDTO> lista = entry.getValue();
            lista.forEach(System.out::println);
        }
    }
}
