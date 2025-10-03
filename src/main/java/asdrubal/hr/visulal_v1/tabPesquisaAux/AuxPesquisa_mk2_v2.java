package asdrubal.hr.visulal_v1.tabPesquisaAux;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.services.CavaloService;

import java.sql.Date;
import java.util.*;

public class AuxPesquisa_mk2_v2 {
    private final Map<Integer, List<CompetidorDTO>> mapa6;
    private final Object[][] dadosCavalosDoPareo;
    private final CavaloService cavaloService;
    private String[] titulos;
    private int colIdCavalo = 6;
    private int nrColunas;
    private Set<Integer> negrito = new TreeSet<>();

    public AuxPesquisa_mk2_v2(Map<Integer, List<CompetidorDTO>> mapa6, Object[][] dadosCavalosDoPareo, CavaloService cavaloService) {
        this.mapa6 = mapa6;
        this.dadosCavalosDoPareo = dadosCavalosDoPareo;
        this.cavaloService = cavaloService;
        titulos = new String[]{" ", "Pos", "Raia", "Prova", "Crono", "Rateio", "Jóquei", "Treinador", "CorpCheg", "ER", "Tempo", "Bolsa"};
        nrColunas = titulos.length;
    }

    public Object[][] montaObjeto() {
        int nrEspace = 0;
        Object[] dados = new Object[nrColunas];
        int tamanho = dadosCavalosDoPareo.length;
        List<Object[]> objetos = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            Integer idCavalo = (int) dadosCavalosDoPareo[i][colIdCavalo];
            String nr = dadosCavalosDoPareo[i][0].toString();
            String cavalo = dadosCavalosDoPareo[i][1].toString();
            String nrCav = montaNrCavalo(nr, cavalo);
            Object[] linhaX = new Object[]{nrCav};
            objetos.add(linhaX);
            nrEspace++;
            List<CompetidorDTO> lDTO = mapa6.get(idCavalo);
            for (CompetidorDTO cDTO : lDTO) {
//                System.out.println("CDTO===>>"+cDTO);
                Object[] linhaY;
                linhaY = montaLinha(cDTO);
                objetos.add(linhaY);
            }
        }
        Object[][] dadosFinal = montx(objetos, nrEspace);
//        ListaObjUniD.show(objetos, "Objtos");
        return dadosFinal;
    }

    private Object[][] montx(List<Object[]> objetos, int nrSpace) {
        boolean inicio = true;
        int nrL = objetos.size() + nrSpace;
        Object[][] dados = new Object[nrL][nrColunas];
        int i = 0;
        for (Object[] obj : objetos) {
            if (obj.length == 1) {
                if (inicio) {
                    dados[i][0] = obj[0];
                    negrito.add(i);
                    i++;
                    inicio = false;
                } else {
                    dados[i][0] = "";
                    i++;
                    dados[i][0] = obj[0];
                    negrito.add(i);
                    i++;
                }
            } else {
                dados[i][0] = obj[0];
                dados[i][1] = obj[1];
                dados[i][2] = obj[2];
                dados[i][3] = obj[3];
                dados[i][4] = obj[4];
                dados[i][5] = obj[5];
                dados[i][6] = obj[6];
                dados[i][7] = obj[7];
                dados[i][8] = obj[8];
                dados[i][9] = obj[9];
                dados[i][10] = obj[10];
                dados[i][11] = obj[11];
                i++;
            }
        }
//        ShowObjectBiDim.show(dados, "dados zzzzzzzz");
        return dados;
    }

    private Object[] montaLinha(CompetidorDTO c) {
        Object[] dados = new Object[nrColunas];
        String dtHip = montaDataHipo(c.getData(), c.getHipoCod());
        String pos = String.valueOf(c.getColocacao()).concat("°L");
        if (c.getCronometro() == null) {
            dados[4] = "";
        } else if (c.getCronometro().equalsIgnoreCase("noInfo")) {
            dados[4] = "";
        } else {
            String cronometro = c.getCronometro();
            cronometro = cronometro.toLowerCase();
            dados[4] = cronometro;
        }
        dados[0] = dtHip;
        dados[1] = pos;
        dados[2] = c.getRaia();
        dados[3] = c.getProva();
        dados[5] = c.getRateio();
        dados[6] = c.getJoquei();
        dados[7] = c.getTreinador();
        dados[8] = c.getCorpoChegada();
        dados[9] = c.getEntradaReta();
        dados[10] = c.getTempo();
        dados[11]= c.getBolsa();
        return dados;
    }

    private String montaDataHipo(Date data, String hipoCod) {
        String dt = new ConverteDateToString().converteMK1(data);
        return hipoCod.concat(" ").concat(dt);
    }

    private String montaNrCavalo(String nr, String cavalo) {
        nr = nr.trim();
        cavalo = cavalo.trim();
        return nr.concat(" - ").concat(cavalo);
    }

    public Set<Integer> getNegrito() {
        return negrito;
    }

    public String[] getTitulos() {
        return titulos;
    }
}
