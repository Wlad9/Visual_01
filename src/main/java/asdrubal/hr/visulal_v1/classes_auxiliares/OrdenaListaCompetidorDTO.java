package asdrubal.hr.visulal_v1.classes_auxiliares;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.Comparator;
import java.util.List;

public class OrdenaListaCompetidorDTO {
    public void porColocacao(List<CompetidorDTO> lDTO) {
        lDTO.sort(Comparator.comparingInt(CompetidorDTO::getColocacao));
    }
}
