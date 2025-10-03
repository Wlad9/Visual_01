package asdrubal.hr.visulal_v1.registro;

import asdrubal.hr.visulal_v1.classes_auxiliares.ConverteBiParaUniDimencional;
import asdrubal.hr.visulal_v1.dto.Analise_DTO;
import asdrubal.hr.visulal_v1.dto.Registro_DTO;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_JT_tabPareos;
import asdrubal.hr.visulal_v1.registro.classes_aux.MontaRegistroDTO;
import asdrubal.hr.visulal_v1.registro.classes_aux.MontaTextoRegistro;
import asdrubal.hr.visulal_v1.registro.components.Tabela_CavalosDoPareo;
import asdrubal.hr.visulal_v1.services.AnaliseService;
import asdrubal.hr.visulal_v1.services.RegistroService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaDeRegistro extends JFrame {
    private final Object[][] dadosCavalosDoPareo;
    private final DTO_JT_tabPareos dtoJtPareos;
    private final RegistroService registroService;
    private final AnaliseService analiseService;
    private JPanel contentPane;
    private JPanel jp_Painel_1;
    private JScrollPane js_painel_1;
    private JTable tb_CavalosDoPareo;
    private JButton bt_Registrar;
    private JTextArea textArea1;
    private JPanel jp_Registro2;
    private JScrollPane js2;
    private JPanel jp_JP2;
    private JLabel lb_Lb1;
    private JLabel lb_Lb2;
    private JButton jb_Select;
    private JButton jb_Descartar;
    private JButton jb_Save;
    private JLabel lb_Lb3;
    private JTextArea jtA_Descricao;
    private JRadioButton rbPositivo;
    private JRadioButton rbNegativo;
    private JCheckBox cbUm;
    private JCheckBox cbDois;
    private JButton jb_Fim;
    private JCheckBox cbZero;
    private String[] titulo1 = new String[]{"N°", "Cavalo", "Joquei", "Treinador", "Idade", " Sx"};
    private Object[] dadosDaLinhaSelec;
    private Integer idCavaloSelec;
    private int pontuacao = 0;

    private Registro_DTO rDTO;
    private Analise_DTO aDTO;
    private List<Analise_DTO> listaAnalies;


    public TelaDeRegistro(Object[][] dadosCavalosDoPareo, DTO_JT_tabPareos dtoJtPareos, RegistroService registroService, AnaliseService analiseService) {
        this.dadosCavalosDoPareo = dadosCavalosDoPareo;
        this.dtoJtPareos = dtoJtPareos;
        this.registroService = registroService;
        this.analiseService = analiseService;
        setContentPane(contentPane);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        montaTabela_CavalosDoPareo();
        jb_Descartar.setEnabled(false);
        jb_Save.setEnabled(false);
        rDTO = new Registro_DTO();
        listaAnalies = new ArrayList<>();

//  Listener botão Analisar
        jb_Select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBtAvaliar();
            }
        });

//  Listenr botão Salvar
        jb_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBtSalvarRegistro();
            }
        });
//  Listener CheckBox Pontuação valor Um Ponto
        cbUm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pontuacao = 1;
                cbDois.setSelected(false);
            }
        });
//  Listener CheckBox Pontuação valor Dois Pontos
        cbDois.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pontuacao = 2;
                cbUm.setSelected(false);
            }
        });
////  Listener CheckBox Pontuação valor Zero de pontuação
//        cbZero.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cbUm.setSelected(false);
//                cbDois.setSelected(false);
//                pontuacao = 0;
//            }
//        });

        this.setVisible(true);
        this.revalidate();
        this.repaint();

    }


    private void listenerBtAvaliar() {
        aDTO = new Analise_DTO();
        jb_Save.setEnabled(true);
        jb_Descartar.setEnabled(true);
        int linhaSelec = tb_CavalosDoPareo.getSelectedRow();
        ConverteBiParaUniDimencional converte = new ConverteBiParaUniDimencional();
        dadosDaLinhaSelec = converte.converteMk1(tb_CavalosDoPareo, linhaSelec);
        MontaTextoRegistro mtr = new MontaTextoRegistro(dadosDaLinhaSelec, dtoJtPareos);
        String cavalo = mtr.texto1();
        lb_Lb1.setText(" Descreva as observações sobre o cavalo:");
        lb_Lb3.setText(cavalo);
        lb_Lb2.setText(mtr.getMsg2());
        lb_Lb1.setVisible(true);
        lb_Lb2.setVisible(true);

        idCavaloSelec = (Integer) dadosCavalosDoPareo[linhaSelec][6];
        String joquei = dadosCavalosDoPareo[linhaSelec][2].toString();
        aDTO.setCavalo(cavalo.trim());
        aDTO.setJoquei(joquei);
        aDTO.setIdCavalo(idCavaloSelec);

    }

    private void listenerBtSalvarRegistro() {

        jb_Save.setEnabled(false);
        jb_Descartar.setEnabled(false);
        String texto = jtA_Descricao.getText();
        System.out.println("Texto==>"+ texto);
        if (rDTO == null) {
            MontaRegistroDTO montaRdto = new MontaRegistroDTO();
            rDTO = montaRdto.inicia(dadosDaLinhaSelec, dtoJtPareos, idCavaloSelec);
            rDTO = registroService.criaRegistro(rDTO);
        }
        aDTO.setDescricao(jtA_Descricao.getText());
        if(rbPositivo.isSelected()){
            if(cbUm.isSelected()){
                aDTO.setPontuacao(1);
            }else if(cbDois.isSelected()){
                aDTO.setPontuacao(2);
            }//TODO construir msg informando que não foi selecionado nenhum cb
        }
        if(rbNegativo.isSelected()){
            if(cbUm.isSelected()){
                aDTO.setPontuacao(-1);
            }else if(cbDois.isSelected()){
                aDTO.setPontuacao(-2);
            }//TODO construir msg informando que não foi selecionado nenhum cb
        }
        listaAnalies.add(aDTO);
        System.out.println("rdto:"+rDTO);
        System.out.println("Adto:"+aDTO);

//        aDTO.setRegistro(rDTO.getIdRegistro());
    }

    private void montaTabela_CavalosDoPareo() {
        tb_CavalosDoPareo = new Tabela_CavalosDoPareo(dadosCavalosDoPareo, titulo1);
        tb_CavalosDoPareo.setRowSelectionAllowed(true);

        js_painel_1.setViewportView(tb_CavalosDoPareo);
        contentPane.revalidate();
        contentPane.repaint();
    }
}
