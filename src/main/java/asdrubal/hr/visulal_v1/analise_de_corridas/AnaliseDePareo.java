package asdrubal.hr.visulal_v1.analise_de_corridas;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.montadores.Mapa3_Montador;
import asdrubal.hr.visulal_v1.montadores.Mapa4_MontadorListaOrdenada;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.LeftPaddingCellRenderer;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.RightPaddingCellRenderer;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.tabPesquisaAux.AuxiliarPesquisa_mk1;
import org.hibernate.boot.model.internal.XMLContext;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class AnaliseDePareo extends JFrame {
    private final CompetidorService competidorService;
    private final Map<Integer, DTO_TabelaCompetidores> mapa2;
    private JPanel contentPane;
    private JTable tabAnalise;
    private JScrollPane scrolTabAnalise1;
    private Map<Integer, List<CompetidorDTO>> mapa3;
    private RightPaddingCellRenderer alinhaDireita = new RightPaddingCellRenderer(5);
    private LeftPaddingCellRenderer alinhaEsquerda = new LeftPaddingCellRenderer(5);
    private DefaultTableCellRenderer centraliza = new DefaultTableCellRenderer();

    public AnaliseDePareo(CompetidorService competidorService, Map<Integer, DTO_TabelaCompetidores> mapa2) {
        this.competidorService = competidorService;
        this.mapa2 = mapa2;
        setContentPane(contentPane);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        alinhaDireita.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        alinhaEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
        alinhaEsquerda.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        centraliza.setHorizontalAlignment(SwingConstants.CENTER);
        setResizable(true);

    }

    public void inicia() {
        mapa3 = new Mapa3_Montador(competidorService).montaMapa(mapa2);
        Mapa4_MontadorListaOrdenada mapa4Monta = new Mapa4_MontadorListaOrdenada();
        Map<Integer, List<CompetidorDTO>> mapa4 = mapa4Monta.ordenaLista(mapa3);
        Map<Integer, List<CompetidorDTO>> mapa5 = mapa4Monta.getMapa5();
        AuxiliarPesquisa_mk1 mk1 = new AuxiliarPesquisa_mk1(mapa4, mapa5);
        String[] titulos = mk1.getTitulos();
        Object[][] dadosPesquisaMk1 = mk1.montaDadosMk1();
        tabAnalise = new JTable(dadosPesquisaMk1, titulos);
        tabAnalise.setFont(new Font("Arial", Font.PLAIN, 12));
        tabAnalise.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabAnalise.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabAnalise.getColumnModel().getColumn(1).setPreferredWidth(90);
        tabAnalise.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabAnalise.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabAnalise.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabAnalise.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabAnalise.getColumnModel().getColumn(6).setPreferredWidth(100);
//        tabAnalise.getColumnModel().getColumn(7).setPreferredWidth(6);
//        tabAnalise.getColumnModel().getColumn(8).setPreferredWidth(6);
//        tabAnalise.getColumnModel().getColumn(9).setPreferredWidth(10);

        tabAnalise.getColumnModel().getColumn(0).setCellRenderer(alinhaDireita);
//
//        tabAnalise.getColumnModel().getColumn(2).setPreferredWidth(15);


        scrolTabAnalise1.setViewportView(tabAnalise);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

}
