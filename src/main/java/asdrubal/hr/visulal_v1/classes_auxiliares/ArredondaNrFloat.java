package asdrubal.hr.visulal_v1.classes_auxiliares;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ArredondaNrFloat {
    public static float duasDecimais(float valor) {
        BigDecimal bd = new BigDecimal(Float.toString(valor));
        bd = bd.setScale(2, RoundingMode.HALF_UP); // Arredonda para 2 casas decimais, usando "HALF_UP" (arredonda 0.005 para cima)
        return bd.floatValue(); // Converte de volta para float
    }

    public static float calculaDif(float valor1, float valor2) {
        float dif = 0.0f;
        if (valor1 > valor2) {
            dif = valor1 - valor2;
            dif = duasDecimais(dif);
        } else if (valor2 > valor1) {
            dif = valor2 - valor1;
            dif = duasDecimais(dif);
        } else {
            return 0.0f;
        }
        return dif;
    }
}
