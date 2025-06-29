package asdrubal.hr.visulal_v1.filtro_raia;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiltrarMapaPorRais {
    public Map<String, List<CompetidorDTO>> inicia(List<String> raiasFiltro, Map<Integer, List<CompetidorDTO>> mapa3, List<Integer> idsSelec) {
        Map<String, List<CompetidorDTO>> mapa = new HashMap<>();
        for (String raia : raiasFiltro) {
            List<CompetidorDTO> lista = new ArrayList<>();
            for (Integer idCavalo : idsSelec) {
                List<CompetidorDTO> lDTO = mapa3.get(idCavalo);
                for (CompetidorDTO cDTO : lDTO) {
                    if (cDTO.getRaia().equalsIgnoreCase(raia)) {
                        lista.add(cDTO);
                    }
                }
                if (!lista.isEmpty()) {
                    mapa.put(raia, lista);
                }
            }
        }
        return mapa;
    }
}