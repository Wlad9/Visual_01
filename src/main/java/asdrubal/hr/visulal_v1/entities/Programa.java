package asdrubal.hr.visulal_v1.entities;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "programa")
public class Programa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrograma;
    @NonNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    private int movPrograma;
    private int ordProg;
    private int st;// aberto=1  fechado=0
    @Column(length = 5)
    private String hipodromoCod;
    private String stringIds;

    @ElementCollection
    @CollectionTable(name = "programa_ids_pareos", joinColumns = @JoinColumn(name = "programa_id"))
    @Column(name = "pareo_id")
    private List<Integer> idsPareos = new ArrayList<>();

    public Programa() {
    }

    public Programa(ProgramaDTO dto) {
        if (dto.getIdPrograma() != null) {
            idPrograma = dto.getIdPrograma();
        }
        data = dto.getData();
        movPrograma = dto.getMovPrograma();
        ordProg = dto.getOrdProg();
        st = dto.getSt();
        hipodromoCod = dto.getHipodromoCod();
        stringIds = dto.getStringIds();
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    @NonNull
    public Date getData() {
        return data;
    }

    public void setData(@NonNull Date data) {
        this.data = data;
    }

    public int getMovPrograma() {
        return movPrograma;
    }

    public void setMovPrograma(int movPrograma) {
        this.movPrograma = movPrograma;
    }

    public int getOrdProg() {
        return ordProg;
    }

    public void setOrdProg(int ordProg) {
        this.ordProg = ordProg;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public String getHipodromoCod() {
        return hipodromoCod;
    }

    public void setHipodromoCod(String hipodromoCod) {
        this.hipodromoCod = hipodromoCod;
    }

    public String getStringIds() {
        return stringIds;
    }

    public void setStringIds(String stringIds) {
        this.stringIds = stringIds;
    }

    public List<Integer> getIdsPareos() {
        return idsPareos;
    }

    public void setIdsPareos(List<Integer> idsPareos) {
        this.idsPareos = idsPareos;
    }

    @Override
    public String toString() {
        return "\nPrograma{" +
                "idPrograma=" + idPrograma +
                ", data=" + data +
                ", movPrograma=" + movPrograma +
                ", ordProg=" + ordProg +
                ", st=" + st +
                ", hipodromoCod='" + hipodromoCod + '\'' +
                ", stringIds='" + stringIds + '\'' +
                "\n idsPareos=" + (idsPareos != null ? idsPareos.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]")) : "null") +
                '}';
    }
}
