package asdrubal.hr.visulal_v1.entities;

import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Indices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIndice;
    private String raia;
    private float azul;
    private float verde;
    private float amarelo;
    private float laranja;
    private float vermelho;

    public Indices() {
    }

    public Indices(IndicesDTO dto) {
        raia = dto.getRaia();
        azul = dto.getAzul();
        verde = dto.getVerde();
        amarelo = dto.getAmarelo();
        laranja = dto.getLaranja();
        vermelho = dto.getVermelho();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indices indices = (Indices) o;
        return Float.compare(indices.azul, azul) == 0 &&
                Float.compare(indices.verde, verde) == 0 &&
                Float.compare(indices.amarelo, amarelo) == 0 &&
                Float.compare(indices.laranja, laranja) == 0 &&
                Float.compare(indices.vermelho, vermelho) == 0 &&
                Objects.equals(raia, indices.raia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raia, azul, verde, amarelo, laranja, vermelho);
    }


    @Override
    public String toString() {
        return "Indices{" +
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
