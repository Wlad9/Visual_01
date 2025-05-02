package asdrubal.hr.visulal_v1.tabelas_class;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Tabela_Competidores extends JTable {
    public Tabela_Competidores(Object[][] dados, String[] colunas) {
        super(new DefaultTableModel(dados, colunas));
        setFillsViewportHeight(true);
        setRowHeight(20);
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

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);

        // Reset de estilo padrão
        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());

        if (column == 1) {
            comp.setFont(comp.getFont().deriveFont(Font.BOLD));
        }

        return comp;
    }
}

