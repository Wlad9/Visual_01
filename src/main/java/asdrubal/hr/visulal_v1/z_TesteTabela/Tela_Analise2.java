package asdrubal.hr.visulal_v1.z_TesteTabela;

import asdrubal.hr.visulal_v1.TitulosDasColunas.TitulosDados1;
import asdrubal.hr.visulal_v1.classes_auxiliares.CapturaLinhasMarcadasNaTabela;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.objetos.ObjetoAlfa;
import asdrubal.hr.visulal_v1.show.ShowDadosTipo_2;
import asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2.AlteraObjetoDados;
import asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2.Tabela_00;
import asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2.Tabela_01;
import asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2.Tabela_01v2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Tela_Analise2 extends JFrame {
    private final Object[][] dados;
    private final Map<Integer, List<CompetidorDTO>> mapa;
    private final Map<String, IndicesDTO> indices;
    private JTable tb00;
    private JPanel jp0_0;
    private JPanel jp0_1;
    private JScrollPane js00;
    private JTable jt01;
    private JScrollPane js01;
    private JList lst_Pistas;
    private JList lst_Distancias;
    private JList lst_Years;
    private JButton jb_Show;
    private JButton jb_OrdTempo;
    private JButton jb_OrdData;
    private JPanel contentPane;
    private JPanel jp1_0;
    private JScrollPane jscrollPista;
    private JScrollPane js_Distancias;
    private JScrollPane js_Years;
    private JPanel jpBotoes;
    private JButton button1;

    public Tela_Analise2(Object[][] dadosCavalosDoPareo, Map<Integer, List<CompetidorDTO>> mapa3, Map<String, IndicesDTO> indices) {
        this.indices = indices;
        setContentPane(contentPane);
        dados = dadosCavalosDoPareo;
        mapa = mapa3;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iniciaTela();
        jb_Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBtPareos();
            }
        });
    }


    private void iniciaTela() {
        String[] titulos00 = new String[]{"Nr", "Cavalo", "Jóquei", "treinador", "Sexo"};
        AlteraObjetoDados altDados = new AlteraObjetoDados(dados);
        Object[][] dadosAlterados = altDados.retiraColuna4(dados, 4);
        tb00 = new Tabela_00(dadosAlterados, titulos00);
        js00.setViewportView(tb00);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    // Listener para o Botão Pareos------------------------------------------------------------------------
    private void listenerBtPareos() {
        List<String> pistasLista = lst_Pistas.getSelectedValuesList();
        List<String> distanciasLista = lst_Distancias.getSelectedValuesList();
        List<String> yearsLista = lst_Years.getSelectedValuesList();
        CapturaLinhasMarcadasNaTabela captura = new CapturaLinhasMarcadasNaTabela(tb00);
        List<Object[]> dadosLinhasSelec = captura.linhasSelecionadas_mk1();
//        ShowDadosTipo_1.show(dadosLinhasSelec);
        tb00.clearSelection();// Desmarca as linhas da tabela
        lst_Pistas.clearSelection();
        lst_Distancias.clearSelection();
        lst_Years.clearSelection();
        ObjetoAlfa alfa = new ObjetoAlfa();
        Object[][] dados1 = alfa.montaObjeto(dadosLinhasSelec, pistasLista, distanciasLista, yearsLista, mapa);
        ShowDadosTipo_2.showDadosTipo2(dados1,"->dadosA - Raia => Competidores");
        TitulosDados1 titulos1 = new TitulosDados1();
        Object[] titulosDados1 = titulos1.inicia();
        if (dados1.length == 0) {
            Object[] info = new Object[1];
            info[0] = "SEM DADOS1";
            jt01 = new Tabela_01(dados1, info, indices);
        } else {
            jt01 = new Tabela_01v2(dados1, titulosDados1, indices);
//            jt01 = new Tabela_01(dados1, titulosDados1, indices);
            js01.setViewportView(jt01);
            this.setVisible(true);
            this.revalidate();
            this.repaint();
        }
    }
}
