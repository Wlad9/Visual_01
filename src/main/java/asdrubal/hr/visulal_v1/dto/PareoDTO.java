package asdrubal.hr.visulal_v1.dto;

import asdrubal.hr.visulal_v1.entities.Competidor;
import asdrubal.hr.visulal_v1.entities.Pareo;

import java.util.ArrayList;
import java.util.List;

public class PareoDTO {
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
    private String cp;//CP=Criado Por=>      0:ok    1:POGV/PORJ.pdf      2:RRGV.pdf      3: RRGV.xls     4:RT.pdf  5:Geral.xlsx
    private String chamada;
    private Integer idDoPrograma;  // Referência ao ProgramaDTO
    private ProgramaDTO programaDTO = new ProgramaDTO();
    private List<CompetidorDTO> competidoresDTOs = new ArrayList<>();
    private String listaIdsCompetidores;

    public PareoDTO insereCompetidoresDTO(List<CompetidorDTO> listaDTO) {
        if (listaDTO != null && !listaDTO.isEmpty()) {
            competidoresDTOs.addAll(new ArrayList<>(listaDTO));
        }
        return this;
    }

    public PareoDTO(Pareo entity) {
        idPareo = entity.getIdPareo();
        nrPareo = entity.getNrPareo();
        ordem = entity.getOrdem();
        prova = entity.getProva();
        listaIdsCompetidores = entity.getListaIdsCompetidores();
        pista = entity.getPista();
        distancia = entity.getDistancia();
        bolsa = entity.getDistancia();
        p1 = entity.getP1();
        p2 = entity.getP2();
        p3 = entity.getP3();
        p4 = entity.getP4();
        p5 = entity.getP5();
        bonus = entity.getBonus();
        movPareo = entity.getMovPareo();
        tempoVencedor = entity.getTempoVencedor();
        timeWinner = entity.getTimeWinner();
        penetrometro = entity.getPenetrometro();
        cp = entity.getCp();
        chamada = entity.getChamada();
        idDoPrograma = entity.getIdDoPrograma();
        programaDTO.setIdPrograma(entity.getIdDoPrograma());
        programaDTO.setData(entity.getPrograma().getData());
        programaDTO.setOrdProg(entity.getPrograma().getOrdProg());
        programaDTO.setSt(entity.getPrograma().getSt());
        programaDTO.setMovPrograma(entity.getPrograma().getMovPrograma());
        programaDTO.setHipodromoCod(entity.getPrograma().getHipodromoCod());
        programaDTO.setStringIds(entity.getPrograma().getStringIds());
//        Programa programa = entity.getPrograma();
//        if(programa != null){
//            this.programaDTO.setIdPrograma(programa.getIdPrograma());
//            this.programaDTO.setData(programa.getData());
//            this.programaDTO.setOrdProg(programa.getOrdProg());
//            this.programaDTO.setHipodromoCod(programaDTO.getHipodromoCod());
//            this.programaDTO.setMovPrograma(programa.getMovPrograma());
//            this.programaDTO.setSt(programa.getSt());
//            this.programaDTO.setStringIds(programa.getStringIds());
//        }
        competidoresDTOs = montaListaCompetidores(entity.getCompetidores());
        //TODO - corrigir a informação idDoPrograma
//        idDoPrograma = programaDTO.getIdPrograma();
    }

    private List<CompetidorDTO> montaListaCompetidores(List<Competidor> competidores) {
        List<CompetidorDTO> lista = new ArrayList<>();
        for (Competidor c : competidores) {
            CompetidorDTO competidorDTO = new CompetidorDTO(c);
            lista.add(competidorDTO);
        }
        return lista;
    }

    public PareoDTO() {
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

    public ProgramaDTO getProgramaDTO() {
        return programaDTO;
    }

    public void setProgramaDTO(ProgramaDTO programaDTO) {
        this.programaDTO = programaDTO;
    }

    public String getListaIdsCompetidores() {
        return listaIdsCompetidores;
    }

    public void setListaIdsCompetidores(String listaIdsCompetidores) {
        this.listaIdsCompetidores = listaIdsCompetidores;
    }

    public List<CompetidorDTO> getCompetidoresDTOs() {
        return competidoresDTOs;
    }

    @Override
    public String toString() {
        return "\nPareoDTO{" +
                "idPareo=" + idPareo +
                ", nrPareo=" + nrPareo +
                ", ordem=" + ordem +
                ", prova='" + prova + '\'' +
                ", pista='" + pista + '\'' +
                ", distancia=" + distancia +
                "\n listaIdsCompetidores='" + listaIdsCompetidores + '\'' +
                "\n bolsa=" + bolsa +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                ", p5=" + p5 +
                ", bonus=" + bonus +
                ", movPareo=" + movPareo +
                "\n tempoVencedor='" + tempoVencedor + '\'' +
                ", timeWinner=" + timeWinner +
                ", penetrometro='" + penetrometro + '\'' +
                ", cp='" + cp + '\'' +
                ", chamada='" + chamada + '\'' +
                ", idDoPrograma=" + idDoPrograma +
                "\n" + programaDTO +
                "\n competidoresDTOs=" + competidoresDTOs +
                '}';
    }
}
