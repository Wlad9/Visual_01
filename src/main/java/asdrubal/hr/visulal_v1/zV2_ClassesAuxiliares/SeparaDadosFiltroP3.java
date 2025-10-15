package asdrubal.hr.visulal_v1.zV2_ClassesAuxiliares;

import java.util.ArrayList;
import java.util.List;

public class SeparaDadosFiltroP3 {
    private final Object[][] dados;

    public SeparaDadosFiltroP3(Object[][] dados) {
        this.dados = dados;
    }

    public Object[][] aplicaFiltroSoGrama() {
        List<Object[]> linhasFiltradas = new ArrayList<>();
        if (dados == null) {
            return new Object[0][0]; // Retorna array vazio se os dados forem nulos
        }
        for (int i = 0; i < dados.length; i++) {
            Object[] linhaAtual = dados[i];

            // Verifica se a linha tem colunas suficientes antes de acessar os índices
            if (linhaAtual.length < 3) {
                continue;
            }

            Object obj0 = linhaAtual[0]; // Coluna 0: [1 - VIENNA FREUD] ou [,
            Object obj2 = linhaAtual[2]; // Coluna 2: [null] ou [GL2000]

            boolean deveIncluir = false;

            // -----------------------------------------------------------
            // 1. Filtro de Início de Grupo (ex: "1 - VIENNA FREUD")
            // Identifica se a coluna 0 é uma String que começa com "NÚMERO - "
            if (obj0 instanceof String) {
                String str0 = ((String) obj0).trim();
                // Verifica o padrão de cabeçalho: NÚMERO - NOME
                if (str0.matches("^\\d+\\s-\\s.*")) {
                    deveIncluir = true;
                }
            }

            // -----------------------------------------------------------
            // 2. Filtro de Linhas de Dados (Colunas 2 contendo 'G')
            if (!deveIncluir && obj2 instanceof String) {
                String raia = ((String) obj2).trim().toUpperCase();
                if (raia.contains("G")) {
                    deveIncluir = true;
                }
            }

            // -----------------------------------------------------------
            // 3. Filtro de Final de Grupo (Linhas em branco)
            // Coluna 0 é nula OU é uma String vazia
            if (!deveIncluir) {
                if (obj0 == null || (obj0 instanceof String && ((String) obj0).trim().isEmpty())) {
                    deveIncluir = true;
                }
            }

            // -----------------------------------------------------------
            // Se a linha passou em qualquer um dos filtros, adiciona ao resultado.
            if (deveIncluir) {
                // Adiciona a linha (o array de Object) diretamente
                linhasFiltradas.add(linhaAtual);
            }
        }

        // 3. Converte a lista de Object[] para o array final Object[][]
        return linhasFiltradas.toArray(new Object[0][0]);
    }

    public Object[][] aplicaFiltroSoAreia() {
        List<Object[]> linhasFiltradas = new ArrayList<>();
        if (dados == null) {
            return new Object[0][0]; // Retorna array vazio se os dados forem nulos
        }
        for (int i = 0; i < dados.length; i++) {
            Object[] linhaAtual = dados[i];
            if (linhaAtual.length < 3) {
                continue;
            }
            Object obj0 = linhaAtual[0]; // Coluna 0: [1 - VIENNA FREUD] ou [,
            Object obj2 = linhaAtual[2]; // Coluna 2: [null] ou [GL2000]
            boolean deveIncluir = false;
            if (obj0 instanceof String) {
                String str0 = ((String) obj0).trim();
                if (str0.matches("^\\d+\\s-\\s.*")) {
                    deveIncluir = true;
                }
            }
            if (!deveIncluir && obj2 instanceof String) {
                String raia = ((String) obj2).trim().toUpperCase();
                if (raia.contains("A")) {
                    deveIncluir = true;
                }
            }
            if (!deveIncluir) {
                if (obj0 == null || (obj0 instanceof String && ((String) obj0).trim().isEmpty())) {
                    deveIncluir = true;
                }
            }
            if (deveIncluir) {
                linhasFiltradas.add(linhaAtual);
            }
        }
        return linhasFiltradas.toArray(new Object[0][0]);
    }
}
