package asdrubal.hr.visulal_v1.filtros_corridas_mesmo_pareo;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.filtros_corrida_por_raia.IdentificaCorridasPorRaia;
import asdrubal.hr.visulal_v1.montadores.CorridasComuns;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.RaiaService;

import java.util.*;
import java.util.stream.Collectors;

public class IdentificaCorridasMesmoPareo {
    private final CompetidorService competidorService;
    private final RaiaService raiaService;
    private final Map<Integer, DTO_TabelaCompetidores> mapa2;

    public IdentificaCorridasMesmoPareo(CompetidorService competidorService, RaiaService raiaService, Map<Integer, DTO_TabelaCompetidores> mapa2) {
        this.competidorService = competidorService;
        this.raiaService = raiaService;
        this.mapa2 = mapa2;
    }

    public Object[][] pesquisa() {
        Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO = montaMapa();
//        MapaDeCorridasDTO_Show.showMapaDeCorridasDTO(mapaDeCorridasDTO);

        Map<Integer, List<Integer>> mapaIdsPareos = montaMapaPareos(mapaDeCorridasDTO);
//        MapaIdsPareos_Show.showMapaIdsPareos(mapaIdsPareos);

        Map<String, List<Integer>> corridasComuns = montaMapaDeCorridasComuns_v3(mapaIdsPareos);
//        MapaCorridasComuns_Show.showMapa(corridasComuns);

// TODO ANALISAR CORRIDAS Por RAIA
        Set<String> raias = raiaService.getAllRaias();
        IdentificaCorridasPorRaia idRaia = new IdentificaCorridasPorRaia();
        Object[][] dadosMesmaRaia = idRaia.identifica(mapaDeCorridasDTO, raias);

        Object[][] dados = preparaDados(corridasComuns, mapaDeCorridasDTO);
        return dados;
    }

    private Map<String, List<Integer>> montaMapaDeCorridasComuns_v3(Map<Integer, List<Integer>> mapaIdsPareos) {
        Map<String, List<Integer>> mapaComum = new HashMap<>();

        // Usamos Map.entrySet().stream().toList() para garantir uma ordem consistente
        // ou para evitar problemas se o mapa original for modificado.
        // Se a ordem não importa, a iteração direta funciona.
        List<Map.Entry<Integer, List<Integer>>> entries = new ArrayList<>(mapaIdsPareos.entrySet());

        // x e y para controlar pares únicos (A,B) sem (B,A) e sem (A,A)
        for (int x = 0; x < entries.size(); x++) {
            Map.Entry<Integer, List<Integer>> entry1 = entries.get(x);
            List<Integer> idsPareos1 = entry1.getValue();

            for (int y = x + 1; y < entries.size(); y++) { // Inicia y de x + 1 para evitar repetições e auto-comparação
                Map.Entry<Integer, List<Integer>> entry2 = entries.get(y);
                List<Integer> idsPareos2 = entry2.getValue();

                // --- CORREÇÃO AQUI: idsComuns é inicializada para CADA PAR de comparação ---
                // Para performance na operação retainAll, é bom usar HashSet
                Set<Integer> setComuns = new HashSet<>(idsPareos1); // Começa com os elementos da primeira lista
                setComuns.retainAll(idsPareos2); // Mantém apenas os elementos que também estão na segunda lista

                if (!setComuns.isEmpty()) {
                    String par = String.valueOf(entry1.getKey())
                            .concat("#")
                            .concat(String.valueOf(entry2.getKey()));
                    mapaComum.put(par, new ArrayList<>(setComuns)); // Coloca uma cópia da lista de IDs comuns
                }
            }
        }
        return mapaComum;

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

    private Map<String, List<Integer>> montaMapaDeCorridasComuns_v2(Map<Integer, List<Integer>> mapaIdsPareos) {
        Map<String, List<Integer>> mapaComum = new HashMap<>();
        int x = 0;
        for (Map.Entry<Integer, List<Integer>> entry1 : mapaIdsPareos.entrySet()) {
            ++x;
            List<Integer> idsPareos1 = entry1.getValue();
            int y = 0;
            List<Integer> idsComuns = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry2 : mapaIdsPareos.entrySet()) {
                ++y;
                if (y > x) {
                    List<Integer> idsPareos2 = entry2.getValue();
                    for (Integer id1 : idsPareos1) {
                        for (Integer id2 : idsPareos2) {
                            if (id1.equals(id2)) {
                                idsComuns.add(id1);
                                break;
                            }
                        }

                    }
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