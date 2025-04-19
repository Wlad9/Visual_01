package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.entities.Competidor;
import asdrubal.hr.visulal_v1.repositoreis.CompetidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetidorService {
    @Autowired
    private CompetidorRepository competidorRepository;

    public List<CompetidorDTO> buscaListaDeCompetidores(List<Integer> listaIds) {
        List<CompetidorDTO> listaDTO = new ArrayList<>();
        Optional<List<Competidor>> listaOptional = competidorRepository.findByIdCompetidorIn(listaIds);
        if (listaOptional.isPresent()) {
            List<Competidor> listaCompetidores = listaOptional.get();
            listaDTO = listaCompetidores.stream()
                    .map(this::converteParaDTO)
                    .collect(Collectors.toList());
        }
        return listaDTO;
    }

    private CompetidorDTO converteParaDTO(Competidor competidor) {
        return new CompetidorDTO(competidor);
    }

}
