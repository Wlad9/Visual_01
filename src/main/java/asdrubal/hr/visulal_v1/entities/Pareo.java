package asdrubal.hr.visulal_v1.entities;

import asdrubal.hr.visulal_v1.dto.PareoDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pareo")
@DynamicUpdate
public class Pareo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPareo;
    private int nrPareo;
    private int ordem;
    private String prova;
    private String pista;
    private int distancia;
    private int bolsa;
    private int p1;
    private int p2;
    private int p3;
    private int p4;
    private int p5;
    private int bonus;
    private int movPareo;
    private String tempoVencedor;
    private float timeWinner;
    private String penetrometro;
    private String cp;//CP=Criado Por=>      0:ok    1:POGV/PORJ.pdf      2:RRGV.pdf      3: RRGV.xls     4:RT.pdf
    @Column(columnDefinition = "TEXT")
    private String chamada;
    private Integer idDoPrograma;

    //==========================================================================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programa_id")
    private Programa programa;
    //    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "pareoId") // Liga com o campo pareoId na entidade Competidor
    @OneToMany(mappedBy = "idDoPareo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Competidor> competidores = new ArrayList<>();
    private String listaIdsCompetidores;

    public Pareo() {
    }

    public Pareo(PareoDTO dto) {
        if (dto.getIdPareo() != null) {
            idPareo = dto.getIdPareo();
        }
        ordem = dto.getOrdem();
        nrPareo = dto.getNrPareo();
        if (dto.getProva() != null) {
            prova = dto.getProva();
        }
        if (dto.getPista() != null) {
            pista = dto.getPista();
        }
        if (dto.getDistancia() > 0) {
            distancia = dto.getDistancia();
        }
        if (dto.getBolsa() > 0) {
            bolsa = dto.getBolsa();
        }
        if (dto.getP1() > 0) {
            p1 = dto.getP1();
        }
        if (dto.getP2() > 0) {
            p2 = dto.getP2();
        }
        if (dto.getP3() > 0) {
            p3 = dto.getP3();
        }
        if (dto.getP4() > 0) {
            p4 = dto.getP4();
        }
        if (dto.getP5() > 0) {
            p5 = dto.getP5();
        }
        if (dto.getBonus() > 0) {
            bonus = dto.getBonus();
        }
        if (dto.getMovPareo() > 0) {
            movPareo = dto.getMovPareo();
        }
        if (dto.getTempoVencedor() != null) {
            tempoVencedor = dto.getTempoVencedor();
        }
        if (dto.getPenetrometro() != null) {
            penetrometro = dto.getPenetrometro();
        }
        if (dto.getChamada() != null) {
            chamada = dto.getChamada();
        }
        if (dto.getCp() != null) {
            cp = dto.getCp();
        }
        if (dto.getIdDoPrograma() != null) {
            idDoPrograma = dto.getIdDoPrograma();
        }
        if(dto.getProgramaDTO() != null){
            programa = new Programa(dto.getProgramaDTO());
        }
    }

    public Pareo(PareoDTO dto, List<Competidor> listaComp) {
        Pareo pareo = new Pareo(dto);
        for (Competidor c : listaComp) {
            competidores.add(c);
        }
    }


    public Integer getIdPareo() {
        return idPareo;
    }

    public void setIdPareo(Integer idPareo) {
        this.idPareo = idPareo;
    }

    public int getNrPareo() {
        return nrPareo;
    }

    public void setNrPareo(int nrPareo) {
        this.nrPareo = nrPareo;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getBolsa() {
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public int getP4() {
        return p4;
    }

    public void setP4(int p4) {
        this.p4 = p4;
    }

    public int getP5() {
        return p5;
    }

    public void setP5(int p5) {
        this.p5 = p5;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getMovPareo() {
        return movPareo;
    }

    public void setMovPareo(int movPareo) {
        this.movPareo = movPareo;
    }

    public String getTempoVencedor() {
        return tempoVencedor;
    }

    public void setTempoVencedor(String tempoVencedor) {
        this.tempoVencedor = tempoVencedor;
    }

    public float getTimeWinner() {
        return timeWinner;
    }

    public void setTimeWinner(float timeWinner) {
        this.timeWinner = timeWinner;
    }

    public String getPenetrometro() {
        return penetrometro;
    }

    public void setPenetrometro(String penetrometro) {
        this.penetrometro = penetrometro;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getChamada() {
        return chamada;
    }

    public void setChamada(String chamada) {
        this.chamada = chamada;
    }

    public Integer getIdDoPrograma() {
        return idDoPrograma;
    }

    public void setIdDoPrograma(Integer idDoPrograma) {
        this.idDoPrograma = idDoPrograma;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public String getListaIdsCompetidores() {
        return listaIdsCompetidores;
    }

    public void setListaIdsCompetidores(String listaIdsCompetidores) {
        this.listaIdsCompetidores = listaIdsCompetidores;
    }

    public List<Competidor> getCompetidores() {
        return competidores;
    }

    @Override
    public String toString() {
        return "\nPareo{" +
                "idPareo=" + idPareo +
                ", nrPareo=" + nrPareo +
                ", ordem=" + ordem +
                ", prova='" + prova + '\'' +
                ", pista='" + pista + '\'' +
                ", distancia=" + distancia +
                "\n bolsa=" + bolsa +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                ", p5=" + p5 +
                ", bonus=" + bonus +
                ", movPareo=" + movPareo +
                "\n listaIdsCompetidores='" + listaIdsCompetidores + '\'' +
                "\n tempoVencedor='" + tempoVencedor + '\'' +
                ", timeWinner=" + timeWinner +
                ", penetrometro='" + penetrometro + '\'' +
                ", cp='" + cp + '\'' +
                "\n chamada='" + chamada + '\'' +
                "\n idDoPrograma=" + idDoPrograma +
                "\n programa=" + programa +
                "\n competidores=" + competidores +
                '}';
    }
}
