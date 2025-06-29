package asdrubal.hr.visulal_v1.show;

public class ShowDadosNaTela {
    public static void show(Object[][] dados, String analiseDe) {
        if (dados != null) {
            if (!analiseDe.equalsIgnoreCase("CorridasComuns")) {
                for (int i = 0; i < dados.length; i++) { // Loop pelas linhas
                    if (dados[i] != null) {
                        StringBuilder linha = new StringBuilder();
                        for (int j = 0; j < dados[i].length; j++) { // Loop pelas colunas da linha atual
                            Object valor = dados[i][j];
                            linha.append(valor == null ? "" : valor.toString());
                            if (j < dados[i].length - 1) {
                                linha.append(" - ");
                            }
                        }
//                    System.out.println("Linha " + i + ": " + linha.toString());
                        System.out.println(linha.toString());
                    } else {
                        System.out.println("Linha " + i + ": (nula)");
                    }
                }
            } else {
                System.out.println("O array de dados é nulo.");
            }
        }
    }
}
