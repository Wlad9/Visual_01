package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.IndicesSoGavea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndicesSoGaveaRepository extends JpaRepository<IndicesSoGavea, Integer> {

    Optional<IndicesSoGavea> findByRaiaGavea(String raiaGavea);
}
