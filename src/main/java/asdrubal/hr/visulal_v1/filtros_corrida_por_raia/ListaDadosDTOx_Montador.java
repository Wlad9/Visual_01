package asdrubal.hr.visulal_v1.filtros_corrida_por_raia;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaDadosDTOx_Montador {

    public Map<String, List<DTO_x>> inicia(Map<String, List<CompetidorDTO>> mapa) {
        Map<String, List<DTO_x>> mapaDTOx = new HashMap<>();
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapa.entrySet()) {
            List<DTO_x> listaX = new ArrayList<>();
            List<CompetidorDTO> listaDTO = entry.getValue();
            String raia = entry.getKey();
            for (CompetidorDTO dto : listaDTO) {
                DTO_x x = getDtoX(dto);
                listaX.add(x);
            }
            if (!listaX.isEmpty()) {
                mapaDTOx.put(raia, listaX);
            }
        }
        return mapaDTOx;
    }

    private static DTO_x getDtoX(CompetidorDTO dto) {
        DTO_x x = new DTO_x();
        x.setCavalo1(dto.getCavalo());
        x.setPos1(dto.getColocacao());
        x.setCrono1(dto.getCronometro());
        x.setTempo1(dto.getTempo());
        x.setData(dto.getData());
        x.setJoquei1(dto.getJoquei());
        x.setTreinador1(dto.getTreinador());
        x.setRateio1(dto.getRateio());
        x.setCorpo1(dto.getCorpoChegada());
        x.setEntra1(dto.getEntradaReta());
        x.setProva(dto.getProva());
        x.setHipoCod(dto.getHipoCod());
        x.setTempo1(dto.getTempo());
        return x;
    }
}
