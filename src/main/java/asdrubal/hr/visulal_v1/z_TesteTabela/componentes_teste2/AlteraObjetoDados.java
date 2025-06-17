package asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2;

public class AlteraObjetoDados {
    private Object[][] d;

    public AlteraObjetoDados(Object[][] dados) {
        d = dados;
    }

    public Object[][] retiraColuna4(Object[][] dados, int x) {
        if (dados == null || dados.length == 0) {
            return null;
        }
        int nrLinhas = d.length;
        int nrColunas = d[0].length;
        if (nrColunas < x) {
            System.out.println("Nr de colunas é menor que o índice a ser retirado.");
            return null;
        }
        Object[][] novoObj = new Object[nrLinhas][nrColunas - 1];
        for (int i = 0; i < nrLinhas; i++) {
            int index = 0;
            for (int j = 0; j < nrColunas; j++) {
                if (j != x) {
                    novoObj[i][index++] = d[i][j];
                }
            }
        }
        return novoObj;
    }
}
