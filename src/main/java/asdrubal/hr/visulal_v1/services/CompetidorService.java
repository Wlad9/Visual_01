package asdrubal.hr.visulal_v1.services;

import asdrubal.hr.visulal_v1.corretor_tempo.TransformaCronometroEmTempo;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.entities.Competidor;
import asdrubal.hr.visulal_v1.repositories.CompetidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetidorService {
    @Autowired
    private CompetidorRepository competidorRepository;

    @Transactional(readOnly = true)
    public List<CompetidorDTO> buscaListaDeCompetidores(List<Integer> listaIds) {
        List<CompetidorDTO> listaDTO = new ArrayList<>();
        Optional<List<Competidor>> listaOptional = competidorRepository.findByIdCompetidorIn(listaIds);
        if (listaOptional.isPresent()) {
            List<Competidor> listaCompetidores = listaOptional.get();
            listaDTO = listaCompetidores.stream()
                    .map(this::converteParaDTO)
                    .collect(Collectors.toList());
        }
        return listaDTO;
    }

    private CompetidorDTO converteParaDTO(Competidor competidor) {

        return new CompetidorDTO(competidor);
    }

    @Transactional(readOnly = true)
    public List<CompetidorDTO> buscaCorridasPorIdCavalo(Integer idCavalo) {
        List<CompetidorDTO> lista = new ArrayList<>();
        for (int page = 0; ; page++) {
            PageRequest pageRequest = PageRequest.of(page, 100);
            Page<Competidor> paginas = competidorRepository.findByHorse_IdCavalo(idCavalo, pageRequest);
            lista.addAll(
                    paginas.getContent()
                            .stream()
                            .map(this::converteParaDTO)
                            .toList()
            );

            if (!paginas.hasNext()) break;
        }
        return lista;
    }

    @Transactional
    public void corrigeTempo() {
        List<Competidor> lista = competidorRepository.findByCronometroIsNotNullAndTempo(0);

        for (Competidor c : lista) {
            try {
                String cronometro = c.getCronometro();
                if (!cronometro.isEmpty()) {
                    TransformaCronometroEmTempo tct = new TransformaCronometroEmTempo(cronometro);
                    float tempoCalculado = tct.cronoToTempo();
                    c.setTempo(tempoCalculado);
                }
            } catch (Exception e) {
                System.err.println("Erro. Cronometro não convertido:" + c);
            }
            competidorRepository.saveAll(lista);
            System.out.println("\n\n------------------------FIM DA CORREÇÃO.");
        }
    }
}
