package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.filtros_tela_analise2.FiltroRaia;
import asdrubal.hr.visulal_v1.filtros_tela_analise2.FiltroYear;
import asdrubal.hr.visulal_v1.montadores.MapaX1_Montador;
import asdrubal.hr.visulal_v1.show.ShowDadosTipo_2;
import asdrubal.hr.visulal_v1.show.ShowMapaRaiaCompetidores;

import java.util.List;
import java.util.Map;

public class ObjetoAlfa {
    public Object[][] montaObjeto(List<Object[]> dadosX1, List<String> pistasLista
            , List<String> distanciasLista, List<String> yearsLista, Map<Integer, List<CompetidorDTO>> mapa) {
        Map<String, List<CompetidorDTO>> mapaRaiaCompetidores;
        Map<String, List<CompetidorDTO>> mapaCompetidoresPorRaia;
        Map<String, List<CompetidorDTO>> mapaX1 = MapaX1_Montador.montaMapaX1(dadosX1, mapa);

        Map<String, List<CompetidorDTO>> mapaX2 = FiltroYear.iniciaFiltro(yearsLista, mapaX1);
        if (mapaX2 == null || mapaX2.isEmpty()) {
            mapaRaiaCompetidores = FiltroRaia.iniciaFiltro(mapaX1, pistasLista, distanciasLista);
        }else{
            mapaRaiaCompetidores = FiltroRaia.iniciaFiltro(mapaX2, pistasLista, distanciasLista);
        }
        Object[][] dadosA = ObjetoAlfa_Montador.monta_A(mapaRaiaCompetidores);
//        ShowDadosTipo_2.showDadosTipo2(dadosA,"->dadosA - Raia => Competidores");
//     TODO  completar depois Montando os dados com base no competidor

//        Map<Integer, List<CompetidorDTO>> mapaX11 = MapaX1_Montador.montaMapaX1_1(dadosX1, mapa);
//        mapaCompetidoresPorRaia = FiltroRaia.filtro2(mapaX11,pistasLista, distanciasLista, yearsLista);
//        Map<String, List<CompetidorDTO>> mapaCompetidorPorRaia = FiltroRaia_Filtro.getMapaCompetidorPorRaia();


//        ShowMapaRaiaCompetidores.showMapa(mapaRaiaCompetidores);
        return dadosA;
    }
}
