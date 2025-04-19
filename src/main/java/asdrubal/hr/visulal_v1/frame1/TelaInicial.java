package asdrubal.hr.visulal_v1.frame1;

import asdrubal.hr.visulal_v1.Painel_Base;
import asdrubal.hr.visulal_v1.dto.ProgramaDTO;
import asdrubal.hr.visulal_v1.painel_pareos.PainelPareos;
import asdrubal.hr.visulal_v1.services.PareoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelaInicial extends JFrame {
    @Autowired
    private PainelPareos painelPareos;

    @Autowired Painel_Base painelBase;

    @Autowired
    private PareoService pareoService;

    private final Map<Integer, ProgramaDTO> mapaProgramas = new HashMap<>();

    public TelaInicial(List<ProgramaDTO> programasOpen, PainelPareos painelPareos) {
        this.painelPareos = painelPareos;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setResizable(true);

        JMenuBar menu1 = new JMenuBar();
        JMenu programas = new JMenu("Programas");
        MontaItensDoMenu menu = new MontaItensDoMenu();
        if (programasOpen != null) {
            for (ProgramaDTO dto : programasOpen) {
                mapaProgramas.put(dto.getIdPrograma(), dto);
                JMenuItem item = new JMenuItem(menu.montaItemMenuPrograma(dto));
                item.setActionCommand(String.valueOf(dto.getIdPrograma()));

                item.addActionListener(e -> {
                    Integer idSelecionado = Integer.valueOf(e.getActionCommand());
                    ProgramaDTO programaSelecionado = mapaProgramas.get(idSelecionado);
                    String listaIds = programaSelecionado.getStringIds();
                    abrirPainelDePareos(listaIds);
                });
                programas.add(item);
                programas.addSeparator();
            }
        }
        JMenuItem itemSair = new JMenuItem("Fim");
        itemSair.addActionListener(e -> System.exit(0));
        programas.add(itemSair);

        menu1.add(programas);
        setJMenuBar(menu1);
        this.setVisible(true);
    }

    public TelaInicial(List<ProgramaDTO> programasOpen, Painel_Base painelBase) {
        this.painelBase = painelBase;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setResizable(true);

        JMenuBar menu1 = new JMenuBar();
        JMenu programas = new JMenu("Programas");
        MontaItensDoMenu menu = new MontaItensDoMenu();
        if (programasOpen != null) {
            for (ProgramaDTO dto : programasOpen) {
                mapaProgramas.put(dto.getIdPrograma(), dto);
                JMenuItem item = new JMenuItem(menu.montaItemMenuPrograma(dto));
                item.setActionCommand(String.valueOf(dto.getIdPrograma()));

                item.addActionListener(e -> {
                    Integer idSelecionado = Integer.valueOf(e.getActionCommand());
                    ProgramaDTO programaSelecionado = mapaProgramas.get(idSelecionado);
                    String listaIds = programaSelecionado.getStringIds();
                    abrirPainelBase(listaIds);// ação de abrir o painel base após clique no botão
                });
                programas.add(item);
                programas.addSeparator();
            }
        }
        JMenuItem itemSair = new JMenuItem("Fim");
        itemSair.addActionListener(e -> System.exit(0));
        programas.add(itemSair);

        menu1.add(programas);
        setJMenuBar(menu1);
        this.setVisible(true);
    }

    private void abrirPainelBase(String listaIds) {
        painelBase.inicia(listaIds);
        setContentPane(painelBase);
        revalidate();
        repaint();
    }

    private void abrirPainelDePareos(String listaIds) {
//        System.out.println("lista de ids selecionados:"+ listaIds);
        painelPareos.inicia(listaIds);
        setContentPane(painelPareos);
        revalidate();
        repaint();
    }
}

