package asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1;

public class IdentificaHipoCod {
    public static String idIpoCod(Object obj) {
        String hipoCod = null;
        if (obj instanceof String) {
            String str = String.valueOf(obj);
            hipoCod = separaHipoCod(str);
        }
        return hipoCod;
    }

    private static String separaHipoCod(String str) {
        String d[] = str.split("\\s+");
        return d[0].trim();
    }
}
