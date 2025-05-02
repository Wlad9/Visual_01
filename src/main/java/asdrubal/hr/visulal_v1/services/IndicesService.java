package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.entities.Indices;
import asdrubal.hr.visulal_v1.repositories.IndicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IndicesService {
    @Autowired
    private IndicesRepository indicesRepository;

    public void save(IndicesDTO dto) {
        Indices indices = new Indices(dto);
        Optional<Indices> optional = indicesRepository.findByRaia(indices.getRaia());
        System.out.println("\n");
        if (optional.isPresent()) {
            System.out.println("Já existe:" + indices.getRaia());
            Indices entity = optional.get();
            if (!indices.equals(entity)) {
                System.out.println("Diferentes");
                System.out.println("Indices:" + indices + "entity:" + entity);
                indices.setIdIndice(entity.getIdIndice());
                indicesRepository.save(indices);
            } else {
                System.out.println(indices.getRaia() + " Iguais.");
            }
        } else {
            System.out.println("Não existe ainda:" + indices.getRaia());
            indicesRepository.save(indices);
        }
    }

    public Map<String, IndicesDTO> findAll() {
        List<Indices> lista = indicesRepository.findAll();
        Map<String,IndicesDTO> mapa = lista.stream()
                .map(indice->new IndicesDTO(indice))
                .collect(Collectors.toMap(IndicesDTO::getRaia, dto->dto));
        return mapa;
    }
}
