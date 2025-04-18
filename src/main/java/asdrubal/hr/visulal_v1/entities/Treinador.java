package asdrubal.hr.visulal_v1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Treinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTreinador;
    private String treinador;

    public Treinador() {
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
        return "Treinador{" +
                "idTreinador=" + idTreinador +
                ", treinador='" + treinador + '\'' +
                '}';
    }
}