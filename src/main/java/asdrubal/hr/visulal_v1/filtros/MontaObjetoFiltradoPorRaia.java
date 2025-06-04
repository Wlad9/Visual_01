package asdrubal.hr.visulal_v1.filtros;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class MontaObjetoFiltradoPorRaia {
    private static List<CompetidorDTO> listaZero = new ArrayList<>();
    private static Map<String, List<CompetidorDTO>> mapaZero;
    private static Set<Integer> negrito = new HashSet<>();
    private static String[] titulos = new String[]{"Tempo", "Cavalo", "Pos", "Data", "Joquei", "Treinador", "Rateio", "Crono", "Prova"};
    private static String[] titulo = new String[]{"Tempo","Pos","Cavalo","Data","Jóquei","Treinador","Rateio","Prova","Crono"};

    public static Object[][] montaObject(Map<String, List<CompetidorDTO>> mapa) {
        int i = 0;
        mapaZero = new HashMap<>();
        Map<String, List<CompetidorDTO>> mapaOrdenado = new HashMap<>();
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapa.entrySet()) {
            String raia = entry.getKey();
            List<CompetidorDTO> lista = entry.getValue();
            List<CompetidorDTO> listaOrdenada = lista.stream()
                    .filter(c -> c.getTempo() > 0f)
                    .sorted(Comparator.comparing(CompetidorDTO::getTempo))
                    .collect(Collectors.toList());
            listaZero = lista.stream().filter(c -> c.getTempo() == 0f).collect(Collectors.toList());
            mapaOrdenado.put(raia, listaOrdenada);
            mapaZero.put(raia, listaZero);
        }
        return finalizaObjeto(mapaOrdenado);
    }

    public static Map<String, List<CompetidorDTO>> getMapaZero() {
        return mapaZero;
    }

    private static Object[][] finalizaObjeto(Map<String, List<CompetidorDTO>> mapaOrdenado) {
        int nrRaias = mapaOrdenado.size();
        int nrLinhas = calculaNrLinhas(nrRaias, mapaOrdenado);
        int nrColunas = 11;
        Object[][] dados = new Object[nrLinhas][nrColunas];
        int i = 0;
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaOrdenado.entrySet()) {
            String raia = entry.getKey().trim();
            dados[i][0] = raia;
            negrito.add(i);
            List<CompetidorDTO> lista = entry.getValue();
            i++;
            for (CompetidorDTO dto : lista) {
                String data = montaDataHipo(dto.getData(), dto.getHipoCod());
                String cronometro = dto.getCronometro();
                cronometro = cronometro.toLowerCase();
                dados[i][0] = cronometro;
//                dados[i][0] = dto.getCronometro();
                dados[i][1] = dto.getColocacao();
                dados[i][2] = dto.getCavalo();
                dados[i][3] = data;
                dados[i][4] = dto.getJoquei();
                dados[i][5] = dto.getTreinador();
                dados[i][6] = dto.getRateio();
                dados[i][7] = dto.getProva();
                dados[i][8] = dto.getCorpoChegada();
                dados[i][9] = dto.getEntradaReta();
                dados[i][10] = dto.getTempo();
                i++;
            }
        }
        return dados;
    }

    private static String montaDataHipo(Date data, String hipoCod) {
        if (hipoCod != null) {
            String dt = new ConverteDateToString().converteMK1(data);
            return hipoCod.concat(" ").concat(dt);
        }
        return null;
    }

    private static int calculaNrLinhas(int nrRaias, Map<String, List<CompetidorDTO>> mapaOrdenado) {
        return (nrRaias + mapaOrdenado.values().stream().mapToInt(List::size).sum());
    }

//    public static String[] getTitulos() {
//        return titulos;
//    }
    public static Set<Integer> getNegrito(){
        return negrito;
    }
}
