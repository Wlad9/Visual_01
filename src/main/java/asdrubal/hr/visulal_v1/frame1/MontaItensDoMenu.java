package asdrubal.hr.visulal_v1.frame1;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;

import java.sql.Date;

public class MontaItensDoMenu {

    public String montaItemMenuPrograma(ProgramaDTO dto) {
        if (dto != null) {
            String data = preparaData(dto.getData());
            String hipodromo = identificaHipodromo(dto.getHipodromoCod().toUpperCase());
            return hipodromo.concat(data);
        }
        return null;
    }

    private String preparaData(Date data) {
        ConverteDateToString converte = new ConverteDateToString();
        return converte.converteMK1(data);
    }

    private String identificaHipodromo(String hipodromoCod) {
        switch (hipodromoCod) {
            case "GV":
                return "Gávea: ";
            case "CJ":
                return "Cidade Jardim: ";
            case "RS":
                return "Cristal: ";
            case "PR":
                return "Tarumã: ";
        }
        return null;
    }

}
