package asdrubal.hr.visulal_v1.raias_filtros;

import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;

import javax.swing.*;
import java.util.Map;

public class Tela_RaiasFiltro {
    private final Map<Integer, DTO_JT_tabPareos> mapa1;
    private JPanel contentPanel;
    private JScrollPane scrollTabCavalos;
    private JTable tbCavalos;
    private JPanel jpPainel2;
    private JPanel jpEsquerda;
    private JPanel jpDireita;

    public Tela_RaiasFiltro(Map<Integer, DTO_JT_tabPareos> mapa1) {
        this.mapa1 = mapa1;
    }
}
