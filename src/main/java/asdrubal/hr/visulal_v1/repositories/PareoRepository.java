package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.Pareo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PareoRepository extends JpaRepository<Pareo, Integer> {

    @EntityGraph(attributePaths = "programa")
    Optional<List<Pareo>> findByIdPareoIn(List<Integer> ids);


}
