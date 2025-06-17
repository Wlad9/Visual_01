package asdrubal.hr.visulal_v1.filtros_corrida_por_raia;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;
import asdrubal.hr.visulal_v1.montadores.DadosDoObjCorridasPorRaia_Montador;
import asdrubal.hr.visulal_v1.show.ShowCorridasMesmaRaia;

import java.util.*;

public class IdentificaCorridasPorRaia {
    public Object[][] identifica(Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO, Set<String> raias) {
        MapaDeCompDTOporRaia_Montador montMapDto = new MapaDeCompDTOporRaia_Montador();
        Map<String, List<CompetidorDTO>> mapaDeCompDTOporRaia = montMapDto.monta(mapaDeCorridasDTO, raias);

        ListaDadosDTOx_Montador montDTOx = new ListaDadosDTOx_Montador();
        Map<String, List<DTO_x>> mapaListaDTOx = montDTOx.inicia(mapaDeCompDTOporRaia);

        DadosDoObjCorridasPorRaia_Montador dobj = new DadosDoObjCorridasPorRaia_Montador();
        Map<String, List<String>> dadosDoObjCorridasPorRaia = dobj.monta(mapaListaDTOx);


        MontaObjetoFiltradoCorridasPorRaia mofmr = new MontaObjetoFiltradoCorridasPorRaia();
//        Object[][] dados = mofmr.inicia(mapaListaDTOx);
        Object[][] dados = mofmr.montaDados(dadosDoObjCorridasPorRaia);
//        ShowCorridasMesmaRaia.showCorridas(dados);

//        for(Map.Entry<String, List<Integer>> entry: mapa.entrySet()){
//            System.out.println("\nRaia:" + entry.getKey());
//            List<Integer> lista = entry.getValue();
//            int cont=0;
//            for(Integer id:lista){
//                System.out.println(id);
//                ++cont;
//            }
//            System.out.println("Total para a raia "+entry.getKey()+"\tT->"+cont);
//        }
        return dados;
    }

    private Map<String, List<Integer>> mapaDeCompetidoresPorRaia(Map<Integer, List<CompetidorDTO>> mapaDeCorridasDTO
            , Set<String> raias) {
        Map<String, List<Integer>> mapa = new HashMap<>();
        Map<String, List<CompetidorDTO>> mapa2 = new HashMap<>();
        for (String raia : raias) {
            List<Integer> lista = new ArrayList<>();
            List<CompetidorDTO> listaCompetidorDTO = new ArrayList<>();
            for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapaDeCorridasDTO.entrySet()) {
                List<CompetidorDTO> listaDTO = entry.getValue();
                for (CompetidorDTO cDTO : listaDTO) {
                    if (raia.equalsIgnoreCase(cDTO.getRaia())) {
                        lista.add(cDTO.getIdCompetidor());
                        listaCompetidorDTO.add(cDTO);
                    }
                }
            }
            if (!lista.isEmpty()) {
                mapa.put(raia, lista);
                mapa2.put(raia, listaCompetidorDTO);
            }
        }
        return mapa;
    }
}
