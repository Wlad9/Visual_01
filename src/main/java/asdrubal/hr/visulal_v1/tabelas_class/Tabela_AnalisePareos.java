package asdrubal.hr.visulal_v1.tabelas_class;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.painel_Inicial.RenderTipoPareos;
import asdrubal.hr.visulal_v1.painel_Inicial.RenderTipoRaias;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tabela_AnalisePareos extends JTable {
    private Set<Integer> negrito;
    private final Map<String, IndicesDTO> mapaIndices;
    private Object[][] dados;
    private final int nrColunas;
    private final String analiseDe;
    private final List<String> raiasFiltro;
    private Color marrom = new Color(139, 69, 19);


    public Tabela_AnalisePareos(Object[][] dados, String[] colunas, Set<Integer> negrito, Map<String, IndicesDTO> indices
            , int nrColunas, String analiseDe, List<String> raiasFiltro) {
        super(new DefaultTableModel(dados, colunas));
        this.negrito = negrito;
        mapaIndices = indices;
        this.dados = dados;
        this.nrColunas = nrColunas;
        this.analiseDe = analiseDe;
        this.raiasFiltro = raiasFiltro;
        setFillsViewportHeight(true);
        setRowHeight(20);

        if (dados != null) {
            if (!analiseDe.equalsIgnoreCase("CorridasComuns")) {
                for (int i = 0; i < dados.length; i++) { // Loop pelas linhas
                    if (dados[i] != null) {
                        StringBuilder linha = new StringBuilder();
                        for (int j = 0; j < dados[i].length; j++) { // Loop pelas colunas da linha atual
                            Object valor = dados[i][j];
                            linha.append(valor == null ? "" : valor.toString());
                            if (j < dados[i].length - 1) {
                                linha.append(" - ");
                            }
                        }
//                    System.out.println("Linha " + i + ": " + linha.toString());
                        System.out.println(linha.toString());
                    } else {
                        System.out.println("Linha " + i + ": (nula)");
                    }
                }
            } else {
                System.out.println("O array de dados é nulo.");
            }
        }
    }

    public Tabela_AnalisePareos(Object[][] dadosFiltradosPorData, String[] titulosRaias, Set<Integer> negritoRaiaFiltroAno
            , Map<String, IndicesDTO> indices, int nrColunas, String raias) {
        super(new DefaultTableModel(dadosFiltradosPorData, titulosRaias));
        this.negrito = negritoRaiaFiltroAno;
        mapaIndices = indices;
        dados = dadosFiltradosPorData;
        this.nrColunas = nrColunas;
        this.analiseDe = raias;
        raiasFiltro = null;
        setFillsViewportHeight(true);
        setRowHeight(20);
    }


    @Override
    public Dimension getPreferredScrollableViewportSize() {
        System.out.println("Preferências:");
        int rows = getRowCount();
        int rowHeight = getRowHeight();
        int height = rows * rowHeight;
        height = Math.max(height, 80);
        height = Math.min(height, 800);
        setBackground(Color.gray);
        System.out.println("Rows:" + rows + "\tRowHeight:" + rowHeight + "\theight:" + height + "\tColorGray");
        return new Dimension(getPreferredSize().width, height);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);
        // Reset estilo
        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());
        if (analiseDe.equals("Raias")) {
            if (column == 0 && negrito.contains(row)) {
                comp.setFont(comp.getFont().deriveFont(Font.BOLD));
                comp.setForeground(Color.BLACK);
            }

            // Lógica de colorização da linha para as linhas de dados
            if (!negrito.contains(row) && row < dados.length && dados[row].length == nrColunas) {
                Object tempoObject = dados[row][nrColunas - 1]; // Última coluna é o tempo
                if (tempoObject instanceof Float) {
                    String raiaLinhaDados = "";
                    int linhaRaiaCorreta = -1;
                    // Encontrar a linha da raia CORRETA (a última linha marcada em negrito ANTES desta linha de dados)
                    for (Integer negritoIndex : negrito) {
                        if (negritoIndex < row) {
                            linhaRaiaCorreta = Math.max(linhaRaiaCorreta, negritoIndex);
                        }
                    }

                    if (linhaRaiaCorreta >= 0 && linhaRaiaCorreta < dados.length && dados[linhaRaiaCorreta].length > 0 && dados[linhaRaiaCorreta][0] instanceof String) {
                        raiaLinhaDados = (String) dados[linhaRaiaCorreta][0];
                    }

                    Float tempo = (Float) tempoObject;
                    if (tempo > 0f && mapaIndices.containsKey(raiaLinhaDados)) {
                        Color corLinha = getCorPorTempo(tempo, mapaIndices.get(raiaLinhaDados), marrom);
                        comp.setForeground(corLinha);
                    }
                }
            }
        } else if (analiseDe.equals("Páreos")) {
            // Lógica de colorização para "Páreos" (mantida como estava)
            if (row < dados.length && dados[row].length > 10) {
                Object object = dados[row][10];
                if (object instanceof Float) {
                    String raiaLinhaDados = (String) dados[row][2];
                    Float tempo = (Float) object;
                    if (tempo > 0f && mapaIndices.containsKey(raiaLinhaDados)) {
                        Color corLinha = getCorPorTempo(tempo, mapaIndices.get(raiaLinhaDados), marrom);
                        comp.setForeground(corLinha);
                    }
                }
            }
            // Formatação especial para a primeira coluna de linhas marcadas com negrito
            if (column == 0 && negrito.contains(row)) {
                comp.setFont(comp.getFont().deriveFont(Font.BOLD));
                comp.setForeground(Color.WHITE);
            }
        }
        return comp;
    }

    private Color getCorPorTempo(Float tempo, IndicesDTO dto, Color marrom) {
        if (tempo <= dto.getAzul()) {
            return Color.BLUE;
        } else if (tempo <= dto.getVerde()) {
            return Color.GREEN;
        } else if (tempo <= dto.getAmarelo()) {
            return Color.YELLOW;
        } else if (tempo <= dto.getLaranja()) {
            return Color.ORANGE;
        } else if (tempo <= dto.getVermelho()) {
            return Color.RED;
        } else {
            return marrom;
        }
    }
}


