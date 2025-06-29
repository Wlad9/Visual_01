package asdrubal.hr.visulal_v1.filtros_tela_analise2;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;
import java.util.Map;

public class FiltroTempo {
    private static Map<String, List<CompetidorDTO>> mapa;

    public static Map<String, List<CompetidorDTO>> ordena(Map<String, List<CompetidorDTO>> mapaX1) {
        mapa = mapaX1;
        int t = mapaX1.size();
        for (int i = 0; i < t; i++) {
            String key = identificaChave(i);
        }
        return null;
    }

    private static String identificaChave(int i) {
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapa.entrySet()) {
            if(locKey(i, entry.getKey())){
                return entry.getKey();
            }
        }
        return null;
    }

    private static boolean locKey(int i, String key) {
        String v = key.replaceAll("[^\\d]", "");
        v = v.trim();
        int nr = Integer.parseInt(v);
        if (nr == i) {
            return true;
        }
        return false;
    }
}
