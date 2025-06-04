package asdrubal.hr.visulal_v1.tabelas_class;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Tabela_Pareos extends JTable {

    public Tabela_Pareos(Object[][] dados, String[] colunas) {
        super(new DefaultTableModel(dados, colunas));
//        showDados(dados);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setFillsViewportHeight(true);
        setRowHeight(20);
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SwingUtilities.invokeLater(() -> {
            TableColumnModel colModel = this.getColumnModel();
            if (colModel.getColumnCount() >= 4) {
                colModel.getColumn(0).setPreferredWidth(70);
                colModel.getColumn(0).setMinWidth(70);
                colModel.getColumn(0).setMaxWidth(80);

                colModel.getColumn(1).setPreferredWidth(200);
                colModel.getColumn(1).setMinWidth(200);
                colModel.getColumn(1).setMaxWidth(200);

                colModel.getColumn(2).setPreferredWidth(60);
                colModel.getColumn(2).setMinWidth(60);
                colModel.getColumn(2).setMaxWidth(70);

                colModel.getColumn(3).setPreferredWidth(65);
                colModel.getColumn(3).setMinWidth(50);
                colModel.getColumn(3).setMaxWidth(80);
            }
        });

    }

    private void showDados(Object[][] dados) {
        for (int i = 0; i < dados.length; i++) {
            System.out.print("Linha " + i + ": [");
            if (dados[i] != null) {
                for (int j = 0; j < dados[i].length; j++) {
                    System.out.print(dados[i][j]);
                    if (j < dados[i].length - 1) {
                        System.out.print(", ");
                    }
                }
            } else {
                System.out.print("null");
            }
            System.out.println("]");
        }
    }
}
