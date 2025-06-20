package asdrubal.hr.visulal_v1.show;

import java.util.List;
import java.util.Map;

public class ShowMapaObjetoComInteiro {
    public static void show(Map<Integer, List<Object[]>> mapaObjetos) {
        for(Map.Entry<Integer,List<Object[]>> entry: mapaObjetos.entrySet()){
            System.out.println("\nIdCavalo:"+entry.getKey());
            List<Object[]>lista = entry.getValue();
            Object[] totais = lista.get(0);
            Object[] tempos = lista.get(1);
            Object[] posicoes = lista.get(2);
            int i=0;
            for(Object obj: posicoes){
                System.out.println(i+"-->"+obj.toString());
                i++;
            }
        }
    }
}
