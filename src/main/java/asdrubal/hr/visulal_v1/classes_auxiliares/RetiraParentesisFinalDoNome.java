package asdrubal.hr.visulal_v1.classes_auxiliares;

public class RetiraParentesisFinalDoNome {
    public static String limpa(String cavalo) {
        cavalo = cavalo.trim();
        if (cavalo.contains("(")) {
            cavalo = cavalo.substring(0, cavalo.indexOf("("));
        }
        return cavalo.trim();
    }
}
