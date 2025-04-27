package asdrubal.hr.visulal_v1.entities;

import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "competidor")
@DynamicUpdate
public class Competidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompetidor;
    private Integer idDoPrograma;
    private Integer idDoPareo;
    private String cavalo;
    private String baliza;
    private String nr;//número do cavalo
    private String pesoCavalo;
    private String pesoJoquei;
    private String idade;
    private String sexo;
    private String medicacao;
    private int colocacao;
    private String rateio;
    private String corpoChegada;
    private String cronometro;
    private float tempo;// novo campo******************************************************************
    private String entradaReta;
    private String obs;
    private String joquei;
    private String treinador;
    private String proprietario;
    private Integer joqueiId;
    private Integer treinadorId;
    private Integer proprietarioId;
    private String raia;
    private String prova;
    @ManyToOne
    @JoinColumn(name = "horseId")
    private Cavalo horse;

    public Competidor() {
    }

    public Competidor(CompetidorDTO dto) {
//        if (dto.getIdCompetidor() != null && dto.getIdCompetidor() > 0) {
//            idCompetidor = dto.getIdCompetidor();
//        }
        idDoPrograma = dto.getIdDoPrograma();
        idDoPareo = dto.getIdDoPareo();
        cavalo = dto.getCavalo();
        baliza = dto.getBaliza();
        nr = dto.getNr();
        pesoCavalo = dto.getPesoCavalo();
        pesoJoquei = dto.getPesoJoquei();
        idade = dto.getIdade();
        sexo = dto.getSexo();
        medicacao = dto.getMedicacao();
        colocacao = dto.getColocacao();
        rateio = dto.getRateio();
        corpoChegada = dto.getCorpoChegada();
        cronometro = dto.getCronometro();
        tempo = dto.getTempo();
        entradaReta = dto.getEntradaReta();
        obs = dto.getObs();
        joquei = dto.getJoquei();
        treinador = dto.getTreinador();
        proprietario = dto.getProprietario();
        joqueiId = dto.getIdJoquei();
        treinadorId = dto.getIdTreinador();
        proprietarioId = dto.getIdProprietario();


//        Cavalo cav = new Cavalo(dto.getCavaloDTO());
//        horse = cav;
    }

    public Integer getIdCompetidor() {
        return idCompetidor;
    }

    public void setIdCompetidor(Integer idCompetidor) {
        this.idCompetidor = idCompetidor;
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public int getColocacao() {
        return colocacao;
    }

    public void setColocacao(int colocacao) {
        this.colocacao = colocacao;
    }

    public String getRateio() {
        return rateio;
    }

    public void setRateio(String rateio) {
        this.rateio = rateio;
    }

    public String getCorpoChegada() {
        return corpoChegada;
    }

    public void setCorpoChegada(String corpoChegada) {
        this.corpoChegada = corpoChegada;
    }

    public String getCronometro() {
        return cronometro;
    }

    public void setCronometro(String cronometro) {
        this.cronometro = cronometro;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public String getEntradaReta() {
        return entradaReta;
    }

    public void setEntradaReta(String entradaReta) {
        this.entradaReta = entradaReta;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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

    public Integer getJoqueiId() {
        return joqueiId;
    }

    public void setJoqueiId(Integer joqueiId) {
        this.joqueiId = joqueiId;
    }

    public Integer getTreinadorId() {
        return treinadorId;
    }

    public void setTreinadorId(Integer treinadorId) {
        this.treinadorId = treinadorId;
    }

    public Integer getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Integer proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public Cavalo getHorse() {
        return horse;
    }

    public void setHorse(Cavalo horse) {
        this.horse = horse;
    }

    public String getRaia() {
        return raia;
    }

    public void setRaia(String raia) {
        this.raia = raia;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    @Override
    public String toString() {
        return "\nCompetidor{" +
                "idCompetidor=" + idCompetidor +
                ", idDoPrograma=" + idDoPrograma +
                ", idDoPareo=" + idDoPareo +
                ", cavalo='" + cavalo + '\'' +
                ", baliza='" + baliza + '\'' +
                "\n Raia='" + raia + '\'' +
                ", Prova='" + prova + '\'' +
                ", nr='" + nr + '\'' +
                "\n pesoCavalo='" + pesoCavalo + '\'' +
                ", pesoJoquei='" + pesoJoquei + '\'' +
                ", idade='" + idade + '\'' +
                ", sexo='" + sexo + '\'' +
                "\n medicacao='" + medicacao + '\'' +
                ", colocacao=" + colocacao +
                ", rateio='" + rateio + '\'' +
                "\n corpoChegada='" + corpoChegada + '\'' +
                ", cronometro='" + cronometro + '\'' +
                ", tempo=" + tempo +
                ", entradaReta='" + entradaReta + '\'' +
                ", obs='" + obs + '\'' +
                "\n joquei='" + joquei + '\'' +
                ", treinador='" + treinador + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", joqueiId=" + joqueiId +
                ", treinadorId=" + treinadorId +
                ", proprietarioId=" + proprietarioId +
//                "\n horse=" + horse +
                '}';
    }
}
