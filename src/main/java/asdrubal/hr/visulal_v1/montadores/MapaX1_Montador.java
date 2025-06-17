package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MapaX1_Montador {
    private static List<CompetidorDTO> listaFiltroYear;
    private static List<CompetidorDTO> listaFiltroRaia;
    private static List<CompetidorDTO> listaFiltroSoDistancia;
    private static List<CompetidorDTO> listaFiltroSoPista;

    public static Map<String, List<CompetidorDTO>> montaMapaX1(List<Object[]> dados, Map<Integer, List<CompetidorDTO>> mapa) {
        Map<String, List<CompetidorDTO>> mapaRetorno = new HashMap<>();
        for (int i = 0; i < dados.size(); i++) {
            Object[] linha = dados.get(i);
            Object nr = linha[0];
            Object nome = linha[1];
            Integer idCavalo = identificaId(nome, mapa);
            if (idCavalo == 0) {
                idCavalo = pesquisa2(nome, mapa);
                if (idCavalo == 0) {
                    System.out.println("idCavalo continua igual a zero. Fazer nova pesquisa.---------------------");
                    // TODO MONTAR NOVA PESQUISAxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                }
            }
            if (idCavalo > 0) {
                String chave = montaChave(nr, nome);
                mapaRetorno.put(chave, mapa.get(idCavalo));
            }
        }
        return mapaRetorno;
    }


    private static Integer identificaId(Object nome, Map<Integer, List<CompetidorDTO>> mapa) {
        String cavalo = nome.toString();
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa.entrySet()) {
            cavalo = cavalo.trim();
            List<CompetidorDTO> lista = entry.getValue();
            for (CompetidorDTO dto : lista) {
                if (cavalo.equalsIgnoreCase(dto.getCavalo())) {
                    if (Objects.equals(entry.getKey(), dto.getIdCavalo())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return 0;
    }

    private static Integer pesquisa2(Object nome, Map<Integer, List<CompetidorDTO>> mapa) {
        String cavalo = nome.toString();
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa.entrySet()) {
            cavalo = cavalo.trim();
            cavalo = limpaParentesis(cavalo);
            List<CompetidorDTO> lista = entry.getValue();
            for (CompetidorDTO dto : lista) {
                String cavalo2 = limpaParentesis(dto.getCavalo());
                if (cavalo.equalsIgnoreCase(cavalo2)) {
                    if (Objects.equals(entry.getKey(), dto.getIdCavalo())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return 0;
    }

    public static String limpaParentesis(String cavalo) {
        if (cavalo.contains("(")) {
            cavalo = cavalo.substring(0, cavalo.indexOf("("));
            return cavalo.trim();
        }
        return cavalo.trim();
    }

    private static String montaChave(Object nr, Object nome) {
        String numero = validaObj(nr);
        String cavalo = nome.toString();
        return numero.concat("- ").concat(cavalo);
    }

    private static String validaObj(Object nr) {
        if (nr == null) {
            return "";
        }
        String str = nr.toString().trim();
        if (str.isEmpty()) {
            return "";
        }
        return str;
    }

    public static Map<Integer, List<CompetidorDTO>> montaMapaX1_1(List<Object[]> dados, Map<Integer, List<CompetidorDTO>> mapa) {
        Map<Integer, List<CompetidorDTO>> mapaRetorno = new HashMap<>();
        for(int i =0;i<dados.size();i++){
            Object[] linha = dados.get(i);
            Object nome = linha[1];
            Integer idCavalo = identificaId(nome, mapa);
            if (idCavalo == 0) {
                idCavalo = pesquisa2(nome, mapa);
            }
            if (idCavalo > 0) {
                mapaRetorno.put(idCavalo, mapa.get(idCavalo));
            }
        }
        return mapaRetorno;
    }
}
