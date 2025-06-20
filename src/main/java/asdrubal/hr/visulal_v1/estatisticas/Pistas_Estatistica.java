package asdrubal.hr.visulal_v1.estatisticas;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.estatisticas.totalizadores.Colocacao_Totalizador;
import asdrubal.hr.visulal_v1.estatisticas.totalizadores.Raias_Totalizador;
import asdrubal.hr.visulal_v1.estatisticas.totalizadores.Tempos_Totalizador;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.RaiaService;
import asdrubal.hr.visulal_v1.show.ShowMapaObjUnid;
import asdrubal.hr.visulal_v1.show.ShowMapaObjetoComInteiro;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pistas_Estatistica {
    private final CompetidorService competidorService;
    private final RaiaService raiaService;
    private final Map<Integer, List<CompetidorDTO>> mapa;
    private final int index1 = 20;
    private final int index2 = 20;
    private final int index3 = 20;

    public Pistas_Estatistica(CompetidorService competidorService, RaiaService raiaService, Map<Integer, List<CompetidorDTO>> mapa) {
        this.competidorService = competidorService;
        this.raiaService = raiaService;
        this.mapa = mapa;
    }

    public Map<Integer, List<Object[]>> inicia(Object[][] dados) {
        Map<Integer, List<Object[]>> mapaObjetos = new HashMap<>();
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa.entrySet()) {
            List<Object[]> listaDeObjetos = new ArrayList<>();
//  Objeto dados corridas por RAIA
            Raias_Totalizador rt = new Raias_Totalizador();
            Object[] totaisRaias = rt.totalizaPorRaia(entry.getValue(), index1);
            totaisRaias[0] = entry.getKey();
            listaDeObjetos.add(totaisRaias);
//            ShowObjetoUniDim.show(totaisRaias, "Totalizador de corridas por Raia.");

//  Objeto total tempo por RAIA
            Tempos_Totalizador tt = new Tempos_Totalizador();
            Object[] totaisTemposPorRaia = tt.calculaTemposPorRaia(entry.getValue(), index2);
            totaisTemposPorRaia[0] = entry.getKey();
            listaDeObjetos.add(totaisTemposPorRaia);
//            ShowObjetoUniDim.show(totaisTemposPorRaia,"Total de tempos por raia.");

//  Objeto total por colocação na chegada
            Colocacao_Totalizador ct = new Colocacao_Totalizador();
            Object[] totaisColocacao = ct.calcula(entry.getValue(), index3);
            totaisColocacao[0]=entry.getKey();
            listaDeObjetos.add(totaisColocacao);
            mapaObjetos.put(entry.getKey(), listaDeObjetos);
        }
        ShowMapaObjetoComInteiro.show(mapaObjetos);
        return mapaObjetos;
    }
}
