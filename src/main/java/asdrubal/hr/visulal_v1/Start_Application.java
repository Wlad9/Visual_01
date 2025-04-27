package asdrubal.hr.visulal_v1;

import asdrubal.hr.visulal_v1.Telas.TelaInicial_01;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.painel_Inicial.TelaInicial;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.PareoService;
import asdrubal.hr.visulal_v1.services.ProgramaService;
import asdrubal.hr.visulal_v1.services.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.List;

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

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(Start_Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<ProgramaDTO> programasOpen = programaService.findByProgOpen();

        SwingUtilities.invokeLater(() -> {
            TelaInicial inicial = new TelaInicial(programasOpen, pareoService, competidorService, tempService);

//            TelaInicial_01 inicial01 = new TelaInicial_01(programasOpen, pareoService, competidorService, tempService);// está ok
//        PainelPareos painelPareos = new PainelPareos(pareoService, competidorService);
//        TelaInicial telaInicial = new TelaInicial(programasOpen, painelPareos);
//            Painel_Base painelBase = new Painel_Base(pareoService, competidorService);
//            TelaInicial telaInicial1 = new TelaInicial(programasOpen, painelBase);
        });
    }
}
