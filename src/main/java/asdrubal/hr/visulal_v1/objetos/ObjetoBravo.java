package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;

import java.util.*;

public class ObjetoBravo {
    private final Map<Integer, List<CompetidorDTO>> mapa;
    private final Map<Integer, List<Integer>> mapaDeCorridas;
    private final int nrColunas = 11;

    public ObjetoBravo(Map<Integer, List<CompetidorDTO>> mapa, Map<Integer, List<Integer>> mapaDeCorridas) {
        this.mapa = mapa;
        this.mapaDeCorridas = mapaDeCorridas;
    }

    public Object[][] montaObj() {
        List<Object[]> listaDeObj = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : mapaDeCorridas.entrySet()) {
            Integer idPareo = entry.getKey();
            List<Integer> lista = entry.getValue();
            if (lista.size() < 2) {
                continue;
            }
            Integer idCavalo = lista.getFirst();
            Object[] obj = montaObjTituloDaCorrida(idCavalo);
            listaDeObj.add(obj);
            for (Integer idDoCavalo : lista) {
                List<CompetidorDTO> lDTO = mapa.get(idDoCavalo);
                ordenaPorColocacao(lDTO);
                for (CompetidorDTO cDTO : lDTO) {
                    if (Objects.equals(cDTO.getIdDoPareo(), idPareo)) {
                        Object[] objLinha = montaLinha(cDTO);
                        listaDeObj.add(objLinha);
                    }
                }
            }
            Object[] linhaEmBranco = new Object[11];
            listaDeObj.add(linhaEmBranco);
        }
        Object[][] dados = listaDeObj.toArray(new Object[0][]);
//        ShowObjectBiDim.show(dados, "Dados de Cavalos no mesmo Páreo");
        return dados;
    }

    private Object[] montaLinha(CompetidorDTO cDTO) {
        String pos = AuxMontaCamposDoObjeto.montaColocacao(cDTO.getColocacao());
        String cavalo = cDTO.getCavalo();
        String crono = cDTO.getCronometro();
        String joquei = cDTO.getJoquei();
        String corpoChegada = cDTO.getCorpoChegada();
        float tempo = cDTO.getTempo();
        String raia = cDTO.getRaia();
        Object[] obj = new Object[11];
        obj[0] = pos;
        obj[1] = cavalo;
        obj[2] = crono;
        obj[3] = joquei;
        obj[4] = corpoChegada;
        obj[8] = tempo;
        obj[10] = raia;
        return obj;
    }

    private Object[] montaObjTituloDaCorrida(Integer idCavalo) {
        List<CompetidorDTO> lDTO = mapa.get(idCavalo);
        CompetidorDTO cDTO = lDTO.getFirst();
        String raia = cDTO.getRaia();
        String data = AuxMontaCamposDoObjeto.montaData(cDTO.getHipoCod(), cDTO.getData());
        String prova = cDTO.getProva();
        Object[] obj = new Object[11];
        obj[0] = raia;
        obj[1] = data;
//        obj[4] = prova;
        return obj;
    }
    private void ordenaPorColocacao(List<CompetidorDTO> lista) {
        lista.sort(Comparator.comparingInt(CompetidorDTO::getColocacao));
    }
}
