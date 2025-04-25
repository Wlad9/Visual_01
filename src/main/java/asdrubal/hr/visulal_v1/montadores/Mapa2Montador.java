package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.services.TempService;

import java.util.Map;

public class Mapa2Montador {
    public Map<Integer, DTO_TabelaCompetidores> montaMapa2(TempService tempService, Integer idPareo, Integer idPrograma) {
        return tempService.montaMapa2(idPareo, idPrograma);
    }
}
