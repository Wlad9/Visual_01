package asdrubal.hr.visulal_v1.show;

import java.util.Arrays;

public class ShowObjetoUniDim {
    public static void show(Object[] dados, String titulo) {
        System.out.println("\n"+titulo);
        System.out.println("Conteúdo do array: " + Arrays.toString(dados));
    }
}
