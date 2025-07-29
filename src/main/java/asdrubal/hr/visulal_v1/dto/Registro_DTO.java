package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Analise;

import java.util.ArrayList;
import java.util.List;

public class Registro_DTO {
    private Integer idRegistro;
    private Integer idPrograma;
    private Integer idPareo;
    private String hipoData;
    private String raia;
    private List<Analise> analises = new ArrayList<>();

    public Registro_DTO() {
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

    public List<Analise> getAnalises() {
        return analises;
    }

    public void setAnalises(List<Analise> analises) {
        this.analises = analises;
    }
}
