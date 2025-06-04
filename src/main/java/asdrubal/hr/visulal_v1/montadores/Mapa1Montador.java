package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapa1Montador {
    public Map<Integer, DTO_JT_tabPareos> montaMapa1(List<DTO_JT_tabPareos> listaDTO) {
        return listaDTO.stream().
                collect(Collectors.toMap(DTO_JT_tabPareos::getOrdem, dto -> dto));
    }
}
