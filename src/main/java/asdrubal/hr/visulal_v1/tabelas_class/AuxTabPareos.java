package asdrubal.hr.visulal_v1.tabelas_class;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConvertStringIdsToListInteger;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.montadores.Mapa1Montador;
import asdrubal.hr.visulal_v1.services.PareoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuxTabPareos {
    private final PareoService pareoService;
    private Object[][] dadosTabela;
    private String[] colunas;
    private Map<Integer, DTO_JT_tabPareos> mapa1 = new HashMap<>();

    public AuxTabPareos(PareoService pareoService) {
        this.pareoService = pareoService;
        colunas = new String[]{"Ordem", "Prova", "Raia", "Bolsa"};
    }

    public void preparaDados(String listaIds, Integer idSelecionado) {
        List<Integer> idsLista = new ConvertStringIdsToListInteger().converte(listaIds);
        List<DTO_JT_tabPareos> listaDTO = pareoService.buscaListaDePareos(idsLista, idSelecionado);
        mapa1 = new Mapa1Montador().montaMapa1(listaDTO);//TODO alt para List<>
        int nrCol = 4;
        dadosTabela = montaDadosDaTabela(mapa1, nrCol);
    }

    private Object[][] montaDadosDaTabela(Map<Integer, DTO_JT_tabPareos> mapa1, int nrCol) {
        Object[][] dados = new Object[mapa1.size()][nrCol];
        int i = 0;
        for (DTO_JT_tabPareos dto : mapa1.values()) {
            String pista = dto.getPista();
            String distancia = String.valueOf(dto.getDistancia());
            String raia = pista.concat(distancia);
            dados[i][0] = dto.getOrdem();
            dados[i][1] = dto.getProva();
            dados[i][2] = raia;
            dados[i][3] = dto.getBolsa();
            i++;
        }
        return dados;
    }

    public Map<Integer, DTO_JT_tabPareos> getMapa1() {
        return mapa1;
    }

    public Object[][] getDadosTabela() {
        return dadosTabela;
    }

    public String[] getColunas() {
        return colunas;
    }

}
