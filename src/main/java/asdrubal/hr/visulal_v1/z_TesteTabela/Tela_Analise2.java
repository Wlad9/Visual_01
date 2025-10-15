package asdrubal.hr.visulal_v1.z_TesteTabela;

import asdrubal.hr.visulal_v1.TitulosDasColunas.TitulosDados1;
import asdrubal.hr.visulal_v1.TitulosDasColunas.TitulosDados2;
import asdrubal.hr.visulal_v1.classes_auxiliares.CapturaLinhasMarcadasNaTabela;
import asdrubal.hr.visulal_v1.corridas_na_mesma_raia.Alfa_MontaObjetoDaTabela;
import asdrubal.hr.visulal_v1.dto.CompetidorDTO;
import asdrubal.hr.visulal_v1.dto.IndicesDTO;
import asdrubal.hr.visulal_v1.estatisticas.Pistas_Estatistica;
import asdrubal.hr.visulal_v1.mesmo_pareo.DadosDaTabela_Montador;
import asdrubal.hr.visulal_v1.objetos.ObjetoFiltrado;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.RaiaService;
import asdrubal.hr.visulal_v1.show.ShowObjectBiDim;
import asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2.AlteraObjetoDados;
import asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2.Tabela_00;
import asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2.Tabela_01;
import asdrubal.hr.visulal_v1.z_TesteTabela.componentes_teste2.Tabela_01v2;
import asdrubal.hr.visulal_v1.z_painel_de_estatistica.PainelEstatistica_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tela_Analise2 extends JFrame {
    private final Object[][] dadosCavalosDoPareo;
    private Object[][] cavalosMesmoPareo;
    private final Map<Integer, List<CompetidorDTO>> mapa3;
    private final Map<String, IndicesDTO> indices;
    private final CompetidorService competidorService;
    private final RaiaService raiaService;
    private final int nrColFiltro = 11;
    private JTable tb00;
    private JPanel jp0_0;
    private JPanel jp0_1;
    private JScrollPane js00;
    private JTable jt01;
    private JScrollPane js01;
    private JList lst_Pistas;
    private JList lst_Distancias;
    private JList lst_Years;
    private JButton jb_Filtro;
    private JButton jb_OrdTempo;
    private JButton jb_OrdData;
    private JPanel contentPane;
    private JPanel jp1_0;
    private JScrollPane jscrollPista;
    private JScrollPane js_Distancias;
    private JScrollPane js_Years;
    private JPanel jpBotoes;
    private JButton jb_sameRun;
    private JButton jb_Estatistica;
    private JButton jb_concatenar;
//    private Map<Integer, List<Object[]>> dados3;

    public Tela_Analise2(Object[][] dadosCavalosDoPareo, Map<Integer, List<CompetidorDTO>> mapa3,
                         Map<String, IndicesDTO> indices, CompetidorService competidorService, RaiaService raiaService, String titPag) {
        this.indices = indices;
        this.competidorService = competidorService;
        this.raiaService = raiaService;
        setContentPane(contentPane);
        this.dadosCavalosDoPareo = dadosCavalosDoPareo;
//        ShowObjectBiDim.show(this.dadosCavalosDoPareo, "DadosCavalosDoPareo");
        this.mapa3 = mapa3;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(titPag);
        iniciaTela();

        jb_Filtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBtFiltro();
            }
        });
        jb_sameRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBtMesmoPareo();
            }
        });
        jb_Estatistica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBtEstatistica();
            }
        });
        jb_concatenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerBtConcatenar();
            }
        });
    }


    private void iniciaTela() {
        String[] titulos00 = new String[]{"Nr", "Cavalo", "Jóquei", "treinador", "Sexo"};
        AlteraObjetoDados altDados = new AlteraObjetoDados(dadosCavalosDoPareo);//retira a coluna com ano de nascimento
//        Object[][] dadosAlterados = altDados.retiraColuna4(dadosCavalosDoPareo, 4);
//        ShowObjectBiDim.show(dadosAlterados, "DADOS ALTERADOS");
//        tb00 = new Tabela_00(dadosAlterados, titulos00);
        tb00 = new Tabela_00(dadosCavalosDoPareo, titulos00);
        js00.setViewportView(tb00);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    // Listener para o Botão FILTRO-----------------------------------------------------------------------
    private void listenerBtFiltro() {
        List<String> pistasLista = lst_Pistas.getSelectedValuesList();
        List<String> distanciasLista = lst_Distancias.getSelectedValuesList();
        List<String> yearsLista = lst_Years.getSelectedValuesList();

        CapturaLinhasMarcadasNaTabela captura = new CapturaLinhasMarcadasNaTabela(tb00);
        List<Object[]> dadosLinhasSelec = captura.linhasSelecionadas_mk1();
        List<Object[]> dadosLS = incluiIdCavalo(dadosLinhasSelec);

        tb00.clearSelection();// Desmarca as linhas da tabela
        lst_Pistas.clearSelection();
        lst_Distancias.clearSelection();
        lst_Years.clearSelection();
        ObjetoFiltrado objF = new ObjetoFiltrado(mapa3, dadosCavalosDoPareo);
        Object[][] dadosF = objF.inicia(dadosLS, pistasLista, distanciasLista, yearsLista, nrColFiltro);
        TitulosDados1 titulos1 = new TitulosDados1();
        Object[] titulosDados1 = titulos1.inicia();

        setTabela(dadosF, titulosDados1, "Dados1");

    }

    private List<Object[]> incluiIdCavalo(List<Object[]> dadosLinhasSelec) {
        int t = dadosCavalosDoPareo.length;
        List<Object[]> listaObjts = new ArrayList<>();
        for (Object[] obj1 : dadosLinhasSelec) {
            int nrI = Integer.parseInt(obj1[0].toString());
            for (int j = 0; j < dadosCavalosDoPareo.length; j++) {
                int nrJ = Integer.parseInt(dadosCavalosDoPareo[j][0].toString());
                if (nrJ == nrI) {
                    Object[] obj = new Object[]{dadosCavalosDoPareo[j][0], dadosCavalosDoPareo[j][1], dadosCavalosDoPareo[j][6]};
                    listaObjts.add(obj);
                }
            }
        }
        return listaObjts;
    }

    // Listener para o Botão mesma corrida entre cavalos------------------------------------------------------------------------
    private void listenerBtMesmoPareo() {
        TitulosDados2 titulos2 = new TitulosDados2();
        Object[] titulosDados2 = titulos2.inicia();

        DadosDaTabela_Montador dtm = new DadosDaTabela_Montador(mapa3, dadosCavalosDoPareo);
        cavalosMesmoPareo = dtm.inicia();
        ShowObjectBiDim.show(cavalosMesmoPareo, "DADOS TIPO 2");
        setTabela(cavalosMesmoPareo, titulosDados2, "Dados2");
    }

    private void setTabela(Object[][] dados, Object[] titulosDados1, String tipo) {
        if (dados.length == 0) {
            Object[] info = new Object[1];
            info[0] = "SEM DADOS1";
            jt01 = new Tabela_01(dados, info, indices);
        } else {
            jt01 = new Tabela_01v2(dados, titulosDados1, indices, tipo);
            js01.setViewportView(jt01);
            this.setVisible(true);
            this.revalidate();
            this.repaint();
        }
    }

//  Listener para o Botão estatisticas------------------------------------------------------------------------
    private void listenerBtEstatistica() {
        Pistas_Estatistica estatisticas = new Pistas_Estatistica(competidorService, raiaService, mapa3);
        Map<Integer, List<Object[]>> mapaObjTotais = estatisticas.inicia(dadosCavalosDoPareo);
        PainelEstatistica_1 estatistica1 = new PainelEstatistica_1(mapaObjTotais, mapa3, dadosCavalosDoPareo);
        estatistica1.inicia();

    }
//----------------------------------------------------------------------------------------------------------------
//  Listener para botão concatenar corridas de cavalos que correram no memo pareo.----------
    private void listenerBtConcatenar() {
        List<String> pistasLista = lst_Pistas.getSelectedValuesList();
        List<String> distanciasLista = lst_Distancias.getSelectedValuesList();

        CapturaLinhasMarcadasNaTabela captura = new CapturaLinhasMarcadasNaTabela(tb00);
        List<Object[]> dadosLinhasSelec = captura.linhasSelecionadas_mk1();
        List<Object[]> dadosLS = incluiIdCavalo(dadosLinhasSelec);

        TitulosDados1 titulos1 = new TitulosDados1();
        Object[] titulosDados1 = titulos1.inicia();

        Alfa_MontaObjetoDaTabela alfaObj = new Alfa_MontaObjetoDaTabela(mapa3, dadosLS);
        Object[][] dados = alfaObj.inicia(pistasLista, distanciasLista);
//        ConcatCorridasMesmaRaia concat = new ConcatCorridasMesmaRaia(cavalosMesmoPareo);
//        Object[][] conkat = concat.inicia();
        setTabela(dados, titulosDados1, "Dados1");
    }
}
