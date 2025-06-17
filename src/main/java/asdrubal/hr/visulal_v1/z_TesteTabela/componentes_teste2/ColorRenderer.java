package asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2;
import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import java.util.Map;

public class ColorRenderer extends DefaultTableCellRenderer {
    private final Map<String, IndicesDTO> indices;

    private static final int COLUNA_RAIA_OCULTA = 10; // Índice da coluna onde a RAIA está no modelo
    private static final int COLUNA_TEMPO = 8;        // Índice da coluna onde o TEMPO (float) está no modelo

    public ColorRenderer(Map<String, IndicesDTO> indices) {
        this.indices = indices;
    }

    // Método auxiliar para determinar a cor com base no tempo e nos índices da raia
    private Color getCorPorTempo(float tempo, IndicesDTO indice) {
        if (indice == null) {
            return Color.LIGHT_GRAY; // Cor padrão para raias sem índices definidos, ou outra cor neutra
        }

        // A ordem dos 'if's é importante, pois verifica de menor para maior tempo (melhor para pior cor)
        if (tempo <= indice.getAzul()) return Color.BLUE;
        if (tempo <= indice.getVerde()) return Color.GREEN;
        if (tempo <= indice.getAmarelo()) return Color.YELLOW;
        if (tempo <= indice.getLaranja()) return Color.ORANGE;
        if (tempo <= indice.getVermelho()) return Color.RED;
        return new Color(139, 69, 19); // Cor marrom para o tempo mais alto / fora dos limites
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // 1. Chama o método da superclasse para obter o componente padrão de renderização
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // 2. Trata a seleção da linha. As cores de seleção têm prioridade.
        if (isSelected) {
            c.setBackground(table.getSelectionBackground());
            c.setForeground(table.getSelectionForeground());
            return c; // Retorna o componente com o estilo de seleção padrão
        } else {
            // Restaura as cores de fundo e frente padrão da tabela para células não selecionadas
            c.setBackground(table.getBackground());
            c.setForeground(table.getForeground());
        }

        // 3. Lógica para aplicar a coloração personalizada baseada na raia e no tempo.

        String raiaDaLinha = null;
        Object tempoObj = null;

        // Acessa a raia diretamente da coluna oculta, é a forma mais confiável.
        // É crucial verificar se a coluna existe no modelo para evitar ArrayIndexOutOfBoundsException
        if (table.getModel().getColumnCount() > COLUNA_RAIA_OCULTA) {
            Object raiaObjNaColunaOculta = table.getModel().getValueAt(row, COLUNA_RAIA_OCULTA);
            if (raiaObjNaColunaOculta instanceof String) {
                raiaDaLinha = (String) raiaObjNaColunaOculta;
            }
        }

        // Acessa o valor do tempo diretamente da COLUNA_TEMPO.
        if (table.getModel().getColumnCount() > COLUNA_TEMPO) {
            tempoObj = table.getModel().getValueAt(row, COLUNA_TEMPO);
        }

        // Condição para aplicar a coloração:
        // A linha deve ter uma raia associada (não nula/vazia)
        // E o valor do tempo deve ser um número válido.
        if (raiaDaLinha != null && !raiaDaLinha.trim().isEmpty() && tempoObj instanceof Number) {
            // Tenta obter o objeto IndicesDTO correspondente à raia
            IndicesDTO indiceDaRaia = null;
            if (this.indices != null) { // Garante que o mapa 'indices' não é nulo antes de usar .get()
                indiceDaRaia = this.indices.get(raiaDaLinha);
            }

            if (indiceDaRaia != null) {
                float tempoFloat = ((Number) tempoObj).floatValue();
                c.setBackground(getCorPorTempo(tempoFloat, indiceDaRaia)); // Aplica a cor de fundo
            } else {
                // Se a raia existe na linha, mas não há um 'IndicesDTO' correspondente no mapa 'indices'
                // Define uma cor padrão diferente para indicar isso (ex: cinza)
                c.setBackground(Color.LIGHT_GRAY); // Ou outra cor de sua escolha
            }
        } else {
            // Se a linha não é uma linha de dados de competidor (ex: linha de cabeçalho da raia, linha em branco),
            // ou se os dados cruciais (raia, tempo) não estão válidos, usa a cor de fundo padrão da tabela.
            c.setBackground(table.getBackground());
        }

        return c; // Retorna o componente com a cor final (ou sem cor personalizada)
    }
}