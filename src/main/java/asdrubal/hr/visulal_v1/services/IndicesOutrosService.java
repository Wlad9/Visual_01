package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.entities.IndicesOutros;
import asdrubal.hr.visulal_v1.repositories.IndicesOutrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndicesOutrosService {
    @Autowired
    private IndicesOutrosRepository indicesOutrosRepository;

    public Map<String, IndicesDTO> findAll() {
        Map<String, IndicesDTO> mapa = new HashMap<>();
        List<IndicesOutros> lista = indicesOutrosRepository.findAll();
        for (IndicesOutros entity : lista) {
            IndicesDTO dto = new IndicesDTO(entity);
            String raia = dto.getRaia();
            mapa.put(raia, dto);
        }
        return mapa;
    }
}
