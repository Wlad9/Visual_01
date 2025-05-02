package asdrubal.hr.visulal_v1.tabelas_class;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Map;
import java.util.Set;

public class Tabela_AnalisePareos extends JTable {
    private Set<Integer> negrito;
    private final Map<String, IndicesDTO> mapaIndices;
    private Object[][] dados;
    private Color marrom = new Color(139, 69, 19);


    public Tabela_AnalisePareos(Object[][] dados, String[] colunas, Set<Integer> negrito, Map<String, IndicesDTO> indices) {
        super(new DefaultTableModel(dados, colunas));
        this.negrito = negrito;
        mapaIndices = indices;
        this.dados = dados;
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
        setBackground(Color.gray);
        return new Dimension(getPreferredSize().width, height);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);

        // Reset estilo
        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());
        if (column == 0 && negrito.contains(row)) {
            comp.setFont(comp.getFont().deriveFont(Font.BOLD));
            comp.setForeground(Color.WHITE);
        }

        Object object = dados[row][10];
        if (object instanceof Float) {
            String raia = (String) dados[row][2];

            Float tempo = (Float) object;
            if (tempo > 0f) {
                IndicesDTO dto = mapaIndices.get(raia);
                if (dto != null) {
                    float azul = dto.getAzul();
                    float verde = dto.getVerde();
                    float amarelo = dto.getAmarelo();
                    float laranja = dto.getLaranja();
                    float vermelho = dto.getVermelho();
                    if (tempo <= azul) {
                        comp.setForeground(Color.BLUE);
                    } else if (tempo <= verde) {
                        comp.setForeground(Color.GREEN);
                    } else if (tempo <= amarelo) {
                        comp.setForeground(Color.YELLOW);
                    } else if (tempo <= laranja) {
                        comp.setForeground(Color.ORANGE);
                    } else if (tempo <= vermelho) {
                        comp.setForeground(Color.RED);
                    } else if (tempo > vermelho) {
                        comp.setForeground(marrom);
                    }
                }
            }
        }
        return comp;
    }
}
