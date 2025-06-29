package asdrubal.hr.visulal_v1.concatenar_corridas;

import asdrubal.hr.visulal_v1.show.ShowMapaK9;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataSeparator {
    public Map<String, List<Object[]>> agrupa(Object[][] dados) {
        Map<String, List<Object[]>> mapa = new LinkedHashMap<>();
        String raiaAtual = null;

        for (Object[] linha : dados) {
            if (linha == null || linha.length == 0) continue;

            // Se a primeira e segunda colunas estão preenchidas, é linha título
            if (linha[0] != null && linha[1] != null) {
                raiaAtual = linha[0].toString();
                mapa.putIfAbsent(raiaAtual, new ArrayList<>());
                mapa.get(raiaAtual).add(linha);
            } else if (raiaAtual != null) {
                // Linha do bloco da raia atual
                mapa.get(raiaAtual).add(linha);
            }
        }
        ShowMapaK9.show(mapa, "MapaK9");
        return mapa;
    }
}


//
//    private boolean isLinhaTitulo(Object[] linha) {
//        // Regra: linha é título se 1ª posição preenchida e posições 2 até 10 forem nulas ou irrelevantes
//        for (int i = 1; i < linha.length; i++) {
//            if (linha[i] != null) {
//                // Se tem tempo, posição, cavalo, etc, então não é título
//                return false;
//            }
//        }
//        return true;
//    }
