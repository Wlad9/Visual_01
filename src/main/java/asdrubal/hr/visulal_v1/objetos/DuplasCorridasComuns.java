package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.classes_auxiliares.ArredondaNrFloat;
import asdrubal.hr.visulal_v1.classes_auxiliares.ContaNrDeValues;
import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;

import java.sql.Date;
import java.util.*;

public class DuplasCorridasComuns {
    private static String raiaAtual;

    public static Object[][] montaObjetoDuplas(Map<String, List<DTO_x>> mapa) {
        int nrColunas = 11;
        int nrTitulos = mapa.size();
        int nrLinhas = nrTitulos;
        int total = ContaNrDeValues.contaNrLinhas(mapa);
        nrLinhas += total;

        Object[][] obj = new Object[nrLinhas][nrColunas];
        int index = 0;
        for (Map.Entry<String, List<DTO_x>> entry : mapa.entrySet()) {
            List<DTO_x> lista = new ArrayList<>(entry.getValue());
            lista.sort(Comparator.comparing(DTO_x::getRaia));
            List<String> listaDeDados = montaCampos(lista);
            String titulo = montaTitulo(entry.getKey());
            System.out.println(" \n" + titulo);
            obj[index++][0] = titulo;
            for (int i = 0; i < listaDeDados.size(); i++) {
                obj[index][0] = listaDeDados.get(i++);
                obj[index][1] = listaDeDados.get(i++);
                obj[index][2] = listaDeDados.get(i++);
                obj[index][3] = listaDeDados.get(i++);
                obj[index][4] = listaDeDados.get(i++);
                obj[index][5] = listaDeDados.get(i++);
                obj[index][6] = listaDeDados.get(i++);
                obj[index][7] = listaDeDados.get(i++);
                obj[index][8] = listaDeDados.get(i++);
                obj[index][9] = listaDeDados.get(i++);
                obj[index][10] = listaDeDados.get(i);
                index++;
            }
        }
//        showObejeto(obj);
        return obj;
    }

    private static void showObejeto(Object[][] dados) {
        for (int i = 0; i < dados.length; i++) {
            System.out.print("Linha " + i + ": [");
            if (dados[i] != null) {
                for (int j = 0; j < dados[i].length; j++) {
                    System.out.print(dados[i][j]);
                    if (j < dados[i].length - 1) {
                        System.out.print(", ");
                    }
                }
            } else {
                System.out.print("null");
            }
            System.out.println("]");
        }
    }

    private static String montaTitulo(String dupla) {
        String[] d = dupla.split("#");
        String cav1 = d[0].trim();
        String cav2 = d[1].trim();
        return raiaAtual.concat(" ->").concat(cav1).concat("  x  ").concat(cav2);
//        return "Animais - >  ".concat(cav1).concat("  x  ").concat(cav2);
    }


    private static List<String> montaCampos(List<DTO_x> lista) {
        List<String> listaDeDados = new ArrayList<>();
        Set<String> raias = identificaRaiasDaLista(lista);
        for (String raia : raias) {
            for (DTO_x dtoX : lista) {
                if (raia.equalsIgnoreCase(dtoX.getRaia())) {
                    //TODO INSERIR AS RAIAS POR DUPLA DE PÁREO
                    raiaAtual = raia;
                    System.out.println("RAIA>>> " + raia);
                    String hrData = montaHRdata(dtoX.getData(), dtoX.getHipoCod());
                    String posCrono1 = montaPosCrono(dtoX.getPos1(), dtoX.getCrono1());
                    String posCrono2 = montaPosCrono(dtoX.getPos2(), dtoX.getCrono2());
                    String corpoChegada = montaCorpoChegada(dtoX.getCorpo1(), dtoX.getCorpo2());
                    String rateio = montaRateio(dtoX.getRateio1(), dtoX.getRateio2());
                    String entradaReta = montaEntradaReta(dtoX.getEntra1(), dtoX.getEntra2());
                    String tempos = montaTempos(dtoX.getTempo1(), dtoX.getTempo2());
                    System.out.println("Raia:" + dtoX.getRaia());
                    System.out.println("hrData:" + hrData);
                    System.out.println("posCrono1>" + posCrono1 + "\tPosCrono2:" + posCrono2);
                    System.out.println("CorpoChegada:" + corpoChegada);
                    System.out.println("Rateio:" + rateio);
                    System.out.println("Entrada:" + entradaReta);
                    System.out.println("Tempos:" + tempos);
                    System.out.println(hrData + " | " + posCrono1 + " | " + posCrono2 + " | " + corpoChegada + " | " + rateio + " | " + entradaReta + " | " + tempos);
                    listaDeDados.add(hrData);
                    listaDeDados.add(posCrono1);
                    listaDeDados.add(posCrono2);
                    listaDeDados.add(corpoChegada);
                    listaDeDados.add(rateio);
                    listaDeDados.add(entradaReta);
                    listaDeDados.add(dtoX.getJoquei1());
                    listaDeDados.add(dtoX.getJoquei2());
                    listaDeDados.add(dtoX.getTreinador1());
                    listaDeDados.add(dtoX.getTreinador2());
                    listaDeDados.add(tempos);
                }
            }
        }
        return listaDeDados;
    }

    private static String montaTempos(float tempo1A, float tempo2A) {
        String tempos = "";
        String dif = "";
        float diferenca = 0.0f;
        if (tempo1A > 0) {
            float tempo1 = ArredondaNrFloat.duasDecimais(tempo1A);
            tempos = tempos.concat(String.valueOf(tempo1)).concat(" - ");
        } else {
            tempos = "x ";
        }
        if (tempo2A > 0) {
            float tempo2 = ArredondaNrFloat.duasDecimais(tempo2A);
            tempos = tempos.concat(String.valueOf(tempo2));
        } else {
            tempos = tempos.concat(" x");
        }
        if (tempo1A > 0 && tempo2A > 0) {
            diferenca = ArredondaNrFloat.calculaDif(tempo1A, tempo2A);
        }
        if (diferenca == 0.0f) {
            tempos = tempos.concat("  Empate.");
        } else {
            dif = String.valueOf(diferenca);
            tempos = tempos.concat("  Dif: ").concat(dif).concat("s");
        }
        return tempos;
    }

    private static Set<String> identificaRaiasDaLista(List<DTO_x> lista) {
        Set<String> raias = new TreeSet<>();
        for (DTO_x dto : lista) {
            raias.add(dto.getRaia());
        }
        return raias;
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

    public static String montaHRdata(Date data, String hipoCod) {
        String dt = new ConverteDateToString().converteMK1(data);
        return hipoCod.concat(" ").concat(dt);
    }

    private static String verificaConteudoDaString(String str) {
        if (str == null) {
            return "x";
        }
        return str.trim();
    }
}
