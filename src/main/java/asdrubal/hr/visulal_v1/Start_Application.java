package asdrubal.hr.visulal_v1;

import asdrubal.hr.visulal_v1.Telas.TelaInicial_01;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.pagina_02.Pagina_02;
import asdrubal.hr.visulal_v1.pagina_03.Pagina_03;
import asdrubal.hr.visulal_v1.painel_Inicial.TelaInicial;
import asdrubal.hr.visulal_v1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Start_Application implements CommandLineRunner {
    @Autowired
    private ProgramaService programaService;
    @Autowired
    private PareoService pareoService;
    @Autowired
    private CompetidorService competidorService;
    @Autowired
    private TempService tempService;
    @Autowired
    private IndicesService indicesService;
    @Autowired
    private CavaloService cavaloService;

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(Start_Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Map<Integer, ProgramaDTO> openPrograms = programaService.findByProgOpen();
        SwingUtilities.invokeLater(() -> {
//            Pagina_02 pg2 = new Pagina_02();
//            Pagina_03 pagina_03 = new Pagina_03();
//
            TelaInicial inicial = new TelaInicial(openPrograms, pareoService, competidorService, tempService, indicesService, cavaloService);

//            TelaInicial_01 inicial01 = new TelaInicial_01(programasOpen, pareoService, competidorService, tempService);// está ok
//        PainelPareos painelPareos = new PainelPareos(pareoService, competidorService);
//        TelaInicial telaInicial = new TelaInicial(programasOpen, painelPareos);
//            Painel_Base painelBase = new Painel_Base(pareoService, competidorService);
//            TelaInicial telaInicial1 = new TelaInicial(programasOpen, painelBase);
        });
    }
}
