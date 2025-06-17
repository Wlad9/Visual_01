package asdrubal.hr.visulal_v1.show;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;
import org.hibernate.boot.jaxb.SourceType;

import java.util.List;
import java.util.Map;

public class MapaListaDTOx_Show {

    public static void show(Map<String, List<DTO_x>> mapaListaDTOx) {
        System.out.println("\n MapaListaDTOx===============================");
        for(Map.Entry<String, List<DTO_x>> entry: mapaListaDTOx.entrySet()){
            System.out.println("\nRaia:"+entry.getKey());
            List<DTO_x> lista = entry.getValue();
            for(DTO_x x:lista){
                System.out.println("Cavalo:"+x.getCavalo1()+" "+x.getHipoCod()+" "+x.getData());
//                System.out.println("HipoCod:"+x.getHipoCod());
//                System.out.println("Data:"+x.getData());
//                System.out.println("Pos1:"+x.getPos1());
//                System.out.println("Crono1:"+x.getCrono1());
//                System.out.println("tempo1:"+x.getTempo1());
//                System.out.println("Rateio:"+x.getRateio1());
//                System.out.println("Prova:"+x.getProva());
//                System.out.println("Corpo:"+x.getCorpo1());
//                System.out.println("Entrada:"+x.getEntra1());
//                System.out.println("Joquei:"+x.getJoquei1());
//                System.out.println("Treinador:"+x.getTreinador1());
//                System.out.println("\n");
            }
        }
    }
}
