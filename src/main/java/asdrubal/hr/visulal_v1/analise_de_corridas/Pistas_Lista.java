package asdrubal.hr.visulal_v1.analise_de_corridas;

import javax.swing.*;

import static asdrubal.hr.visulal_v1.classes_auxiliares.Constantes.PISTAS_LISTA;

public class Pistas_Lista extends JList<String> {
    public Pistas_Lista() {
        super(new DefaultListModel<>());
        init();
    }

    private void init() {
        DefaultListModel<String> listModel = (DefaultListModel<String>) getModel();
        for (String distancia : PISTAS_LISTA) {
            listModel.addElement(distancia);
        }
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        setVisibleRowCount(10); // ou ajuste conforme o layout desejado
        setFixedCellHeight(20); // opcional
    }
}
