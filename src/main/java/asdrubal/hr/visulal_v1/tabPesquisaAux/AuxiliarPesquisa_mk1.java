package asdrubal.hr.visulal_v1.tabPesquisaAux;

import asdrubal.hr.visulal_v1.classes_auxiliares.ContadorDeColocacao;
import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.classes_auxiliares.MontaLinhaInicial;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class AuxiliarPesquisa_mk1 {
    private final Map<Integer, List<CompetidorDTO>> mapa4;
    private final Map<Integer, List<CompetidorDTO>> mapa5;
    private final Map<Integer, List<CompetidorDTO>> mapa6;
    private String[] titulos;

    public AuxiliarPesquisa_mk1(Map<Integer, List<CompetidorDTO>> mapa4, Map<Integer, List<CompetidorDTO>> mapa5, Map<Integer, List<CompetidorDTO>> mapa6) {
        this.mapa4 = mapa4;
        this.mapa5 = mapa5;
        this.mapa6 = mapa6;
        titulos = new String[]{" ", "Pos", "Raia", "Prova", "Crono", "Rateio", "Jóquei", "Treinador", "CorpCheg", "EntraReta", "Tempo"};
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
            int soma1, soma2, soma3 = 0;
            soma1 = ContadorDeColocacao.calcula(listaOrdenada, listaZero);
            soma2 = ContadorDeColocacao.getCont2();
            soma3 = ContadorDeColocacao.getCont3();
            String cavalo = null;
            if (listaOrdenada != null && !listaOrdenada.isEmpty()) {
                CompetidorDTO dto = listaOrdenada.getFirst();
                cavalo = dto.getCavalo();
                String str = MontaLinhaInicial.monta(soma1, soma2, soma3);
                dados[i][0] = "Cavalo:";
                dados[i][1] = cavalo;
                dados[i][2] = str;
                i++;
                for (CompetidorDTO c : listaOrdenada) {
                    String dtHip = montaDataHipo(c.getData(), c.getHipoCod());

                    String pos = String.valueOf(c.getColocacao()).concat("°");
                    dados[i][0] = dtHip;
                    dados[i][1] = pos;
                    dados[i][2] = c.getRaia();
                    dados[i][3] = c.getProva();
                    dados[i][4] = c.getCronometro();
                    dados[i][5] = c.getRateio();
                    dados[i][6] = c.getJoquei();
                    dados[i][7] = c.getTreinador();
                    dados[i][8] = c.getCorpoChegada();
                    dados[i][9] = c.getEntradaReta();
                    dados[i][10] = c.getTempo();
                    i++;
                }
                for (CompetidorDTO d : listaZero) {
                    String dtHip = montaDataHipo(d.getData(), d.getHipoCod());
                    String pos = String.valueOf(d.getColocacao()).concat("°");
                    dados[i][0] = dtHip;
                    dados[i][1] = pos;
                    dados[i][2] = d.getRaia();
                    dados[i][3] = d.getProva();
                    dados[i][4] = d.getCronometro();
                    dados[i][5] = d.getRateio();
                    dados[i][6] = d.getJoquei();
                    dados[i][7] = d.getTreinador();
                    dados[i][8] = d.getCorpoChegada();
                    dados[i][9] = d.getEntradaReta();
                    dados[i][10] = d.getTempo();
                    i++;
                }
            }
        }
        return dados;
    }

    private String montaDataHipo(Date data, String hipoCod) {
        if (hipoCod != null) {
            String dt = new ConverteDateToString().converteMK1(data);
            return hipoCod.concat(" ").concat(dt);
        }
        return null;
    }

    private int calculaLinhas(Map<Integer, List<CompetidorDTO>> mapa) {
        return mapa.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    public String[] getTitulos() {
        return titulos;
    }

    public Object[][] montaDadosMk2() {
        int nrLinhas = calculaLinhas(mapa4);
        nrLinhas += calculaLinhas(mapa5) + mapa4.size();
        int nrColunas = titulos.length;
        Object[][] dados = new Object[nrLinhas][nrColunas];
        int i = 0;
        for (Integer idCavalo : mapa6.keySet()) {
            List<CompetidorDTO> lista = mapa6.get(idCavalo);
            int soma1, soma2, soma3 = 0;
            soma1 = ContadorDeColocacao.calcula(lista);
            soma2 = ContadorDeColocacao.getCont2();
            soma3 = ContadorDeColocacao.getCont3();
            CompetidorDTO dto = lista.get(idCavalo);
            String cavalo = dto.getCavalo();
            String str = MontaLinhaInicial.monta(soma1, soma2, soma3);
            dados[i][0] = "Cavalo:";
            dados[i][1] = cavalo;
            dados[i][2] = str;
            i++;
            for (CompetidorDTO c : lista) {
                String dtHip = montaDataHipo(c.getData(), c.getHipoCod());
                String pos = String.valueOf(c.getColocacao()).concat("°");
                dados[i][0] = dtHip;
                dados[i][1] = pos;
                dados[i][2] = c.getRaia();
                dados[i][3] = c.getProva();
                dados[i][4] = c.getCronometro();
                dados[i][5] = c.getRateio();
                dados[i][6] = c.getJoquei();
                dados[i][7] = c.getTreinador();
                dados[i][8] = c.getCorpoChegada();
                dados[i][9] = c.getEntradaReta();
                dados[i][10] = c.getTempo();
                i++;
            }
        }
        return dados;
    }
}
