package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.Indices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndicesRepository extends JpaRepository<Indices, Integer> {

    Optional<Indices> findByRaia(String raia);
}
