package asdrubal.hr.visulal_v1.filtros;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Raias_Filtro {
    private static String[] titulo = new String[]{"Crono", "Pos", "Cavalo", "Data", "Jóquei", "Treinador", "Rateio","Prova","Corp","ER","Tempo"};

    public static Object[][] filtroMk3(List<String> raiasFiltro, Map<Integer, List<CompetidorDTO>> mapa3) {
        Map<String, List<CompetidorDTO>> mapa = new HashMap<>();
        int i = 0;
        for (String raia : raiasFiltro) {
            List<CompetidorDTO> selecao = new ArrayList<>();
            for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa3.entrySet()) {
                List<CompetidorDTO> lista = entry.getValue();
                for (CompetidorDTO cDTO : lista) {
                    if (cDTO.getRaia().equalsIgnoreCase(raia)) {
                        selecao.add(cDTO);
                    }
                }
                if (!selecao.isEmpty()) {
                    mapa.put(raia, selecao);
                }
            }
        }
        return MontaObjetoFiltradoPorRaia.montaObject(mapa);
    }

    public static String[] getTitulo() {
        return titulo;
    }
}
