package asdrubal.hr.visulal_v1.show;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;
import java.util.Map;

public class Mapa3_Show {
    public static void show(Map<Integer, List<CompetidorDTO>> mapa3, String titulo) {
        System.out.println(titulo);
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa3.entrySet()) {
            System.out.println("id:" + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
