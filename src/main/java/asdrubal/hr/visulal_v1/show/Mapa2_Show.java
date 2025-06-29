package asdrubal.hr.visulal_v1.show;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;

import java.util.Map;

public class Mapa2_Show {
    public static void show(Map<Integer, DTO_TabelaCompetidores> mapa2, String dadosMapa2) {
        for(Map.Entry<Integer, DTO_TabelaCompetidores>entry: mapa2.entrySet()){
            System.out.println("\nid:"+entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
