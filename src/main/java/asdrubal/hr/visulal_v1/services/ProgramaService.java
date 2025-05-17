package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.entities.Programa;
import asdrubal.hr.visulal_v1.repositories.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProgramaService {
    @Autowired
    private ProgramaRepository programaRepository;

    public Map<Integer,ProgramaDTO> findByProgOpen() {
        Map<Integer,ProgramaDTO> mapa = new HashMap<>();
        Optional<List<Programa>> optional = programaRepository.findBySt(1);
        if(optional.isPresent()){
            List<Programa> lista = optional.get();
            lista.stream().forEach(programa -> mapa.put(programa.getIdPrograma(), new ProgramaDTO(programa)));
            return mapa;
        }
        return null;
    }
}
