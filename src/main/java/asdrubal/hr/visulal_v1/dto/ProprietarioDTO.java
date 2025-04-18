package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Proprietario;

public class ProprietarioDTO {
    private Integer idProprietario;
    private String proprietario;

    public ProprietarioDTO(Proprietario entity) {
        idProprietario = entity.getIdProprietario();
        proprietario = entity.getProprietario();
    }

    public ProprietarioDTO() {
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
}
