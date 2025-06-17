package asdrubal.hr.visulal_v1.filtros_corrida_por_raia;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;
import asdrubal.hr.visulal_v1.objetos.DuplasCorridasComuns;
import asdrubal.hr.visulal_v1.show.MapaListaDTOx_Show;
import asdrubal.hr.visulal_v1.show.ShowCorridasMesmaRaia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MontaObjetoFiltradoCorridasPorRaia {

    public Object[][] montaDados(Map<String, List<String>> mapa) {
        int nrLinhas = calulaNrLinhas(mapa);
        nrLinhas = nrLinhas + 1; // referente ao título do tipo de dados listados;
        String titulo1 = "Lista de corridas por raia.";
        int nrColunas = 11;
        Object[][] obj = new Object[nrLinhas][nrColunas];
        int linha = 0;
        obj[linha][0] = titulo1;
        obj[linha++][9]=".";//indica que é uma linha de título
        for (Map.Entry<String, List<String>> entry : mapa.entrySet()) {
            String raia = entry.getKey();
            obj[linha][0] = raia;
            obj[linha++][9]=",";// INDICA QUE É UMA LINHA DE RAIA
            int coluna = 0;
            List<String> lista = entry.getValue();
            for (int i = 0; i < lista.size(); i++) {
                obj[linha][coluna++] = lista.get(i++);//cavalo
                obj[linha][coluna++] = lista.get(i++);//col
                obj[linha][coluna++] = lista.get(i++);//crono
                obj[linha][coluna++] = lista.get(i++);//hipoData
                obj[linha][coluna++] = lista.get(i++);//corpoChegada
                obj[linha][coluna++] = lista.get(i++);//joquei
                obj[linha][coluna++] = lista.get(i++);//treinador
                obj[linha][coluna++] = lista.get(i++);//rateio
                obj[linha][coluna++] = lista.get(i++);//entradaReta
                obj[linha][coluna++] = lista.get(i++);//prova
                obj[linha][coluna] = lista.get(i);  // tempo
                coluna = 0;
                linha++;
            }
        }
        ShowCorridasMesmaRaia.showCorridas(obj);
        return obj;
    }

    private int calulaNrLinhas(Map<String, List<String>> mapa) {
        int nrRaias = mapa.size();
        return (nrRaias + mapa.values().stream().mapToInt(List::size).sum());
    }
}

