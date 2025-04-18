package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.PareoDTO;
import asdrubal.hr.visulal_v1.entities.Pareo;
import asdrubal.hr.visulal_v1.repositoreis.PareoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
}
