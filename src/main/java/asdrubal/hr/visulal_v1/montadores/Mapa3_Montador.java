package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.services.CompetidorService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa3_Montador {
    private final CompetidorService competidorService;

    public Mapa3_Montador(CompetidorService competidorService) {
        this.competidorService = competidorService;
    }

    public Map<Integer, List<CompetidorDTO>> montaMapa(Map<Integer, DTO_TabelaCompetidores> mapa2) {
        Map<Integer, List<CompetidorDTO>> mapa3 = new HashMap<>();
        List<Integer> idsCavalos = new ArrayList<>();
        for (Integer id : mapa2.keySet()) {
            List<CompetidorDTO> lista = competidorService.buscaCorridasPorIdCavalo(id);
            mapa3.put(id, lista);
        }
        return mapa3;
    }
}
