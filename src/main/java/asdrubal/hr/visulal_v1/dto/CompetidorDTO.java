package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Competidor;

import java.sql.Date;

public class CompetidorDTO {
    private Integer idCompetidor;
    private Integer idDoPrograma;
    private Integer idDoPareo;
    private String cavalo;
    private String baliza;
    private String nr;
    private int colocacao;
    private String rateio;
    private String corpoChegada;
    private String pesoCavalo;
    private String pesoJoquei;
    private String medicacao;
    private Integer idCavalo;
    private Integer idJoquei;
    private Integer idTreinador;
    private Integer idProprietario;
    private String obs;
    private String cronometro;
    private float tempo;
    private String entradaReta;
    private Integer paiId;
    private Integer maeId;
    private Integer avoId;
    //    private Integer pareoId;
    private String joquei;
    private String treinador;// Entidade Competidor não tem este campo
    private String proprietario;// Entidade Competidor não tem este campo
    private String sexo;
    private String idade;
    private String pai;
    private String mae;
    private String avo;
    private String raia;
    private String prova;
    private String hipoCod;
    private Date data;
    private CavaloDTO cavaloDTO;
    private int bolsa;

    //    private PareoDTO pareoDTO;
    public CompetidorDTO(Competidor entity) {
//        System.out.println("Entity==->" + entity.getCavalo());
        idCompetidor = entity.getIdCompetidor();
        tempo = entity.getTempo();
        cavalo = entity.getCavalo();
        joquei = entity.getJoquei();
        treinador = entity.getTreinador();
        proprietario = entity.getProprietario();
        colocacao = entity.getColocacao();
        rateio = entity.getRateio();
        corpoChegada = entity.getCorpoChegada();
        pesoCavalo = entity.getPesoCavalo();
        pesoJoquei = entity.getPesoJoquei();
        medicacao = entity.getMedicacao();
        idDoPareo = entity.getIdDoPareo();
        idDoPrograma = entity.getIdDoPrograma();
        if (idCavalo == null) {
            idCavalo = entity.getHorse().getIdCavalo();
        }
        if (idJoquei == null) {
            idJoquei = entity.getJoqueiId();
        }
        if (idTreinador == null) {
            idTreinador = entity.getTreinadorId();
        }
        if (idProprietario == null) {
            idProprietario = entity.getProprietarioId();
        }
        obs = entity.getObs();
        cronometro = entity.getCronometro();
        baliza = entity.getBaliza();
        nr = entity.getNr();
        entradaReta = entity.getEntradaReta();
        idade = entity.getIdade();
        sexo = entity.getSexo();
        raia = entity.getRaia();
        prova = entity.getProva();
        data = entity.getData();
        hipoCod = entity.getHipoCod();
        bolsa = entity.getBolsa();
//        pareoId = entity.getPareoId();
    }

    public CompetidorDTO() {
    }

    public int getBolsa() {
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
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

    public Integer getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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

    public Integer getPaiId() {
        return paiId;
    }

    public void setPaiId(Integer paiId) {
        this.paiId = paiId;
    }

    public Integer getMaeId() {
        return maeId;
    }

    public void setMaeId(Integer maeId) {
        this.maeId = maeId;
    }

    public Integer getAvoId() {
        return avoId;
    }

    public void setAvoId(Integer avoId) {
        this.avoId = avoId;
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

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getAvo() {
        return avo;
    }

    public void setAvo(String avo) {
        this.avo = avo;
    }

    public CavaloDTO getCavaloDTO() {
        return cavaloDTO;
    }

    public void setCavaloDTO(CavaloDTO cavaloDTO) {
        this.cavaloDTO = cavaloDTO;
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

    public String getHipoCod() {
        return hipoCod;
    }

    public void setHipoCod(String hipoCod) {
        this.hipoCod = hipoCod;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\nCompetidorDTO{" +
                "idCompetidor=" + idCompetidor +
                ", idDoPrograma=" + idDoPrograma +
                ", idDoPareo=" + idDoPareo +
                ", cavalo='" + cavalo + '\'' +
                ", baliza='" + baliza + '\'' +
                "\n Raia='" + raia + '\'' +
                " Hip='" + hipoCod + '\'' +
                " Data='" + data + '\'' +
                ", Prova='" + prova + '\'' +
                ", nr='" + nr + '\'' +
                ", colocacao=" + colocacao +
                ", rateio='" + rateio + '\'' +
                "\n corpoChegada='" + corpoChegada + '\'' +
                ", pesoCavalo='" + pesoCavalo + '\'' +
                ", pesoJoquei='" + pesoJoquei + '\'' +
                ", medicacao='" + medicacao + '\'' +
                ", idCavalo=" + idCavalo +
                ", idJoquei=" + idJoquei +
                ", idTreinador=" + idTreinador +
                ", idProprietario=" + idProprietario +
                ", obs='" + obs + '\'' +
                "\n cronometro='" + cronometro + '\'' +
                ", tempo=" + tempo +
                ", entradaReta='" + entradaReta + '\'' +
                "\n paiId=" + paiId +
                ", maeId=" + maeId +
                ", avoId=" + avoId +
                ", joquei='" + joquei + '\'' +
                ", treinador='" + treinador + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade='" + idade + '\'' +
                ", pai='" + pai + '\'' +
                ", mae='" + mae + '\'' +
                ", avo='" + avo + '\'' +
                ", cavaloDTO=" + cavaloDTO +
                '}';
    }
}
