package asdrubal.hr.visulal_v1.montadores;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_x;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DadosDoObjCorridasPorRaia_Montador {

    public Map<String, List<String>> monta(Map<String, List<DTO_x>> mapaListaDTOx) {
        Map<String, List<String>> mapa = new HashMap<>();
        for (Map.Entry<String, List<DTO_x>> entry : mapaListaDTOx.entrySet()) {
            List<String> dados = new ArrayList<>();
            String raia = entry.getKey();
            List<DTO_x> lista = entry.getValue();
            for (DTO_x x : lista) {
                String hipoCod = x.getHipoCod();
                Date dt = x.getData();
                int pos = x.getPos1();

                String hipoData = montaHipoData(hipoCod, dt);
                String col = montaColocacao(pos);
                String crono = x.getCrono1();
                String cavalo = x.getCavalo1();
                String joquei = x.getJoquei1();
                String treinador = x.getTreinador1();
                String rateio = x.getRateio1();
                String corpo = x.getCorpo1();
                String entrada = x.getEntra1();
                String prova = x.getProva();
                float tempo = x.getTempo1();
                // Lista com 10 itens
                dados.add(cavalo);
                dados.add(col);
                dados.add(crono);
                dados.add(hipoData);
                dados.add(corpo);
                dados.add(joquei);
                dados.add(treinador);
                dados.add(rateio);
                dados.add(entrada);
                dados.add(prova);
                dados.add(String.valueOf(tempo));
            }
            if (!dados.isEmpty()) {
                mapa.put(raia, dados);
            }
        }
        return mapa;
    }

    private String montaColocacao(int pos) {
        return String.valueOf(pos).concat("°L");
    }

    private String montaHipoData(String hipoCod, Date data) {
        String dt = new ConverteDateToString().converteMK1(data);
        return hipoCod.concat(" ").concat(dt);

    }
}
