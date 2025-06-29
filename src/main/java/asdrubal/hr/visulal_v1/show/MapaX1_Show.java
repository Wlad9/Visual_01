package asdrubal.hr.visulal_v1.show;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;
import java.util.Map;

public class MapaX1_Show {
    public static void show(Map<String, List<CompetidorDTO>> mapaX1, String titlo) {
        System.out.println(titlo);
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaX1.entrySet()) {
            System.out.println("\n" + entry.getKey());
            entry.getValue().forEach(System.out::println);
            System.out.println("\n");
        }
    }
}
