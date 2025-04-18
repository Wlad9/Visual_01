package asdrubal.hr.visulal_v1;

import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.frame1.TelaInicial;
import asdrubal.hr.visulal_v1.painel_pareos.PainelPareos;
import asdrubal.hr.visulal_v1.repositoreis.CompetidorRepository;
import asdrubal.hr.visulal_v1.services.PareoService;
import asdrubal.hr.visulal_v1.services.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Start_Application implements CommandLineRunner {
    @Autowired
    private ProgramaService programaService;
    @Autowired
    private PareoService pareoService;
    @Autowired
    private CompetidorRepository competidorRepository;

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(Start_Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<ProgramaDTO> programasOpen = programaService.findByProgOpen();
        PainelPareos painelPareos = new PainelPareos(pareoService);
        TelaInicial telaInicial = new TelaInicial(programasOpen, painelPareos);
    }
}
