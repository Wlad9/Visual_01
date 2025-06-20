package asdrubal.hr.visulal_v1.mesmo_pareo;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.objetos.ObjetoBravo;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class CavalosCorrendoMesmoPareo {
    private final Map<Integer, List<CompetidorDTO>> mapa3;

    public CavalosCorrendoMesmoPareo(Map<Integer, List<CompetidorDTO>> mapa3) {
        this.mapa3 = mapa3;
    }

    public Object[][] montaObjBravo() {
        Map<Integer, List<Integer>> mapaDePareosComuns = montaMapaDeIdsPareo();
//        Map<Integer, List<Integer>> mapaDeCorridas = MapaPareosPorCavalo.inverteMapa(mapaDePareosComuns);
        ObjetoBravo bravo = new ObjetoBravo(mapa3, mapaDePareosComuns);
        Object dadosBravo[][] = bravo.montaObj();
//        for (Map.Entry<Integer, List<Integer>> entry : mapaDeCorridas.entrySet()) {
//            List<Integer> lst = entry.getValue();
//            if (lst.size() > 1) {
//                System.out.println("\nidPareo:" + entry.getKey());
//                for (Integer id : lst) {
//                    System.out.println("idCavalo: " + id);
//                }
//            }
//        }
        return dadosBravo;
    }

    private Map<Integer, List<Integer>> montaMapaDeIdsPareo() {
        Map<Integer, List<Integer>> mapa = new HashMap<>();

        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa3.entrySet()) {
            List<CompetidorDTO> listaCompetidores = entry.getValue();

            for (CompetidorDTO cDTO : listaCompetidores) {
                Integer idPareo = cDTO.getIdDoPareo();
                Integer idCavalo = cDTO.getIdCavalo();
                // Se ainda não existe a chave, cria a lista
                mapa.computeIfAbsent(idPareo, k -> new ArrayList<>()).add(idCavalo);
            }
        }
        mapa.entrySet().removeIf(e -> e.getValue().size() <= 1);// Agora, remover páreos que só têm 1 cavalo
        return mapa;
//        System.out.println("\n\n-------------------\n\n");
//        for (Map.Entry<Integer, List<Integer>> entry : mapa.entrySet()) {
//            Integer id = entry.getKey();
//            if (id > 0) {
//                System.out.println("\n---------idPareo:" + entry.getKey());
//                List<Integer> lista = entry.getValue();
//                for (Integer idx : lista) {
//                    System.out.println("idCavalo:" + idx);
//                }
//            }
//        }
    }
}
