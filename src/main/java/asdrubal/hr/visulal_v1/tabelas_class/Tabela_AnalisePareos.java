package asdrubal.hr.visulal_v1.tabelas_class;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Set;

public class Tabela_AnalisePareos extends JTable {
    private Set<Integer> negrito;
    public Tabela_AnalisePareos(Object[][] dados, String[] colunas, Set<Integer> negrito) {
        super(new DefaultTableModel(dados, colunas));
        this.negrito = negrito;
        setFillsViewportHeight(true);
        setRowHeight(20);
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        int rows = getRowCount();
        int rowHeight = getRowHeight();
        int height = rows * rowHeight;
        height = Math.max(height, 80);
        height = Math.min(height, 800);
        return new Dimension(getPreferredSize().width, height);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);

        // Reset estilo
        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());

        // Negrito na coluna 0
//        if (column == 1) {
//            comp.setFont(comp.getFont().deriveFont(Font.BOLD));
//        }
        if (column == 1 && negrito.contains(row)) {
            comp.setFont(comp.getFont().deriveFont(Font.BOLD));
        }
//
//        // Pintar linha se coluna 3 (índice 2) contiver "69"
//        Object valorColuna3 = getValueAt(row, 2);
//        if (valorColuna3 != null && valorColuna3.toString().contains("69")) {
//            comp.setBackground(Color.CYAN);
//            comp.setForeground(Color.BLACK);
//        }

        return comp;
    }
}
