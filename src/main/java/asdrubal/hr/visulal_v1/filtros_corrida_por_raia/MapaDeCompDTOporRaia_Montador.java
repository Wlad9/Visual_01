package asdrubal.hr.visulal_v1.filtros_corrida_por_raia;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.*;

public class MapaDeCompDTOporRaia_Montador {
    public Map<String, List<CompetidorDTO>> monta(Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO, Set<String> raias) {
        Map<String, List<CompetidorDTO>> mapa = new HashMap<>();
        for (String raia : raias) {
            List<CompetidorDTO> listaCompetidorDTO = new ArrayList<>();
            for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapaDeCorridasDTO.entrySet()) {
                List<CompetidorDTO> listaDTO = entry.getValue();
                for (CompetidorDTO cDTO : listaDTO) {
                    if (raia.equalsIgnoreCase(cDTO.getRaia())) {
                        listaCompetidorDTO.add(cDTO);
                    }
                }
            }
            if (!listaCompetidorDTO.isEmpty()) {
                mapa.put(raia, listaCompetidorDTO);
            }
        }
        return mapa;
    }
}
