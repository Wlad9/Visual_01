package asdrubal.hr.visulal_v1.classes_auxiliares;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TransformaUniDiParaBiDi {
    private Set<Integer> negrito = new TreeSet<>();

    public Object[][] transforma(List<Object[]> objetos, int nrSpace, int nrColunas) {
        boolean inicio = true;
        int nrL = objetos.size() + nrSpace;
        Object[][] dados = new Object[nrL][nrColunas];
        int i = 0;
        for (Object[] obj : objetos) {
            boolean isTitulo = obj[3] == null;
            if (isTitulo) {
                if (inicio) {
                    dados[i][0] = obj[0];
                    dados[i][1] = obj[1];
                    negrito.add(i);
                    i++;
                    inicio = false;
                } else {
                    dados[i][0] = "";
                    i++;
                    dados[i][0] = obj[0];
                    dados[i][1] = obj[1];
                    negrito.add(i);
                    i++;
                }
            } else {
                for (int j = 0; j < nrColunas && j < obj.length; j++) {
                    dados[i][j] = obj[j];

//                    dados[i][0] = obj[0];
//                    dados[i][1] = obj[1];
//                    dados[i][2] = obj[2];
//                    dados[i][3] = obj[3];
//                    dados[i][4] = obj[4];
//
//                    dados[i][8] = obj[8];
//                    dados[i][9] = obj[9];
//                    dados[i][10] = obj[10];
                }
                i++;
            }
        }
        return Arrays.copyOf(dados, i);
//        return dados;
    }

    public Object[][] transforma_Mk2(List<Object[]> lstObj) {
        return lstObj.toArray(new Object[0][]);
    }
}
