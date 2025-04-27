package asdrubal.hr.visulal_v1;

import asdrubal.hr.visulal_v1.classes_auxiliares.Constantes;
import asdrubal.hr.visulal_v1.dto_especiais.DTO_TabelaCompetidores;
import asdrubal.hr.visulal_v1.montadores.CompetidoresDoPareo;
import asdrubal.hr.visulal_v1.painel_pareos.Bt_PesquisaCompetidoresDoPareo;
import asdrubal.hr.visulal_v1.painel_pareos.IdentificaCamposDaTabela;
import asdrubal.hr.visulal_v1.services.CompetidorService;
import asdrubal.hr.visulal_v1.services.PareoService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

import static asdrubal.hr.visulal_v1.classes_auxiliares.Constantes.DISTANCIAS_LISTA;
import static asdrubal.hr.visulal_v1.classes_auxiliares.Constantes.PISTAS_LISTA;

public class Painel_Base extends JPanel {
    private JButton bt_BuscaCavalos;
    private PareoService pareoService;
    private CompetidorService competidorService;
    private Integer idPareo = 0;
    private JTable competidoresTab;
    private JScrollPane scrollCompetidores;
    private int nrLinhasCompetidores;

    private JList<String> jlDistancias;
    private JScrollPane scrollDistancia;
    private JList<String> jlPistas;
    private JScrollPane scrollPista;

    public Painel_Base(PareoService pareoService, CompetidorService competidorService) {
        this.pareoService = pareoService;
        this.competidorService = competidorService;
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        bt_BuscaCavalos = new Bt_PesquisaCompetidoresDoPareo();
        bt_BuscaCavalos.setVisible(false);
        bt_BuscaCavalos.addActionListener(e -> abrirTabelaCavalosDoPareo(idPareo));
        add(bt_BuscaCavalos);

        competidoresTab = new JTable();
        scrollCompetidores = new JScrollPane(competidoresTab);
        scrollCompetidores.setVisible(false);
        add(scrollCompetidores);
//  Incluindo as JList
        jlDistancias = new JList<>();
        scrollDistancia = new JScrollPane(jlDistancias);
        scrollDistancia.setVisible(false);

        jlPistas = new JList<>();
        scrollPista = new JScrollPane(jlPistas);
        scrollPista.setVisible(false);

        add(scrollDistancia);
        add(scrollPista);
    }

    public void inicia(String listaIds) {
        removeAll(); // Limpa painel
        setLayout(null);
        revalidate();
        repaint();

        IdentificaCamposDaTabela colunasTab = new IdentificaCamposDaTabela(pareoService);
        Map<Integer, List<String>> mapaCampos = colunasTab.inicia1(listaIds);//Monta mapa de dados
        int nrLinhasPareo = mapaCampos.size();

        String[] colunasPareo = {"Ordem", "Prova", "Raia", "Bolsa R$"};

        DefaultTableModel TabPareos = new DefaultTableModel(colunasPareo, nrLinhasPareo);
        JTable tabelaDePareos = new JTable(TabPareos);
        tabelaDePareos.setFont(new Font("Arial", Font.PLAIN, 11)); // Fonte, estilo, tamanho
        tabelaDePareos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableColumnModel colModel = tabelaDePareos.getColumnModel();// alterando os campos da tabela
        colModel.getColumn(0).setPreferredWidth(80);
        colModel.getColumn(1).setPreferredWidth(120);
        colModel.getColumn(2).setPreferredWidth(90);
        colModel.getColumn(3).setPreferredWidth(90);

        tabelaDePareos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabelaDePareos.getSelectedRow() != -1) {
                String textoBotao = String.valueOf(tabelaDePareos.getValueAt(tabelaDePareos.getSelectedRow(), 0));
                bt_BuscaCavalos.setText(textoBotao);
                bt_BuscaCavalos.setVisible(true);
                idPareo = identificaIdDoPareo(textoBotao, mapaCampos);

                scrollCompetidores.setVisible(false);
                competidoresTab.setModel(new DefaultTableModel());
                competidoresTab.revalidate();
                competidoresTab.repaint();

                jlDistancias.setVisible(false);
                jlPistas.setVisible(false);
            }
        });

        for (int i = 0; i < nrLinhasPareo; i++) {
            List<String> itens = mapaCampos.get(i + 1);
            TabPareos.setValueAt(" " + (i + 1) + "º Páreo", i, 0);
            TabPareos.setValueAt(itens.get(0), i, 1);
            TabPareos.setValueAt(itens.get(1), i, 3);
            TabPareos.setValueAt(itens.get(2), i, 2);
        }

        JScrollPane scrollPareo = new JScrollPane(tabelaDePareos);
        int alturaPareo = tabelaDePareos.getRowHeight() * nrLinhasPareo + 24;
        scrollPareo.setBounds(10, 10, 400, alturaPareo);
        add(scrollPareo);

//  Adicinando o JButton
        bt_BuscaCavalos.setBounds(10, scrollPareo.getY() + scrollPareo.getHeight() + 5, 90, 20);
        add(bt_BuscaCavalos);


        int alturaComp = 20 * Math.max(1, nrLinhasCompetidores) + 24;
        scrollCompetidores.setBounds(10, bt_BuscaCavalos.getY() + bt_BuscaCavalos.getHeight() + 10, 400, alturaComp);
        scrollCompetidores.setVisible(false);
        add(scrollCompetidores);


        scrollDistancia.setBounds(10, scrollCompetidores.getY() + scrollCompetidores.getHeight() + 10, 80, 150);
        scrollPista.setBounds(100, scrollCompetidores.getY() + scrollCompetidores.getHeight() + 10, 80, 150);
        scrollDistancia.setVisible(true);
        scrollPista.setVisible(true);

        scrollCompetidores.revalidate();
        scrollCompetidores.repaint();

        revalidate(); // Adicionado para garantir que o layout seja recalculado
        repaint();    // Adicionado para garantir que a tela seja redesenhada
//        jlDistancias.setBounds(10, scrollCompetidores.getY() + scrollCompetidores.getHeight() + 10, 40, 150);
//        jlPistas.setBounds(60, scrollCompetidores.getY() + scrollCompetidores.getHeight() + 10, 40, 150);
//        add(scrollCompetidores);
//        add(jlDistancias);
//        add(jlPistas);
    }

    private void abrirTabelaCavalosDoPareo(Integer idPareo) {
        Map<String, DTO_TabelaCompetidores> mapaDadosCompetidores = new CompetidoresDoPareo().identificaCompetidores(idPareo, pareoService, competidorService);

        String[] colunasCompetidores = {"N°", "Cavalo", "Jóquei", "Treinador", "Nasc.", "Sx"};
        nrLinhasCompetidores = mapaDadosCompetidores.size();

        DefaultTableModel modeloComp = new DefaultTableModel(colunasCompetidores, 0);
        competidoresTab.setModel(modeloComp);
        competidoresTab.setFont(new Font("Arial", Font.PLAIN, 10));
        competidoresTab.setRowHeight(20);
        competidoresTab.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        competidoresTab.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        TableColumnModel cMode =  competidoresTab.getColumnModel();
        cMode.getColumn(0).setPreferredWidth(25);
        cMode.getColumn(1).setPreferredWidth(100);
        cMode.getColumn(2).setPreferredWidth(110);
        cMode.getColumn(3).setPreferredWidth(110);
        cMode.getColumn(4).setPreferredWidth(35);
        cMode.getColumn(5).setPreferredWidth(25);

        for (Map.Entry<String, DTO_TabelaCompetidores> entry : mapaDadosCompetidores.entrySet()) {
            DTO_TabelaCompetidores dto = entry.getValue();
            modeloComp.addRow(new Object[]{
                    entry.getKey(), dto.getCavalo(), dto.getJoquei(),
                    dto.getTreinador(), dto.getIdade(), dto.getSexo()
            });
        }

        competidoresTab.setModel(modeloComp);
        competidoresTab.setRowHeight(20);

        int alturaComp = competidoresTab.getRowHeight() * nrLinhasCompetidores + 24;
        scrollCompetidores.setBounds(10, bt_BuscaCavalos.getY() + bt_BuscaCavalos.getHeight() + 10, 400, alturaComp);
        scrollCompetidores.setVisible(true);

        jlDistancias.setVisible(true);
        jlPistas.setVisible(true);

        jlDistancias.setListData(DISTANCIAS_LISTA);
        jlPistas.setListData(PISTAS_LISTA);

        scrollDistancia.setVisible(true);
        scrollPista.setVisible(true);
        scrollCompetidores.revalidate();
        scrollCompetidores.repaint();

    }



    private Integer identificaIdDoPareo(String textoBotao, Map<Integer, List<String>> mapaCampos) {
        String nr = textoBotao.replaceAll("[^0-9]", "").trim();
        int ordem = Integer.parseInt(nr);
        List<String> valores = mapaCampos.get(ordem);
        return Integer.parseInt(valores.get(3));
    }
}