package asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class Pag_Filtros_01_v3 extends JFrame{
    private final Object[][] dados;
    private final String[] titulosColunas;
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesRS;
    private final Map<String, IndicesDTO> indicesCJ;
    private JPanel contentPane;
    private JPanel jp_TabelaFiltro;
    private JLabel jl_TabelaFiltro;
    private JScrollPane js_TabelaFiltro;
    private JTable jt_TabelaFiltro;

    public Pag_Filtros_01_v3(Object[][] dadosFiltradosSoGrama, String[] titulosColunas, Map<String, IndicesDTO> indicesGeral,
                             Map<String, IndicesDTO> indicesGV, Map<String, IndicesDTO> indicesPR,
                             Map<String, IndicesDTO> indicesRS, Map<String, IndicesDTO> indicesCJ) {
        dados = dadosFiltradosSoGrama;
        this.titulosColunas = titulosColunas;
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesPR = indicesPR;
        this.indicesRS = indicesRS;
        this.indicesCJ = indicesCJ;
        this.setContentPane(contentPane); // Adiciona o painel principal ao JFrame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Filtros V3");
    }

    public void inicia() {
        Tabela_Filtros_01_v3 tabela = new Tabela_Filtros_01_v3(dados, titulosColunas, indicesGeral,
                indicesGV, indicesCJ, indicesPR, indicesRS);
        tabela.inicia();

//        DefaultTableModel model = new DefaultTableModel(dados, titulosColunas);
//
//        jt_TabelaFiltro.setModel(model);
//        JFrame frame = new JFrame("xxxxxxxxxxxxxxxxxx");
//        frame.setContentPane(this.contentPane);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);








//
//        js_TabelaFiltro.setViewportView(tabela);
////        js_TabelaFiltro = new JScrollPane(jt_TabelaFiltro);
////        jp_TabelaFiltro = new JPanel(new BorderLayout());
////        jp_TabelaFiltro.add(js_TabelaFiltro, BorderLayout.CENTER);
//
//        setTitle("Filtros - Exibição");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setContentPane(contentPane);
//        setSize(1200, 600);
//        setLocationRelativeTo(null); // centraliza
//        setVisible(true); // <-- ESSENCIAL
    }
}
