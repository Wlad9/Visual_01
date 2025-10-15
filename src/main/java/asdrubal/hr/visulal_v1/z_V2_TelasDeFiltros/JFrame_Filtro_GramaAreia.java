package asdrubal.hr.visulal_v1.z_V2_TelasDeFiltros;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class JFrame_Filtro_GramaAreia extends JFrame {
    private final Object[][] dados;
    private final String[] titulos;
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesPR;
    private final Map<String, IndicesDTO> indicesRS;
    private final Map<String, IndicesDTO> indicesCJ;
    private JPanel contentPane;
    private JPanel jp_TabelaFiltro;
    private JScrollPane js_TabelaFiltro;
    private JTable jt_TabelaFiltro;

    public JFrame_Filtro_GramaAreia(Object[][] dados, String[] titulos,
                                    Map<String, IndicesDTO> indicesGeral, Map<String, IndicesDTO> indicesGV,
                                    Map<String, IndicesDTO> indicesPR, Map<String, IndicesDTO> indicesRS,
                                    Map<String, IndicesDTO> indicesCJ) {
        this.dados = dados;
        this.titulos = titulos;
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesPR = indicesPR;
        this.indicesRS = indicesRS;
        this.indicesCJ = indicesCJ;
    }

    public void inicia() {
        Tabela_Filtro_Grama_Areia tabelaFiltroGramaAreia = new Tabela_Filtro_Grama_Areia(dados, titulos, indicesGeral,
                indicesGV, indicesRS, indicesPR, indicesCJ);
        JScrollPane scroll = new JScrollPane(tabelaFiltroGramaAreia);
        scroll.setBorder(BorderFactory.createTitledBorder("Tabela Filtro Grama/Areia"));

        // Define o painel principal
        contentPane = new JPanel(new BorderLayout());
        contentPane.add(scroll, BorderLayout.CENTER);

        // Configura o JFrame
        setContentPane(contentPane);
        setTitle("Filtros Grama/Areia");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
