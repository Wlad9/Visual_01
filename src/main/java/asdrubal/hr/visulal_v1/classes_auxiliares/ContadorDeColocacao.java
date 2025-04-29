package asdrubal.hr.visulal_v1.classes_auxiliares;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;

public class ContadorDeColocacao {
    private static int cont1;
    private static int cont2;
    private static int cont3;

    public static int calcula(List<CompetidorDTO> listaOrdenada, List<CompetidorDTO> listaZero) {
        cont1 = 0;
        cont2 = 0;
        cont3 = 0;

        for (CompetidorDTO c : listaOrdenada) {
            int pos = c.getColocacao();
            if (pos == 1) {
                cont1++;
            } else if (pos == 2) {
                cont2++;
            } else if (pos == 3) {
                cont3++;
            }
        }
        for (CompetidorDTO c : listaZero) {
            int pos = c.getColocacao();
            if (pos == 1) {
                cont1++;
            } else if (pos == 2) {
                cont2++;
            } else if (pos == 3) {
                cont3++;
            }
        }
        return cont1;
    }

    public static int getCont2() {
        return cont2;
    }

    public static int getCont3() {
        return cont3;
    }

    public static int calcula(List<CompetidorDTO> lista) {
        cont1 = 0;
        cont2 = 0;
        cont3 = 0;

        for (CompetidorDTO c : lista) {
            int pos = c.getColocacao();
            if (pos == 1) {
                cont1++;
            } else if (pos == 2) {
                cont2++;
            } else if (pos == 3) {
                cont3++;
            }
        }
        return cont1;
    }
}
