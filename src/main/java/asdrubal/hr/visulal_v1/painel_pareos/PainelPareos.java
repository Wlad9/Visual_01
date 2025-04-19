package asdrubal.hr.visulal_v1.painel_pareos;

import asdrubal.hr.visulal_v1.montadores.CompetidoresDoPareo;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.PareoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;
import java.util.Map;


public class PainelPareos extends JPanel {
    private final JPanel jp_Pareos; // Painel onde as tabelas serão empilhadas
    private JButton bt_BuscaCavalos;
    private PareoService pareoService;
    private CompetidorService competidorService;
    private Integer idPareo = 0;

    public PainelPareos(PareoService pareoService, CompetidorService competidorService) {
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        setBackground(Color.RED);
        setLayout(new BorderLayout());

        jp_Pareos = new JPanel();
        jp_Pareos.setBackground(Color.YELLOW); // Fundo do painel interno que está no scroll
        jp_Pareos.setOpaque(true); // ✅ necessário para cor de fundo aparecer
        jp_Pareos.setLayout(new BoxLayout(jp_Pareos, BoxLayout.Y_AXIS));
//        jp_Pareos.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(jp_Pareos);
        scrollPane.setPreferredSize(new Dimension(420, 500));
        add(scrollPane, BorderLayout.CENTER);

        JPanel jP_PesqCompetidores = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        jP_PesqCompetidores.setBackground(Color.GREEN);
        jP_PesqCompetidores.setOpaque(false);

//  Incluir Bt_PesquisaCompetidoresDoPareo
        bt_BuscaCavalos = new Bt_PesquisaCompetidoresDoPareo();
        bt_BuscaCavalos.setVisible(false);
        bt_BuscaCavalos.addActionListener(e -> {
            abrirTabelaCavalosDoPareo(idPareo);
        });

        jP_PesqCompetidores.add(bt_BuscaCavalos);
        add(jP_PesqCompetidores, BorderLayout.SOUTH);

    }

    public void inicia(String listaIds) {
        jp_Pareos.removeAll();
        jp_Pareos.revalidate();
        jp_Pareos.repaint();
        IdentificaCamposDaTabela colunasTab = new IdentificaCamposDaTabela(pareoService);
        Map<Integer, List<String>> mapaCampos = colunasTab.inicia1(listaIds);//Monta mapa de dados
        int nrLinhas = mapaCampos.size();
        String[] colunas = {"Ordem", "Prova", "Raia", "Bolsa R$"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, nrLinhas);
        JTable tabela = new JTable(modelo);
        tabela.setFont(new Font("Arial", Font.PLAIN, 11)); // Fonte, estilo, tamanho
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumnModel colModel = tabela.getColumnModel();// alterando os campos da tabela
        colModel.getColumn(0).setPreferredWidth(80);
        colModel.getColumn(1).setPreferredWidth(120);
        colModel.getColumn(2).setPreferredWidth(90);
        colModel.getColumn(3).setPreferredWidth(90);
        tabela.setPreferredScrollableViewportSize(new Dimension(400, tabela.getRowHeight() * nrLinhas));
        tabela.setFillsViewportHeight(true);
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() != -1) {
                String textoBotao = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 0));
                bt_BuscaCavalos.setText(textoBotao);
                bt_BuscaCavalos.setVisible(true);
                idPareo = identificaIdDoPareo(textoBotao, mapaCampos);
            }
        });
        JLabel titulo = new JLabel("Páreo - " + listaIds);
        titulo.setFont(new Font("Arial", Font.BOLD, 11));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);


        for (int i = 0; i < nrLinhas; i++) {
            List<String> itens = mapaCampos.get(i + 1);
            modelo.setValueAt(" " + (i + 1) + "º Páreo", i, 0);
            modelo.setValueAt(itens.get(0), i, 1);
            modelo.setValueAt(itens.get(1), i, 3);
            modelo.setValueAt(itens.get(2), i, 2);
        }
        // Insere a tabela com scroll
        JScrollPane tabelaScroll = new JScrollPane(tabela);
        tabelaScroll.setPreferredSize(new Dimension(400, tabela.getRowHeight() * nrLinhas + 24)); // inclui cabeçalho
        tabelaScroll.setAlignmentX(Component.LEFT_ALIGNMENT);

// Novo: encapsula o scroll dentro de um wrapper para controlar o tamanho
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        wrapper.setOpaque(false);
        wrapper.add(tabelaScroll);
//  Novo JPanel para o botão de pesquisar competidores
        JPanel jP_PesqCompetidores = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        jP_PesqCompetidores.setOpaque(false);
        jP_PesqCompetidores.setAlignmentX(Component.LEFT_ALIGNMENT);
        jP_PesqCompetidores.add(bt_BuscaCavalos);

        jp_Pareos.add(Box.createVerticalStrut(10));
        jp_Pareos.add(titulo);
        jp_Pareos.add(wrapper);
        jp_Pareos.add(jP_PesqCompetidores);
        revalidate();
        repaint();
    }


    private void abrirTabelaCavalosDoPareo(Integer idPareo) {
        // ação a ser executada
        System.out.println("Pesquisar competidores do Páreo:" + idPareo);
        CompetidoresDoPareo comp = new CompetidoresDoPareo();
//        List<String> dadosCompetidores = comp.identificaCompetidores(idPareo, pareoService, competidorService);
    }

    private Integer identificaIdDoPareo(String textoBotao, Map<Integer, List<String>> mapaCampos) {
        String nr = textoBotao.replaceAll("[^0-9]", "").trim();
        int ordem = Integer.parseInt(nr);
        List<String> valores = mapaCampos.get(ordem);
        int cont = 0;
        for (String str : valores) {
            System.out.println(cont++ + ">" + str);
        }
        return Integer.parseInt(valores.get(3));
    }
}