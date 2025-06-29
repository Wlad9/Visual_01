package asdrubal.hr.visulal_v1.show;

import java.util.List;

public class ListaObjUniD {
    public static void show(List<Object[]> objetos, String objtos) {
        for (Object[] objArray : objetos) {
            System.out.print("["); // Início da representação do array
            for (int i = 0; i < objArray.length; i++) {
                System.out.print(objArray[i]); // Imprime o elemento
                if (i < objArray.length - 1) {
                    System.out.print(", "); // Adiciona vírgula e espaço entre elementos
                }
            }
            System.out.println("]");
        }
    }
}
