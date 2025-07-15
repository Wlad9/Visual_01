package asdrubal.hr.visulal_v1.mesmo_pareo;

import asdrubal.hr.visulal_v1.classes_auxiliares.OrdenaListaCompetidorDTO;
import asdrubal.hr.visulal_v1.classes_auxiliares.TransformaUniDiParaBiDi;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.objetos.AuxMontaCamposDoObjeto;
import asdrubal.hr.visulal_v1.objetos.ObjetoBravo;
import asdrubal.hr.visulal_v1.show.ShowDadosTipo_1;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DadosDaTabela_Montador {
    private final Map<Integer, List<CompetidorDTO>> mapa;
    private final Object[][] dados;
    private int colIdCavalo = 6;
    private int nrColunas = 11;

    public DadosDaTabela_Montador(Map<Integer, List<CompetidorDTO>> mapa3, Object[][] dadosCavalosDoPareo) {
        mapa = mapa3;
        dados = dadosCavalosDoPareo;
    }

    public Object[][] inicia() {
        MesmoPareoEntreCavalos mpec = new MesmoPareoEntreCavalos();
        Map<Integer, List<Integer>> mapaIdsComuns = mpec.identifica(mapa);
        Object[][] dados = montaObjetoDados(mapaIdsComuns);
        return dados;
    }

    private Object[][] montaObjetoDados(Map<Integer, List<Integer>> mapaIdsComuns) {
        int nrSpace = 0;
        List<Object[]> objetos = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : mapaIdsComuns.entrySet()) {
            Integer idPareo = entry.getKey();
            List<Integer> lista = entry.getValue();
            // Monta título da corrida
            Integer idCavalo = lista.getFirst();
            Object[] tituloRaia = montaObjTituloRaia(idCavalo, idPareo);
            objetos.add(tituloRaia);
            nrSpace++;

            // Junta todos os competidores deste páreo
            List<CompetidorDTO> listaX = new ArrayList<>();

            for (Integer idDoCavalo : lista) {
                List<CompetidorDTO> lDTO = mapa.get(idDoCavalo);
                if (lDTO != null) {
                    for (CompetidorDTO cDTO : lDTO) {
                        if (Objects.equals(cDTO.getIdDoPareo(), idPareo)) {
                            listaX.add(cDTO);
                        }
                    }
                }
            }
            // Agora ordena todos os competidores deste páreo por colocação
            OrdenaListaCompetidorDTO ordenador = new OrdenaListaCompetidorDTO();
            ordenador.porColocacao(listaX);

            // Monta as linhas já ordenadas
            for (CompetidorDTO cDTO : listaX) {
                Object[] objLinha = prepLinha(cDTO);
                objetos.add(objLinha);
            }
        }
//        ShowDadosTipo_1.show(objetos,">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        TransformaUniDiParaBiDi tud = new TransformaUniDiParaBiDi();
        return tud.transforma(objetos, nrSpace, nrColunas);
    }

    private Object[] prepLinha(CompetidorDTO cDTO) {
        String pos = AuxMontaCamposDoObjeto.montaColocacao(cDTO.getColocacao());
        String cavalo = cDTO.getCavalo();
        cavalo = prepNomeCavalo(cDTO, cavalo);
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

    private String prepNomeCavalo(CompetidorDTO cDTO, String cavalo) {
        Integer idCavalo = cDTO.getIdCavalo();
//        System.out.println(cDTO);
        for (int i = 0; i < dados.length; i++) {
            Integer id = (int) dados[i][colIdCavalo];
            if (Objects.equals(idCavalo, id)) {
                String nrCavalo = dados[i][0].toString().trim();
                cavalo = cavalo.trim();
                String str = nrCavalo.concat("-").concat(cavalo);
                return str;
            }
        }
        System.out.println("Erro nr + Cavalo:------------------------------");
        System.exit(0);///////////////////////////////////////
        return "";
    }

    private Object[] montaObjTituloRaia(Integer idCavalo, Integer idPareo) {
        List<CompetidorDTO> lDTO = mapa.get(idCavalo);
        CompetidorDTO cDTO = identificaCompetidor(idPareo, lDTO);

        String raia = cDTO.getRaia();
        String data = AuxMontaCamposDoObjeto.montaData(cDTO.getHipoCod(), cDTO.getData());
        String prova = cDTO.getProva();
        Object[] obj = new Object[11];
        obj[0] = raia;
        obj[1] = data;
        return obj;
    }

    private CompetidorDTO identificaCompetidor(Integer idPareo, List<CompetidorDTO> lDTO) {
        for (CompetidorDTO cDTO : lDTO) {
            if (cDTO.getIdDoPareo().equals(idPareo)) {
                return cDTO;
            }
        }
        System.out.println("Erro na idPareo não existe");
        System.exit(0);//////////////////////////////+++++++++++++++++++++++++++++
        return null;
    }


    private String montaNrCavalo(String nr, String cavalo) {
        nr = nr.trim();
        cavalo = cavalo.trim();
        return nr.concat(" - ").concat(cavalo);
    }
}
