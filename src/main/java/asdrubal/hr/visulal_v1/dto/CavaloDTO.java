package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Cavalo;

public class CavaloDTO {
    private Integer idCavalo;
    private String cavalo;
    private String idade;
    private String sexo;
    private String origem;
    private Integer paiId;
    private Integer maeId;
    private Integer avoId;

    public CavaloDTO(Cavalo cavaloEntity) {
        this.idCavalo = cavaloEntity.getIdCavalo();
        this.cavalo = cavaloEntity.getCavalo();
        this.idade = cavaloEntity.getIdade();
        this.sexo = cavaloEntity.getSexo();
        this.origem = cavaloEntity.getOrigem();
        this.paiId = cavaloEntity.getPaiId();
        this.maeId = cavaloEntity.getMaeId();
        this.avoId = cavaloEntity.getAvoId();

    }


    public CavaloDTO(String cavalo, String sexo) {
        this.cavalo = cavalo;
        this.sexo = sexo;
    }

    public CavaloDTO() {
    }

    public CavaloDTO(CavaloDTO dto) {
        cavalo = dto.getCavalo();
        sexo = dto.getSexo();
        idade = dto.getIdade();
        origem = dto.getOrigem();
        paiId = dto.getPaiId();
        maeId = dto.getMaeId();
        avoId = dto.getAvoId();
    }

    public Integer getIdCavalo() {
        return idCavalo;
    }

    public void setIdCavalo(Integer idCavalo) {
        this.idCavalo = idCavalo;
    }

    public String getCavalo() {
        return cavalo;
    }

    public void setCavalo(String cavalo) {
        this.cavalo = cavalo;
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
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

    @Override
    public String toString() {
        return "\nCavaloDTO{" +
                "idCavalo=" + idCavalo +
                ", cavalo='" + cavalo + '\'' +
                ", idade='" + idade + '\'' +
                ", sexo='" + sexo + '\'' +
                ", origem='" + origem + '\'' +
                ", paiId=" + paiId +
                ", maeId=" + maeId +
                ", avoId=" + avoId +
                '}';
    }
}
