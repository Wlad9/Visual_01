package asdrubal.hr.visulal_v1.registro.classes_aux;

import asdrubal.hr.visulal_v1.classes_auxiliares.MontaRaia;
import asdrubal.hr.visulal_v1.classes_auxiliares.PreparaDataComHipoCod;
import asdrubal.hr.visulal_v1.dto.Registro_DTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import java.sql.Date;

public class MontaRegistroDTO {
    public Registro_DTO inicia(Object[] dados, DTO_JT_tabPareos dto, Integer idCavaloSelec) {
        String cavalo = dados[1].toString();
        String joquei = dados[2].toString();
        String dist = String.valueOf(dto.getDistancia());
        String pista = dto.getPista();
        Integer idPareo = dto.getIdPareo();
        Integer idPrograma = dto.getIdPrograma();
        String hipoCod = dto.getHipocod();
        Date data = dto.getData();
        String hipoData = PreparaDataComHipoCod.inicia(data, hipoCod);
        String raia = new MontaRaia().monta(pista, dist);

        Registro_DTO rDTO = new Registro_DTO();
        rDTO.setIdPareo(idPareo);
        rDTO.setIdPrograma(idPrograma);
        rDTO.setHipoData(hipoData);
        rDTO.setRaia(raia);
        return rDTO;
    }
}
