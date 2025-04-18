package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Programa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProgramaDTO {
    private Integer idPrograma;
    private String hipodromoCod;
    private Date data;
    private int ordProg;
    private int movPrograma;
    private List<PareoDTO> pareos = new ArrayList<>();
    private int st;// aberto=1  fechado=0
    private List<Integer> idsDosPareos = new ArrayList<>();
    private String stringIds;

    public ProgramaDTO() {
    }
    public ProgramaDTO(Programa entity) {
        idPrograma = entity.getIdPrograma();
        hipodromoCod = entity.getHipodromoCod();
        data = entity.getData();
        ordProg = entity.getOrdProg();
        movPrograma = entity.getMovPrograma();
        st = entity.getSt();
        stringIds = entity.getStringIds();
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getHipodromoCod() {
        return hipodromoCod;
    }

    public void setHipodromoCod(String hipodromoCod) {
        this.hipodromoCod = hipodromoCod;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getOrdProg() {
        return ordProg;
    }

    public void setOrdProg(int ordProg) {
        this.ordProg = ordProg;
    }

    public int getMovPrograma() {
        return movPrograma;
    }

    public void setMovPrograma(int movPrograma) {
        this.movPrograma = movPrograma;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public String getStringIds() {
        return stringIds;
    }

    public void setStringIds(String stringIds) {
        this.stringIds = stringIds;
    }

    public List<PareoDTO> getPareos() {
        return pareos;
    }

    public List<Integer> getIdsDosPareos() {
        return idsDosPareos;
    }

    @Override
    public String toString() {
        return "\nProgramaDTO{" +
                "idPrograma=" + idPrograma +
                ", hipodromoCod='" + hipodromoCod + '\'' +
                ", data=" + data +
                ", ordProg=" + ordProg +
                "\n movPrograma=" + movPrograma +
                ", st=" + st +
                "\n pareos=" + pareos +
                "\n stringIds='" + stringIds + '\'' +
                '}';
    }
}
