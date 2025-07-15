package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;

public class TituloPagina {


    private final DTO_JT_tabPareos dto;

    public TituloPagina(DTO_JT_tabPareos mapa1) {
        this.dto = mapa1;
    }

    public String montaTitulo() {
        String distancia = String.valueOf(dto.getDistancia());
        String pista = dto.getPista();
        String chamada = dto.getChamada();
        ConverteDateToString cvd = new ConverteDateToString();
        String data =  cvd.converteMK1(dto.getData());
        String hipoCod = dto.getHipocod();
        String ordem = String.valueOf(dto.getOrdem());
        ordem = ordem.concat("°Páreo.");
        String x =ordem.concat("    ").concat(hipoCod).concat("  ").concat(data).concat("  -   ")
                .concat(pista).concat(distancia).concat(" -       ").concat(chamada);
        return x;
    }
}
