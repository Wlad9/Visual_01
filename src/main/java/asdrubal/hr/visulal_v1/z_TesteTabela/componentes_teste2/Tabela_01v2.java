package asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Map;

public class Tabela_01v2 extends JTable {

    private final Object[][] dados;
    private final Object[] titulos;
    private final Map<String, IndicesDTO> indices;
    private Color marrom = new Color(139, 69, 19);
    private Color DARKER_ORANGE = new Color(200, 100, 0);
    private Color DARKER_RED = new Color(255, 0, 0);
    private Color DARKER_GREEN = new Color(0, 160, 10);

    public Tabela_01v2(Object[][] dados1, Object[] titulosDados1, Map<String, IndicesDTO> indices) {
        super(new DefaultTableModel(dados1, titulosDados1));
        dados = dados1;
        titulos = titulosDados1;
        this.indices = indices;
        setBackground(new Color(175,175,175));
        setFont(new Font("Arial", Font.PLAIN, 14));
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
        System.out.println(dados1.length + "--->" + titulosDados1.length);
        if (getColumnModel().getColumnCount() > 10) {
            getColumnModel().removeColumn(getColumnModel().getColumn(10));
        }
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);
        // Reset estilo
        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());


        Object valorColuna0 = this.getModel().getValueAt(row, 0);
        Object valorColunaCavalo = this.getModel().getValueAt(row, 2);
        Object valorColunaTempo = null;
        Object valorColunaRaia = null;

        if (getModel().getColumnCount() > 10) {
            valorColunaRaia = this.getModel().getValueAt(row, 10);
        }
        if (temComteudo(valorColuna0) && temComteudo(valorColunaCavalo)) {
            valorColunaTempo = this.getModel().getValueAt(row, 8);
            if (temComteudo(valorColunaTempo) && temComteudo(valorColunaRaia)) {
                try {
                    float tempo = Float.parseFloat(valorColunaTempo.toString());
                    String raia = valorColunaRaia.toString().trim();
                    IndicesDTO indicesDaRaia = indices.get(raia);
                    if (tempo > 0f && indicesDaRaia != null) {
//                        comp.setBackground(getCorPorTempo(tempo, indicesDaRaia));
                        comp.setForeground(getCorPorTempo(tempo, indicesDaRaia));
                    }
                } catch (NumberFormatException e) {
                    // TODO - Tratar erro se valor da coluna de tempo não for um número válido.
                    System.err.println("Erro: Valor da coluna de tempo não é um número válido na linha " + row + ". Valor: " + valorColunaTempo);
                    // Opcional: define uma cor de erro para a célula
                    // comp.setBackground(Color.PINK);
                }
            }
        }
        return comp;
    }

    private Color getCorPorTempo(Float tempo, IndicesDTO dto) {
        if (tempo <= dto.getAzul()) {
            return Color.BLUE;
        } else if (tempo <= dto.getVerde()) {
            return DARKER_GREEN;
        } else if (tempo <= dto.getAmarelo()) {
            return Color.YELLOW;
        } else if (tempo <= dto.getLaranja()) {
            return DARKER_ORANGE;
        } else if (tempo <= dto.getVermelho()) {
            return DARKER_RED;
        } else {
            return marrom;
        }
    }

    private boolean temComteudo(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            return !((String) obj).trim().isEmpty();
        }
        return true;
    }
}
