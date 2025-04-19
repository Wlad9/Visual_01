package asdrubal.hr.visulal_v1.painel_pareos;

import asdrubal.hr.visulal_v1.dto.PareoDTO;
import asdrubal.hr.visulal_v1.services.PareoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IdentificaCamposDaTabela {
    private PareoService pareoService;

    public IdentificaCamposDaTabela(PareoService pareoService) {
        this.pareoService = pareoService;
    }

//    public Map<PareoDTO, List<String>> inicia(String listaIds) {
//        Map<PareoDTO, List<String>> mapa = new HashMap<>();
//        String[] ids = listaIds.split("#");
//        for (int i = 0; i < ids.length; i++) {
//            Integer idPareo = Integer.parseInt(ids[i]);
//            PareoDTO pareoDTO = pareoService.findById(idPareo);
//            if (pareoDTO == null) {
//                System.out.println("ERRO. Id do páreo não localizado.");
//                System.exit(0);////////////////////////////////////////////////
//            }
//            List<String> campos = new ArrayList<>();
//            campos.add(String.valueOf(pareoDTO.getOrdem()));// ordem
//            campos.add(pareoDTO.getProva());// prova
//            campos.add(String.valueOf(pareoDTO.getBolsa())); // bolsa
//            campos.add(montaRaia(pareoDTO.getDistancia(), pareoDTO.getPista()));// raia
//            mapa.put(pareoDTO, campos);
//        }
//        return mapa;
//    }

    private String montaRaia(int distancia, String pista) {
        return pista.concat(String.valueOf(distancia)).toUpperCase().trim();
    }

    public Map<Integer, List<String>> inicia1(String listaIds) {
        Map<Integer, List<String>> mapa = new HashMap<>();
        String[] ids = listaIds.split("#");
        for (int i = 0; i < ids.length; i++) {
            Integer idPareo = Integer.parseInt(ids[i]);
            PareoDTO pareoDTO = pareoService.findById(idPareo);
            if (pareoDTO == null) {
                System.out.println("ERRO. Id do páreo não localizado.");
                System.exit(0);////////////////////////////////////////////////
            }
            List<String> campos = new ArrayList<>();
            Integer ordem = pareoDTO.getOrdem();
            String strIdPareo = String.valueOf(pareoDTO.getIdPareo());
            campos.add(pareoDTO.getProva());// prova
            campos.add(String.valueOf(pareoDTO.getBolsa())); // bolsa
            campos.add(montaRaia(pareoDTO.getDistancia(), pareoDTO.getPista()));// raia
            campos.add(strIdPareo);// identifica o páreo que foi selecionado na tabela
//            String raia = montaRaia(pareoDTO.getDistancia(), pareoDTO.getPista());// raia

//            System.out.println("Ordem:"+ ordem);
//            System.out.println("Prova:"+pareoDTO.getProva());
//            System.out.println("Bolsa:"+pareoDTO.getBolsa());
//            System.out.println("Raia:"+raia);
            mapa.put(ordem, campos);
        }
        return mapa;
    }
}
