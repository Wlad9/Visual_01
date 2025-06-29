package asdrubal.hr.visulal_v1.classes_auxiliares;

public class InserirNrNomeCavalo {
    public static String inicia(String cavalo, Object[][] dadosCP) {
        int nrLinhas = dadosCP.length;
        int nrColunas = 6;
        for (int i = 0; i < nrLinhas; i++) {
            String nome = dadosCP[i][1].toString();
            if (nome.equalsIgnoreCase(cavalo)) {
                if (dadosCP[i][0] != null) {
                    String nr = dadosCP[i][0].toString();
                    return concatDados(nr, nome);
                }
            }
        }
        return cavalo;
    }

    private static String concatDados(String nr, String nome) {
        nr = nr.trim();
        nome = nome.trim();
        return nr.concat(" - ").concat(nome);
    }
}
