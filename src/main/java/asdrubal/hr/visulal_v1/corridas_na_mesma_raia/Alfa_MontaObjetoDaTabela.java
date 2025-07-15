package asdrubal.hr.visulal_v1.corridas_na_mesma_raia;

import asdrubal.hr.visulal_v1.TitulosDasColunas.TitulosDados1;
import asdrubal.hr.visulal_v1.analise2_objeto_montador.Finaliza_FinalmenteKRaLHO;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.montadores.Raias_Montador;
import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;

import java.util.List;
import java.util.Map;

public class Alfa_MontaObjetoDaTabela {
    private final Map<Integer, List<CompetidorDTO>> mapa3;
    private final List<Object[]> dadosLS;
    private final int nrCol = 11;

    public Alfa_MontaObjetoDaTabela(Map<Integer, List<CompetidorDTO>> mapa3, List<Object[]> dadosLS) {
        this.mapa3 = mapa3;
        this.dadosLS = dadosLS;
    }

    public Object[][] inicia(List<String> pistasLista, List<String> distanciasLista) {
        List<String> raiasFiltro = Raias_Montador.raiasMk1(pistasLista, distanciasLista);
        SeparaCompetidorPorRaia scr = new SeparaCompetidorPorRaia();
        SeparaCompetidorPorRaia spc = new SeparaCompetidorPorRaia();
        Map<String, List<CompetidorDTO>> mapaA = spc.inicia(mapa3, dadosLS, raiasFiltro);

        MontaListObjcUnidimencional uniDi = new MontaListObjcUnidimencional();
        List<Object[]> objetos = uniDi.inicia(mapaA, nrCol, dadosLS);


//        MontaObjetoDadosFinal modf = new MontaObjetoDadosFinal();
//        Object[][] dadosFinal = modf.inicia(objetos, nrCol);
        Finaliza_FinalmenteKRaLHO ffkr = new Finaliza_FinalmenteKRaLHO();
        Object[][] dadosFinal = ffkr.finaliza(objetos, nrCol);
        ShowObjectBiDim.show(dadosFinal,"fiana++++++++++++++++++++++++++++");
        return dadosFinal;
    }
}
