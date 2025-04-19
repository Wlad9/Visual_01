package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto.PareoDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.PareoService;

import java.util.*;

public class CompetidoresDoPareo {
    public Map<String, DTO_TabelaCompetidores> identificaCompetidores(Integer idPareo, PareoService pareoService, CompetidorService competidorService) {
        Map<String, DTO_TabelaCompetidores> mapa;
        PareoDTO pareoDTO = pareoService.findById(idPareo);
        if (pareoDTO == null) {
            System.out.println("ERRO. Páreo não foi localizado. IdPareo=" + idPareo);
            System.exit(0);///////////////////////////////////*********************///////////////////
        }
        String listaIdsCompetidores = pareoDTO.getListaIdsCompetidores();
        List<CompetidorDTO> compDTOs = montaLista(competidorService, listaIdsCompetidores);

        mapa = separaDados(compDTOs);
        return mapa;
    }

    private Map<String, DTO_TabelaCompetidores> separaDados(List<CompetidorDTO> compDTOs) {
        if (compDTOs.isEmpty()) {
            System.out.println("ERRO. Lista de competidoresDTO está vazia>");
            System.exit(0);//////////////////////***************/////////////
        }
        Map<String, DTO_TabelaCompetidores> mapa = new TreeMap<>();
        for (CompetidorDTO dto : compDTOs) {
            DTO_TabelaCompetidores dtoTabela = new DTO_TabelaCompetidores();
            String nr = dto.getNr();
            Integer idCompetidor = dto.getIdCompetidor();
            dtoTabela.setNr(dto.getNr());
            dtoTabela.setCavalo(dto.getCavalo());
            dtoTabela.setJoquei(dto.getJoquei());
            dtoTabela.setTreinador(dto.getTreinador());
            dtoTabela.setIdade(dto.getIdade());
            dtoTabela.setSexo(dto.getSexo());
            dtoTabela.setIdCompetidor(idCompetidor);
            dtoTabela.setIdCavalo(dto.getIdCavalo());
            dtoTabela.setIdJoquei(dto.getIdJoquei());
            dtoTabela.setIdTreinador(dto.getIdTreinador());
            mapa.put(nr, dtoTabela);
        }
        return mapa;
    }

    private List<CompetidorDTO> montaLista(CompetidorService competidorService, String listaIdsCompetidores) {
        List<Integer> listaIds = new ArrayList<>();
        String[] ids = listaIdsCompetidores.split("#");
        for (int i = 0; i < ids.length; i++) {
            Integer idCompetidor = Integer.parseInt(ids[i]);
            listaIds.add(idCompetidor);
        }
        if (listaIds.isEmpty()) {
            return null;
        }
        return competidorService.buscaListaDeCompetidores(listaIds);
    }
}
