package asdrubal.hr.visulal_v1.objetos;

import asdrubal.hr.visulal_v1.classes_auxiliares.RetiraParentesisFinalDoNome;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.enums.CampoOrdenacao;
import asdrubal.hr.visulal_v1.ordenador.OrdenaCompetidor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjetoAlfa_Montador {
    private static int nrColunas = 11;

    public static Object[][] monta_A(Map<String, List<CompetidorDTO>> mapa) {
        if (mapa.size() == 0) {
            return semDados();
        }

        Map<String, List<CompetidorDTO>> mapaOrdenadoPorData = ordenaLista(mapa, CampoOrdenacao.DATA);
        int nrLinhas = AuxMontaCamposDoObjeto.calculaNrLinhas(mapaOrdenadoPorData);

//        int nrLinhas = AuxMontaCamposDoObjeto.calculaNrLinhas(mapa);
        Object[][] obj = new Object[nrLinhas][nrColunas];
        int linha = 0;
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapaOrdenadoPorData.entrySet()) {
            String raia = entry.getKey();
            obj[linha++][0] = raia;
            for (CompetidorDTO cDTO : entry.getValue()) {
                String crono = cDTO.getCronometro();
                if (crono != null) {
                    crono = crono.toLowerCase();
                }
                obj[linha][0] = crono;
                String pos = AuxMontaCamposDoObjeto.montaColocacao(cDTO.getColocacao());
                obj[linha][1] = pos;
                String cavalo = cDTO.getCavalo();
                cavalo = RetiraParentesisFinalDoNome.limpa(cavalo);
                obj[linha][2] = cavalo;
                String data = AuxMontaCamposDoObjeto.montaData(cDTO.getHipoCod(), cDTO.getData());
                obj[linha][3] = data;
                obj[linha][4] = cDTO.getJoquei();
                obj[linha][5] = cDTO.getCorpoChegada();
                obj[linha][6] = cDTO.getTreinador();
                obj[linha][7] = cDTO.getRateio();
                obj[linha][8] = cDTO.getTempo();// Filtro aplicado neste campo
                obj[linha][9] = cDTO.getEntradaReta();
                obj[linha][10] = cDTO.getRaia();
                linha++;
            }
            for (int col = 0; col < nrColunas; col++) {
                obj[linha][col] = " ";  // ou "" se preferir visualmente uma célula vazia
            }
            linha++;
        }
        return obj;
    }

    private static Map<String, List<CompetidorDTO>> ordenaLista(Map<String, List<CompetidorDTO>> mapa, CampoOrdenacao campoOrdenacao) {
        Map<String, List<CompetidorDTO>> mapaOrdenado = new HashMap<>();
        for (Map.Entry<String, List<CompetidorDTO>> entry : mapa.entrySet()) {
            List<CompetidorDTO> listaOriginal = entry.getValue();
            List<CompetidorDTO> listaOrdenadaPorData = OrdenaCompetidor.ordenaPorCampo(listaOriginal, campoOrdenacao);
            OrdenaCompetidor.ordenaPorCampo(listaOrdenadaPorData, campoOrdenacao);
            mapaOrdenado.put(entry.getKey(), listaOrdenadaPorData);
        }
        return mapaOrdenado;
    }

    private static Object[][] semDados() {
        Object[][] obj = new Object[1][1];
        obj[0][0] = "Não há Info.";
        return obj;
    }
}
