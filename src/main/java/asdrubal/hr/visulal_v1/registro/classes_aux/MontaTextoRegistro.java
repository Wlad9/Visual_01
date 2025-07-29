package asdrubal.hr.visulal_v1.registro.classes_aux;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;

import java.sql.Date;

public class MontaTextoRegistro {
    private final Object[] dados;
    private final DTO_JT_tabPareos dto;
    private String msg2;

    public MontaTextoRegistro(Object[] dadosDaLinha, DTO_JT_tabPareos dtoJtPareos) {
        dados = dadosDaLinha;
        dto = dtoJtPareos;
    }

    public String texto1() {
        String cavalo = dados[1].toString();
        ConverteDateToString converte = new ConverteDateToString();
        String data = converte.converteMK1(dto.getData());
        String pista = dto.getPista();
        String dist = String.valueOf(dto.getDistancia());
        String hipoCod = dto.getHipocod();
        String raia = pista.concat(dist);
        msg2 = " Páreo: ".concat(hipoCod).concat(" ").concat(data).concat("  -  ").concat(raia);
        return " ".concat(cavalo.trim());
    }

    public String getMsg2() {
        return msg2;
    }
}
