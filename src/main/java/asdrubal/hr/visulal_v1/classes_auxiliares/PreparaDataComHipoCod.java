package asdrubal.hr.visulal_v1.classes_auxiliares;

import java.sql.Date;

public class PreparaDataComHipoCod {
    public static String inicia(Date data, String hipCod) {
        String dt = new ConverteDateToString().converteMK1(data);
        dt = dt.trim();
        hipCod = hipCod.trim();
        return hipCod.concat(" ").concat(dt);
    }
}
