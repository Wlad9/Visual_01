package asdrubal.hr.visulal_v1.filtros_tela_analise2;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiltroRaia {
    public static List<CompetidorDTO> filtraRaia(List<CompetidorDTO> listaDTOFull) {
        return null;
    }

    public static Map<String, List<CompetidorDTO>> iniciaFiltro(Map<String, List<CompetidorDTO>> mapaX, List<String> pistasLista, List<String> distanciasLista) {
        if (pistasLista.isEmpty() && distanciasLista.isEmpty()) {
            return mapaX;
        }
        if (!pistasLista.isEmpty() && !distanciasLista.isEmpty()) {
            return FiltroRaia_Filtro.filtra(mapaX, pistasLista, distanciasLista);
        }
        if (!distanciasLista.isEmpty()) {
            return FiltroSoDistancia.filtra(mapaX, distanciasLista);
        }
        return FiltroSoPista.filtra(mapaX, pistasLista);
    }

    public static Map<String, List<CompetidorDTO>> filtro2(Map<Integer, List<CompetidorDTO>> mapaX11, List<String> pistasLista, List<String> distanciasLista, List<String> yearsLista) {
        Map<String, List<CompetidorDTO>> mapaFiltrado = new HashMap<>();
        Map<Integer, List<CompetidorDTO>> mapaFiltradoPorAno = filtraYear(mapaX11, yearsLista);

        System.out.println("\nPesquisando ALfa Filtro2");
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapaFiltradoPorAno.entrySet()) {
            System.out.println("Key:" + entry.getKey());
            List<CompetidorDTO> lista = entry.getValue();
            for (CompetidorDTO cDTO : lista) {
                System.out.println(cDTO);

            }
        }
        if (mapaFiltradoPorAno == null) {
            mapaFiltrado = FiltroRaia_Filtro.filtra2(mapaX11, pistasLista, distanciasLista);
        } else {
            mapaFiltrado = FiltroRaia_Filtro.filtra2(mapaFiltradoPorAno, pistasLista, distanciasLista);
        }
        System.out.println("\nMapaFiltrado Competidor x Raias");
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaFiltrado.entrySet()) {
            System.out.println("Competidor:" + entry.getKey());
            List<CompetidorDTO> lista = entry.getValue();
            for (CompetidorDTO cDTO : lista) {
                System.out.println("Raia:" + cDTO.getRaia() + "\tCavalo:" + cDTO.getCavalo() + "\tData:" + cDTO.getData() + "\tTempo:" + cDTO.getTempo() + "\tidComp:" + cDTO.getIdCompetidor());
            }
        }


        return mapaFiltrado;
    }

    private static Map<Integer, List<CompetidorDTO>> filtraYear(Map<Integer, List<CompetidorDTO>> mapaX11, List<String> yearsLista) {
        if (yearsLista.contains("Todos") || yearsLista.isEmpty() || yearsLista.size() == 0) {
            System.out.println("Retonrounull");
            System.out.println("Tamanho:" + yearsLista.size());
            return null;
        }
        return FiltroYear.filtro2(mapaX11, yearsLista);
    }
}
