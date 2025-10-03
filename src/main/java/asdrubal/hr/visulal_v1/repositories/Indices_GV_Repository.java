package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.IndicesGV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Indices_GV_Repository extends JpaRepository<IndicesGV, Integer> {
}
