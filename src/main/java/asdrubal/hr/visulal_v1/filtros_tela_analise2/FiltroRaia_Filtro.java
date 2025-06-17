package asdrubal.hr.visulal_v1.filtros_tela_analise2;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.montadores.MapaX1_Montador;
import org.hibernate.usertype.UserTypeLegacyBridge;

import java.util.*;

public class FiltroRaia_Filtro {

    public static Map<String, List<CompetidorDTO>> filtra(Map<String, List<CompetidorDTO>> mapaX, List<String> pistasLista, List<String> distanciasLista) {
        Map<String, List<CompetidorDTO>> mapaFiltroRaia = new HashMap<>();
        List<String> raias = montaRaias(pistasLista, distanciasLista);
        for (String raia : raias) {
            List<CompetidorDTO> selecao = new ArrayList<>();
            for (Map.Entry<String, List<CompetidorDTO>> entry : mapaX.entrySet()) {
                List<CompetidorDTO> lista = entry.getValue();
                for (CompetidorDTO cDTO : lista) {
                    String raiaC = cDTO.getRaia();
                    if (raia.equalsIgnoreCase(raiaC)) {
                        selecao.add(cDTO);
                    }
                }
            }
            if (!selecao.isEmpty()) {
                mapaFiltroRaia.put(raia, selecao);
            }
        }
        return mapaFiltroRaia;
    }

    private static List<String> montaRaias(List<String> pistasLista, List<String> distanciasLista) {
        List<String> raias = new ArrayList<>();
        for (String pista : pistasLista) {
            for (String distancia : distanciasLista) {
                String raia = pista.trim().concat(distancia.trim());
                raias.add(raia);
            }
        }
//  TODO FAZER VRF DA SE AS RAIAS MONTADAS EXISTEM NA TABELA RAIA
        return raias;
    }

    //  montado mapa filtro Competidor por raia
    public static Map<String, List<CompetidorDTO>> filtra2(Map<Integer, List<CompetidorDTO>> mapa, List<String> pistasLista, List<String> distanciasLista) {
        Map<String, List<CompetidorDTO>> mapaRetorno = new HashMap<>();
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa.entrySet()) {
            List<CompetidorDTO> competidores = entry.getValue();
            List<CompetidorDTO> competidoresFiltradosPorRaia = filtraRaias(competidores, pistasLista, distanciasLista);
            if(competidoresFiltradosPorRaia != null){
                CompetidorDTO cDTO = competidores.getFirst();
                String cavalo = cDTO.getCavalo();
                cavalo = MapaX1_Montador.limpaParentesis(cavalo);
                mapaRetorno.put(cavalo, competidoresFiltradosPorRaia);
            }
        }
        return mapaRetorno;
    }

    private static List<CompetidorDTO> filtraRaias(List<CompetidorDTO> competidores, List<String> pistasLista, List<String> distanciasLista) {
        List<String> raias = montaRaias(pistasLista, distanciasLista);
        List<CompetidorDTO> selecao = List.of();
        for (CompetidorDTO cDTO : competidores) {
            selecao = new ArrayList<>();
            for (String raia : raias) {
                String raiaC = cDTO.getRaia();
                if (raia.equalsIgnoreCase(raiaC)) {
                    selecao.add(cDTO);
                }
            }
        }
        return selecao;
    }
}
