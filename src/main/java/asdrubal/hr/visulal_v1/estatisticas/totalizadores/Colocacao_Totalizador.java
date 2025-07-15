package asdrubal.hr.visulal_v1.estatisticas.totalizadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import java.util.ArrayList;
import java.util.List;

public class Colocacao_Totalizador {
    public Object[] calcula(List<CompetidorDTO> lDTO, int index) {

        int[] tG = new int[5];
        int[] tGL = new int[5];
        int[] tGM = new int[5];
        int[] tGP = new int[5];
        int[] tGE = new int[5];
        int[] tGSeca = new int[5];
        int[] tGMolhada = new int[5];

        int[] tA = new int[5];
        int[] tAL = new int[5];
        int[] tAM = new int[5];
        int[] tAP = new int[5];
        int[] tAE = new int[5];
        int[] tALV = new int[5];
        int[] tAMV = new int[5];
        int[] tAPV = new int[5];
        int[] tAEV = new int[5];
        int[] tAU = new int[5];
        int[] tASeca = new int[5];
        int[] tAMolhada = new int[5];
        Object[] obj = new Object[index];
        for (CompetidorDTO cDTO : lDTO) {
            int pos = arrumaValor(cDTO.getColocacao());
            String raia = cDTO.getRaia();
            raia = raia.trim();
            raia = raia.replaceAll("\\d+", "").trim();
            switch (raia) {
                case ("GL"):
                    tG[pos] += 1;
                    tGSeca[pos] += 1;
                    tGL[pos] += 1;
                    break;
                case ("GM"):
                    tG[pos] += 1;
                    tGSeca[pos] += 1;
                    tGM[pos] += 1;
                    break;
                case ("GP"):
                    tG[pos] += 1;
                    tGMolhada[pos] += 1;
                    tGP[pos] += 1;
                    break;
                case ("GE"):
                    tG[pos] += 1;
                    tGMolhada[pos] += 1;
                    tGE[pos] += 1;
                    break;
//------------AREIA
                case ("AL"):
                    tA[pos] += 1;
                    tASeca[pos] += 1;
                    tAL[pos] += 1;
                    break;
                case ("AM"):
                    tA[pos] += 1;
                    tASeca[pos] += 1;
                    tAM[pos] += 1;
                    break;
                case ("AP"):
                    tA[pos] += 1;
                    tAMolhada[pos] += 1;
                    tAP[pos] += 1;
                    break;
                case ("AE"):
                    tA[pos] += 1;
                    tAMolhada[pos] += 1;
                    tAE[pos] += 1;
                    break;
                case ("ALV"):
                    tA[pos] += 1;
                    tASeca[pos] += 1;
                    tALV[pos] += 1;
                    break;
                case ("AMV"):
                    tA[pos] += 1;
                    tASeca[pos] += 1;
                    tAMV[pos] += 1;
                    break;
                case ("APV"):
                    tA[pos] += 1;
                    tAMolhada[pos] += 1;
                    tAPV[pos] += 1;
                    break;
                case ("AEV"):
                    tA[pos] += 1;
                    tAMolhada[pos] += 1;
                    tAEV[pos] += 1;
                    break;
                case ("AU"):
                    tA[pos] += 1;
                    tAMolhada[pos] += 1;
                    tAU[pos] += 1;
                    break;
                case ("AÚ"):
                    tA[pos] += 1;
                    tAMolhada[pos] += 1;
                    tAU[pos] += 1;
                    break;
            }
        }
        obj[1] = tG;
        obj[2] = tGSeca;
        obj[3] = tGMolhada;
        obj[4] = tGL;
        obj[5] = tGM;
        obj[6] = tGP;
        obj[7] = tGE;
        obj[8] = tA;
        obj[9] = tASeca;
        obj[10] = tAMolhada;
        obj[11] = tAL;
        obj[12] = tAM;
        obj[13] = tAP;
        obj[14] = tAE;
        obj[15] = tALV;
        obj[16] = tAMV;
        obj[17] = tAPV;
        obj[18] = tAEV;
        obj[19] = tAU;
        return obj;
    }

    private int arrumaValor(int pos) {
        if (pos > 0) {
            if (pos > 4) {
                pos = 5;
            }
            pos = pos - 1;
        }
        return pos;
    }


    private void inicializaArrayComZero(List<Object[]> listaDeObjetos) {
        for (Object[] objArray : listaDeObjetos) {
            for (int i = 0; i < objArray.length; i++) {
                objArray[i] = 0;
            }
        }
    }
}





