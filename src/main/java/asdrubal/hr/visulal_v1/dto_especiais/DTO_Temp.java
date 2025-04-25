package asdrubal.hr.visulal_v1.dto_especiais;

import asdrubal.hr.visulal_v1.entities.Temp;

public class DTO_Temp {
    private String cavalo;
    private String nr;
    private String joquei;
    private String treinador;// Entidade Competidor não tem este campo
    private String proprietario;// Entidade Competidor não tem este campo
    private String sexo;
    private String idade;

    private Integer idCavalo;
    private Integer idJoquei;
    private Integer idTreinador;

    public DTO_Temp() {
    }

    public DTO_Temp(Temp entity) {
        cavalo = entity.getCavalo();
        nr = entity.getNr();
        joquei = entity.getJoquei();
        treinador = entity.getTreinador();
        proprietario = entity.getProprietario();
        sexo = entity.getSexo();
        idade = entity.getIdade();
        idCavalo = entity.getIdCavalo();
        idJoquei = entity.getJoqueiId();
        idTreinador = entity.getTreinadorId();
    }

    public String getCavalo() {
        return cavalo;
    }

    public void setCavalo(String cavalo) {
        this.cavalo = cavalo;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getJoquei() {
        return joquei;
    }

    public void setJoquei(String joquei) {
        this.joquei = joquei;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Integer getIdCavalo() {
        return idCavalo;
    }

    public void setIdCavalo(Integer idCavalo) {
        this.idCavalo = idCavalo;
    }

    public Integer getIdJoquei() {
        return idJoquei;
    }

    public void setIdJoquei(Integer idJoquei) {
        this.idJoquei = idJoquei;
    }

    public Integer getIdTreinador() {
        return idTreinador;
    }

    public void setIdTreinador(Integer idTreinador) {
        this.idTreinador = idTreinador;
    }

    @Override
    public String toString() {
        return "DTO_Temp{" +
                "cavalo='" + cavalo + '\'' +
                ", nr='" + nr + '\'' +
                ", joquei='" + joquei + '\'' +
                ", treinador='" + treinador + '\'' +
                ", proprietario='" + proprietario + '\'' +
                "\n sexo='" + sexo + '\'' +
                ", idade='" + idade + '\'' +
                ", idCavalo=" + idCavalo +
                ", idJoquei=" + idJoquei +
                ", idTreinador=" + idTreinador +
                '}';
    }
}
