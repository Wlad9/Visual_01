package asdrubal.hr.visulal_v1.show;

import java.util.List;

public class ShowDadosTipo_1 {
    public static void show(List<Object[]> dados, String titulo) {
        System.out.println(titulo);
        for (int i = 0; i < dados.size(); i++) {
            Object[] linha = dados.get(i); // Pega o array de objetos que representa uma linha
            System.out.print("Linha " + (i + 1) + ": "); // Imprime o número da linha para referência
            // Verifica se a linha (o Object[]) é nula
            if (linha == null) {
                System.out.println("[Linha Nula]");
                continue; // Pula para a próxima linha da lista
            }
            // Itera sobre cada 'coluna' (elemento) dentro da linha atual
            for (int j = 0; j < linha.length; j++) {
                // Imprime o elemento, seguido de uma tabulação para formatação
                // Se o elemento for nulo, imprime "NULL" para clareza
                System.out.print((linha[j] != null ? linha[j] : "NULL") + (j == linha.length - 1 ? "" : "\t"));
            }
            System.out.println(); // Quebra de linha para a próxima linha de dados
        }
        System.out.println("--- Fim da Listagem de Dados ---");
    }
}