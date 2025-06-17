package asdrubal.hr.visulal_v1.show;

import java.util.List;
import java.util.Map;

public class MapaIdsPareos_Show {
    public static void showMapaIdsPareos(Map<Integer, List<Integer>> mapaIdsPareos) {
        System.out.println("\nMapa idsPareo---------------------------");
        for(Map.Entry<Integer, List<Integer>> entry: mapaIdsPareos.entrySet()){
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
