package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.*;
import java.util.stream.Collectors;

public class Mapa4_MontadorListaOrdenada {
    private List<CompetidorDTO> listaZero = new ArrayList<>();
    private Map<Integer, List<CompetidorDTO>> mapa5;

    public Map<Integer, List<CompetidorDTO>> ordenaLista(Map<Integer, List<CompetidorDTO>> mapa3) {
        mapa5 = new HashMap<>();
        Map<Integer, List<CompetidorDTO>> mapa4 = new HashMap<>();
        for (Integer idCavalo : mapa3.keySet()) {
            List<CompetidorDTO> listaDTO = mapa3.get(idCavalo);
            List<CompetidorDTO> lst = mapa3.get(idCavalo);
            List<CompetidorDTO> listaOrdenada = listaDTO.stream()
                    .filter(c -> c.getTempo() > 0f)
                    .sorted(Comparator.comparing(CompetidorDTO::getTempo))
                    .collect(Collectors.toList());
            listaZero = listaDTO.stream().filter(dto -> dto.getTempo() == 0f).collect(Collectors.toList());
            mapa4.put(idCavalo, listaOrdenada);
            mapa5.put(idCavalo, listaZero);
        }
        return mapa4;
    }

    public Map<Integer, List<CompetidorDTO>> getMapa5() {
        return mapa5;
    }
}
