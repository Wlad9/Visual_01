package asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Map;

public class Pag_Filtros_01_v2 {
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesRS;
    private final Map<String, IndicesDTO> indicesCJ;
    private JTable jt_TabFiltro1;
    private JPanel contentPane;
    private JPanel jp_JPTabFiltro1;
    private JScrollPane js_JSTabFiltro1;

    public Pag_Filtros_01_v2(Map<String, IndicesDTO> indicesGeral, Map<String, IndicesDTO> indicesGV,
                             Map<String, IndicesDTO> indicesPR, Map<String, IndicesDTO> indicesRS,
                             Map<String, IndicesDTO> indicesCJ) {
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesPR = indicesPR;
        this.indicesRS = indicesRS;
        this.indicesCJ = indicesCJ;

    }

    public void inicia_mk1(Object[][] dados, String[] titulosTabela) {
        DefaultTableModel model = new DefaultTableModel(dados, titulosTabela) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jt_TabFiltro1.setModel(model);
        final String filtroInicial = "P2";

        CorRenderizador renderer = new CorRenderizador(
                dados,
                filtroInicial,
                this.indicesGeral,
                this.indicesGV,
                this.indicesPR,
                this.indicesRS,
                this.indicesCJ
        );
        for (int i = 0; i < titulosTabela.length; i++) {
            jt_TabFiltro1.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        JFrame frame = new JFrame("Tela de Filtros");
        frame.setContentPane(this.contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
