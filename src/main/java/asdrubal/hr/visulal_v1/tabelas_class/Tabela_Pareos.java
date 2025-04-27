package asdrubal.hr.visulal_v1.tabelas_class;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Tabela_Pareos extends JTable {

    public Tabela_Pareos(Object[][] dados, String[] colunas) {
        super(new DefaultTableModel(dados, colunas));
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setFillsViewportHeight(true);
        setRowHeight(20);
        SwingUtilities.invokeLater(() -> {
            TableColumnModel colModel = this.getColumnModel();
            if (colModel.getColumnCount() >= 4) {
                colModel.getColumn(0).setPreferredWidth(80);
                colModel.getColumn(0).setMinWidth(80);
                colModel.getColumn(0).setMaxWidth(80);

                colModel.getColumn(1).setPreferredWidth(120);
                colModel.getColumn(1).setMinWidth(120);
                colModel.getColumn(1).setMaxWidth(120);

                colModel.getColumn(2).setPreferredWidth(90);
                colModel.getColumn(2).setMinWidth(90);
                colModel.getColumn(2).setMaxWidth(90);

                colModel.getColumn(3).setPreferredWidth(90);
                colModel.getColumn(3).setMinWidth(90);
                colModel.getColumn(3).setMaxWidth(90);
            }
        });

    }

//    @Override
//    public Dimension getPreferredScrollableViewportSize() {
//        int totalWidth = 0;
//        for (int i = 0; i < getColumnModel().getColumnCount(); i++) {
//            totalWidth += getColumnModel().getColumn(i).getPreferredWidth();
//        }
//
//        int rows = getRowCount();
//        int rowHeight = getRowHeight();
//        int height = rows * rowHeight;
//
//        height = Math.max(height, 80);
//        height = Math.min(height, 800);
//
//        return new Dimension(totalWidth, height);
//    }
}
