package asdrubal.hr.visulal_v1.registro.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Tabela_CavalosDoPareo extends JTable{
    public Tabela_CavalosDoPareo(Object[][] dados, String[] colunas) {
        super(new DefaultTableModel(dados, colunas));
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setFont(new Font("Arial", Font.PLAIN, 12));
        getColumnModel().getColumn(0).setPreferredWidth(5);
        getColumnModel().getColumn(1).setPreferredWidth(105);
        getColumnModel().getColumn(2).setPreferredWidth(80);
        getColumnModel().getColumn(3).setPreferredWidth(80);
        getColumnModel().getColumn(4).setPreferredWidth(15);
        getColumnModel().getColumn(5).setPreferredWidth(4);
    }
}
