package asdrubal.hr.visulal_v1.corretor_tempo;


import static asdrubal.hr.visulal_v1.classes_auxiliares.Constantes.TAG_NOINFO;

public class TransformaCronometroEmTempo {
    private String cronometro;
    private float min = 0.0F;
    private float seg = 0.0F;
    private float dec = 0.0F;
    private String minuto = "";
    private String segundo = "";
    private String decimo = "";

    public TransformaCronometroEmTempo(String cronometro) {
        this.cronometro = cronometro;
    }

    public float cronoToTempo() {
//        System.out.println("\nCronometro: "+cronometro);
        String crono = cronometro.toUpperCase().trim();
        if (crono.contains("M")) {
            minuto = separaValor(crono, "M");
            crono = retiraValor(crono, "M");
//            System.out.println("Minuto:" + minuto + "\tCrono:" + crono);
        }

        if (crono.contains("S")) {
            segundo = separaValor(crono, "S");
            crono = retiraValor(crono, "S");
//            System.out.println("Segundo:" + segundo + "\t..>Crono:" + crono);
        }
        decimo = crono;
//        System.out.println("NewCrono:" + crono);
        return tempo(minuto, segundo, decimo);
    }

    private float tempo(String minuto, String segundo, String decimo) {
//        System.out.println("minuto:" + minuto + "\tsegundo:" + segundo + "\tdecimo:" + decimo);
        if (minuto.length() > 0) {
            min = Float.parseFloat(minuto) * 60;
        }
        if (segundo.length() > 0) {
            seg = Float.parseFloat(segundo);
        }
        if (decimo.length() > 0 && !decimo.equalsIgnoreCase(TAG_NOINFO)) {
            decimo = "0.".concat(decimo);
            dec = Float.parseFloat(decimo);
        }else{
            dec = 0.f;
        }

        Float valor = min + seg + dec;
//        System.out.println("VALOR:" + valor);
        return valor;
    }

    private String retiraValor(String crono, String str) {
        return crono.substring(crono.indexOf(str) + 1);
    }

    private String separaValor(String crono, String str) {
        return crono.substring(0, crono.indexOf(str));
    }
}