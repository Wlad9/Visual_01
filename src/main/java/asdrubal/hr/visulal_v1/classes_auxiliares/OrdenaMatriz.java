package asdrubal.hr.visulal_v1.classes_auxiliares;

import java.util.Arrays;
import java.util.Comparator;

public class OrdenaMatriz {
    public static Object[][] ordenaPelaPrimeiraColuna(Object[][] dados) {
        if (dados == null || dados.length <= 1) {
            return dados; // Retorna a matriz original se for nula ou tiver menos de 2 linhas
        }

        Arrays.sort(dados, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] linha1, Object[] linha2) {
                try {
                    // Tenta converter o primeiro elemento de cada linha para Integer
                    Integer valor1 = Integer.parseInt(String.valueOf(linha1[0]));
                    Integer valor2 = Integer.parseInt(String.valueOf(linha2[0]));
                    return valor1.compareTo(valor2);
                } catch (NumberFormatException e) {
                    // Se a conversão falhar, mantém a ordem original dessas linhas
                    return 0;
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Se a linha não tiver elementos suficientes, mantém a ordem original
                    return 0;
                }
            }
        });

        return dados;

    }
}
