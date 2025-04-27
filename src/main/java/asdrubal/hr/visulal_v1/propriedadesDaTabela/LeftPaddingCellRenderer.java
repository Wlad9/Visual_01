package asdrubal.hr.visulal_v1.propriedadesDaTabela;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class LeftPaddingCellRenderer extends DefaultTableCellRenderer {
    private final int padding;

    public LeftPaddingCellRenderer(int padding) {
        this.padding = padding;
        setHorizontalAlignment(SwingConstants.LEFT);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (c instanceof JLabel) {
            ((JLabel) c).setBorder(BorderFactory.createEmptyBorder(0, padding, 0, 0));
        }
        return c;
    }
}
