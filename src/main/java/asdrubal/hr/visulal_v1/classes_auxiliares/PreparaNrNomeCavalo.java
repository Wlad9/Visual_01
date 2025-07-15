package asdrubal.hr.visulal_v1.classes_auxiliares;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;

public class PreparaNrNomeCavalo {

    public static String prepNomeCavalo(String cavalo, Integer idCavalo, List<Object[]> dadoLS) {
        for (Object[] obj : dadoLS) {
            Integer id = Integer.parseInt(obj[2].toString());
            if (id.equals(idCavalo)) {
                cavalo = cavalo.trim();
                String nr = obj[0].toString();
                return nr.concat(" -").concat(cavalo);
            }
        }
        return cavalo;
    }
}
