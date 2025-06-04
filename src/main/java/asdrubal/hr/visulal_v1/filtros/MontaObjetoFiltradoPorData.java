package asdrubal.hr.visulal_v1.filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MontaObjetoFiltradoPorData {
    private static String regex = "\\d{2}-\\d{2}-\\d{2}$";
    private static Pattern pattern = Pattern.compile(regex);
    private static Set<Integer> negrito;

    public static Object[][] filtra(Object[][] dados, int anoPesquisa, String objUso) {
        switch (objUso) {
            case "Mk3" -> {
//                showDados(dados);
                return objetoTipoMk3(dados, anoPesquisa);
            }
            case "Mk2" -> {
//                showDados(dados);
                return objetoTipoMk2(dados, anoPesquisa);
            }
        }


        return null;
    }

    private static void showDados(Object[][] dados) {
        for (int i = 0; i < dados.length; i++) {
            System.out.print("Linha " + i + ": [");
            if (dados[i] != null) {
                for (int j = 0; j < dados[i].length; j++) {
                    System.out.print(dados[i][j]);
                    if (j < dados[i].length - 1) {
                        System.out.print(", ");
                    }
                }
            } else {
                System.out.print("null");
            }
            System.out.println("]");
        }
    }

    private static Object[][] objetoTipoMk2(Object[][] dados, int anoPesquisa) {
        List<Object[]> linhas = new ArrayList<>();
        negrito = new TreeSet<>();
        int novoIndiceNaTabela = 0;

        if (dados == null || dados.length == 0) {
            return new Object[0][0];
        }

        for (int i = 0; i < dados.length; i++) { //
//            if (dados[i] == null || dados[i].length == 0 || dados[i][0] == null) {
//                linhas.add(dados[i]);
//                negrito.add(novoIndiceNaTabela);
//                novoIndiceNaTabela++;
//                continue;
//            }

            String dt = dados[i][0].toString();

            if (vrfSeData(dt)) {
                if (passouNoFiltro(anoPesquisa, dt)) {
                    linhas.add(dados[i]);
                    novoIndiceNaTabela++;
                }
            } else {
                linhas.add(dados[i]);
                negrito.add(novoIndiceNaTabela);
                novoIndiceNaTabela++;
            }
        }

        int nrCol = dados[0].length;
        int nrLin = linhas.size();
        Object[][] dadosFiltrados = new Object[nrLin][nrCol];

        for (int i = 0; i < linhas.size(); i++) {
            System.arraycopy(linhas.get(i), 0, dadosFiltrados[i], 0, nrCol);
        }

        return dadosFiltrados;
    }


    public static Set<Integer> getNegrito() {
        return negrito;
    }

    private static boolean passouNoFiltro(int anoPesquisa, String dt) {
        System.out.println("------------>" + dt + "\tAno:" + anoPesquisa);
        String[] d = dt.split("-");
        String ano = d[2];
        int year = Integer.parseInt(ano);
        return year >= anoPesquisa;
    }

    private static Object[][] objetoTipoMk3(Object[][] dados, int anoPesquisa) {
        List<Object[]> linhas = new ArrayList<>();
        negrito = new TreeSet<>();
        int novoIndiceNaTabela = 0;
        if (dados == null || dados.length == 0) {
            return new Object[0][0];
        }
        for (int i = 0; i < dados.length; i++) { //
            if (dados[i][3] == null) {
                linhas.add(dados[i]);
                negrito.add(novoIndiceNaTabela);
                novoIndiceNaTabela++;
            } else {
                String dt = dados[i][3].toString();
                if (vrfSeData(dt)) {
                    if (passouNoFiltro(anoPesquisa, dt)) {
                        linhas.add(dados[i]);
                        novoIndiceNaTabela++;
                    }
                }
            }
        }
        int nrCol = dados[0].length;
        int nrLin = linhas.size();
        Object[][] dadosFiltrados = new Object[nrLin][nrCol];
        for (int i = 0; i < linhas.size(); i++) {
            System.arraycopy(linhas.get(i), 0, dadosFiltrados[i], 0, nrCol);
        }
        return dadosFiltrados;
    }

    private static boolean vrfSeData(String dt) {
        Matcher matcher = pattern.matcher(dt);
        return matcher.find();
    }

}
