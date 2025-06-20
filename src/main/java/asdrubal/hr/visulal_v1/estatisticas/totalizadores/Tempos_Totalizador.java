package asdrubal.hr.visulal_v1.estatisticas.totalizadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;

public class Tempos_Totalizador {
    public Object[] calculaTemposPorRaia(List<CompetidorDTO> lDTO, int index) {
        float tG = 0.0f;
        float tGL = 0.0f;
        float tGM = 0.0f;
        float tGP = 0.0f;
        float tGE = 0.0f;
        float tGSeca = 0.0f;
        float tGMolhada = 0.0f;

        float tA = 0.0f;
        float tAL = 0.0f;
        float tAM = 0.0f;
        float tAP = 0.0f;
        float tAE = 0.0f;
        float tALV = 0.0f;
        float tAMV = 0.0f;
        float tAPV = 0.0f;
        float tAEV = 0.0f;
        float tAU = 0.0f;
        float tASeca = 0.0f;
        float tAMolhada = 0.0f;
        Object[] obj = new Object[index];
        for (CompetidorDTO cDTO : lDTO) {
            float tempo = cDTO.getTempo();
            String raia = cDTO.getRaia();
            raia = raia.trim();
            raia = raia.replaceAll("\\d+", "").trim();
            switch (raia) {
                case ("GL"):
                    tG += tempo;
                    tGSeca += tempo;
                    tGL += tempo;
                    break;
                case ("GM"):
                    tG += tempo;
                    tGSeca += tempo;
                    tGM += tempo;
                    break;
                case ("GP"):
                    tG += tempo;
                    tGMolhada += tempo;
                    tGP += tempo;
                    break;
                case ("GE"):
                    tG += tempo;
                    tGMolhada += tempo;
                    tGE += tempo;
                    break;
//------------AREIA
                case ("AL"):
                    tA += tempo;
                    tASeca += tempo;
                    tAL += tempo;
                    break;
                case ("AM"):
                    tA += tempo;
                    tASeca += tempo;
                    tAM += tempo;
                    break;
                case ("AP"):
                    tA += tempo;
                    tAMolhada += tempo;
                    tAP += tempo;
                    break;
                case ("AE"):
                    tA += tempo;
                    tAMolhada += tempo;
                    tAE += tempo;
                    break;
                case ("ALV"):
                    tA += tempo;
                    tASeca += tempo;
                    tALV += tempo;
                    break;
                case ("AMV"):
                    tA += tempo;
                    tASeca += tempo;
                    tAMV += tempo;
                    break;
                case ("APV"):
                    tA += tempo;
                    tAMolhada += tempo;
                    tAPV += tempo;
                    break;
                case ("AEV"):
                    tA += tempo;
                    tAMolhada += tempo;
                    tAEV += tempo;
                    break;
                case ("AU"):
                    tA += tempo;
                    tAMolhada += tempo;
                    tAU += tempo;
                    break;
                case ("AÚ"):
                    tA += tempo;
                    tAMolhada += tempo;
                    tAU += tempo;
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
}
