package asdrubal.hr.visulal_v1.painel_pareos;

import asdrubal.hr.visulal_v1.dto.PareoDTO;
import asdrubal.hr.visulal_v1.services.PareoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;
import java.util.Map;


public class PainelPareos extends JPanel {
    private final JPanel conteudo; // Painel onde as tabelas serão empilhadas
    private PareoService pareoService;

    public PainelPareos(PareoService pareoService) {
        this.pareoService = pareoService;
        setBackground(new Color(59, 159, 168));
        setLayout(new BorderLayout());

        conteudo = new JPanel();
        conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
        conteudo.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(conteudo);
        scrollPane.setPreferredSize(new Dimension(420, 500));
        add(scrollPane, BorderLayout.CENTER);
    }

    public void inicia(String listaIds) {

        IdentificaCamposDaTabela colunasTab = new IdentificaCamposDaTabela(pareoService);
        Map<Integer, List<String>> mapaCampos = colunasTab.inicia1(listaIds);//Monta mapa
        int nrLinhas = mapaCampos.size();
        String[] colunas = {"Ordem", "Prova", "Raia", "Bolsa R$"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, nrLinhas);
        JTable tabela = new JTable(modelo);
        tabela.setFont(new Font("Arial", Font.PLAIN, 11)); // Fonte, estilo, tamanho
        TableColumnModel colModel = tabela.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(80);
        colModel.getColumn(1).setPreferredWidth(120);
        colModel.getColumn(2).setPreferredWidth(90);
        colModel.getColumn(3).setPreferredWidth(90);
        tabela.setPreferredScrollableViewportSize(new Dimension(400, tabela.getRowHeight() * nrLinhas));
        tabela.setFillsViewportHeight(true);

        JLabel titulo = new JLabel("Páreo - " + listaIds);
        titulo.setFont(new Font("Arial", Font.BOLD, 11));
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);


        for (int i = 0; i < nrLinhas; i++) {
            List<String> itens = mapaCampos.get(i+1);
            modelo.setValueAt(" " + (i + 1) + "º Páreo", i, 0);
            modelo.setValueAt(itens.get(0), i, 1);
            modelo.setValueAt(itens.get(1), i, 2);
            modelo.setValueAt(itens.get(2), i, 3);
        }
        // Insere a tabela com scroll
        JScrollPane tabelaScroll = new JScrollPane(tabela);
        tabelaScroll.setPreferredSize(new Dimension(400, tabela.getRowHeight() * nrLinhas + 24)); // inclui cabeçalho
        tabelaScroll.setAlignmentX(Component.LEFT_ALIGNMENT);

// Novo: encapsula o scroll dentro de um wrapper para controlar o tamanho
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        wrapper.setOpaque(false);
        wrapper.add(tabelaScroll);

        conteudo.add(Box.createVerticalStrut(10));
        conteudo.add(titulo);
        conteudo.add(Box.createVerticalStrut(5));
        conteudo.add(wrapper);
        revalidate();
        repaint();
    }
}