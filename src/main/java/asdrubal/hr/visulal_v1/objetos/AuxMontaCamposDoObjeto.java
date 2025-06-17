package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class AuxMontaCamposDoObjeto {
    public static String montaColocacao(int colocacao) {
        return String.valueOf(colocacao).concat("°L");
    }

    public static String montaData(String hipoCod, Date data) {
        if (hipoCod != null) {
            String dt = new ConverteDateToString().converteMK1(data);
            return hipoCod.concat(" ").concat(dt);
        }
        return new ConverteDateToString().converteMK1(data);
    }

    public static int calculaNrLinhas(Map<String, List<CompetidorDTO>> mapa) {
        int nrRaias = mapa.size();
        int linhasEmBranco = nrRaias;
        int nrCorridas = (mapa.values().stream().mapToInt(List::size).sum());
        return nrRaias + nrCorridas + linhasEmBranco;
    }
}
