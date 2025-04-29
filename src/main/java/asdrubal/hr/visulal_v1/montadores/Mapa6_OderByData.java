package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa6_OderByData {
    public Map<Integer, List<CompetidorDTO>> ordena(Map<Integer, List<CompetidorDTO>> mapa3) {
        Map<Integer, List<CompetidorDTO>> mapa = new HashMap<>();
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa3.entrySet()) {
            Integer id = entry.getKey();
            List<CompetidorDTO> lista = entry.getValue();
            lista.sort((Comparator.comparing(CompetidorDTO::getData).reversed()));
//            lista.sort(Comparator.comparing(CompetidorDTO::getData));
            mapa.put(id, lista);
        }
        return mapa;
    }
}
