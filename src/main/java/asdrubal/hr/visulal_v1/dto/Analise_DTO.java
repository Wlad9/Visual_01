package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Registro;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Analise_DTO {
    private Integer idAnalise;
    private Integer idCavalo;
    private Integer idCompetidor = 0;
    private String cavalo;
    private String descricao;
    private int positivo = 0;
    private int negativo = 0;
    private Registro registro;

    public Analise_DTO() {
    }

    public Integer getIdAnalise() {
        return idAnalise;
    }

    public void setIdAnalise(Integer idAnalise) {
        this.idAnalise = idAnalise;
    }

    public Integer getIdCavalo() {
        return idCavalo;
    }

    public void setIdCavalo(Integer idCavalo) {
        this.idCavalo = idCavalo;
    }

    public Integer getIdCompetidor() {
        return idCompetidor;
    }

    public void setIdCompetidor(Integer idCompetidor) {
        this.idCompetidor = idCompetidor;
    }

    public String getCavalo() {
        return cavalo;
    }

    public void setCavalo(String cavalo) {
        this.cavalo = cavalo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPositivo() {
        return positivo;
    }

    public void setPositivo(int positivo) {
        this.positivo = positivo;
    }

    public int getNegativo() {
        return negativo;
    }

    public void setNegativo(int negativo) {
        this.negativo = negativo;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
}
