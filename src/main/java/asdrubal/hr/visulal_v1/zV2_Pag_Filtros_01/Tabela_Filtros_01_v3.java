package asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.IdentificaCorDaLinha;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.IdentificaHipoCod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Map;

public class Tabela_Filtros_01_v3 extends JTable {
    private final Object[][] dados;
    private final String[] colunas;
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesCJ;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesRS;
    private IdentificaCorDaLinha identificaCorDaLinha;

    public Tabela_Filtros_01_v3(Object[][] dados, String[] colunas, Map<String, IndicesDTO> indicesGeral,
                                Map<String, IndicesDTO> indicesGV, Map<String, IndicesDTO> indicesCJ,
                                Map<String, IndicesDTO> indicesPR, Map<String, IndicesDTO> indicesRS) {
        super(new DefaultTableModel(dados, colunas));
        this.dados = dados;
        this.colunas = colunas;
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesCJ = indicesCJ;
        this.indicesPR = indicesPR;
        this.indicesRS = indicesRS;
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
        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());
        Object obj = dados[row][10];
        if (obj instanceof Float) {
            Float tempo = (Float) obj;
            String hipoCod = IdentificaHipoCod.idIpoCod(dados[row][0]);
            Object objRaia = dados[row][2];
            String raia = (String) objRaia;
            IndicesDTO dto = null;
            switch (hipoCod) {
                case "GV":
                    dto = indicesGV.get(raia);
                    break;
                case "CJ":
                    dto = indicesCJ.get(raia);
                    break;
                case "RS":
                    dto = indicesRS.get(raia);
                    break;
                case "PR":
                    dto = indicesPR.get(raia);
                    break;
            }
            if (tempo > 0 && dto != null) {
                Color corDaLinha = identificaCorDaLinha.corDaLinhaPeloTempoGeral(tempo, dto);
                if (corDaLinha == null) return null;
                Color corAjustada = ajustarCorAutomaticamente(corDaLinha);
                comp.setBackground(corAjustada);
                comp.setForeground(Color.BLACK);
            }
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

    public void inicia() {
        this.setModel(new DefaultTableModel(dados, colunas));
        this.revalidate();
        this.repaint();
    }
}
