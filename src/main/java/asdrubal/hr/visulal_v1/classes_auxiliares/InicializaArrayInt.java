package asdrubal.hr.visulal_v1.classes_auxiliares;

import java.util.List;

public class InicializaArrayInt {
    public void inicializa(List<Object[]> listaDeObjetos) {
        for (Object[] objArray : listaDeObjetos) {
            for (int i = 0; i < objArray.length; i++) {
                objArray[i] = 0;
            }
        }
    }
}
