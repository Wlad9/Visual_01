package asdrubal.hr.visulal_v1.dto_especiais;

import asdrubal.hr.visulal_v1.entities.Pareo;

public class DTO_JT_tabPareos {
    private Integer idPareo;
    private Integer idPrograma;
    private int nrPareo;
    private int ordem;
    private String prova;
    private String pista;
    private int distancia;
    private int bolsa;
    private String chamada;

    public DTO_JT_tabPareos() {
    }

    public DTO_JT_tabPareos(Pareo entity, Integer idPrograma) {
        idPareo = entity.getIdPareo();
        this.idPrograma = idPrograma;
        nrPareo = entity.getNrPareo();
        ordem = entity.getOrdem();
        prova = entity.getProva();
        pista = entity.getPista();
        distancia = entity.getDistancia();
        bolsa = entity.getBolsa();
        chamada = entity.getChamada();
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

    public int getNrPareo() {
        return nrPareo;
    }

    public void setNrPareo(int nrPareo) {
        this.nrPareo = nrPareo;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getBolsa() {
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }

    public String getChamada() {
        return chamada;
    }

    public void setChamada(String chamada) {
        this.chamada = chamada;
    }

    @Override
    public String toString() {
        return "DTO_JT_tabPareos{" +
                "idPareo=" + idPareo +
                ", idPrograma=" + idPrograma +
                ", nrPareo=" + nrPareo +
                "\n ordem=" + ordem +
                ", prova='" + prova + '\'' +
                ", pista='" + pista + '\'' +
                ", distancia=" + distancia +
                ", bolsa=" + bolsa +
                ", chamada='" + chamada + '\'' +
                '}';
    }
}
