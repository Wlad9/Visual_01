package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Treinador;

public class TreinadorDTO {
    private Integer idTreinador;
    private String treinador;

    public TreinadorDTO() {
    }

    public TreinadorDTO(Treinador entity) {
        idTreinador = entity.getIdTreinador();
        treinador = entity.getTreinador();
    }

    public Integer getIdTreinador() {
        return idTreinador;
    }

    public void setIdTreinador(Integer idTreinador) {
        this.idTreinador = idTreinador;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }

    @Override
    public String toString() {
        return "\nTreinadorDTO{" +
                "idTreinador=" + idTreinador +
                ", treinador='" + treinador + '\'' +
                '}';
    }
}
