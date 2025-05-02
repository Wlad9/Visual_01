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

public class AnaliseEntreCompetidores extends JFrame{
    private final CompetidorService competidorService;
    private final Map<Integer, DTO_TabelaCompetidores> mapa2;
    private JPanel contentPane;
    private JScrollPane panel1;
    private JScrollPane scrol1;
    private JPanel panel2;
    private JScrollPane scrol2;
    private JTable table1;
    private JTable tabela1;
    private RightPaddingCellRenderer alinhaDireita = new RightPaddingCellRenderer(5);
    private LeftPaddingCellRenderer alinhaEsquerda = new LeftPaddingCellRenderer(5);
    private DefaultTableCellRenderer centraliza = new DefaultTableCellRenderer();

    public AnaliseEntreCompetidores(CompetidorService competidorService, Map<Integer, DTO_TabelaCompetidores> mapa2) {
        this.competidorService = competidorService;
        this.mapa2 = mapa2;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        alinhaDireita.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        alinhaEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
        alinhaEsquerda.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        centraliza.setHorizontalAlignment(SwingConstants.CENTER);
        setResizable(true);
    }

    public void inicia() {
        Map<Integer, List<CompetidorDTO>> mapa3 = new Mapa3_Montador(competidorService).montaMapa(mapa2);
        Object [][] dadosCavalo = new Object[2][2];
        Mapa4_MontadorListaOrdenada mapa4Monta = new Mapa4_MontadorListaOrdenada();
        Map<Integer, List<CompetidorDTO>> mapa4 = mapa4Monta.ordenaLista(mapa3);
        for(Integer id: mapa4.keySet()){
            List<CompetidorDTO> lista =mapa4.get(id);
            for(CompetidorDTO c: lista){
                System.out.println(c.getTempo());
            }
        }
        Map<Integer, List<CompetidorDTO>> mapa5 = mapa4Monta.getMapa5();
        OrdenaMapaPorDataDoPareo ordenaMapa = new OrdenaMapaPorDataDoPareo();
//        Map<Integer, List<CompetidorDTO>> mapa6 = ordenaMapa.ordena(mapa3);
        Map<Integer, List<CompetidorDTO>> mapa7 = ordenaMapa.ordenaPorTempo(mapa4);
        AuxPesquisa_mk2 auxMk2 = new AuxPesquisa_mk2(mapa7, dadosCavalo);
        String[] titulos = auxMk2.getTitulos();
        Object[][] dadosMk2 = auxMk2.montaDadosDaTabela();

        tabela1 = new JTable(dadosMk2, titulos);
        tabela1.setFont(new Font("Arial", Font.PLAIN, 12));
        tabela1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabela1.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabela1.getColumnModel().getColumn(1).setPreferredWidth(25);
        tabela1.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabela1.getColumnModel().getColumn(3).setPreferredWidth(90);
        tabela1.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabela1.getColumnModel().getColumn(5).setPreferredWidth(70);
        tabela1.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabela1.getColumnModel().getColumn(7).setPreferredWidth(80);
        tabela1.getColumnModel().getColumn(8).setPreferredWidth(83);
        tabela1.getColumnModel().getColumn(9).setPreferredWidth(40);
        tabela1.getColumnModel().getColumn(10).setPreferredWidth(60);
        tabela1.getColumnModel().getColumn(0).setCellRenderer(alinhaDireita);
        tabela1.getColumnModel().getColumn(0).setCellRenderer(centraliza);

        scrol1.setViewportView(tabela1);

        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
}
