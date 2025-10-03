package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.IndicesRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Indices_RS_Repository extends JpaRepository<IndicesRS, Integer> {
}
