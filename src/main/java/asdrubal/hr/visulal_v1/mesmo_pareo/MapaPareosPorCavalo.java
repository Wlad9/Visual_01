package asdrubal.hr.visulal_v1.mesmo_pareo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapaPareosPorCavalo {

    public static Map<Integer, List<Integer>> inverteMapa(Map<Integer, List<Integer>> mapaCavaloPareo) {
        Map<Integer, List<Integer>> mapaPareoCavalos = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : mapaCavaloPareo.entrySet()) {
            Integer idCavalo = entry.getKey();
            List<Integer> listaPareo = entry.getValue();

            for (Integer idPareo : listaPareo) {
                // Adiciona o cavalo ao páreo correspondente
                mapaPareoCavalos
                        .computeIfAbsent(idPareo, k -> new ArrayList<>())
                        .add(idCavalo);
            }
        }
        return mapaPareoCavalos;
    }
}