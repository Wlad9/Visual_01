package asdrubal.hr.visulal_v1.corridas_na_mesma_raia;

import asdrubal.hr.visulal_v1.classes_auxiliares.PreparaDataComHipoCod;
import asdrubal.hr.visulal_v1.classes_auxiliares.PreparaNrNomeCavalo;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.objetos.AuxMontaCamposDoObjeto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MontaListObjcUnidimencional {
    public List<Object[]> inicia(Map<String, List<CompetidorDTO>> mapaA, int nrCol, List<Object[]> dadosLS) {
        List<Object[]> objList = new ArrayList<>();
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaA.entrySet()) {
            String raia = entry.getKey();
            Object[] dado = new Object[]{raia};
            objList.add(dado);
            List<CompetidorDTO> lDTO = entry.getValue();
            lDTO.forEach(e -> {
                Object[] obj = new Object[nrCol];
                Integer idCavalo = e.getIdCavalo();
                String pos = AuxMontaCamposDoObjeto.montaColocacao(e.getColocacao());
                String cavalo = e.getCavalo();
                cavalo = PreparaNrNomeCavalo.prepNomeCavalo(cavalo, idCavalo, dadosLS);
                String crono = e.getCronometro();
                String joquei = e.getJoquei();
                String corpoChegada = e.getCorpoChegada();
                float tempo = e.getTempo();
                Date data = e.getData();
                String hipCod = e.getHipoCod();
                String dt = PreparaDataComHipoCod.inicia(data, hipCod);
                String treinador = e.getTreinador();
                String entradaReta = e.getEntradaReta();
                obj[0] = crono;
                obj[1] = pos;
                obj[2] = cavalo;
                obj[3] = dt;
                obj[4] = joquei;
                obj[5] = corpoChegada;
                obj[6] = treinador;
                obj[7] = e.getRateio();
                obj[8] = tempo;
                obj[9] = entradaReta;
                obj[10] = raia;
                objList.add(obj);
            });
        }
        return objList;
    }

}
