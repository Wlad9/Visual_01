package asdrubal.hr.visulal_v1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "raias")
public class Raia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Integer idRaia;

    @Column(unique = true, nullable = false)
    private String raia;

    public Raia() {
    }

    public Raia(String raia) {
        this.raia = raia;
    }

    public Integer getIdRaia() {
        return idRaia;
    }

    public void setIdRaia(Integer idRaia) {
        this.idRaia = idRaia;
    }

    public String getRaia() {
        return raia;
    }

    public void setRaia(String raia) {
        this.raia = raia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Raia otherRaia = (Raia) o; // Use um nome de variável diferente para evitar confusão
        // Compara a propriedade 'raia' deste objeto com a propriedade 'raia' do 'otherRaia'
        return java.util.Objects.equals(this.raia, otherRaia.raia); // Garante comparação segura contra null
    }

    @Override
    public int hashCode() {
        // O hash code deve ser baseado na propriedade 'raia' para consistência com equals
        return java.util.Objects.hash(raia);
    }
}

