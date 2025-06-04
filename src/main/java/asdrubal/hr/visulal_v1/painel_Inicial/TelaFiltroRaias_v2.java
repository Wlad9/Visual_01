package asdrubal.hr.visulal_v1.painel_Inicial;
import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Map;
import java.util.Set;

public class TelaFiltroRaias_v2 extends JPanel {
    private final Object[][] dados;
    private final String[] titulos;
    private final Set<Integer> negrito;
    private final Map<String, IndicesDTO> indices;
    private final int nrColunas;
    private final JScrollPane scroll2;
    private final JTable tabelaParaAtualizar; // Recebe a instância da tabela existente

    public TelaFiltroRaias_v2(Object[][] dados, String[] titulos, JTable tabelaParaAtualizar, Set<Integer> negrito,
                           Map<String, IndicesDTO> indices, int nrColunas, JScrollPane scroll2) {
        this.dados = dados;
        this.titulos = titulos;
        this.negrito = negrito;
        this.indices = indices;
        this.nrColunas = nrColunas;
        this.scroll2 = scroll2;
        this.tabelaParaAtualizar = tabelaParaAtualizar;

        atualizarTabela();

        setLayout(new BorderLayout());
        add(scroll2, BorderLayout.CENTER);
    }

    private void atualizarTabela() {
        if (tabelaParaAtualizar != null) {
            DefaultTableModel model = (DefaultTableModel) tabelaParaAtualizar.getModel();
            model.setDataVector(dados, titulos); // Define os novos dados e cabeçalhos

            // Define o renderer personalizado para a tabela existente
            tabelaParaAtualizar.setDefaultRenderer(Object.class, new Tabela_AnalisePareosRenderer(negrito, indices, nrColunas, dados));

            tabelaParaAtualizar.revalidate();
            tabelaParaAtualizar.repaint();
        }
    }
}

// Classe Renderer separada para manter a lógica de prepareRenderer
class Tabela_AnalisePareosRenderer extends DefaultTableCellRenderer {
    private final Set<Integer> negrito;
    private final Map<String, IndicesDTO> mapaIndices;
    private final int nrColunas;
    private final Object[][] dados;
    private final Color marrom = new Color(139, 69, 19);

    public Tabela_AnalisePareosRenderer(Set<Integer> negrito, Map<String, IndicesDTO> indices, int nrColunas, Object[][] dados) {
        this.negrito = negrito;
        this.mapaIndices = indices;
        this.nrColunas = nrColunas;
        this.dados = dados;
    }

}