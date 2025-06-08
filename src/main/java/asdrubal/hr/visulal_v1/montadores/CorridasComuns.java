package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;
import asdrubal.hr.visulal_v1.objetos.DuplasCorridasComuns;
import asdrubal.hr.visulal_v1.show.MapaCorridasComunsPorDupla_Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorridasComuns {
    private static Map<Integer, List<CompetidorDTO>> corridas;
    private static String cavalo2;
    private static Integer idCavalo1;
    private static Integer idCavalo2;


    public static Object[][] montaObjeto(Map<String, List<Integer>> mapa, Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO) {
        corridas = mapaDeCorridasDTO;
        Map<String, List<DTO_x>> mapaCorridasComunsPorDupla = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : mapa.entrySet()) {
            String dupla = entry.getKey();
            System.out.println("dupla:" + dupla);
            List<Integer> idsPareos = entry.getValue();
            String cavalo1 = nomeiaCavalos(dupla);
            System.out.println("Cavalo1:" + cavalo1 + "\tCavalo2:" + cavalo2);
            String animais = montaDupla(cavalo1, cavalo2);
            List<CompetidorDTO> corridasCavalo1 = corridas.get(idCavalo1);
            List<CompetidorDTO> corridasCavalo2 = corridas.get(idCavalo2);
            List<Integer> pareosComuns = entry.getValue();
            List<DTO_x> listaDTOx = MapaDeDuplas_Montador.inicia(corridasCavalo1, corridasCavalo2, pareosComuns, cavalo1, cavalo2);
            mapaCorridasComunsPorDupla.put(animais, listaDTOx);
        }
        MapaCorridasComunsPorDupla_Show.showMapaCorridasComunsPorDupla(mapaCorridasComunsPorDupla);
        Object[][] objeto = DuplasCorridasComuns.montaObjetoDuplas(mapaCorridasComunsPorDupla);
        return null;
    }

    private static String montaDupla(String cavalo1, String cavalo2) {
        cavalo1 = cavalo1.trim().toUpperCase();
        cavalo2 = cavalo2.trim().toUpperCase();
        return cavalo1.concat("#").concat(cavalo2);
    }

    private static String nomeiaCavalos(String dupla) {
        String[] d = dupla.split("#");
        idCavalo1 = Integer.parseInt(d[0]);
        idCavalo2 = Integer.parseInt(d[1]);
        System.out.println("\nid1:" + idCavalo1 + "\tid2:" + idCavalo2);

        List<CompetidorDTO> listaDeCorridas2 = corridas.get(idCavalo2);
        for (CompetidorDTO dto2 : listaDeCorridas2) {
            cavalo2 = dto2.getCavalo();
        }
        List<CompetidorDTO> listaDeCorridas1 = corridas.get(idCavalo1);
        for (CompetidorDTO dto1 : listaDeCorridas1) {
            return dto1.getCavalo();
        }
        return null;
    }

    private static String getCavalo2() {
        return cavalo2;
    }
}
