package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class RenderTipoRaias {
    private final Component comp;
    private final int nrColunas;
    private final Object[][] dados;
    private final Map<String, IndicesDTO> mapaIndices;
    private final int row;
    private final List<String> raiasFiltro;

    public RenderTipoRaias(Component comp, int nrColunas, Object[][] dados, Map<String, IndicesDTO> mapaIndices, int row, List<String> raiasFiltro) {
        this.comp = comp;
        this.nrColunas = nrColunas;
        this.dados = dados;
        this.mapaIndices = mapaIndices;
        this.row = row;
        this.raiasFiltro = raiasFiltro;
    }

    public Component inicia() {
        int quantidade = 0;




//        System.out.println("\ninicianando raias;;;;;;;;;;;;;;;;;;;");
//        for (String raia : raiasFiltro) {
//            System.out.println("\nRAIA--->:" + raia);
//            for (int i = 0; i < dados.length; i++) { // Loop pelas linhas
//                if (dados[i] != null) {
//                    StringBuilder linha = new StringBuilder();
//                    for (int j = 0; j < dados[i].length; j++) { // Loop pelas colunas da linha atual
//                        Object valor = dados[i][j];
//                        linha.append(valor == null ? "" : valor.toString());
//                        if (j < dados[i].length - 1) {
//                            linha.append(" - ");
//                        }
//                    }
////                    System.out.println("Linha " + i + ": " + linha.toString());
//                    System.out.println(linha.toString());
//                } else {
//                    System.out.println("Linha " + i + ": (nula)");
//                }
//            }
//        }
        return null;
    }
}
