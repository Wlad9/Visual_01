package asdrubal.hr.visulal_v1.Telas;

import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.frame1.MontaItensDoMenu;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.PareoService;
import asdrubal.hr.visulal_v1.services.TempService;
import asdrubal.hr.visulal_v1.tabelas_class.AuxTabPareos;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_Pareos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelaInicial_01 extends JFrame {
    private final List<ProgramaDTO> programasOpen;
    private final PareoService pareoService;
    private final CompetidorService competidorService;
    private final TempService tempService;
    private JPanel contentPane;
    private JPanel panelTabelaPareos;
    private JScrollPane scrol2PaneTabela;

    private JMenuBar menuBar;
    private JMenu programaMenu;
    private JMenuItem itemMenu;

    //    private JTable tabPareos;
    private JScrollPane scrolTabPareos;
    private DefaultTableModel dtmPareos;

    private final Map<Integer, ProgramaDTO> mapaProgramas = new HashMap<>();
    private String listaIds;

    public TelaInicial_01(List<ProgramaDTO> programasOpen, PareoService pareoService, CompetidorService competidorService, TempService tempService) {
        this.programasOpen = programasOpen;
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        this.tempService = tempService;

        menuBar = new JMenuBar();
        programaMenu = new JMenu("Programas");
        scrol2PaneTabela = new JScrollPane();
        setContentPane(contentPane);
//        contentPane.add(scrol2PaneTabela);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        montaMenu();

        this.setVisible(true);
        revalidate();
        repaint();

    }

    private void montaMenu() {
        MontaItensDoMenu menu = new MontaItensDoMenu();
        for (ProgramaDTO dto : programasOpen) {
            mapaProgramas.put(dto.getIdPrograma(), dto);
            JMenuItem item = new JMenuItem(menu.montaItemMenuPrograma(dto));
            item.setActionCommand(String.valueOf(dto.getIdPrograma()));
//  Menu Listener
            item.addActionListener(e -> {
                Integer idSelecionado = Integer.valueOf(e.getActionCommand());
                ProgramaDTO programaSelecionado = mapaProgramas.get(idSelecionado);
                listaIds = programaSelecionado.getStringIds();
                AuxTabPareos aux = new AuxTabPareos(pareoService);
                aux.preparaDados(listaIds, idSelecionado);
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
        Tabela_Pareos tabPareos = new Tabela_Pareos(dados, colunas);
        scrol2PaneTabela.setViewportView(tabPareos);

        panelTabelaPareos.setLayout(new BorderLayout());
        panelTabelaPareos.add(scrol2PaneTabela, BorderLayout.CENTER);

        scrol2PaneTabela.setVisible(true);
        panelTabelaPareos.setVisible(true);
        contentPane.revalidate();
        contentPane.repaint();
        this.revalidate();  // <- revalida o JFrame (a própria janela)
        this.repaint();

//        scrol2PaneTabela.revalidate();
//        scrol2PaneTabela.repaint();

//        if(scrolTabPareos != null){
//            contentPane.remove(scrolTabPareos);
//        }
//        scrolTabPareos = new JScrollPane(tabPareos);
//


//        panelTabelaPareos.removeAll();
//        panelTabelaPareos.setLayout(new BorderLayout()); // Define um layout adequado dentro do painel
//        panelTabelaPareos.add(scrolTabPareos);
//        contentPane.add(panelTabelaPareos);


//        setVisible(true);
//
//        contentPane.revalidate();
//        contentPane.repaint();
//        dtmPareos = new DefaultTableModel(colunasPareo, nrLineTabPareos);
    }

}
