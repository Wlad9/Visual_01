package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.classes_auxiliares.OrdenaListaCompetidorDTO;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.util.*;

public class ObjetoBravo {
    private final Map<Integer, List<CompetidorDTO>> mapa3;
    private final Map<Integer, List<Integer>> mapaDePareosComuns;
    private final int nrColunas = 11;

    public ObjetoBravo(Map<Integer, List<CompetidorDTO>> mapa3, Map<Integer, List<Integer>> mapaDePareosComuns) {
        this.mapa3 = mapa3;
        this.mapaDePareosComuns = mapaDePareosComuns;
    }
    public Object[][] montaObj() {
        List<Object[]> listaDeObj = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : mapaDePareosComuns.entrySet()) {
            Integer idPareo = entry.getKey();
            List<Integer> lista = entry.getValue();

            // Monta título da corrida
            Integer idCavalo = lista.getFirst();
            Object[] obj = montaObjTituloDaCorrida(idCavalo, idPareo);
            listaDeObj.add(obj);

            // Junta todos os competidores deste páreo
            List<CompetidorDTO> listaCompetidoresDoPareo = new ArrayList<>();

            for (Integer idDoCavalo : lista) {
                List<CompetidorDTO> lDTO = mapa3.get(idDoCavalo);
                if (lDTO != null) {
                    for (CompetidorDTO cDTO : lDTO) {
                        if (Objects.equals(cDTO.getIdDoPareo(), idPareo)) {
                            listaCompetidoresDoPareo.add(cDTO);
                        }
                    }
                }
            }

            // Agora ordena todos os competidores deste páreo por colocação
            OrdenaListaCompetidorDTO ordenador = new OrdenaListaCompetidorDTO();
            ordenador.porColocacao(listaCompetidoresDoPareo);

            // Monta as linhas já ordenadas
            for (CompetidorDTO cDTO : listaCompetidoresDoPareo) {
                Object[] objLinha = montaLinha(cDTO);
                listaDeObj.add(objLinha);
            }

            // Linha em branco ao final de cada páreo
            Object[] linhaEmBranco = new Object[11];
            listaDeObj.add(linhaEmBranco);
        }

        Object[][] dados = listaDeObj.toArray(new Object[0][]);
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

    private Object[] montaObjTituloDaCorrida(Integer idCavalo, Integer idPareo) {
        List<CompetidorDTO> lDTO = mapa3.get(idCavalo);
        CompetidorDTO cDTO = identiricaCompetidor(idPareo, lDTO);

        String raia = cDTO.getRaia();
        String data = AuxMontaCamposDoObjeto.montaData(cDTO.getHipoCod(), cDTO.getData());
        String prova = cDTO.getProva();
        Object[] obj = new Object[11];
        obj[0] = raia;
        obj[1] = data;
//        obj[4] = prova;
        return obj;
    }

    private CompetidorDTO identiricaCompetidor(Integer idPareo, List<CompetidorDTO> lDTO) {
        for (CompetidorDTO cDTO : lDTO) {
            if(cDTO.getIdDoPareo().equals(idPareo)){
                return cDTO;
            }
        }
        System.out.println("Erro na idPareo não existe");
        System.exit(0);//////////////////////////////+++++++++++++++++++++++++++++
        return null;
    }

    private void ordenaPorColocacao(List<CompetidorDTO> lista) {
        lista.sort(Comparator.comparingInt(CompetidorDTO::getColocacao));
    }
}
