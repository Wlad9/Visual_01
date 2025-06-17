package asdrubal.hr.visulal_v1.ordenador;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.enums.CampoOrdenacao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaCompetidor {
    public static List<CompetidorDTO> ordenaPorCampo(List<CompetidorDTO> lista, CampoOrdenacao campo) {
        if (lista == null || lista.isEmpty() || campo == null) {
            return null;
        }
        Comparator<CompetidorDTO> comparator = null;
        switch (campo) {
            case DATA:
                comparator = (c1, c2) -> {
                    Date d1 = c1.getData();
                    Date d2 = c2.getData();
                    if (d1 == null && d2 == null) return 0;
                    if (d1 == null) return 1;
                    if (d2 == null) return -1;
                    return d2.compareTo(d1);
                };
                break;
            case TEMPO:
                comparator = (c1, c2) -> {
                    Float t1 = c1.getTempo();
                    Float t2 = c2.getTempo();
                    return t1.compareTo(t2);
                };
                break;
            case JOQUEI:
                comparator = (c1, c2) -> {
                    String j1 = c1.getJoquei();
                    String j2 = c2.getJoquei();
                    if (j1 == null && j2 == null) return 0;
                    if (j1 == null) return 1;
                    if (j2 == null) return -1;
                    return j1.compareToIgnoreCase(j2);
                };
                break;
            case RATEIO:
                comparator = (c1, c2) -> {
                    Float r1 = Float.parseFloat(c1.getRateio());
                    Float r2 = Float.parseFloat(c2.getRateio());
                    return r1.compareTo(r2);
                };
                break;
            default:
                System.out.println("Campo de ordenação não reconhecido.");


        }
        List<CompetidorDTO> listaOrdenada = new ArrayList<>(lista);
        Collections.sort(listaOrdenada, comparator);
        return listaOrdenada;
    }
}
