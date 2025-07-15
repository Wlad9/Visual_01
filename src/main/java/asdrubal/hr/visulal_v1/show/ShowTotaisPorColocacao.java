package asdrubal.hr.visulal_v1.show;

public class ShowTotaisPorColocacao {
    public static void mostraTotaisPorColocacao(Object[] obj, String titulo) {
        String[] posicoes = {"1º", "2º", "3º", "4º", "5º ou +"};
        String[] labels = {
                "Grama (Total)", "Grama Seca", "Grama Molhada", "GL", "GM", "GP", "GE",
                "Areia (Total)", "Areia Seca", "Areia Molhada", "AL", "AM", "AP", "AE",
                "ALV", "AMV", "APV", "AEV", "AU"
        };

        System.out.println("\n======= " + titulo + " =======");

        for (int i = 1; i < obj.length; i++) { // Começa em 1 porque obj[0] está reservado
            int[] valores = (int[]) obj[i];
            System.out.printf("\n%-20s: ", labels[i - 1]);
            for (int j = 0; j < valores.length; j++) {
                System.out.printf("%s = %d\t", posicoes[j], valores[j]);
            }
        }

        System.out.println("\n===============================");
    }
}

