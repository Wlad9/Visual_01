package asdrubal.hr.visulal_v1;

import java.util.Arrays;

public class CopiaDeObjetoBiDimensional {
    private final Object[][] alfa;

    public CopiaDeObjetoBiDimensional(Object[][] alfa) {
        this.alfa = alfa;
    }

    public Object[][] makeDeepCopy() {
        Object[][] copia = new Object[alfa.length][];
        for (int i = 0; i < alfa.length; i++) {
            if (alfa[i] != null) {
                copia[i] = Arrays.copyOf(alfa[i], alfa[i].length);
            }
        }
        return copia;
    }
}
