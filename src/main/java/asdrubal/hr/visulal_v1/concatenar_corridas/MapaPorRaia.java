package asdrubal.hr.visulal_v1.concatenar_corridas;

import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;

import java.util.*;

public class MapaPorRaia {

    public Map<String, List<Object[]>> inicia(Set<String> raias, Object[][] dados) {
        DataSeparator ds = new DataSeparator();
        Map<String, List<Object[]>> mapaK9 = ds.agrupa(dados);
        for (Map.Entry<String, List<Object[]>> entry : mapaK9.entrySet()) {
            System.out.println("Raia: " + entry.getKey());
            for (Object[] linha : entry.getValue()) {
                System.out.println(Arrays.toString(linha));
            }
        }


        int nrLinhas = dados.length;
        int nrColunas = dados[0].length;
        ShowObjectBiDim.show(dados, "********************");
        Map<String, List<Object[]>> mapa = new HashMap<>();//raia, Lista de Obj da linha
        List<Object[]> objetos = new ArrayList<>();
        for (String raia : raias) {
            Object[] obj = new Object[nrColunas];
            for (int i = 0; i < nrLinhas; i++) {
                if (dados[i][0] != null) {
                    String r = dados[i][0].toString();
                    if (raia.equalsIgnoreCase(r)) {
//                        DataSeparator ds = new DataSeparator();
//                        objetos = separaDados(i, nrLinhas, dados, raia);
                    }
                }
            }
            mapa.put(raia, objetos);
        }
        return mapa;
    }

    private List<Object[]> separaDados(int x, int nrLinhas, Object[][] dados, String raia) {
        if (x + 1 > nrLinhas) {
            return null;
        }
        boolean raiaIgual = true;
        List<Object[]> lista = new ArrayList<>();
        Object[] obj = new Object[nrLinhas];
        int index = x + 1;
        do {
            obj = dados[index++];
            lista.add(obj);
            if (dados[index][2] == null) {

            }
        } while (raiaIgual);

        for (int i = index; i < nrLinhas; i++) {
            if (dados[i][2] == null) {
                if (dados[1][0] != null) {
                    String r = dados[i][0].toString();
                    if (r.equalsIgnoreCase(raia)) {

                    }
                }
            }
            obj = dados[i];
            lista.add(obj);
        }
        return lista;
    }
}
