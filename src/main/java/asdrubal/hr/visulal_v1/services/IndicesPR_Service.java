package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.entities.IndicesPR;
import asdrubal.hr.visulal_v1.repositories.Indices_PR_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndicesPR_Service {
    @Autowired
    private Indices_PR_Repository indices_pr_repository;

    public Map<String, IndicesDTO> findAll() {

        List<IndicesPR> lista = indices_pr_repository.findAll();
        Map<String, IndicesDTO> mapa = lista.stream().map(indice -> new IndicesDTO(indice))
                .collect(Collectors.toMap(IndicesDTO::getRaia, dto -> dto));
        return mapa;
    }
}
