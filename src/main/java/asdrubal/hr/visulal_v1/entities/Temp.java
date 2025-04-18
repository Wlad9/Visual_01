package asdrubal.hr.visulal_v1.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "temp")
public class Temp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTemp;
    private String baliza;
    private String nr;
    private String pesoCavalo;
    private String pesoJoquei;
    private String medicacao;
    private String obs;

    private Integer idDoPrograma;
    private Integer idDoPareo;

    private String cavalo;
    private Integer idCavalo;

    private String joquei;
    private Integer joqueiId;

    private String treinador;
    private Integer treinadorId;

    private String proprietario;
    private Integer proprietarioId;

    private String sexo;
    private String idade;
    private String pai;
    private Integer idDoPai;

    private String mae;
    private Integer idDaMae;

    private String avo;
    private Integer idDoAvo;

    public Temp() {
    }

    public Integer getIdTemp() {
        return idTemp;
    }

    public void setIdTemp(Integer idTemp) {
        this.idTemp = idTemp;
    }

    public String getBaliza() {
        return baliza;
    }

    public void setBaliza(String baliza) {
        this.baliza = baliza;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getPesoCavalo() {
        return pesoCavalo;
    }

    public void setPesoCavalo(String pesoCavalo) {
        this.pesoCavalo = pesoCavalo;
    }

    public String getPesoJoquei() {
        return pesoJoquei;
    }

    public void setPesoJoquei(String pesoJoquei) {
        this.pesoJoquei = pesoJoquei;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getIdDoPrograma() {
        return idDoPrograma;
    }

    public void setIdDoPrograma(Integer idDoPrograma) {
        this.idDoPrograma = idDoPrograma;
    }

    public Integer getIdDoPareo() {
        return idDoPareo;
    }

    public void setIdDoPareo(Integer idDoPareo) {
        this.idDoPareo = idDoPareo;
    }

    public String getCavalo() {
        return cavalo;
    }

    public void setCavalo(String cavalo) {
        this.cavalo = cavalo;
    }

    public Integer getIdCavalo() {
        return idCavalo;
    }

    public void setIdCavalo(Integer idCavalo) {
        this.idCavalo = idCavalo;
    }

    public String getJoquei() {
        return joquei;
    }

    public void setJoquei(String joquei) {
        this.joquei = joquei;
    }

    public Integer getJoqueiId() {
        return joqueiId;
    }

    public void setJoqueiId(Integer joqueiId) {
        this.joqueiId = joqueiId;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }

    public Integer getTreinadorId() {
        return treinadorId;
    }

    public void setTreinadorId(Integer treinadorId) {
        this.treinadorId = treinadorId;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Integer getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Integer proprietarioId) {
        this.proprietarioId = proprietarioId;
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

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public Integer getIdDoPai() {
        return idDoPai;
    }

    public void setIdDoPai(Integer idDoPai) {
        this.idDoPai = idDoPai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public Integer getIdDaMae() {
        return idDaMae;
    }

    public void setIdDaMae(Integer idDaMae) {
        this.idDaMae = idDaMae;
    }

    public String getAvo() {
        return avo;
    }

    public void setAvo(String avo) {
        this.avo = avo;
    }

    public Integer getIdDoAvo() {
        return idDoAvo;
    }

    public void setIdDoAvo(Integer idDoAvo) {
        this.idDoAvo = idDoAvo;
    }

    @Override
    public String toString() {
        return "\nTemp{" +
                "idTemp=" + idTemp +
                ", baliza='" + baliza + '\'' +
                ", nr='" + nr + '\'' +
                ", pesoCavalo='" + pesoCavalo + '\'' +
                ", pesoJoquei='" + pesoJoquei + '\'' +
                ", medicacao='" + medicacao + '\'' +
                ", obs='" + obs + '\'' +
                "\n idDoPrograma=" + idDoPrograma +
                ", idDoPareo=" + idDoPareo +
                "\n cavalo='" + cavalo + '\'' +
                ", idCavalo=" + idCavalo +
                ", joquei='" + joquei + '\'' +
                ", joqueiId=" + joqueiId +
                ", treinador='" + treinador + '\'' +
                ", treinadorId=" + treinadorId +
                ", proprietario='" + proprietario + '\'' +
                ", proprietarioId=" + proprietarioId +
                "\n sexo='" + sexo + '\'' +
                ", idade='" + idade + '\'' +
                ", pai='" + pai + '\'' +
                ", idDoPai=" + idDoPai +
                ", mae='" + mae + '\'' +
                ", idDaMae=" + idDaMae +
                ", avo='" + avo + '\'' +
                ", idDoAvo=" + idDoAvo +
                '}';
    }
}