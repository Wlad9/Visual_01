package asdrubal.hr.visulal_v1.show;

import java.util.List;
import java.util.Map;

public class ShowMapaK9 {
    public static void show(Map<String, List<Object[]>> mapa, String titulo) {
        System.out.println(titulo);
        for (Map.Entry<String, List<Object[]>> entry : mapa.entrySet()) {
            String raia = entry.getKey();
            List<Object[]> linhas = entry.getValue();

            System.out.println("\n=== Raia: " + raia + " ===");
            for (Object[] linha : linhas) {
                for (Object celula : linha) {
                    System.out.print((celula != null ? celula.toString() : "") + "\t");
                }
                System.out.println();
            }
        }
    }
}
