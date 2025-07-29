package asdrubal.hr.visulal_v1.classes_auxiliares;

import javax.swing.*;

public class ConverteBiParaUniDimencional {
    private Integer idCavalo;

    public Object[] converteMk1(JTable tabela, int linhaSelec) {
        int nrCol = tabela.getColumnCount();
        Object[] obj = new Object[nrCol];
        for (int i = 0; i < nrCol; i++) {
            obj[i] = tabela.getValueAt(linhaSelec, i);
        }
        return obj;
    }
}
