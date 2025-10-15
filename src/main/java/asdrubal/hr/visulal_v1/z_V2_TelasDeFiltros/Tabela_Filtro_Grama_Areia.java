package asdrubal.hr.visulal_v1.z_V2_TelasDeFiltros;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.IdentificaCorDaLinha;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.IdentificaHipoCod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.Map;

public class Tabela_Filtro_Grama_Areia extends JTable {
    private final Object[][] dados;
    private final String[] titulos;
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesRS;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesCJ;
    private Identifa_A_CorDaFaixa idCorFaixa;

    public Tabela_Filtro_Grama_Areia(Object[][] dados, String[] titulos, Map<String, IndicesDTO> indicesGeral,
                                     Map<String, IndicesDTO> indicesGV, Map<String, IndicesDTO> indicesRS,
                                     Map<String, IndicesDTO> indicesPR, Map<String, IndicesDTO> indicesCJ) {
        super(new DefaultTableModel(dados,titulos));
        idCorFaixa = new Identifa_A_CorDaFaixa();
        this.dados = dados;
        this.titulos = titulos;
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesRS = indicesRS;
        this.indicesPR = indicesPR;
        this.indicesCJ = indicesCJ;
        setGridColor(Color.DARK_GRAY);
        setShowHorizontalLines(true);
        setShowVerticalLines(true);
        setIntercellSpacing(new Dimension(1, 1));

        SwingUtilities.invokeLater(() -> {
            setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            TableColumnModel cm = getColumnModel();
            cm.getColumn(0).setPreferredWidth(145);
            cm.getColumn(1).setPreferredWidth(30);
            cm.getColumn(2).setPreferredWidth(75);
            cm.getColumn(3).setPreferredWidth(100);
            cm.getColumn(4).setPreferredWidth(75);
            cm.getColumn(5).setPreferredWidth(45);
            cm.getColumn(6).setPreferredWidth(100);
            cm.getColumn(7).setPreferredWidth(115);
            cm.getColumn(8).setPreferredWidth(55);
            cm.getColumn(9).setPreferredWidth(25);
            cm.getColumn(10).setPreferredWidth(68);
            cm.getColumn(11).setPreferredWidth(67);
        });
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
//            System.out.println("Tempo:"+tempo+"\tHip:"+hipoCod+"\traia:"+raia+"\nDTO:"+dto);
            if (tempo > 0 && dto != null) {
                Color corDaLinha = idCorFaixa.corDaFaixa(tempo, dto);
                if (corDaLinha == null) return null;
                Color corAjustada = ajustarCorAutomaticamente(corDaLinha);
                comp.setBackground(corAjustada);
                comp.setForeground(Color.BLACK);
//              comp.setBackground(corClara);
            }
        }
        return comp;
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

    private Color ajustarCorAutomaticamente(Color cor) {
//        double brilho = 0.299 * cor.getRed() + 0.587 * cor.getGreen() + 0.114 * cor.getBlue();
        double brilho = 0.450 * cor.getRed() + 0.550 * cor.getGreen() + 0.214 * cor.getBlue();

        // Se for escura (brilho < 128), clareia
        if (brilho < 128) {
            return clarearCor(cor, 0.5f); // clareia 50%
        }
        return cor;
    }
}
