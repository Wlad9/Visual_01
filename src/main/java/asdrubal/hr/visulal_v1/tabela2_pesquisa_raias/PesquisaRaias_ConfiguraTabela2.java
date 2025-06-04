package asdrubal.hr.visulal_v1.tabela2_pesquisa_raias;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_AnalisePareos;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Set;

public class PesquisaRaias_ConfiguraTabela2 {
    private JTable tabela2;
    private final JScrollPane scroll2;
    private final Object[][] dadosMk3;
    private final String[] titulos;
    private final Set<Integer> negrito;
    private final Map<String, IndicesDTO> indices;
    private final int nrColunas;

    public PesquisaRaias_ConfiguraTabela2(JTable tabela2, JScrollPane scroll2, Object[][] dadosMk3, String[] titulos, Set<Integer> negrito
            , Map<String, IndicesDTO> indices, int nrColunas) {
        this.tabela2 = tabela2;
        this.scroll2 = scroll2;
        this.dadosMk3 = dadosMk3;
        this.titulos = titulos;
        this.negrito = negrito;
        this.indices = indices;
        this.nrColunas = nrColunas;
        System.out.println("nr de colunas.>"+nrColunas);
    }



    public void configura() {
        tabela2 = new Tabela_AnalisePareos(dadosMk3, titulos, negrito, indices, nrColunas, "xxx", null);
        tabela2.setFont(new Font("Arial",Font.PLAIN, 12));
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

//        centraliza.setHorizontalAlignment(SwingConstants.CENTER);
//        alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
//        alinhaDireita.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
//        alinhaEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
//        alinhaEsquerda.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//
////        tabela2.getColumnModel().getColumn(0).setCellRenderer(alinhaDireita);
//        tabela2.getColumnModel().getColumn(1).setCellRenderer(centraliza);// Pos
//        tabela2.getColumnModel().getColumn(8).setCellRenderer(centraliza);//CorpoChegada
//        tabela2.getColumnModel().getColumn(9).setCellRenderer(centraliza);// ER- EntradaReta
//        tabela2.getColumnModel().getColumn(10).setCellRenderer(centraliza);//tempo

        scroll2.setViewportView(tabela2);

        tabela2.setVisible(true);
        tabela2.revalidate();
        tabela2.repaint();
    }
}
