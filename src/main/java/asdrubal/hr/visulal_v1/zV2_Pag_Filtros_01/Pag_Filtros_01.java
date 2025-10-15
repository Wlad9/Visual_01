package asdrubal.hr.visulal_v1.zV2_Pag_Filtros_01;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;

import javax.swing.*;
import java.util.Map;

public class Pag_Filtros_01 extends JFrame{
    private final Object[][] dados;
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesRS;
    private final Map<String, IndicesDTO> indicesCJ;
    private final String[] tituloColunas;
    private JTable jt_Filtros_01;
    private JPanel contentPane;
    private JPanel jp_Filtros_01;
    private JLabel jl_Filtros_01;
    private JScrollPane js_Filtros_01;

    public Pag_Filtros_01(Object[][] dadosFiltradosSoGrama, Map<String, IndicesDTO> indicesGeral,
                          Map<String, IndicesDTO> indicesGV, Map<String, IndicesDTO> indicesPR,
                          Map<String, IndicesDTO> indicesRS, Map<String, IndicesDTO> indicesCJ, String[] titulosPareos) {
        dados = dadosFiltradosSoGrama;
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesPR = indicesPR;
        this.indicesRS = indicesRS;
        this.indicesCJ = indicesCJ;
        tituloColunas = titulosPareos;
        setContentPane(contentPane);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void inicia(String filtro) {
        ShowObjectBiDim.show(dados, "Dados filtrados grama.");
        Tabela_Filtros_01 tabelaFiltros01 = new Tabela_Filtros_01(indicesGeral, indicesGV, indicesCJ,
                indicesPR, indicesRS, dados, tituloColunas);
        tabelaFiltros01.inicia(filtro);
    }
}
