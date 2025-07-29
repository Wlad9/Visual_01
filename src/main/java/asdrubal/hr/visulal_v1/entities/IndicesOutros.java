package asdrubal.hr.visulal_v1.entities;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IndicesOutros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIndice;
    private String raia;
    private float azul;
    private float verde;
    private float amarelo;
    private float laranja;
    private float vermelho;

    public IndicesOutros() {
    }

    public Integer getIdIndice() {
        return idIndice;
    }

    public void setIdIndice(Integer idIndice) {
        this.idIndice = idIndice;
    }

    public String getRaia() {
        return raia;
    }

    public void setRaia(String raia) {
        this.raia = raia;
    }

    public float getAzul() {
        return azul;
    }

    public void setAzul(float azul) {
        this.azul = azul;
    }

    public float getVerde() {
        return verde;
    }

    public void setVerde(float verde) {
        this.verde = verde;
    }

    public float getAmarelo() {
        return amarelo;
    }

    public void setAmarelo(float amarelo) {
        this.amarelo = amarelo;
    }

    public float getLaranja() {
        return laranja;
    }

    public void setLaranja(float laranja) {
        this.laranja = laranja;
    }

    public float getVermelho() {
        return vermelho;
    }

    public void setVermelho(float vermelho) {
        this.vermelho = vermelho;
    }
}
