package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.entities.Cavalo;
import asdrubal.hr.visulal_v1.repositories.CavaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CavaloService {
    @Autowired
    private CavaloRepository cavaloRepository;

    public String findById(Integer idCavalo) {
        Optional<Cavalo> optional = cavaloRepository.findById(idCavalo);
        if(optional.isPresent()){
            Cavalo cavalo = optional.get();
            return cavalo.getCavalo();
        }
        return null;
    }
}
