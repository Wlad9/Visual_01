package asdrubal.hr.visulal_v1.z_V2_TelasDeFiltros;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import java.awt.*;

public class Identifa_A_CorDaFaixa {
    private Color marrom = new Color(139, 69, 19);

    public Color corDaFaixa(Float tempo, IndicesDTO dto) {
        if (dto == null) return null;
        if (tempo <= dto.getAzul()) {
            return Color.BLUE;
        } else if (tempo <= dto.getVerde()) {
            return Color.GREEN;
        } else if (tempo <= dto.getAmarelo()) {
            return Color.YELLOW;
        } else if (tempo <= dto.getLaranja()) {
            return Color.ORANGE;
        } else if (tempo <= dto.getVermelho()) {
            return Color.RED;
        } else {
            return marrom;
        }
    }
}
