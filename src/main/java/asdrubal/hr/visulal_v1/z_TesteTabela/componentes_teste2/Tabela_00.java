package asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Tabela_00 extends JTable {


    public Tabela_00(Object[][] dados, String[] titulos00) {
        super(new DefaultTableModel(dados, titulos00));
        setFont(new Font("Arial", Font.PLAIN, 12));
        getColumnModel().getColumn(0).setPreferredWidth(5);
        getColumnModel().getColumn(1).setPreferredWidth(100);
        getColumnModel().getColumn(2).setPreferredWidth(80);
        getColumnModel().getColumn(3).setPreferredWidth(80);
        getColumnModel().getColumn(4).setPreferredWidth(5);
    }
}
