package asdrubal.hr.visulal_v1.classes_auxiliares;

import java.sql.Date;

public class ConverteDateToString {
    public String converteMK1(Date dt) {
        String d = String.valueOf(dt).trim();
        String[] t = d.split("-");
        String dia = t[2].trim();
        String mes = t[1].trim();
        String ano = t[0].trim();
        ano = ano.substring(2);
        return dia.concat("/").concat(mes).concat("/").concat(ano).trim();
    }
}
//RCB data 2025-12-03 e transforma em string 03/12/2025