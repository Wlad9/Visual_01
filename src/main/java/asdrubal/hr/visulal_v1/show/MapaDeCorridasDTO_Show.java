package asdrubal.hr.visulal_v1.show;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.Map;

public class MapaDeCorridasDTO_Show {
    public static void showMapaDeCorridasDTO(Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO) {
        System.out.println("\nMapa de CorridasDTO-----------------------------------------------------");
        for(Map.Entry<Integer, List<CompetidorDTO>>entry:mapaDeCorridasDTO.entrySet()){
            System.out.println("\nidCavalo:"+entry.getKey());
            int cont=0;
            List<CompetidorDTO> lista = entry.getValue();
            for(CompetidorDTO dto:lista){
                System.out.println("Cavalo:"+dto.getCavalo()+"\tidCavalo:"+dto.getIdCavalo()+"\tRaia:"+dto.getRaia()
                        +"\tidPareo:"+dto.getIdDoPareo());
                ++cont;
            }
            System.out.println("Total de corridas:"+cont);
        }
    }
}
