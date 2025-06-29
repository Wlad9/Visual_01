package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.analise2_objeto_montador.MontaTitulosDaTabela;
import asdrubal.hr.visulal_v1.analise2_objeto_montador.ObjetoFiltroAnalise2;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.filtro_raia.FiltrarMapaPorRais;
import asdrubal.hr.visulal_v1.montadores.Raias_Montador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ObjetoFiltrado {
    private final Map<Integer, List<CompetidorDTO>> mapa3;
    private final Object[][] dadosCavalosDoPareo;
    private Object[] titulosDaTabela;

    public ObjetoFiltrado(Map<Integer, List<CompetidorDTO>> mapa3, Object[][] dadosCavalosDoPareo) {
        this.mapa3 = mapa3;
        this.dadosCavalosDoPareo = dadosCavalosDoPareo;
    }

    public Object[][] inicia(List<Object[]> dadosLS, List<String> pistasLista, List<String> distanciasLista, List<String> yearsLista, int nrColFiltro) {
        List<String> raiasFiltro = Raias_Montador.raiasMk1(pistasLista, distanciasLista);
        List<Integer> idsSelec = separaCavalos(dadosLS);
        FiltrarMapaPorRais fmr = new FiltrarMapaPorRais();
        Map<String, List<CompetidorDTO>> mapaA = fmr.inicia(raiasFiltro, mapa3, idsSelec);
        Object[][] dadosF = ObjetoFiltroAnalise2.montaObj(mapaA, dadosLS, nrColFiltro);
        return dadosF;
    }

    private List<Integer> separaCavalos(List<Object[]> dadosLS) {
        List<Integer> lista = new ArrayList<>();
        for (Object[] obj : dadosLS) {
            lista.add(Integer.parseInt(obj[2].toString()));
        }
        return lista;
    }

    private boolean mesmoCavalo(String nome, String cavalo) {
        nome = nome.trim();
        cavalo = cavalo.trim();
        return nome.equalsIgnoreCase(cavalo);
    }
}
