package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.analise2_objeto_montador.ObjetoFiltroAnalise2;
import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.classes_auxiliares.TransformaUniDiParaBiDi;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.filtros_corridas_mesmo_pareo.MontaObjetoFiltradoPorRaia;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ObjetoFiltrado_Montador {
    private static final int nrLn = 11;

    public static Object[][] montaDadosF(Map<String, List<CompetidorDTO>> mapaA, List<Object[]> dadoLS) {
        List<Object[]> lista = new ArrayList<>();
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaA.entrySet()) {
            String raia = entry.getKey();
            Object[] obj = new Object[]{raia};
            lista.add(obj);
            List<CompetidorDTO> lDTO = entry.getValue();
            lDTO.forEach(e -> {
                Object[] ob = capturaDados(e, dadoLS);
                lista.add(ob);
            });
        }
        for(Object[] x: lista) {
            ShowObjetoUniDim.show(x,"XHHH---------------");
        }

        TransformaUniDiParaBiDi trbidi = new TransformaUniDiParaBiDi();
        Object[][] objX = trbidi.transforma_Mk2(lista);
        Object[][] objX_Final = ObjetoFiltroAnalise2.montaObj(mapaA, dadoLS);
        return ObjetoFiltrado_Transfoma.inicia(lista);
    }

    private static Object[] capturaDados(CompetidorDTO e, List<Object[]> dadoLS) {
        Integer idCavalo = e.getIdCavalo();
        String crono = e.getCronometro();
        String pos = String.valueOf(e.getColocacao());
        pos = preparaPos(pos);
        String cavalo = e.getCavalo();
        cavalo = preparaNome(cavalo, idCavalo, dadoLS);
        Date data = e.getData();
        String hipCod = e.getHipoCod();
        String dt = preparaData(data, hipCod);
        String joquei = e.getJoquei();
        String corpo = e.getCorpoChegada();
        String treinador = e.getTreinador();
        String rateio = e.getRateio();
        float tempo = e.getTempo();
        Object[] obj = new Object[nrLn];
        obj[0] = crono;
        obj[1] = pos;
        obj[2] = cavalo;
        obj[3] = dt;
        obj[4] = joquei;
        obj[5] = corpo;
        obj[6] = treinador;
        obj[7] = treinador;
        obj[8] = tempo;
        return obj;
    }

    private static String preparaData(Date data, String hipCod) {
        String dt = new ConverteDateToString().converteMK1(data);
        dt = dt.trim();
        hipCod = hipCod.trim();
        return hipCod.concat(" ").concat(dt);
    }

    private static String preparaPos(String pos) {
        pos = pos.trim();
        return pos.concat("°L");
    }

    private static String preparaNome(String cavalo, Integer idCavalo, List<Object[]> dadoLS) {
        for (Object[] obj : dadoLS) {
            Integer id = Integer.parseInt(obj[2].toString());
            if (id.equals(idCavalo)) {
                cavalo = cavalo.trim();
                String nr = obj[0].toString();
                return nr.concat(" -").concat(cavalo);
            }
        }
        return cavalo;
    }

}
