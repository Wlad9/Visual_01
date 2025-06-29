package asdrubal.hr.visulal_v1.mesmo_pareo;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MesmoPareoEntreCavalos {
    public Map<Integer, List<Integer>> identifica(Map<Integer, List<CompetidorDTO>> mapa3) {
        Map<Integer, List<Integer>> mapa = new HashMap<>();
        for(Map.Entry<Integer, List<CompetidorDTO>> entry: mapa3.entrySet()) {
            List<CompetidorDTO> listaCompetidores = entry.getValue();
            for (CompetidorDTO cDTO : listaCompetidores) {
                Integer idPareo = cDTO.getIdDoPareo();
                Integer idCavalo = cDTO.getIdCavalo();
                // Se ainda não existe a chave, cria a lista
                mapa.computeIfAbsent(idPareo, k -> new ArrayList<>()).add(idCavalo);
            }
        }
        mapa.entrySet().removeIf(e -> e.getValue().size() <= 1);// Agora, remover páreos que só têm 1 cavalo
        return mapa;
    }
}
