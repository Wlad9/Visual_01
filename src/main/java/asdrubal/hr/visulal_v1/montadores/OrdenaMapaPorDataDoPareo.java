package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.*;

public class OrdenaMapaPorDataDoPareo {
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

    public Map<Integer, List<CompetidorDTO>> ordenaPorTempo(Map<Integer, List<CompetidorDTO>> mapa) {
        Map<Integer, List<CompetidorDTO>> mapaOrdenado = new HashMap<>();
        for (Integer key : mapa.keySet()) {
            List<CompetidorDTO> lista = mapa.get(key);
            List<CompetidorDTO> listaOrdenada = new ArrayList<>(lista);
            listaOrdenada.sort(Comparator.comparing(CompetidorDTO::getTempo));
            mapaOrdenado.put(key, listaOrdenada);
        }
        return mapaOrdenado;
    }
}
