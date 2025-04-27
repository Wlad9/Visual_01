package asdrubal.hr.visulal_v1.repositories;

import asdrubal.hr.visulal_v1.entities.Competidor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetidorRepository extends JpaRepository<Competidor, Integer> {
    Optional<List<Competidor>> findByIdCompetidorIn(List<Integer> listaIds);

    Page<Competidor> findByHorse_IdCavalo(Integer idCavalo, PageRequest pageRequest);
}
