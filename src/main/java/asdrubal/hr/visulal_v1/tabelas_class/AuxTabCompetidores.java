package asdrubal.hr.visulal_v1.tabelas_class;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;

import java.util.Map;

public class AuxTabCompetidores {
   private int nrCol = 0;
    private String[] colunas;
    private final Map<Integer, DTO_TabelaCompetidores> mapa2;

    public AuxTabCompetidores(Map<Integer, DTO_TabelaCompetidores> mapa2) {
        this.mapa2 = mapa2;
        colunas = new String[]{"N°", "Cavalo", "Joquei", "Treinador", "Idade", " Sx"};
        nrCol = colunas.length;
    }

    public Object[][] preparaDados() {
        Object[][] dadosTabela = new Object[mapa2.size()][nrCol];
        int i = 0;
        for (DTO_TabelaCompetidores dto : mapa2.values()) {
            Integer idCavalo = dto.getIdCavalo();
            dadosTabela[i][0] = dto.getNr();
            dadosTabela[i][1] = dto.getCavalo();
            dadosTabela[i][2] = dto.getJoquei();
            dadosTabela[i][3] = dto.getTreinador();
            dadosTabela[i][4] = dto.getIdade();
            dadosTabela[i][5] = dto.getSexo();
            i++;
        }
        System.out.println("mostrar dados:"+dadosTabela.length);
        for (int x = 0; x < dadosTabela.length;x++) {
            for (int j = 0; j < dadosTabela[x].length; j++) {
                System.out.print(dadosTabela[x][j] + "\t"); // usa \t para tabular
            }
            System.out.println(); // pula linha após cada linha da matriz
        }
        return dadosTabela;
    }

    public String[] getColunas() {
        return colunas;
    }
}
