package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.Raia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaiaRepository extends JpaRepository<Raia, Integer> {
    List<Raia> findAll();
}
