package asdrubal.hr.visulal_v1.repositoreis;

import asdrubal.hr.visulal_v1.entities.Pareo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PareoRepository extends JpaRepository<Pareo, Integer> {
}
