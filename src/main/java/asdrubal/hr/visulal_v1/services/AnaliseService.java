package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.repositories.AnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {
    @Autowired
    private AnaliseRepository analiseRepository;
}
