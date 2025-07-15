package asdrubal.hr.visulal_v1.corridas_na_mesma_raia;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.ArrayList;
import java.util.List;

public class SeparaCorridaPorRaiaCompetidor {
    public List<CompetidorDTO> separa(List<CompetidorDTO> lDTO, String raia) {
        List<CompetidorDTO> lista = new ArrayList<>();
        raia = raia.trim();
        for (CompetidorDTO cDTO : lDTO) {
            String r = cDTO.getRaia().trim();
            if (raia.equalsIgnoreCase(r)) {
                lista.add(cDTO);
            }
        }
        return lista;
    }
}
