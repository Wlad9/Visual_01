package asdrubal.hr.visulal_v1.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;
    private Integer idPrograma;
    private Integer idPareo;
    private String hipoData;
    private String raia;
    @OneToMany(mappedBy = "registro",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Analise> analises = new ArrayList<>();

    public Registro() {
    }

    public String getHipoData() {
        return hipoData;
    }

    public void setHipoData(String hipoData) {
        this.hipoData = hipoData;
    }

    public String getRaia() {
        return raia;
    }

    public void setRaia(String raia) {
        this.raia = raia;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Integer getIdPareo() {
        return idPareo;
    }

    public void setIdPareo(Integer idPareo) {
        this.idPareo = idPareo;
    }

    public List<Analise> getAnalises() {
        return analises;
    }
}
