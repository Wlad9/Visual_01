package asdrubal.hr.visulal_v1.analise_de_corridas;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.montadores.Mapa3_Montador;
import asdrubal.hr.visulal_v1.montadores.Mapa4_MontadorListaOrdenada;
import asdrubal.hr.visulal_v1.montadores.OrdenaMapaPorDataDoPareo;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.LeftPaddingCellRenderer;
import asdrubal.hr.visulal_v1.propriedadesDaTabela.RightPaddingCellRenderer;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.tabPesquisaAux.AuxPesquisa_mk2;

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
    private JScrollPane scrolInfo;
    private JTable tabInfo;
    private Map<Integer, List<CompetidorDTO>> mapa3;
    private RightPaddingCellRenderer alinhaDireita = new RightPaddingCellRenderer(5);
    private LeftPaddingCellRenderer alinhaEsquerda = new LeftPaddingCellRenderer(5);
    private DefaultTableCellRenderer centraliza = new DefaultTableCellRenderer();

    public AnaliseDePareo(CompetidorService competidorService, Map<Integer, DTO_TabelaCompetidores> mapa2) {
        this.competidorService = competidorService;
        this.mapa2 = mapa2;
//        showMapa2();
        setContentPane(contentPane);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        alinhaDireita.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        alinhaEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
        alinhaEsquerda.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        centraliza.setHorizontalAlignment(SwingConstants.CENTER);
        setResizable(true);

    }

    public void inicia() {
        mapa3 = new Mapa3_Montador(competidorService).montaMapa(mapa2);

        Object [][] xxxxxx = new Object[2][2];//TODO acertad dados ENTRADA DE DADOS XXX
        Mapa4_MontadorListaOrdenada mapa4Monta = new Mapa4_MontadorListaOrdenada();
        Map<Integer, List<CompetidorDTO>> mapa4 = mapa4Monta.ordenaLista(mapa3);
        Map<Integer, List<CompetidorDTO>> mapa5 = mapa4Monta.getMapa5();
        OrdenaMapaPorDataDoPareo ordenaMapa = new OrdenaMapaPorDataDoPareo();
        Map<Integer, List<CompetidorDTO>> mapa6 = ordenaMapa.ordena(mapa3);
        AuxPesquisa_mk2 auxMk2 = new AuxPesquisa_mk2(mapa6, xxxxxx);
        String[] titulos = auxMk2.getTitulos();
        Object[][] dadosMk2 = auxMk2.montaDadosDaTabela();
        tabAnalise = new JTable(dadosMk2, titulos);
        tabAnalise.setFont(new Font("Arial", Font.PLAIN, 12));
        tabAnalise.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabAnalise.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabAnalise.getColumnModel().getColumn(1).setPreferredWidth(90);
        tabAnalise.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabAnalise.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabAnalise.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabAnalise.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabAnalise.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabAnalise.getColumnModel().getColumn(7).setPreferredWidth(6);
        tabAnalise.getColumnModel().getColumn(8).setPreferredWidth(6);
        tabAnalise.getColumnModel().getColumn(9).setPreferredWidth(5);
        tabAnalise.getColumnModel().getColumn(10).setPreferredWidth(10);
        tabAnalise.getColumnModel().getColumn(0).setCellRenderer(alinhaDireita);
        tabAnalise.getColumnModel().getColumn(0).setCellRenderer(centraliza);

        scrolTabAnalise1.setViewportView(tabAnalise);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    private void showMapa2(){
        for(Integer id: mapa2.keySet()){
            System.out.println("\nidCavalo:"+id);
            DTO_TabelaCompetidores dto = mapa2.get(id);
//            System.out.println(dto);
        }
    }
}
