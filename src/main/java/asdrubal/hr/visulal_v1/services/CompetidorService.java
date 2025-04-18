package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.repositoreis.CompetidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetidorService {
    @Autowired
    private CompetidorRepository competidorRepository;
}
