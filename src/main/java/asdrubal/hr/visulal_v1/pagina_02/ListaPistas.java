package asdrubal.hr.visulal_v1.pagina_02;

import javax.swing.*;

import static asdrubal.hr.visulal_v1.classes_auxiliares.Constantes.PISTAS_LISTA;

public class ListaPistas extends JList {
    private JList lista;

    public ListaPistas(){
        lista = new JList(PISTAS_LISTA);
    }
}
