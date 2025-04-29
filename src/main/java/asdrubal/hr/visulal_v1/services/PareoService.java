package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.PareoDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.entities.Pareo;
import asdrubal.hr.visulal_v1.repositories.PareoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PareoService {
    @Autowired
    private PareoRepository pareoRepository;

    @Transactional(readOnly = true)
    public PareoDTO findById(Integer idPareo) {
        Optional<Pareo> optional = pareoRepository.findById(idPareo);
        if (optional.isPresent()) {
            Pareo entity = optional.get();
            return new PareoDTO(entity);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<DTO_JT_tabPareos> buscaListaDePareos(List<Integer> ids) {
        return pareoRepository.findByIdPareoIn(ids)
                .orElse(Collections.emptyList())
                .stream()
                .map(DTO_JT_tabPareos::new)
                .collect(Collectors.toList());
    }
}
// return pareoRepository.findByIdIn(ids)
//            .orElse(Collections.emptyList())
//            .stream()
//            .map(DTO_JT_tabPareos::new)
//            .collect(Collectors.toList());
