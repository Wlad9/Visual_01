package asdrubal.hr.visulal_v1.pagina_03;

import javax.swing.*;

import java.awt.*;

import static asdrubal.hr.visulal_v1.classes_auxiliares.Constantes.DISTANCIAS_LISTA;
import static asdrubal.hr.visulal_v1.classes_auxiliares.Constantes.PISTAS_LISTA;

public class Pagina_03 extends JFrame{
    private JPanel contentPane;
    private JPanel jpEsquerdo;
    private JPanel jpDireito;
    private JTable tbCavalos;
    private JScrollPane scrollTabCavalos;
    private JScrollPane scrollListaPista;
    private JScrollPane scrollListaDistancia;
    private JList jlPista;
    private JList jlDistancia;
    private JPanel jpListas;
    private JPanel jpListasLadoLado;

    public Pagina_03(){
        setContentPane(contentPane);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] colunas = {"Coluna 1", "Coluna 2", "Coluna 3", "Coluna 4", "Coluna 5", "Coluna 6"};
        Object[][] dados = new Object[][]{
                {"Linha 1, Coluna 1", "Linha 1, Coluna 2", "Linha 1, Coluna 3", "Linha 1, Coluna 4", "Linha 1, Coluna 5", "Linha 1, Coluna 6"},
                {"Linha 2, Coluna 1", "Linha 2, Coluna 2", "Linha 2, Coluna 3", "Linha 2, Coluna 4", "Linha 2, Coluna 5", "Linha 2, Coluna 6"},
                {"Linha 3, Coluna 1", "Linha 3, Coluna 2", "Linha 3, Coluna 3", "Linha 3, Coluna 4", "Linha 3, Coluna 5", "Linha 3, Coluna 6"},
                {"Linha 4, Coluna 1", "Linha 4, Coluna 2", "Linha 4, Coluna 3", "Linha 4, Coluna 4", "Linha 4, Coluna 5", "Linha 4, Coluna 6"},
                {"Linha 5, Coluna 1", "Linha 5, Coluna 2", "Linha 5, Coluna 3", "Linha 5, Coluna 4", "Linha 5, Coluna 5", "Linha 5, Coluna 6"},
                {"Linha 6, Coluna 1", "Linha 6, Coluna 2", "Linha 6, Coluna 3", "Linha 6, Coluna 4", "Linha 6, Coluna 5", "Linha 6, Coluna 6"},
                {"Linha 7, Coluna 1", "Linha 7, Coluna 2", "Linha 7, Coluna 3", "Linha 7, Coluna 4", "Linha 7, Coluna 5", "Linha 7, Coluna 6"},
                {"Linha 8, Coluna 1", "Linha 8, Coluna 2", "Linha 8, Coluna 3", "Linha 8, Coluna 4", "Linha 8, Coluna 5", "Linha 8, Coluna 6"},
                {"Linha 9, Coluna 1", "Linha 9, Coluna 2", "Linha 9, Coluna 3", "Linha 9, Coluna 4", "Linha 9, Coluna 5", "Linha 9, Coluna 6"},
                {"Linha 10, Coluna 1", "Linha 10, Coluna 2", "Linha 10, Coluna 3", "Linha 10, Coluna 4", "Linha 10, Coluna 5", "Linha 10, Coluna 6"},
                {"Linha 11, Coluna 1", "Linha 11, Coluna 2", "Linha 10, Coluna 3", "Linha 10, Coluna 4", "Linha 10, Coluna 5", "Linha 10, Coluna 6"},
                {"Linha 12, Coluna 1", "Linha 12, Coluna 2", "Linha 10, Coluna 3", "Linha 10, Coluna 4", "Linha 10, Coluna 5", "Linha 10, Coluna 6"}
        };
        tbCavalos = new TabelaCavalos(dados, colunas);
        scrollTabCavalos.setViewportView(tbCavalos);

        jpListasLadoLado.add(scrollListaPista);
        jpListasLadoLado.add(scrollListaDistancia);
        jpListas.add(jpListasLadoLado, BorderLayout.CENTER);////??????????
        DefaultListModel<String> dflPistas = new DefaultListModel<>();
        String spc = " ";
        for(String pista: PISTAS_LISTA){
            pista = spc.concat(pista);
            dflPistas.addElement(pista);
        }
        jlPista.setModel(dflPistas);
        scrollListaPista.setViewportView(jlPista);
        DefaultListModel<String> dflDistancias = new DefaultListModel<>();
        for(String distancia : DISTANCIAS_LISTA){
            distancia = spc.concat(distancia);
            dflDistancias.addElement(distancia);
        }
        jlDistancia.setModel(dflDistancias);
        scrollListaDistancia.setViewportView(jlDistancia);
        scrollListaDistancia.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        jpButtons.setLayout(new GroupLayout(3, 2));
        setResizable(true);
        setVisible(true);
    }
}
