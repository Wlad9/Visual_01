package asdrubal.hr.visulal_v1.classes_auxiliares;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CapturaLinhasMarcadasNaTabela {
    private final JTable tabela;

    public CapturaLinhasMarcadasNaTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public Object[][] linhasSelecionadas() {// retorna todos as colunas das linhas marcadas
        int[] linhasSelecionadas = tabela.getSelectedRows();
        int totalColunas = tabela.getColumnCount();
        Object[][] dadosSelecionados = new Object[linhasSelecionadas.length][totalColunas];
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            for (int j = 0; j < totalColunas; j++) {
                dadosSelecionados[i][j] = tabela.getValueAt(linhasSelecionadas[i], j);
            }
        }
        return dadosSelecionados;
    }

    public List<Object[]> linhasSelecionadas_mk1() {// seleciona somente os dados das colunas 0 e 1: nr e cavalo
        int[] linhasSelecionadas = tabela.getSelectedRows();
        List<Object[]> dados = new ArrayList<>();
        if (linhasSelecionadas.length > 0) {
            for (int linha : linhasSelecionadas) {
                Object nr = tabela.getValueAt(linha, 0);
                Object cavalo = tabela.getValueAt(linha, 1);
//                Object idCavalo = tabela.getValueAt(linha, 6);
                dados.add(new Object[]{nr, cavalo});
            }
        } else {
            dados = todaTabala();
        }
        return dados;
    }

    private List<Object[]> todaTabala() {
        List<Object[]> dados = new ArrayList<>();
        TableModel model = tabela.getModel();
        int nrLinhas = model.getRowCount();
        for (int linha = 0; linha < nrLinhas; linha++) {
            Object nr = tabela.getValueAt(linha, 0);
            Object cavalo = tabela.getValueAt(linha, 1);
            dados.add(new Object[]{nr, cavalo});
        }
        return dados;
    }
}