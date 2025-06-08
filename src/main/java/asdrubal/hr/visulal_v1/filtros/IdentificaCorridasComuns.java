package asdrubal.hr.visulal_v1.filtros;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.montadores.CorridasComuns;
import asdrubal.hr.visulal_v1.services.CompetidorService;

import java.util.*;
import java.util.stream.Collectors;

public class IdentificaCorridasComuns {
    private final CompetidorService competidorService;
    private final Map<Integer, DTO_TabelaCompetidores> mapa2;

    public IdentificaCorridasComuns(CompetidorService competidorService, Map<Integer, DTO_TabelaCompetidores> mapa2) {
        this.competidorService = competidorService;
        this.mapa2 = mapa2;
    }

    public Object[][] pesquisa() {
        Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO = montaMapa();
        Map<Integer, List<Integer>> mapaIdsPareos = montaMapaPareos(mapaDeCorridasDTO);
        Map<String, List<Integer>> corridasComuns = montaMapaDeCorridasComuns(mapaIdsPareos);
        Object[][] dados = preparaDados(corridasComuns, mapaDeCorridasDTO);
        return dados;
    }

    private Object[][] preparaDados(Map<String, List<Integer>> mapa, Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO) {
        Object[][] dados = CorridasComuns.montaObjeto(mapa, mapaDeCorridasDTO);
        return dados;
    }

    private Map<String, List<Integer>> montaMapaDeCorridasComuns(Map<Integer, List<Integer>> mapaIdsPareos) {
        Map<String, List<Integer>> mapaComum = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry1 : mapaIdsPareos.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> entry2 : mapaIdsPareos.entrySet()) {
                if (!Objects.equals(entry1.getKey(), entry2.getKey())) {
                    List<Integer> idsComuns = new ArrayList<>(entry1.getValue());
                    idsComuns.retainAll(entry2.getValue());
                    if (!idsComuns.isEmpty()) {
                        String par = String.valueOf(entry1.getKey()).concat("#").concat(String.valueOf(entry2.getKey()));
                        mapaComum.put(par, idsComuns);
                    }
                }
            }

        }
        return mapaComum;
    }

    private Map<Integer, List<Integer>> montaMapaPareos(Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO) {
        Map<Integer, List<Integer>> mapa = mapaDeCorridasDTO.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey, // Chave do novo mapa será a chave da entrada original (Integer)
                        entry -> entry.getValue().stream() // Valor do novo mapa:
                                .map(CompetidorDTO::getIdDoPareo) //  Mapeia cada CompetidorDTO para seu idDoPareo
                                .collect(Collectors.toList()) //  Coleta os IDs em uma nova List<Integer> para cada entrada
                ));
        return mapa;
    }

    private Map<Integer, List<CompetidorDTO>> montaMapa() {
        Map<Integer, List<CompetidorDTO>> mapa = new HashMap<>();
        for (Map.Entry<Integer, DTO_TabelaCompetidores> entry : mapa2.entrySet()) {
            Integer idCavalo = entry.getKey();
            List<CompetidorDTO> corridasDoCavalo = competidorService.buscaCorridasPorIdCavalo(idCavalo);
            if (!corridasDoCavalo.isEmpty()) {
                mapa.put(idCavalo, corridasDoCavalo);
            }
        }
        return mapa;
    }
}


//        System.out.println("\nMapa2---------------------");
//        for(Map.Entry<Integer, DTO_TabelaCompetidores> entry: mapa2.entrySet()){
//            System.out.println("\nidCavalo:"+entry.getKey());
//            System.out.println(entry.getValue());
//        }
//        System.out.println("----------------------------------------------------------");


//        System.out.println("\n******************Mapade corridas DTO");
//        for(Map.Entry<Integer, List<CompetidorDTO>> entry: mapaDeCorridasDTO.entrySet()){
//            System.out.println("\nidCavalo:"+entry.getKey());
//            List<CompetidorDTO>lista = entry.getValue();
//            for(CompetidorDTO cDTO: lista){
//                System.out.println("idPareo:"+cDTO.getIdDoPareo()+"   idCavalo:"+cDTO.getIdCavalo());
//            }
//        }


//        for(Map.Entry<String, List<Integer>> entry: mapa2.entrySet()){
//        System.out.println("\n*-=>"+ entry.getKey());
//List<Integer> ids = entry.getValue();
//            ids.forEach(System.out::println);
//        }