package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_Temp;
import asdrubal.hr.visulal_v1.entities.Programa;
import asdrubal.hr.visulal_v1.entities.Temp;
import asdrubal.hr.visulal_v1.repositories.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TempService {
    @Autowired
    private TempRepository tempRepository;

    @Transactional(readOnly = true)
    public List<DTO_Temp> findByCompetidores(Integer idPrograma, Integer idPareo) {
        return tempRepository.findByIdDoProgramaAndIdDoPareo(idPrograma, idPareo)
                .orElse(Collections.emptyList())
                .stream()
                .map(DTO_Temp::new).collect(Collectors.toList());

    }
    @Transactional(readOnly = true)
    public Map<Integer, DTO_TabelaCompetidores> montaMapa2(Integer idPareo, Integer idPrograma) {
        return findByCompetidores(idPrograma, idPareo).stream()
                .collect(Collectors.toMap(
                        DTO_Temp::getIdCavalo,
                        DTO_TabelaCompetidores::new
                ));
    }
}
