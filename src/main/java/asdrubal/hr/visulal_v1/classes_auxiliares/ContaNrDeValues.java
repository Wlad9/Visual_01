package asdrubal.hr.visulal_v1.classes_auxiliares;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;

import java.util.List;
import java.util.Map;

public class ContaNrDeValues {
    public static int contaNrLinhas(Map<String, List<DTO_x>> mapa) {
        int t = 0;
        for (Map.Entry<String, List<DTO_x>> entry : mapa.entrySet()) {
            List<DTO_x> lista = entry.getValue();
            t = t + conta(lista);
        }
        return t;
    }// contar o nr de itens no value do mapa

    private static int conta(List<DTO_x> lista) {
        int t = 0;
        for (DTO_x dto : lista) {
            t += 1;
        }
        return t;
    }
}
