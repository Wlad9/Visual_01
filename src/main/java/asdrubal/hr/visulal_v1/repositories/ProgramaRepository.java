package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Integer> {
    Optional<Programa> findByDataAndHipodromoCodAndOrdProg(Date data, String hipoCode, int ordProg);

    Optional<Programa> findByDataAndHipodromoCod(Date data, String hipoCod);

    List<Programa> findBySt(int i);
}
