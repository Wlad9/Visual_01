package asdrubal.hr.visulal_v1.z_painel_de_estatistica;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.estatisticas.Monta_Obj_Est1;
import asdrubal.hr.visulal_v1.show.ShowObjetoUniDim;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class PainelEstatistica_1 extends JFrame {
    private final Map<Integer, List<Object[]>> dados3;
    private final Map<Integer, List<CompetidorDTO>> mapa;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTable tb_estatistica1;
    private JPanel contentPane;
    private JPanel jp_estatistica1;
    private JPanel jp_botoes;

    public PainelEstatistica_1(Map<Integer, List<Object[]>> dados3, Map<Integer, List<CompetidorDTO>> mapa) {
        this.dados3 = dados3;
        this.mapa = mapa;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iniciaTela();
    }

    private void iniciaTela() {
        for (Map.Entry<Integer, List<Object[]>> entry : dados3.entrySet()) {
            List<Object[]> lista = entry.getValue();
            Object[] totais = lista.get(0);
            Object[] tempos = lista.get(1);
            Monta_Obj_Est1 objEst1 = new Monta_Obj_Est1();
            Object[] linha = objEst1.montaLinhaDeDados(totais, tempos);
        }
    }
}
