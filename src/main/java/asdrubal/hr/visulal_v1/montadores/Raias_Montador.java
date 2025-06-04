package asdrubal.hr.visulal_v1.montadores;

import java.util.ArrayList;
import java.util.List;

public class Raias_Montador {
    public static List<String> raiasMk1(List<String> pistasLista, List<String> distanciasLista) {
        if (pistasLista.size() == 0) {
            //TODO AVISO DE FALTA DE MARCAR PISTA
        }
        if (distanciasLista.size() == 0) {
            // TODO AVISO FALTA MARCAR DISTANCIA
        }
        List<String> raias = new ArrayList<>();
        for (String pista : pistasLista) {
            for (String distancia : distanciasLista) {
                String raia = montaRaia(pista, distancia);
                raias.add(raia);
            }
        }
        return raias;
    }

    private static String montaRaia(String pista, String distancia) {
        pista = pista.trim();
        distancia = distancia.trim();
        return pista.concat(distancia);
    }
}
