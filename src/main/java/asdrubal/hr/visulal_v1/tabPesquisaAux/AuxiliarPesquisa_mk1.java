package asdrubal.hr.visulal_v1.tabPesquisaAux;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.List;
import java.util.Map;

public class AuxiliarPesquisa_mk1 {
    private final Map<Integer, List<CompetidorDTO>> mapa4;
    private final Map<Integer, List<CompetidorDTO>> mapa5;
    private String[] titulos;

    public AuxiliarPesquisa_mk1(Map<Integer, List<CompetidorDTO>> mapa4, Map<Integer, List<CompetidorDTO>> mapa5) {
        this.mapa4 = mapa4;
        this.mapa5 = mapa5;
        titulos = new String[]{"Pos", "Raia", "Prova", "Crono", "Rateio", "Jóquei", "Treinador", "CorpCheg", "EntraReta", "Tempo"};
    }

    public Object[][] montaDadosMk1() {
        int nrLinhas = calculaLinhas(mapa4);
        nrLinhas += calculaLinhas(mapa5) + mapa4.size();
        int nrColunas = titulos.length;
        Object[][] dados = new Object[nrLinhas][nrColunas];
        int i = 0;
        for (Integer idCavalo : mapa4.keySet()) {
            List<CompetidorDTO> listaOrdenada = mapa4.get(idCavalo);
            List<CompetidorDTO> listaZero = mapa5.get(idCavalo);
            String cavalo = null;
            if (listaOrdenada != null && !listaOrdenada.isEmpty()) {
                CompetidorDTO dto = listaOrdenada.get(0);
                cavalo = dto.getCavalo();
                dados[i][0] = "Cavalo:";
                dados[i][1] = cavalo;
                i++;
                for (CompetidorDTO c : listaOrdenada) {
                    dados[i][0] = c.getColocacao();
                    dados[i][1] = c.getRaia();
                    dados[i][2] = c.getProva();
                    dados[i][3] = c.getCronometro();
                    dados[i][4] = c.getRateio();
                    dados[i][5] = c.getJoquei();
                    dados[i][6] = c.getTreinador();
                    dados[i][7] = c.getCorpoChegada();
                    dados[i][8] = c.getEntradaReta();
                    dados[i][9] = c.getTempo();
                    i++;
                }
                for (CompetidorDTO d : listaZero) {
                    dados[i][0] = d.getColocacao();
                    dados[i][1] = d.getRaia();
                    dados[i][2] = d.getProva();
                    dados[i][3] = d.getCronometro();
                    dados[i][4] = d.getRateio();
                    dados[i][5] = d.getJoquei();
                    dados[i][6] = d.getTreinador();
                    dados[i][7] = d.getCorpoChegada();
                    dados[i][8] = d.getEntradaReta();
                    dados[i][9] = d.getTempo();
                    i++;
                }
            }
        }
        return dados;
    }

    private int calculaLinhas(Map<Integer, List<CompetidorDTO>> mapa) {
        return mapa.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    public String[] getTitulos() {
        return titulos;
    }
}
