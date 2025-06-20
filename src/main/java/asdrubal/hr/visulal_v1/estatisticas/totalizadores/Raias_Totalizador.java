package asdrubal.hr.visulal_v1.estatisticas.totalizadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;

public class Raias_Totalizador {
//    private static int tG = 0;
//    private static int tGL = 0;
//    private static int tGM = 0;
//    private static int tGP = 0;
//    private static int tGE = 0;
//    private static int tGLV = 0;
//    private static int tGMV = 0;
//    private static int tGPV = 0;
//    private static int tGEV = 0;

    //    private static int tGSeca = 0;
//    private static int tGMolhada = 0;
//
//    private static int tA = 0;
//    private static int tAL = 0;
//    private static int tAM = 0;
//    private static int tAP = 0;
//    private static int tAE = 0;
//    private static int tALV = 0;
//    private static int tAMV = 0;
//    private static int tAPV = 0;
//    private static int tAEV = 0;
//    private static int tAU = 0;
//
//    private static int tASeca = 0;
//    private static int tAMolhada = 0;
//    boolean bG = false;
//    boolean bGL = false;
//    boolean bGM = false;
//    boolean bGP = false;
//    boolean bGE = false;
//    boolean bGSeca = false;
//    boolean bGMolhada = false;
//
//    boolean bA = false;
//    boolean bAL = false;
//    boolean bAM = false;
//    boolean bAP = false;
//    boolean bAE = false;
//    boolean bALV = false;
//    boolean bAMV = false;
//    boolean bAPV = false;
//    boolean bAEV = false;
//    boolean bAU = false;
//    boolean bASeca = false;
//    boolean bAMolhada = false;

    public Object[] totalizaPorRaia(List<CompetidorDTO> lDTO, int index) {
        int tG = 0;
        int tGL = 0;
        int tGM = 0;
        int tGP = 0;
        int tGE = 0;
        int tGSeca = 0;
        int tGMolhada = 0;

        int tA = 0;
        int tAL = 0;
        int tAM = 0;
        int tAP = 0;
        int tAE = 0;
        int tALV = 0;
        int tAMV = 0;
        int tAPV = 0;
        int tAEV = 0;
        int tAU = 0;
        int tASeca = 0;
        int tAMolhada = 0;
        Object[] obj = new Object[index];
        for (CompetidorDTO cDTO : lDTO) {
            String raia = cDTO.getRaia();
            raia = raia.trim();
            raia = raia.replaceAll("\\d+", "").trim();
            switch (raia) {
                case ("GL"):
                    ++tG;
                    ++tGSeca;
                    ++tGL;
                    obj[1] = tG;
                    obj[2] = tGSeca;
                    obj[4] = tGL;
                    break;
                case ("GM"):
                    ++tG;
                    ++tGSeca;
                    ++tGM;
                    obj[1] = tG;
                    obj[2] = tGSeca;
                    obj[5] = tGM;
                    break;
                case ("GP"):
                    ++tG;
                    ++tGMolhada;
                    ++tGP;
                    obj[1] = tG;
                    obj[3] = tGMolhada;
                    obj[6] = tGP;
                    break;
                case ("GE"):
                    ++tG;
                    ++tGMolhada;
                    ++tGE;
                    obj[1] = tG;
                    obj[3] = tGMolhada;
                    obj[7] = tGE;
                    break;
//------------AREIA
                case ("AL"):
                    ++tA;
                    ++tASeca;
                    ++tAL;
                    obj[8] = tA;
                    obj[9] = tASeca;
                    obj[11] = tAL;
                    break;
                case ("AM"):
                    ++tA;
                    ++tASeca;
                    ++tAM;
                    obj[8] = tA;
                    obj[9] = tASeca;
                    obj[12] = tAM;
                    break;
                case ("AP"):
                    ++tA;
                    ++tAMolhada;
                    ++tAP;
                    obj[8] = tA;
                    obj[10] = tAMolhada;
                    obj[13] = tAP;
                    break;
                case ("AE"):
                    ++tA;
                    ++tAMolhada;
                    ++tAE;
                    obj[8] = tA;
                    obj[10] = tAMolhada;
                    obj[14] = tAE;
                    break;
                case ("ALV"):
                    ++tA;
                    ++tASeca;
                    ++tALV;
                    obj[8] = tA;
                    obj[9] = tASeca;
                    obj[15] = tALV;
                    break;
                case ("AMV"):
                    ++tA;
                    ++tASeca;
                    ++tAMV;
                    obj[8] = tA;
                    obj[9] = tASeca;
                    obj[16] = tAMV;
                    break;
                case ("APV"):
                    ++tA;
                    ++tAMolhada;
                    ++tAPV;
                    obj[8] = tA;
                    obj[10] = tAMolhada;
                    obj[17] = tAPV;
                    break;
                case ("AEV"):
                    ++tA;
                    ++tAMolhada;
                    ++tAEV;
                    obj[8] = tA;
                    obj[10] = tAMolhada;
                    obj[18] = tAEV;
                    break;
                case ("AU"):
                    ++tA;
                    ++tAMolhada;
                    ++tAU;
                    obj[8] = tA;
                    obj[10] = tAMolhada;
                    obj[19] = tAU;
                    break;
                case ("AÚ"):
                    ++tA;
                    ++tAMolhada;
                    ++tAU;
                    obj[8] = tA;
                    obj[10] = tAMolhada;
                    obj[19] = tAU;
                    break;
            }
        }
        return obj;
    }
}
