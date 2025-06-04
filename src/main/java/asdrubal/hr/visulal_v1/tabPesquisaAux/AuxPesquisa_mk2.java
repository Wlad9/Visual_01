package asdrubal.hr.visulal_v1.tabPesquisaAux;

import asdrubal.hr.visulal_v1.classes_auxiliares.ContadorDeColocacao;
import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.classes_auxiliares.MontaLinhaInicial;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.services.CavaloService;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AuxPesquisa_mk2 {
    private final Map<Integer, List<CompetidorDTO>> mapa;
    private final Object[][] dadosDosCavalos;
    private String[] titulos;
    private Set<Integer> negrito = new HashSet<>();
    private final CavaloService cavaloService;

    public AuxPesquisa_mk2(Map<Integer, List<CompetidorDTO>> mapa6, Object[][] dadosDosCavalo, CavaloService cavaloService) {
        mapa = mapa6;
        this.cavaloService = cavaloService;
        dadosDosCavalos = dadosDosCavalo;
        titulos = new String[]{" ", "Pos", "Raia", "Prova", "Crono", "Rateio", "Jóquei", "Treinador", "CorpCheg", "ER", "Tempo"};
//        listarDados(dadosDosCavalo);
    }

    public Object[][] montaDadosDaTabela() {
        int nrCavalos = mapa.size();
        int nrLinhas = calculaLinhas(mapa) + nrCavalos;
        int nrColunas = titulos.length;
        Object[][] dados = new Object[nrLinhas][nrColunas];
        int i = 0;
        for (Integer idCavalo : mapa.keySet()) {
            List<CompetidorDTO> listaDTOs = mapa.get(idCavalo);
            if (listaDTOs.size() == 0) {
                String cavaloNome = cavaloService.findById(idCavalo);
                if (cavaloNome != null) {
                    dados[i][0] = cavaloNome;
                    dados[i][2] = "NoInfo";
                    negrito.add(i);
                    i++;
                } else {
                    System.out.println("ERRO! Cavalo não identificado:" + idCavalo);
                    System.exit(0);///////////////////////////////////////////////
                }
            } else {
                int soma1, soma2, soma3 = 0;
                soma1 = ContadorDeColocacao.calcula(listaDTOs);
                soma2 = ContadorDeColocacao.getCont2();
                soma3 = ContadorDeColocacao.getCont3();

                CompetidorDTO cDTO = listaDTOs.getFirst();
//                System.out.println("\n\nCavalos do Páreo------------\n"+cDTO);
                String cavalo = cDTO.getCavalo();
                String nrCavalo = identifaNrDoCavalo(cavalo, dadosDosCavalos);
                if (nrCavalo != null) {
                    cavalo = nrCavalo.concat("- ").concat(cavalo);
                }
                String str = MontaLinhaInicial.monta(soma1, soma2, soma3);//*********
//            dados[i][0] = "Cavalo:";
                dados[i][0] = cavalo;
                dados[i][2] = str;
                negrito.add(i);
                i++;
                for (CompetidorDTO c : listaDTOs) {
                    String dtHip = montaDataHipo(c.getData(), c.getHipoCod());
                    String pos = String.valueOf(c.getColocacao()).concat("°");
                    if (c.getCronometro() == null) {
                        dados[i][4] = "";
                    } else if (c.getCronometro().equalsIgnoreCase("noInfo")) {
                        dados[i][4] = "      --";
                    } else {
                        String cronometro = c.getCronometro();
                        cronometro = cronometro.toLowerCase();
                        dados[i][4] = cronometro;
                    }
                    dados[i][0] = dtHip;
                    dados[i][1] = pos;
                    dados[i][2] = c.getRaia();
                    dados[i][3] = c.getProva();
//                    dados[i][4] = c.getCronometro();
                    dados[i][5] = c.getRateio();
                    dados[i][6] = c.getJoquei();
                    dados[i][7] = c.getTreinador();
                    dados[i][8] = c.getCorpoChegada();
                    dados[i][9] = c.getEntradaReta();
                    dados[i][10] = c.getTempo();
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

    private String montaDataHipo(Date data, String hipoCod) {
        if (hipoCod != null) {
            String dt = new ConverteDateToString().converteMK1(data);
            return hipoCod.concat(" ").concat(dt);
        }
        return null;
    }

    public String[] getTitulos() {
        return titulos;
    }

    private String identifaNrDoCavalo(String cavalo, Object[][] dados) {
        String nrCavalo = null;
        cavalo = cavalo.trim();
        for (int i = 0; i < dados.length; i++) {
            Object object = dados[i][1];
            String nomeCavalo = (String) object;
            if (nomeCavalo != null) {
                nomeCavalo = nomeCavalo.trim();
                if (nomeCavalo.equalsIgnoreCase(cavalo)) {
                    return (String) dados[i][0];
                }
            }
        }
        return null;
    }

    public Set<Integer> getNegrito() {
        return negrito;
    }

    public void listarDados(Object[][] dados) {
        if (dados != null) {
            for (int i = 0; i < dados.length; i++) { // Loop pelas linhas
                if (dados[i] != null) {
                    for (int j = 0; j < dados[i].length; j++) { // Loop pelas colunas da linha atual
                        Object valor = dados[i][j];
                        System.out.print("[" + i + "][" + j + "]: " + valor + "\t"); // Imprime o índice e o valor
                    }
                    System.out.println(); // Nova linha após cada linha do array
                } else {
                    System.out.println("Linha [" + i + "] é nula.");
                }
            }
        } else {
            System.out.println("O array de dados é nulo.");
        }
    }
}
