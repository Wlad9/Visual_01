package asdrubal.hr.visulal_v1.tabPesquisaAux;

import java.util.Set;
import java.util.TreeSet;

public class AuxMontaSetNegritoCorridasComuns {
    public static Set<Integer> inicia(Object[][] corridasComuns) {
        Set<Integer> negrito = new TreeSet<>();
        int tamanho = corridasComuns.length;
        for (int i = 0; i < tamanho; i++) {
            if (corridasComuns[i][4] == null && corridasComuns[i][5] == null) {
                negrito.add(i);
            }
        }
        return negrito;
    }
}
