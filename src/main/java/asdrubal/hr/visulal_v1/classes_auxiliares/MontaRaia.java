package asdrubal.hr.visulal_v1.classes_auxiliares;

public class MontaRaia {

    public String monta(String pista, String dist) {
        pista = pista.trim();
        dist = dist.trim();
        return pista.concat(dist);
    }
}
