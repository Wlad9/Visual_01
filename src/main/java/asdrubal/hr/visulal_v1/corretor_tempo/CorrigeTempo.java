package asdrubal.hr.visulal_v1.corretor_tempo;

import asdrubal.hr.visulal_v1.services.CompetidorService;

public class CorrigeTempo {
    private final CompetidorService competidorService;

    public CorrigeTempo(CompetidorService competidorService) {
        this.competidorService = competidorService;
        iniciaCorrecao();
    }

    private void iniciaCorrecao() {
        competidorService.corrigeTempo();
    }
}
