package asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.Tabela_Dados_1;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;
import asdrubal.hr.visulal_v1.zV2_ClassesAuxiliares.SeparaDadosFiltroP3;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.IdentificaCorDaLinha;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.IdentificaHipoCod;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.Map;
import java.util.Set;

public class Tabela_Dados_1 extends JTable {
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesRS;
    private final Map<String, IndicesDTO> indicesCJ;
    private final Map<String, IndicesDTO> indicesOutros;
    private Object[][] dados;
    private String[] colunas;
    private String tipoDeFiltro;
    private Object[][] dadosP3;
    private int nrLinhas;
    private int nrColunas;
    private IdentificaCorDaLinha idCorLinha;

    public Tabela_Dados_1(Object[][] dadosMk2, String[] colunas, Set<Integer> negritoPareo,
                          String filtroTipo,
                          Map<String, IndicesDTO> indicesGeral,
                          Map<String, IndicesDTO> indicesGV,
                          Map<String, IndicesDTO> indicesPR,
                          Map<String, IndicesDTO> indicesRS,
                          Map<String, IndicesDTO> indicesCJ,
                          Map<String, IndicesDTO> indicesOutros) {
        super(new DefaultTableModel(dadosMk2, colunas));

        //Dados da largura das colunas da tabela
//        int largColA = this.getColumnModel().getColumn(3).getWidth();
//        int largColB = this.getColumnModel().getColumn(0).getWidth();
//        int tamanho = this.getColumnModel().getTotalColumnWidth();
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesPR = indicesPR;
        this.indicesRS = indicesRS;
        this.indicesCJ = indicesCJ;
        this.indicesOutros = indicesOutros;

//        Cor da grade
        setGridColor(Color.DARK_GRAY);

// Mostrar linhas horizontais e verticais
        setShowHorizontalLines(true);
        setShowVerticalLines(true);

// Aumentar a espessura da grade (usando Border personalizada)
        setIntercellSpacing(new Dimension(1, 1));

        idCorLinha = new IdentificaCorDaLinha(indicesGeral, indicesGV, indicesOutros);
        dados = dadosMk2;
        this.colunas = colunas;
        tipoDeFiltro = filtroTipo;
        setFillsViewportHeight(true);
        setRowHeight(20);
        setRowSelectionAllowed(false);
        nrColunas = colunas.length;
        switch (filtroTipo) {
            case "P1":
                ShowObjectBiDim.show(dadosMk2, "Dados MK2");
//                montaPadrao1();
                break;
            case "P2":
                break;
        }
    }

    private void montaPadrao1() {
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
        // Reset estilo
        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());
        switch (tipoDeFiltro) {
            case "P1":
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
                break;
            case "P2":
                Object obj2 = dados[row][10];
                if (obj2 instanceof Float) {
                    Float tempo = (Float) obj2;
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
                        Color corDaLinha = idCorLinha.corDaLinhaPeloTempoGeral(tempo, dto);
                        if (corDaLinha == null) return null;
                        Color corAjustada = ajustarCorAutomaticamente(corDaLinha);
                        comp.setBackground(corAjustada);
                        comp.setForeground(Color.BLACK);
                    }
                }
                break;
            case "P3":
                Object obj3 = dadosP3[row][10];
                if (obj3 instanceof Float) {
                    Float tempo = (Float) obj3;
                    String hipoCod = IdentificaHipoCod.idIpoCod(dadosP3[row][0]);
                    Object objRaia = dadosP3[row][2];
                    String raia = (String) objRaia;
                    System.out.println("RAIA---->"+raia);
                    if (raia.contains("G")) {
                        System.out.println("-===========Contem G:"+raia);
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
                            Color corDaLinha = idCorLinha.corDaLinhaPeloTempoGeral(tempo, dto);
                            if (corDaLinha == null) return null;
                            Color corAjustada = ajustarCorAutomaticamente(corDaLinha);
                            comp.setBackground(corAjustada);
                            comp.setForeground(Color.BLACK);
                        }
                    }
                }
                break;
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

    public void aplicaFiltroTipoP2() {
        tipoDeFiltro = "P2";
        this.setModel(new DefaultTableModel(dados, colunas));
        montaPadrao1();
        this.revalidate();
        this.repaint();
    }

    public void aplicaFiltroTipoP3() {
        SeparaDadosFiltroP3 sp3 = new SeparaDadosFiltroP3(dados);
        dadosP3 = sp3.aplicaFiltroSoGrama();
        System.out.println("Filtro P3");
        tipoDeFiltro = "P3";
        this.setModel(new DefaultTableModel(dados, colunas));
        montaPadrao1();
        this.revalidate();
        this.repaint();

    }
}
