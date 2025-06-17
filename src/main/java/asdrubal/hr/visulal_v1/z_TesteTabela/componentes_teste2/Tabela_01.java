package asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class Tabela_01 extends JTable {
    private final Map<String, IndicesDTO> indices;

    public Tabela_01(Object[][] dados1, Object[] titulosDados1, Map<String, IndicesDTO> indices) {
        super(new DefaultTableModel(dados1, titulosDados1));
        this.indices = indices;

        setFont(new Font("Arial", Font.PLAIN, 12));
        getColumnModel().getColumn(0).setPreferredWidth(25);
        getColumnModel().getColumn(1).setPreferredWidth(5);
        getColumnModel().getColumn(2).setPreferredWidth(100);
        getColumnModel().getColumn(3).setPreferredWidth(60);
        getColumnModel().getColumn(4).setPreferredWidth(80);
        getColumnModel().getColumn(5).setPreferredWidth(20);
        getColumnModel().getColumn(6).setPreferredWidth(80);
        getColumnModel().getColumn(7).setPreferredWidth(15);
        getColumnModel().getColumn(8).setPreferredWidth(20);
        getColumnModel().getColumn(9).setPreferredWidth(5);

//  Escondendo a coluna 10 com o campo RAIA
        if (getColumnModel().getColumnCount() > 10) { // Verifica se a coluna extra existe
            getColumnModel().removeColumn(getColumnModel().getColumn(10));
        }
        setDefaultRenderer(Object.class, new ColorRenderer());
    }

    private class ColorRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
                return c;
            }

            Object raiaObj = table.getValueAt(row, 0);
            Object tempoObj = table.getValueAt(row, 8);

            if (raiaObj instanceof String) {
                String raia = (String) raiaObj;
                Float tempo = parseTempo(tempoObj);
                if (tempo != null && indices.containsKey(raia)) {
                    IndicesDTO indice = indices.get(raia);
                    c.setBackground(getCorPorTempo(tempo, indice));
                } else {
                    c.setBackground(Color.WHITE);
                }
            } else {
                c.setBackground(Color.WHITE);
            }

            c.setForeground(Color.BLACK);
            return c;
        }

        private Float parseTempo(Object tempoObj) {
            if (tempoObj == null) return null;
            if (tempoObj instanceof Float) return (Float) tempoObj;
            if (tempoObj instanceof Number) return ((Number) tempoObj).floatValue();
            try {
                return Float.parseFloat(tempoObj.toString());
            } catch (NumberFormatException e) {
                return null;
            }
        }

        private Color getCorPorTempo(float tempo, IndicesDTO indice) {
            if (tempo <= indice.getAzul()) return Color.BLUE;
            if (tempo <= indice.getVerde()) return Color.GREEN;
            if (tempo <= indice.getAmarelo()) return Color.YELLOW;
            if (tempo <= indice.getLaranja()) return Color.ORANGE;
            if (tempo <= indice.getVermelho()) return Color.RED;
            return new Color(139, 69, 19); // marrom
        }
    }
}