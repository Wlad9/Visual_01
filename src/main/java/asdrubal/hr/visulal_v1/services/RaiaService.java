package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.entities.Raia;
import asdrubal.hr.visulal_v1.repositories.RaiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RaiaService {
    @Autowired
    private RaiaRepository raiaRepository;

    public Set<String> getAllRaias() {
        List<Raia> todasAsRaias = raiaRepository.findAll();
        return todasAsRaias.stream()
                .map(Raia::getRaia)
                .collect(Collectors.toSet());
    }
}
