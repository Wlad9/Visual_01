package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto.PareoDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;

import java.util.*;

public class MapaDeDuplas_Montador {
    private static List<CompetidorDTO> corridasCavalo1;
    private static List<CompetidorDTO> corridasCavalo2;

    public static List<DTO_x> inicia(List<CompetidorDTO> corridasCav1, List<CompetidorDTO> corridasCav2
            , List<Integer> pareosComuns, String cavalo1, String cavalo2) {
        corridasCavalo1 = corridasCav1;
        corridasCavalo2 = corridasCav2;

        List<DTO_x> listaX = new ArrayList<>();
        for (Integer idPareo : pareosComuns) {
            for (CompetidorDTO cDTO1 : corridasCavalo1) {
                if (cDTO1.getIdDoPareo().equals(idPareo)) {
                    CompetidorDTO dto1 = cDTO1;
                    CompetidorDTO dto2 = identificaDTO(idPareo);
                    DTO_x dtoX = montaDTOx(dto1, dto2);
                    listaX.add(dtoX);
                }
            }
        }
        return listaX;
    }

    private static DTO_x montaDTOx(CompetidorDTO dto1, CompetidorDTO dto2) {
        return new DTO_x(dto1, dto2);
    }

    private static CompetidorDTO identificaDTO(Integer idPareo) {
        for (CompetidorDTO dto : corridasCavalo2) {
            if (dto.getIdDoPareo().equals(idPareo)) {
                return dto;
            }
        }
        System.out.println("ERRO. Corridas comuns erro de dto comum.");
        System.exit(0);////////////////////////////////////////////////////////////////////////////////////////
        return null;
    }
}
