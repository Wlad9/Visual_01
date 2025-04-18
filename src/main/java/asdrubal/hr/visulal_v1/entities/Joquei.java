package asdrubal.hr.visulal_v1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "joquei")
public class Joquei {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJoquei;
    private String joquei;

    public Joquei() {
    }

    public Integer getIdJoquei() {
        return idJoquei;
    }

    public void setIdJoquei(Integer idJoquei) {
        this.idJoquei = idJoquei;
    }

    public String getJoquei() {
        return joquei;
    }

    public void setJoquei(String joquei) {
        this.joquei = joquei;
    }

    @Override
    public String toString() {
        return "Joquei{" +
                "idJoquei=" + idJoquei +
                ", joquei='" + joquei + '\'' +
                '}';
    }
}