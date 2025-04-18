package asdrubal.hr.visulal_v1.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "proprietario")
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProprietario;
    private String proprietario;

    public Proprietario() {
    }

    public Integer getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Proprietario{" +
                "idProprietario=" + idProprietario +
                ", proprietario='" + proprietario + '\'' +
                '}';
    }
}