package asdrubal.hr.visulal_v1.analise2_objeto_montador;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class ObjetoFiltroAnalise2 {
    private static final int nrLn = 11;

    public static Object[][] montaObj(Map<String, List<CompetidorDTO>> mapa, List<Object[]> dadosLS, int nrColunas) {
        Map<String, List<CompetidorDTO>> mapaOrdenado = new HashMap<>();
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapa.entrySet()) {
            String raia = entry.getKey();
            List<CompetidorDTO> lista = entry.getValue();
            List<CompetidorDTO> listaOrdenada = lista.stream()
                    .filter(c -> c.getTempo() > 0f)
                    .sorted(Comparator.comparing(CompetidorDTO::getTempo))
                    .collect(Collectors.toList());
            mapaOrdenado.put(raia, listaOrdenada);
        }
        List<Object[]> listObj = preparaObjetoUniDim(mapaOrdenado, dadosLS);
        Finaliza_FinalmenteKRaLHO kRaLHO = new Finaliza_FinalmenteKRaLHO();
        return kRaLHO.finaliza(listObj, nrColunas);
    }

    private static List<Object[]> preparaObjetoUniDim(Map<String, List<CompetidorDTO>> mapaOrdenado, List<Object[]> dadosLS) {
        List<Object[]> lista = new ArrayList<>();
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaOrdenado.entrySet()) {
            String raia = entry.getKey();
            Object[] obj = new Object[]{raia};
            lista.add(obj);
            List<CompetidorDTO> lDTO = entry.getValue();
            lDTO.forEach(e -> {
                Object[] ob = capturaDados(e, dadosLS);
                lista.add(ob);
            });
        }
        return lista;
    }

    private static Object[] capturaDados(CompetidorDTO e, List<Object[]> dadosLS) {
        Integer idCavalo = e.getIdCavalo();
        String crono = e.getCronometro();
        String pos = String.valueOf(e.getColocacao());
        pos = preparaPos(pos);
        String cavalo = e.getCavalo();
        cavalo = preparaNome(cavalo, idCavalo, dadosLS);
        Date data = e.getData();
        String hipCod = e.getHipoCod();
        String dt = preparaData(data, hipCod);
        String joquei = e.getJoquei();
        String corpo = e.getCorpoChegada();
        String treinador = e.getTreinador();
        String rateio = e.getRateio();
        String raia = e.getRaia();
        float tempo = e.getTempo();
        Object[] obj = new Object[nrLn];
        obj[0] = crono;
        obj[1] = pos;
        obj[2] = cavalo;
        obj[3] = dt;
        obj[4] = joquei;
        obj[5] = corpo;
        obj[6] = treinador;
        obj[7] = rateio;
        obj[8] = tempo;
        obj[10]= raia;
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
