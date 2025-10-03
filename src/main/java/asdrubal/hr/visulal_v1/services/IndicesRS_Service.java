package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.entities.IndicesRS;
import asdrubal.hr.visulal_v1.repositories.Indices_RS_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndicesRS_Service {
    @Autowired
    private Indices_RS_Repository indices_rs_repository;

    public Map<String, IndicesDTO> findAll() {
        Map<String, IndicesDTO> mapa = new HashMap<>();
        List<IndicesRS> lista = indices_rs_repository.findAll();
        for (IndicesRS entity : lista) {
            IndicesDTO dto = new IndicesDTO(entity);
            String raia = dto.getRaia();
            mapa.put(raia, dto);
        }
        return mapa;
    }
}
