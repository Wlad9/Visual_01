package asdrubal.hr.visulal_v1.tabelas_class;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Tabela_Pareos extends JTable {
    public Tabela_Pareos(Object[][] dados, String[] colunas) {
        super(new DefaultTableModel(dados, colunas));
        setFillsViewportHeight(true);
        setRowHeight(20);

        TableColumnModel colModel = this.getColumnModel();// alterando os campos da tabela
        colModel.getColumn(0).setPreferredWidth(80);
        colModel.getColumn(1).setPreferredWidth(120);
        colModel.getColumn(2).setPreferredWidth(90);
        colModel.getColumn(3).setPreferredWidth(90);
    }
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        int rows = getRowCount();
        int rowHeight = getRowHeight();
        int height = rows * rowHeight;

        // Limite mínimo/máximo para não explodir a tela
        height = Math.max(height, 80);   // mínimo
        height = Math.min(height, 800);  // máximo

        return new Dimension(getPreferredSize().width, height);
    }
}
