package asdrubal.hr.visulal_v1.corridas_na_mesma_raia;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.*;
import java.util.stream.Collectors;

public class SeparaCompetidorPorRaia {
    public Map<String, List<CompetidorDTO>> inicia(Map<Integer, List<CompetidorDTO>> mapa, List<Object[]> dados, List<String> raias) {
        Map<String, List<CompetidorDTO>> mapaRetorno = new HashMap<>();
        for (String raia : raias) {
            List<CompetidorDTO> corridasNaRaia = new ArrayList<>();
            for (Object[] obj : dados) {
                Integer idCavalo = Integer.parseInt(obj[2].toString());
                List<CompetidorDTO> lDTO = mapa.get(idCavalo);
                SeparaCorridaPorRaiaCompetidor scrc = new SeparaCorridaPorRaiaCompetidor();
                corridasNaRaia.addAll(scrc.separa(lDTO, raia));
            }
            corridasNaRaia.sort(Comparator.comparing(CompetidorDTO::getTempo));
            mapaRetorno.put(raia, corridasNaRaia);
        }

        return mapaRetorno;
    }

    private List<CompetidorDTO> ordenaListaPorTempo(List<CompetidorDTO> lDTO) {
        List<CompetidorDTO> lista = lDTO.stream().filter(c -> c.getTempo() > 0f)
                .sorted(Comparator.comparing(CompetidorDTO::getTempo))
                .collect((Collectors.toList()));
        return lista;
    }
}
