package asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Map;

public class Tabela_Filtros_01 extends JTable {
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesCJ;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesRS;
    private final Object[][] dados;
    private final String[] tituloColunas;

    public Tabela_Filtros_01(Map<String, IndicesDTO> indicesGeral, Map<String, IndicesDTO> indicesGV,
                             Map<String, IndicesDTO> indicesCJ, Map<String, IndicesDTO> indicesPR,
                             Map<String, IndicesDTO> indicesRS, Object[][] dados, String[] tituloColunas) {
        super(new DefaultTableModel(dados, tituloColunas));
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesCJ = indicesCJ;
        this.indicesPR = indicesPR;
        this.indicesRS = indicesRS;
        this.dados = dados;
        this.tituloColunas = tituloColunas;
    }

    public void inicia(String filtro) {

    }
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component comp = super.prepareRenderer(renderer, row, column);
        // Reset estilo
        comp.setFont(getFont());
        comp.setForeground(getForeground());
        comp.setBackground(getBackground());
        return comp;
    }

}
