package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.entities.IndicesGV;
import asdrubal.hr.visulal_v1.repositories.Indices_GV_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndicesGV_Service {
    @Autowired
    private Indices_GV_Repository indicesGvRepository;

    public Map<String, IndicesDTO> findAll() {
        Map<String, IndicesDTO> mapa = new HashMap<>();
        List<IndicesGV> lista = indicesGvRepository.findAll();
        for(IndicesGV entity: lista){
            IndicesDTO dto = new IndicesDTO(entity);
            String raia = dto.getRaia();
            mapa.put(raia, dto);
        }

        return mapa;
//        String key
//        Map<String, Indices_GV_DTO> mapaGavea = lista.stream().map(indice-> new Indices_GV_DTO(indice))
//                .collect(Collectors.toMap(Indices_GV_DTO::getRaia, indicesGvDto -> indicesGvDto));
//
//        return mapaGavea;
    }
}
