package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;

public class TituloPagina {


    private final DTO_JT_tabPareos dto;

    public TituloPagina(DTO_JT_tabPareos dtoJtTabPareos) {
        this.dto = dtoJtTabPareos;
    }

    public String montaTitulo() {
        String distancia = String.valueOf(dto.getDistancia());
        String pista = dto.getPista();
        String chamada = dto.getChamada();
        if(chamada == null){
            chamada = "noInfo";
        }
        ConverteDateToString cvd = new ConverteDateToString();
        String data =  cvd.converteMK1(dto.getData());
        String hipoCod = dto.getHipocod();
        String ordem = String.valueOf(dto.getOrdem());
        ordem = ordem.concat("°Páreo.");
//        System.out.println("Distancia:"+distancia+"\tpista:"+pista);
//        System.out.println("Chamada:"+chamada);
//        System.out.println("Data:"+data);
//        System.out.println("hip:"+hipoCod);
//        System.out.println("Ordem:"+ordem);
        String x =ordem.concat("    ").concat(hipoCod).concat("  ").concat(data).concat("  -   ")
                .concat(pista).concat(distancia).concat(" -       ").concat(chamada);
        return x;
    }
}
