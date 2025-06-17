package asdrubal.hr.visulal_v1.show;

import java.util.List;
import java.util.Map;

public class MapaCorridasComuns_Show {
    public static void showMapa(Map<String, List<Integer>> corridasComuns) {
        System.out.println("\nMapa corridasComuns-----------------------------------------------");
        for (Map.Entry<String, List<Integer>> entry : corridasComuns.entrySet()) {
            System.out.println("\nDupla:" + entry.getKey());
            int cont = 0;
            List<Integer> lista = entry.getValue();
            for (Integer id : lista) {
                System.out.println("idPareo:" + id);
                cont++;
            }
            System.out.println("Total de páreo:" + cont);
        }
    }
}
