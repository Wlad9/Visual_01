package asdrubal.hr.visulal_v1.classes_auxiliares;

public class MontaLinhaInicial {
    public static String monta(int soma1, int soma2, int soma3) {
        String line = "   1ª Col= ".concat(String.valueOf(soma1)).concat("   2ª Col= ")
                .concat(String.valueOf(soma2)).concat("   3ª Col= ").concat(String.valueOf(soma3));
        return line.trim();
    }
}
