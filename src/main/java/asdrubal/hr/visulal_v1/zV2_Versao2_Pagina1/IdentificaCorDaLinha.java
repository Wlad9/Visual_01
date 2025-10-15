package asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import java.awt.*;
import java.util.Map;

public class IdentificaCorDaLinha {
    private final Map<String, IndicesDTO> indicesGeral;
    private final Map<String, IndicesDTO> indicesGV;
    private final Map<String, IndicesDTO> indicesOutros;
    private Color marrom = new Color(139, 69, 19);

    public IdentificaCorDaLinha(Map<String, IndicesDTO> indicesGeral, Map<String, IndicesDTO> indicesGV,
                                Map<String, IndicesDTO> indicesOutros) {
        this.indicesGeral = indicesGeral;
        this.indicesGV = indicesGV;
        this.indicesOutros = indicesOutros;
//        System.out.println("Lista de Indices Geral----1111111111----------------------:");
//        for(Map.Entry<String, IndicesDTO>entry:indicesGeral.entrySet()){
//            System.out.println("Raia-->"+entry.getKey());
//            System.out.println(entry.getValue());
//        }
    }

    public Color corDaLinhaPeloTempo(String hipoCod, Float tempo) {
        switch (hipoCod) {
            case "GV"://  TODO COMPLETAR COM O LINHA 112 TABELA_AnalisePareos
//                Color cor = indicesGavea(tempo, );
                break;
            case "RS":
                break;
            case "PR":
                break;
            case "CJ":
                break;
            case "TAB":
            default:
        }
        return null;
    }
    

    public Color corDaLinhaPeloTempoGeral(Float tempo, IndicesDTO dto) {
        if(dto == null) return null;
        if (tempo <= dto.getAzul()) {
            return Color.BLUE;
        } else if (tempo <= dto.getVerde()) {
            return Color.GREEN;
        } else if (tempo <= dto.getAmarelo()) {
            return Color.YELLOW;
        } else if (tempo <= dto.getLaranja()) {
            return Color.ORANGE;
        } else if (tempo <= dto.getVermelho()) {
            return Color.RED;
        } else {
            return marrom;
        }
    }

    public Color corDaLinhaTempoPorHipodromo(Float tempo, IndicesDTO dto) {
        return null;
    }
}
