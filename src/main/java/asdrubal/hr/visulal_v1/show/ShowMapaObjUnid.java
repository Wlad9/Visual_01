package asdrubal.hr.visulal_v1.show;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ShowMapaObjUnid {
    public static void show(Map<Integer, List<Object[]>> map, String titulo) {
        int entryIndex = 1; // Contador para a ordem das entradas no mapa (para visualização)

        // Itera sobre cada entrada (par chave-valor) do mapa.
        // A chave é um Integer, e o valor é uma List<Object[]>.
        for (
                Map.Entry<Integer, List<Object[]>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Object[]> listOfArrays = entry.getValue();

            System.out.println("\nEntrada #" + entryIndex + ": Chave (ID) = " + key);

            // Verifica se a lista associada à chave é nula ou vazia.
            if (listOfArrays == null || listOfArrays.isEmpty()) {
                System.out.println("  Esta chave não possui arrays associados ou a lista é nula/vazia.");
            } else {
                int arrayIndex = 0; // Contador para os arrays dentro da lista
                // Itera sobre cada Object[] dentro da List<Object[]>.
                for (Object[] objArray : listOfArrays) {
                    System.out.print("  Array " + arrayIndex + ": ");
                    // Usa Arrays.toString() para imprimir o conteúdo do Object[] de forma legível.
                    if (objArray == null) {
                        System.out.println("null (o array é nulo)");
                    } else {
                        System.out.println(Arrays.toString(objArray));
                    }
                    arrayIndex++;
                }
            }
            entryIndex++;
        }
        System.out.println("\n--- Fim da Listagem do Mapa ---");
    }
}
