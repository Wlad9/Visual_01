package asdrubal.hr.visulal_v1.show;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;

import java.util.List;
import java.util.Map;

public class MapaCorridasComunsPorDupla_Show {
    public static void showMapaCorridasComunsPorDupla(Map<String, List<DTO_x>> mapa) {
        for(Map.Entry<String, List<DTO_x>> entry : mapa.entrySet()){
            System.out.println("\nDupla:"+entry.getKey());
            List<DTO_x> lista = entry.getValue();
            for(DTO_x dto: lista){
                System.out.println(dto);
            }
        }
    }
}
