package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Joquei;

public class JoqueiDTO {
    private Integer idJoquei;
    private String joquei;

    public JoqueiDTO() {
    }

    public JoqueiDTO(Joquei entity) {
        idJoquei = entity.getIdJoquei();
        joquei = entity.getJoquei();
        idJoquei = entity.getIdJoquei();
    }

    public Integer getIdJoquei() {
        return idJoquei;
    }

    public void setIdJoquei(Integer idJoquei) {
        this.idJoquei = idJoquei;
    }

    public String getJoquei() {
        return joquei;
    }

    public void setJoquei(String joquei) {
        this.joquei = joquei;
    }

    @Override
    public String toString() {
        return "\nJoqueiDTO{" +
                "idJoquei=" + idJoquei +
                ", joquei='" + joquei + '\'' +
                '}';
    }
}
