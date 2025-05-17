package asdrubal.hr.visulal_v1.pagina_03;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TabelaCavalos extends JTable {
    public TabelaCavalos(Object[][] dados, String[] colunas) {
        super(new DefaultTableModel(dados, colunas));

    }
}
