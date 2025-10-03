package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Registro;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Analise_DTO {
    private Integer idAnalise;
    private Integer idCavalo;
    private String cavalo;
    private String joquei;
    private String descricao;
    private int pontuacao = 0;
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

    public String getCavalo() {
        return cavalo;
    }

    public void setCavalo(String cavalo) {
        this.cavalo = cavalo;
    }

    public String getJoquei() {
        return joquei;
    }

    public void setJoquei(String joquei) {
        this.joquei = joquei;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Analise_DTO{" +
                "idAnalise=" + idAnalise +
                ", idCavalo=" + idCavalo +
                ", cavalo='" + cavalo + '\'' +
                ", joquei='" + joquei + '\'' +
                ", descricao='" + descricao + '\'' +
                ", pontuacao=" + pontuacao +
                ", registro=" + registro +
                '}';
    }
}
