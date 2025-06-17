package asdrubal.hr.visulal_v1.filtros_tela_analise2;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiltroYear {

    public static Map<String, List<CompetidorDTO>> iniciaFiltro(List<String> yearsLista, Map<String, List<CompetidorDTO>> mapaX1) {
        if (yearsLista.contains("Todos") || yearsLista.isEmpty()) {
            return null;
        }
        Map<String, List<CompetidorDTO>> mapaRetorno = new HashMap<>();
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaX1.entrySet()) {
            List<CompetidorDTO> lista = passaFiltros(yearsLista, entry.getValue());
            if (!lista.isEmpty()) {
                mapaRetorno.put(entry.getKey(), lista);
            }
        }
        return mapaRetorno;
    }

    private static List<CompetidorDTO> passaFiltros(List<String> yearsLista, List<CompetidorDTO> lista) {
        List<CompetidorDTO> retorno = new ArrayList<>();
        for (String filtro : yearsLista) {
            int ano = Integer.parseInt(filtro);
            for (CompetidorDTO cDTO : lista) {
                int anoData = cDTO.getData().toLocalDate().getYear();
                if (anoData == ano) {
                    retorno.add(cDTO);
                }
            }
        }
        return retorno;
    }

    public static Map<Integer, List<CompetidorDTO>> filtro2(Map<Integer, List<CompetidorDTO>> mapaX11, List<String> yearsLista) {
        System.out.println("Executando o filtro2");
        Map<Integer, List<CompetidorDTO>> mapaRetorno = new HashMap<>();
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapaX11.entrySet()) {
            List<CompetidorDTO> selecao = passaFiltros(yearsLista, entry.getValue());
            if (!selecao.isEmpty()) {
                mapaRetorno.put(entry.getKey(), selecao);
            }
        }
        return mapaRetorno;
    }

}


