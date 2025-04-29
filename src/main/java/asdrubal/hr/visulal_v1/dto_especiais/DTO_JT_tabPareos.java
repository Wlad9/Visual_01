package asdrubal.hr.visulal_v1.dto_especiais;

import asdrubal.hr.visulal_v1.entities.Pareo;

import java.sql.Date;

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
    private Date data;
    private String hipocod;


    public DTO_JT_tabPareos() {
    }

    public DTO_JT_tabPareos(Pareo pareo) {
        idPareo = pareo.getIdPareo();
        idPrograma = pareo.getPrograma() != null ? pareo.getPrograma().getIdPrograma() : null;
        nrPareo = pareo.getNrPareo();
        ordem = pareo.getOrdem();
        prova = pareo.getProva();
        pista = pareo.getPista();
        distancia = pareo.getDistancia();
        bolsa = pareo.getBolsa();
        chamada = pareo.getChamada();
        hipocod = pareo.getPrograma() != null ? pareo.getPrograma().getHipodromoCod() : null;
        data = pareo.getPrograma() != null ? pareo.getPrograma().getData() : null;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHipocod() {
        return hipocod;
    }

    public void setHipocod(String hipocod) {
        this.hipocod = hipocod;
    }

    @Override
    public String toString() {
        return "DTO_JT_tabPareos{" +
                "idPareo=" + idPareo +
                ", idPrograma=" + idPrograma +
                ", nrPareo=" + nrPareo +
                ", Data='" + data + '\'' +
                ", hipoCod='" + hipocod + '\'' +
                "\n ordem=" + ordem +
                ", prova='" + prova + '\'' +
                ", pista='" + pista + '\'' +
                ", distancia=" + distancia +
                ", bolsa=" + bolsa +
                ", chamada='" + chamada + '\'' +
                '}';
    }
}
