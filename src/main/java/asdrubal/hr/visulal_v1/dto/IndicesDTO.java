package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.*;

public class IndicesDTO {
    private Integer idIndice;
    private String raia;
    private float azul;
    private float verde;
    private float amarelo;
    private float laranja;
    private float vermelho;

    public IndicesDTO() {
    }

    public IndicesDTO(Indices entity) {
        idIndice = entity.getIdIndice();
        raia = entity.getRaia();
        azul = entity.getAzul();
        verde = entity.getVerde();
        amarelo = entity.getAmarelo();
        laranja = entity.getLaranja();
        vermelho = entity.getVermelho();
    }

    public IndicesDTO(IndicesGV entity) {
        idIndice = entity.getIdIndice();
        raia = entity.getRaia();
        azul = entity.getAzul();
        verde = entity.getVerde();
        amarelo = entity.getAmarelo();
        laranja = entity.getLaranja();
        vermelho = entity.getVermelho();
    }

    public IndicesDTO(IndicesRS entity) {
        idIndice = entity.getIdIndice();
        raia = entity.getRaia();
        azul = entity.getAzul();
        verde = entity.getVerde();
        amarelo = entity.getAmarelo();
        laranja = entity.getLaranja();
        vermelho = entity.getVermelho();
    }

    public IndicesDTO(IndicesCJ entity) {
        idIndice = entity.getIdIndice();
        raia = entity.getRaia();
        azul = entity.getAzul();
        verde = entity.getVerde();
        amarelo = entity.getAmarelo();
        laranja = entity.getLaranja();
        vermelho = entity.getVermelho();
    }

    public IndicesDTO(IndicesPR entity) {
        idIndice = entity.getIdIndice();
        raia = entity.getRaia();
        azul = entity.getAzul();
        verde = entity.getVerde();
        amarelo = entity.getAmarelo();
        laranja = entity.getLaranja();
        vermelho = entity.getVermelho();
    }


    public IndicesDTO(IndicesOutros entity) {
        idIndice = entity.getIdIndice();
        raia = entity.getRaia();
        azul = entity.getAzul();
        verde = entity.getVerde();
        amarelo = entity.getAmarelo();
        laranja = entity.getLaranja();
        vermelho = entity.getVermelho();
    }

    public IndicesDTO(Integer idIndice) {
        this.idIndice = idIndice;
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

    @Override
    public String toString() {
        return "IndicesDTO{" +
                "idIndice=" + idIndice +
                ", raia='" + raia + '\'' +
                ", azul=" + azul +
                ", verde=" + verde +
                ", amarelo=" + amarelo +
                ", laranja=" + laranja +
                ", vermelho=" + vermelho +
                '}';
    }
}
