package asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.IdentificaCorDaLinha;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.IdentificaHipoCod;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class CorRenderizador extends DefaultTableCellRenderer{
    private final Object[][] dados; // Matriz de dados da tabela
    private final String tipoDeFiltro;
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesRS;
    private final Map<String, IndicesDTO> indicesCJ;
    private IdentificaCorDaLinha idCorLinha;

    public CorRenderizador(Object[][] dados, String tipoDeFiltro,
                           Map<String, IndicesDTO> indicesGeral, Map<String, IndicesDTO> indicesGV,
                           Map<String, IndicesDTO> indicesPR, Map<String, IndicesDTO> indicesRS,
                           Map<String, IndicesDTO> indicesCJ /*, ... outras dependências ... */) {

        this.dados = dados;
        this.tipoDeFiltro = tipoDeFiltro;
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesPR = indicesPR;
        this.indicesRS = indicesRS;
        this.indicesCJ = indicesCJ;

        // ... inicializar idCorLinha se for necessário
    }

    // A JTable chama este método para CADA CÉLULA
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {

        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        comp.setFont(table.getFont());
        comp.setForeground(table.getForeground());
        comp.setBackground(table.getBackground());

        if (row < dados.length) {
            if (tipoDeFiltro.equals("P1")) {
                Object obj = dados[row][10];
                if (obj instanceof Float) {
                    Float tempo = (Float) obj;
                    String hipoCod = IdentificaHipoCod.idIpoCod(dados[row][0]);
                    Object objRaia = dados[row][2];
                    String raia = (String) objRaia;
                    IndicesDTO dto = indicesGeral.get(raia);
                    if (tempo > 0 && dto != null) {
                        Color corDaLinha = idCorLinha.corDaLinhaPeloTempoGeral(tempo, dto);
//                    comp.setForeground(corDaLinha);
//                    Color corClara = clarearCor(corDaLinha, 0.4f);
                        if (corDaLinha == null) return null;
                        Color corAjustada = ajustarCorAutomaticamente(corDaLinha);
                        comp.setBackground(corAjustada);

//                    comp.setBackground(corClara);
                        comp.setForeground(Color.BLACK);
                    }
                }
            }
        }
        if (isSelected) {
            comp.setBackground(table.getSelectionBackground());
            comp.setForeground(table.getSelectionForeground());
        }

        return comp;
    }

    private Color ajustarCorAutomaticamente(Color cor) {
//        double brilho = 0.299 * cor.getRed() + 0.587 * cor.getGreen() + 0.114 * cor.getBlue();
        double brilho = 0.450 * cor.getRed() + 0.550 * cor.getGreen() + 0.214 * cor.getBlue();

        // Se for escura (brilho < 128), clareia
        if (brilho < 128) {
            return clarearCor(cor, 0.5f); // clareia 50%
        }
        return cor;
    }

    private Color clarearCor(Color cor, float fator) {
        int r = cor.getRed();
        int g = cor.getGreen();
        int b = cor.getBlue();

        r += (int) ((255 - r) * fator);
        g += (int) ((255 - g) * fator);
        b += (int) ((255 - b) * fator);

        return new Color(r, g, b);
    }
}