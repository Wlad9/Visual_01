package asdrubal.hr.visulal_v1.tabPesquisaAux;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteDateToString;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.entities.Competidor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class AuxPesquisa_Raias {
    private final Map<Integer, List<CompetidorDTO>> mapa3;
    private final Map<Integer, List<CompetidorDTO>> mapa4;
    private final Map<Integer, List<CompetidorDTO>> mapa6;
    private final Object[][] dadosCavalosDoPareo;
    private String[] titulos;

    public AuxPesquisa_Raias(Map<Integer, List<CompetidorDTO>> mapa3, Map<Integer, List<CompetidorDTO>> mapa4, Map<Integer, List<CompetidorDTO>> mapa6, Object[][] dadosCavalosDoPareo) {
        this.mapa3 = mapa3;
        this.mapa4 = mapa4;
        this.mapa6 = mapa6;
        this.dadosCavalosDoPareo = dadosCavalosDoPareo;
        titulos = new String[]{"Tempo", "Animal", "Pos.", "Joquei", "Data", "Treinador", "Rateio", "Corpo", "Ent.", "Crono."};
    }

    public Object[][] inicia(String raia) {
        System.out.println("RAIA:" + raia);
        List<CompetidorDTO> listao = new ArrayList<>();
        for (Map.Entry<Integer, List<CompetidorDTO>> entry : mapa4.entrySet()) {
            List<CompetidorDTO> compDTO = entry.getValue();
            for (CompetidorDTO dto : compDTO) {
                if (dto.getRaia().equalsIgnoreCase(raia)) {
                    listao.add(dto);
                }
            }
//            listao.addAll(compDTO);
        }
        listao.sort(Comparator.comparing(CompetidorDTO::getTempo));
        for (CompetidorDTO dto : listao) {
            System.out.println(dto.getCavalo() + "\t->" + dto.getTempo() + "\t" + dto.getRaia());
        }
        return montaObject(listao);
    }

    private Object[][] montaObject(List<CompetidorDTO> listao) {
        int nrColunas = 10;
        int nrLinhas = listao.size();
        Object[][] dadosMK3 = new Object[nrLinhas][nrColunas];
        int i = 0;
        for (CompetidorDTO dto : listao) {
            String hipoData = montaHipdromoData(dto.getHipoCod(), dto.getData());
            dadosMK3[i][0] = dto.getTempo();
            dadosMK3[i][1] = dto.getCavalo();
            dadosMK3[i][2] = dto.getColocacao();
            dadosMK3[i][3] = dto.getJoquei();
            dadosMK3[i][4] = hipoData;
            dadosMK3[i][5] = dto.getTreinador();
            dadosMK3[i][6] = dto.getRateio();
            dadosMK3[i][7] = dto.getCorpoChegada();
            dadosMK3[i][8] = dto.getEntradaReta();
            dadosMK3[i][9] = dto.getCronometro().toLowerCase();
            i++;
        }
        return dadosMK3;
    }

    private String montaHipdromoData(String hipoCod, Date data) {
        String dt = new ConverteDateToString().converteMK1(data);
        return hipoCod.concat(" ").concat(dt);
    }

    public String[] getTitulos() {
        return titulos;
    }
}