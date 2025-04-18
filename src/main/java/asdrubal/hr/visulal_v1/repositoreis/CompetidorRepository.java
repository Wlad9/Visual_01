package asdrubal.hr.visulal_v1.repositoreis;

import asdrubal.hr.visulal_v1.entities.Competidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetidorRepository extends JpaRepository<Competidor, Integer> {
}
