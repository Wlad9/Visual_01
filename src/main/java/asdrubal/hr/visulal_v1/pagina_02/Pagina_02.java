package asdrubal.hr.visulal_v1.pagina_02;

import javax.swing.*;

public class Pagina_02 extends JFrame {
    private JPanel contentPane;
    private JPanel jpEsquerda;
    private JPanel jpCavalos;
    private JPanel jpDados;
    private JScrollPane scrollPistas;
    private JScrollPane scrollDados;
    private JTable jtCavalos;
    private JTable jtDados;
    private JPanel jpEsqInf;
    private JList jlPista;
    private JScrollPane scrollPista;
    public Pagina_02(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        contentPane.add(jpEsquerda);
        contentPane.add(jpEsqInf);
        jpEsqInf.add(jlPista);
    }
}
