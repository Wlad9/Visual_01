package asdrubal.hr.visulal_v1.analise2_objeto_montador;

import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Finaliza_FinalmenteKRaLHO {
    public Object[][] finaliza(List<Object[]> listObj, int nrColunas) {
        Set<Integer> negrito = new TreeSet<>();
        boolean inicio = true;
        int nrLinhas = calculaLinhas(listObj);
        int index = 0;
        Object[][] objFinal = new Object[nrLinhas][nrColunas];
        for (Object[] obj : listObj) {
            if (obj.length == 1 && inicio) {
                negrito.add(index);
                objFinal[index++][0] = obj[0];
                inicio = false;
            } else if (obj.length == 1) {
                objFinal[index++][0] = "";//Linha em branco
                negrito.add(index);
                objFinal[index++][0] = obj[0];
            }
            if (obj.length > 2) {
                objFinal[index][0] = obj[0];
                objFinal[index][1] = obj[1];
                objFinal[index][2] = obj[2];
                objFinal[index][3] = obj[3];
                objFinal[index][4] = obj[4];
                objFinal[index][5] = obj[5];
                objFinal[index][6] = obj[6];
                objFinal[index][7] = obj[7];
                objFinal[index][8] = obj[8];
                objFinal[index++][10] = obj[10];
            }
        }
//        ShowObjectBiDim.show(objFinal, "OBjeto FINAL");
        return objFinal;
    }

    private int calculaLinhas(List<Object[]> listObj) {
        int t1 = listObj.size();
        int nrRaias = 0;
        for (Object[] obj : listObj) {
            if (obj.length == 1) {
                nrRaias++;
            }
        }
        nrRaias = nrRaias - 1;
        return t1 + nrRaias;
    }
}
