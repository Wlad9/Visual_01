package asdrubal.hr.visulal_v1.dto_especiais;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;

import java.sql.Date;

public class DTO_x {
    private String raia;
    private Date data;
    private String hipoCod;
    private int pos1;
    private int pos2;
    private String crono1;
    private String crono2;
    private String rateio1;
    private String rateio2;
    private float tempo1;
    private float tempo2;
    private String prova;
    private String corpo1;
    private String corpo2;
    private String entra1;
    private String entra2;
    private String joquei1;
    private String joquei2;
    private String treinador1;
    private String treinador2;
    private Integer idCavalo1;
    private Integer idCavalo2;

    public DTO_x() {
    }

    public DTO_x(CompetidorDTO dto1, CompetidorDTO dto2) {
        setRaia(dto1.getRaia());
        setData(dto1.getData());
        setHipoCod(dto1.getHipoCod());
        setPos1(dto1.getColocacao());
        setCrono1(dto1.getCronometro());
        setRateio1(dto1.getRateio());
        setTempo1(dto1.getTempo());
        setCorpo1(dto1.getCorpoChegada());
        setEntra1(dto1.getEntradaReta());
        setJoquei1(dto1.getJoquei());
        setTreinador1(dto1.getTreinador());
        setIdCavalo1(dto1.getIdCavalo());

        setPos2(dto2.getColocacao());
        setCrono2(dto2.getCronometro());
        setRateio2(dto2.getRateio());
        setTempo2(dto2.getTempo());
        setCorpo2(dto2.getCorpoChegada());
        setEntra2(dto2.getEntradaReta());
        setJoquei2(dto2.getJoquei());
        setTreinador2(dto2.getTreinador());
        setIdCavalo2(dto2.getIdCavalo());
        if (!dto1.getRaia().equalsIgnoreCase(dto2.getRaia())) {
            System.out.println("Erro na construção DTOx. Raias diferentes:");
            System.exit(0);/////////////////////////////////////////////////////
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHipoCod() {
        return hipoCod;
    }

    public void setHipoCod(String hipoCod) {
        this.hipoCod = hipoCod;
    }

    public String getRaia() {
        return raia;
    }

    public void setRaia(String raia) {
        this.raia = raia;
    }

    public int getPos1() {
        return pos1;
    }

    public void setPos1(int pos1) {
        this.pos1 = pos1;
    }

    public int getPos2() {
        return pos2;
    }

    public void setPos2(int pos2) {
        this.pos2 = pos2;
    }

    public String getCrono1() {
        return crono1;
    }

    public void setCrono1(String crono1) {
        this.crono1 = crono1;
    }

    public String getCrono2() {
        return crono2;
    }

    public void setCrono2(String crono2) {
        this.crono2 = crono2;
    }

    public String getRateio1() {
        return rateio1;
    }

    public void setRateio1(String rateio1) {
        this.rateio1 = rateio1;
    }

    public String getRateio2() {
        return rateio2;
    }

    public void setRateio2(String rateio2) {
        this.rateio2 = rateio2;
    }

    public float getTempo1() {
        return tempo1;
    }

    public void setTempo1(float tempo1) {
        this.tempo1 = tempo1;
    }

    public float getTempo2() {
        return tempo2;
    }

    public void setTempo2(float tempo2) {
        this.tempo2 = tempo2;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    public String getCorpo1() {
        return corpo1;
    }

    public void setCorpo1(String corpo1) {
        this.corpo1 = corpo1;
    }

    public String getCorpo2() {
        return corpo2;
    }

    public void setCorpo2(String corpo2) {
        this.corpo2 = corpo2;
    }

    public String getEntra1() {
        return entra1;
    }

    public void setEntra1(String entra1) {
        this.entra1 = entra1;
    }

    public String getEntra2() {
        return entra2;
    }

    public void setEntra2(String entra2) {
        this.entra2 = entra2;
    }

    public String getJoquei1() {
        return joquei1;
    }

    public void setJoquei1(String joquei1) {
        this.joquei1 = joquei1;
    }

    public String getJoquei2() {
        return joquei2;
    }

    public void setJoquei2(String joquei2) {
        this.joquei2 = joquei2;
    }

    public String getTreinador1() {
        return treinador1;
    }

    public void setTreinador1(String treinador1) {
        this.treinador1 = treinador1;
    }

    public String getTreinador2() {
        return treinador2;
    }

    public void setTreinador2(String treinador2) {
        this.treinador2 = treinador2;
    }

    public Integer getIdCavalo1() {
        return idCavalo1;
    }

    public void setIdCavalo1(Integer idCavalo1) {
        this.idCavalo1 = idCavalo1;
    }

    public Integer getIdCavalo2() {
        return idCavalo2;
    }

    public void setIdCavalo2(Integer idCavalo2) {
        this.idCavalo2 = idCavalo2;
    }

    @Override
    public String toString() {
        return "DTO_x{" +
                "raia='" + raia + '\'' +
                ", data=" + data +
                ", hipoCod='" + hipoCod + '\'' +
                ", pos1=" + pos1 +
                ", pos2=" + pos2 +
                ", crono1='" + crono1 + '\'' +
                ", crono2='" + crono2 + '\'' +
                ", rateio1='" + rateio1 + '\'' +
                ", rateio2='" + rateio2 + '\'' +
                ", tempo1=" + tempo1 +
                ", tempo2=" + tempo2 +
                ", prova='" + prova + '\'' +
                ", corpo1='" + corpo1 + '\'' +
                ", corpo2='" + corpo2 + '\'' +
                ", entra1='" + entra1 + '\'' +
                ", entra2='" + entra2 + '\'' +
                ", joquei1='" + joquei1 + '\'' +
                ", joquei2='" + joquei2 + '\'' +
                ", treinador1='" + treinador1 + '\'' +
                ", treinador2='" + treinador2 + '\'' +
                ", idCavalo1=" + idCavalo1 +
                ", idCavalo2=" + idCavalo2 +
                '}';
    }
}
