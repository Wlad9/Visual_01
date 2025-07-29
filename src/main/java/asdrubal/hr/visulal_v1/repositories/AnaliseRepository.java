package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.Analise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Integer> {
}
