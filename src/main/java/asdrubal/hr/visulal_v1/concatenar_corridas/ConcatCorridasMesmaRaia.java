package asdrubal.hr.visulal_v1.concatenar_corridas;

import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import java.util.*;

public class ConcatCorridasMesmaRaia {
    private final Object[][] dados;
    int nrLinhas;
    int nrColunas;

    public ConcatCorridasMesmaRaia(Object[][] cavalosMesmoPareo) {
        dados = cavalosMesmoPareo;

    }

    public Object[][] inicia() {
        if (dados.length == 0) {
            return null;
        }
        nrLinhas = dados.length;
        nrColunas = dados[0].length;
        Set<String> raias = identificaRaiasExistentes();

        MapaPorRaia mpr = new MapaPorRaia();
        Map<String, List<Object[]>> mapaD = mpr.inicia(raias, dados);

        for (Map.Entry<String, List<Object[]>> entry : mapaD.entrySet()) {
            System.out.println("\nRaia>" + entry.getKey());
            List<Object[]> ob = entry.getValue();
            for (Object[] x : ob) {
                ShowObjetoUniDim.show(x, "");
            }
        }


        String raia = "";
        String data = "";
        for (int i = 0; i < nrLinhas; i++) {
            Object[] obj = new Object[nrColunas];
            if (dados[i][2] == null) {
                if (dados[i][0] != null) {
                    raia = dados[i][0].toString();
                    data = dados[i][1].toString();
                }
            }

        }
        return null;
    }

    private Set<String> identificaRaiasExistentes() {
        Set<String> raias = new TreeSet<>();
        for (int i = 0; i < nrLinhas; i++) {
            if (dados[i][0] != null) {
                String raia = dados[i][0].toString().trim();
                raias.add(raia);
            }
        }
        return raias;
    }
}
