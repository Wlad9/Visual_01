package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.IndicesCJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Indices_CJ_Repository extends JpaRepository<IndicesCJ, Integer> {
}
