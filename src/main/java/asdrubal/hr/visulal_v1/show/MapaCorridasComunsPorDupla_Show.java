package asdrubal.hr.visulal_v1.show;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;

import java.util.List;
import java.util.Map;

public class MapaCorridasComunsPorDupla_Show {
    public static void showMapaCorridasComunsPorDupla(Map<String, List<DTO_x>> mapa) {
        for(Map.Entry<String, List<DTO_x>> entry : mapa.entrySet()){
            System.out.println("\nDupla:"+entry.getKey());
            List<DTO_x> lista = entry.getValue();
//            for(DTO_x dto: lista){
//                System.out.println(dto);
//            }
        }
    }
    public static void  showMapaIdsPareos(Map<Integer, List<Integer>>  mapa){
        for(Map.Entry<Integer, List<Integer>> entry: mapa.entrySet()){
            System.out.println("\nidCavalo:"+entry.getKey());
            List<Integer> lista = entry.getValue();
            int cont=0;
            for(Integer id:lista){
                System.out.println("idPareo:"+id);
                ++cont;
            }
            System.out.println("Total de páreo:"+cont);
        }
    }
}
