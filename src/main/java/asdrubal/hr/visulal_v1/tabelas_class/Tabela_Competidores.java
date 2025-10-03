package asdrubal.hr.visulal_v1.tabelas_class;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Tabela_Competidores extends JTable {
    public Tabela_Competidores(Object[][] dados, String[] colunas) {
        super(new DefaultTableModel(dados, colunas));
        setFillsViewportHeight(true);
        setRowHeight(20);
        setRowSelectionAllowed(true);
        getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // Obtenha o TableColumnModel
        TableColumnModel columnModel = getColumnModel();

        // Defina a largura preferida para cada coluna (índice 0 a 5)
        if (columnModel.getColumnCount() == 6) {
            columnModel.getColumn(0).setPreferredWidth(45);   // Ex: Coluna 0 (Número)
            columnModel.getColumn(1).setPreferredWidth(150);  // Ex: Coluna 1 (Nome do Competidor - BOLD)
            columnModel.getColumn(2).setPreferredWidth(90);   // Ex: Coluna 2 (Jóquei)
            columnModel.getColumn(3).setPreferredWidth(80);   // Ex: Coluna 3 (Treinador)
            columnModel.getColumn(4).setPreferredWidth(60);   // Ex: Coluna 4 (Ano)
            columnModel.getColumn(5).setPreferredWidth(35);   // Ex: Coluna 5 (Sexo)
        }
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

        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());

        if (column == 1) {
            comp.setFont(comp.getFont().deriveFont(Font.BOLD));
        }

        return comp;
    }
}


