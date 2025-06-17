package asdrubal.hr.visulal_v1.show;

public class ShowObjectBiDim {
    public static void show(Object[][] dados, String titulo) {
        System.out.println("\n" + titulo);
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
}
