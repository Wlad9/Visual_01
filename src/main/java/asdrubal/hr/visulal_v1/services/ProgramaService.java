package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.entities.Programa;
import asdrubal.hr.visulal_v1.repositoreis.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramaService {
    @Autowired
    private ProgramaRepository programaRepository;

    public List<ProgramaDTO> findByProgOpen() {
        List<Programa> programas = programaRepository.findBySt(1);
        System.out.println("retorno="+programas.size());
        List<ProgramaDTO> lista = new ArrayList<>();
        if (programas != null) {
            for (Programa entity : programas) {
                ProgramaDTO dto = new ProgramaDTO(entity);
                lista.add(dto);
            }
            return lista;
        }
        return null;
    }
}
