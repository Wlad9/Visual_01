package asdrubal.hr.visulal_v1;

import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.services.*;
import asdrubal.hr.visulal_v1.zV2_Versao2_Pagina1.Pagina_Inicial_v5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
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
    private IndicesGV_Service indicesGV_service;
    @Autowired
    private IndicesCJ_Service indicesCJ_service;
    @Autowired
    private IndicesRS_Service indicesRS_service;
    @Autowired
    private IndicesPR_Service indicesPR_service;
    @Autowired
    private IndicesOutrosService indicesOutrosService;
    @Autowired
    private CavaloService cavaloService;
    @Autowired
    private RaiaService raiaService;
    @Autowired
    private RegistroService registroService;
    @Autowired
    private AnaliseService analiseService;

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(Start_Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Map<Integer, ProgramaDTO> openPrograms = programaService.findByProgOpen();
//        for(Map.Entry<Integer, ProgramaDTO>entry: openPrograms.entrySet()){
//            System.out.println("\nId:"+ entry.getKey());
//            System.out.println("ProgDTO:"+ entry.getValue());
//        }

//        SwingUtilities.invokeLater(() -> {
//            TelaInicial inicial = new TelaInicial(openPrograms, pareoService, competidorService, tempService
//                    , indicesService, cavaloService, raiaService, registroService, analiseService);
//        });

//

        SwingUtilities.invokeLater(() -> {
            Pagina_Inicial_v5 paginaInicialv5 = new Pagina_Inicial_v5(openPrograms, pareoService, competidorService, tempService
                    , indicesService, cavaloService, raiaService, registroService, analiseService, indicesGV_service, indicesOutrosService,indicesCJ_service, indicesPR_service, indicesRS_service);
        });


    }
}
