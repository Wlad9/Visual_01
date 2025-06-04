package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.tabelas_class.Tabela_AnalisePareos;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Set;

public class TelaFiltroRaias extends JPanel{
    private final Object[][] dados;
    private final String[] titulos;
    private final Set<Integer> negrito;
    private final Map<String, IndicesDTO> indices;
    private int nrColunas;
    private final JScrollPane scroll2;
//    private final JTable tabela2;


    public TelaFiltroRaias(Object[][] dados, String[] titulos, JTable tabela2, Set<Integer> negrito,
                           Map<String, IndicesDTO> indices, int nrColunas, JScrollPane scroll2) {
        this.dados = dados;
        this.titulos = titulos;
        this.negrito = negrito;
        this.indices = indices;

        this.nrColunas = nrColunas;
        this.scroll2 = scroll2;
        tabela2 = new Tabela_AnalisePareos(dados, titulos, negrito, indices, nrColunas, "xxx", null);


        tabela2.setFont(new Font("Arial", Font.PLAIN, 12));
        tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela2.getColumnModel().getColumn(0).setPreferredWidth(70);//tempo
        tabela2.getColumnModel().getColumn(1).setPreferredWidth(100);//cavalo
        tabela2.getColumnModel().getColumn(2).setPreferredWidth(40);//posição
        tabela2.getColumnModel().getColumn(3).setPreferredWidth(90);//data
        tabela2.getColumnModel().getColumn(4).setPreferredWidth(100);//joquei
        tabela2.getColumnModel().getColumn(5).setPreferredWidth(100);//treinador
        tabela2.getColumnModel().getColumn(6).setPreferredWidth(60);//rateio
        tabela2.getColumnModel().getColumn(7).setPreferredWidth(110);//cronometreo
        tabela2.getColumnModel().getColumn(8).setPreferredWidth(130);//prova
        tabela2.setBackground(new Color(177, 187, 197));
        scroll2.setViewportView(tabela2);

        tabela2.setVisible(true);
        tabela2.revalidate();
        tabela2.repaint();
    }

    public void montaTela() {

    }
}
