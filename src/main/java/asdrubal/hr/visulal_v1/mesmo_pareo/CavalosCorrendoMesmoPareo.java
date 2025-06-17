package asdrubal.hr.visulal_v1.mesmo_pareo;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.objetos.ObjetoBravo;

import java.util.*;

public class CavalosCorrendoMesmoPareo {
    private final Map<Integer, List<CompetidorDTO>> mapa;

    public CavalosCorrendoMesmoPareo(Map<Integer, List<CompetidorDTO>> mapa) {
        this.mapa = mapa;
    }

    public Object[][] montaObjBravo() {
        Map<Integer, List<Integer>> mapaDePareosComuns = montaMapaDeIdsPareo();
        Map<Integer, List<Integer>> mapaDeCorridas = MapaPareosPorCavalo.inverteMapa(mapaDePareosComuns);
        ObjetoBravo bravo = new ObjetoBravo(mapa, mapaDeCorridas);
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
        Map<Integer, List<Integer>> mapaDePareo = new HashMap<>();
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa.entrySet()) {
            List<Integer> idsPareos = montaListaDeIdsPareo(entry.getValue());
            mapaDePareo.put(entry.getKey(), idsPareos);
        }
        return mapaDePareo;
    }

    private List<Integer> montaListaDeIdsPareo(List<CompetidorDTO> lista) {
        List<Integer> idsPareos = new ArrayList<>();
        lista.forEach(e -> idsPareos.add(e.getIdDoPareo()));
        return idsPareos;
    }
}
