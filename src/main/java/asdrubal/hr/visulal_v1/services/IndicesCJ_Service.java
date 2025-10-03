package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.entities.IndicesCJ;
import asdrubal.hr.visulal_v1.entities.IndicesGV;
import asdrubal.hr.visulal_v1.repositories.Indices_CJ_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndicesCJ_Service {
    @Autowired
    private Indices_CJ_Repository indicesCJRepository;

    public Map<String, IndicesDTO> findAll() {
        Map<String, IndicesDTO> mapa = new HashMap<>();
        List<IndicesCJ> lista = indicesCJRepository.findAll();
        for (IndicesCJ entity : lista) {
            IndicesDTO dto = new IndicesDTO(entity);
            String raia = dto.getRaia();
            mapa.put(raia, dto);
        }
        return mapa;
    }
}
