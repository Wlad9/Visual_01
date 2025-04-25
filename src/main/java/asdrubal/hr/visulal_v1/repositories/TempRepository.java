package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.Programa;
import asdrubal.hr.visulal_v1.entities.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TempRepository extends JpaRepository<Temp, Integer> {

    Optional<List<Temp>> findByIdDoProgramaAndIdDoPareo(Integer idPrograma, Integer idPareo);
}
