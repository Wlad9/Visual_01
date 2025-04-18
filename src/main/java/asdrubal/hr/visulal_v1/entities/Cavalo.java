package asdrubal.hr.visulal_v1.entities;

import asdrubal.hr.visulal_v1.dto.CavaloDTO;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "cavalo")
public class Cavalo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCavalo;
    @NonNull
    @Column(unique = true, nullable = false)
    private String cavalo;
    private String idade;
    private String sexo;
    private String origem;
    private Integer paiId;
    private Integer maeId;
    private Integer avoId;

    public Cavalo() {
    }
    public Cavalo(CavaloDTO cavaloDTO) {
        cavalo = cavaloDTO.getCavalo();
        idade = cavaloDTO.getIdade();
        sexo = cavaloDTO.getSexo();
        origem = cavaloDTO.getOrigem();
        paiId = cavaloDTO.getPaiId();
        maeId = cavaloDTO.getMaeId();
        avoId = cavaloDTO.getAvoId();
    }
    public Integer getIdCavalo() {
        return idCavalo;
    }

    public void setIdCavalo(Integer idCavalo) {
        this.idCavalo = idCavalo;
    }

    @NonNull
    public String getCavalo() {
        return cavalo;
    }

    public void setCavalo(@NonNull String cavalo) {
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
}
