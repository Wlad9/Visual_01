package asdrubal.hr.visulal_v1.painel_Inicial;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;

import java.awt.*;
import java.util.Map;

public class RenderTipoPareos {
    private final Component comp;
    private final int nrColunas;
    private final Object[][] dados;
    private final Map<String, IndicesDTO> mapaIndices;
    private final int row;
    private Color marrom = new Color(139, 69, 19);

    public RenderTipoPareos(Component comp, int nrColunas, Object[][] dados, Map<String, IndicesDTO> mapaIndices, int row) {
        this.comp = comp;
        this.nrColunas = nrColunas;
        this.dados = dados;
        this.mapaIndices = mapaIndices;
        this.row = row;
    }

    public Component inicia() {
        if (nrColunas >= 0 && nrColunas < dados[row].length) {
            Object object = dados[row][nrColunas];
            if (object instanceof Float) {
                String raia = (String) dados[row][2];

                Float tempo = (Float) object;
                if (tempo > 0f) {
                    IndicesDTO dto = mapaIndices.get(raia);
                    if (dto != null) {
                        float azul = dto.getAzul();
                        float verde = dto.getVerde();
                        float amarelo = dto.getAmarelo();
                        float laranja = dto.getLaranja();
                        float vermelho = dto.getVermelho();
                        if (tempo <= azul) {
                            comp.setForeground(Color.BLUE);
                        } else if (tempo <= verde) {
                            comp.setForeground(Color.GREEN);
                        } else if (tempo <= amarelo) {
                            comp.setForeground(Color.YELLOW);
                        } else if (tempo <= laranja) {
                            comp.setForeground(Color.ORANGE);
                        } else if (tempo <= vermelho) {
                            comp.setForeground(Color.RED);
                        } else if (tempo > vermelho) {
                            comp.setForeground(marrom);
                        }
                    }
                }
            }
        }
        return comp;
    }
}
