package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;

import java.sql.Date;
import java.util.*;

public class DuplasCorridasComuns {
    public static Object[][] montaObjetoDuplas(Map<String, List<DTO_x>> mapa) {
        int nrColunas = 10;
        int nrTitulos = mapa.size();
        int nrLinhas = nrTitulos;
        for (Map.Entry<String, List<DTO_x>> entry : mapa.entrySet()) {
            nrLinhas = nrLinhas + entry.getKey().length();
        }
        Object[][] obj = new Object[nrLinhas][nrColunas];
        int index = 0;
        for (Map.Entry<String, List<DTO_x>> entry : mapa.entrySet()) {
            List<DTO_x> lista = new ArrayList<>(entry.getValue());
            lista.sort(Comparator.comparing(DTO_x::getRaia));
            System.out.println("-------------Dupla:"+entry.getKey());
            montaCampos(lista);
            String linhaChamada = montaLinhaChamada(entry.getKey());

            obj[index][0] = linhaChamada;
        }
        return null;
    }

    private static void montaCampos(List<DTO_x> lista) {
        for (DTO_x dtoX : lista) {
            String hrData = montaHRdata(dtoX.getData(), dtoX.getHipoCod());
            String posCrono1 = montaPosCrono(dtoX.getPos1(), dtoX.getCrono1());
            String posCrono2 = montaPosCrono(dtoX.getPos2(), dtoX.getCrono2());
            String corpoChegada = montaCorpoChegada(dtoX.getCorpo1(), dtoX.getCorpo2());
            String rateio = montaRateio(dtoX.getRateio1(), dtoX.getRateio2());
            String entradaReta = montaEntradaReta(dtoX.getEntra1(), dtoX.getEntra2());
            System.out.println("\nRaia:"+dtoX.getRaia());
            System.out.println("hrData:" + hrData);
            System.out.println("posCrono1>" + posCrono1 + "\tPosCrono2:" + posCrono2);
            System.out.println("CorpoChegada:" + corpoChegada);
            System.out.println("Rateio:" + rateio);
            System.out.println("Entrada:" + entradaReta);
            System.out.println(hrData + " | " + posCrono1 + " | " + posCrono2 + " | " + corpoChegada + " | " + rateio + " | " + entradaReta);
        }
    }

    private static String montaEntradaReta(String entra1, String entra2) {
        entra1 = verificaConteudoDaString(entra1);
        entra2 = verificaConteudoDaString(entra2);
        return entra1.concat(" - ").concat(entra2);
    }

    private static String montaRateio(String rateio1, String rateio2) {
        rateio1 = verificaConteudoDaString(rateio1);
        rateio2 = verificaConteudoDaString(rateio2);
        return rateio1.concat(" - ").concat(rateio2);
    }

    private static String montaCorpoChegada(String corpo1, String corpo2) {
        corpo1 = verificaConteudoDaString(corpo1);
        corpo2 = verificaConteudoDaString(corpo2);
        return corpo1.concat(" - ").concat(corpo2);
    }

    private static String montaPosCrono(int pos, String crono) {
        String col = String.valueOf(pos).concat("ºL");
        if (crono != null) {
            crono = crono.toLowerCase().trim();
            return col.concat(" ").concat(crono);
        }
        return col;
    }

    private static String montaHRdata(Date data, String hipoCod) {
        String dt = new ConverteDateToString().converteMK1(data);
        return hipoCod.concat(" ").concat(dt);
    }

    private static String montaLinhaChamada(String str) {
        String[] d = str.split("#");
        return d[0].concat("  X  ").concat(d[1]);
    }

    private static String verificaConteudoDaString(String str) {
        if (str == null) {
            return "x";
        }
        return str.trim();
    }
}
