package asdrubal.hr.visulal_v1.filtros_tela_analise2;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.show.MapaIdsPareos_Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiltroSoDistancia {
    public static Map<String, List<CompetidorDTO>> filtra(Map<String, List<CompetidorDTO>> mapaX, List<String> distancias) {
        Map<String, List<CompetidorDTO>> mapaRetorno = new HashMap<>();
        for (String distancia : distancias) {
            List<CompetidorDTO> selecao = new ArrayList<>();
            int dist1 = Integer.parseInt(distancia);
            for (Map.Entry<String, List<CompetidorDTO>> entry : mapaX.entrySet()) {
                List<CompetidorDTO> lDTO = entry.getValue();
                for (CompetidorDTO cDTO : lDTO) {
                    String raia = cDTO.getRaia();
                    int dist2 = separaDistancia(raia);
                    if (dist1 == dist2) {
                        selecao.add(cDTO);
                    }
                }
            }
        }


        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaX.entrySet()) {
            List<CompetidorDTO> lDTO = entry.getValue();
            List<CompetidorDTO> selecao = new ArrayList<>();
            for (String distancia : distancias) {
                int dist1 = Integer.parseInt(distancia);
                for (CompetidorDTO cDTO : lDTO) {
                    String raia = cDTO.getRaia();
                    int dist2 = separaDistancia(raia);
                    if (dist1 == dist2) {
                        selecao.add(cDTO);
                    }
                }
            }
            mapaRetorno.put(entry.getKey(), selecao);
        }
        return mapaRetorno;
    }

    private static int separaDistancia(String raia) {
        String nr = raia.replaceAll("[^0-9]", "").trim();
        return Integer.parseInt(nr);
    }
}
