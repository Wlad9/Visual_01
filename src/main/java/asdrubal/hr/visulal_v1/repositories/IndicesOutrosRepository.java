package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.IndicesOutros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndicesOutrosRepository extends JpaRepository<IndicesOutros, Integer> {

    Optional<IndicesOutros> findByRaia(String raiaOutros);
}
