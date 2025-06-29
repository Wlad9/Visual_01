package asdrubal.hr.visulal_v1.analise2_objeto_montador;

import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import java.util.List;

public class Finaliza_FinalmenteKRaLHO {
    public Object[][] finaliza(List<Object[]> listObj) {
        for(Object[] obj: listObj){
            ShowObjetoUniDim.show(obj,"FINALMENTE----------------------------");
        }
        return null;
    }
}
