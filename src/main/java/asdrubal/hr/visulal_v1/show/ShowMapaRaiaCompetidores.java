package asdrubal.hr.visulal_v1.show;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;
import java.util.Map;

public class ShowMapaRaiaCompetidores {
    public static void showMapa(Map<String, List<CompetidorDTO>> mapaRaiaCompetidores) {
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaRaiaCompetidores.entrySet()) {
//            System.out.println("\n=====>*>" + entry.getKey());
            List<CompetidorDTO> lista = entry.getValue();
            for (CompetidorDTO cDTO : lista) {
                System.out.println("Raia:" + cDTO.getRaia() + "\tCavalo:" + cDTO.getCavalo() + "\tData:" + cDTO.getData() + "\tTempo:" + cDTO.getTempo() + "\tidComp:" + cDTO.getIdCompetidor());
            }
        }
    }
}
