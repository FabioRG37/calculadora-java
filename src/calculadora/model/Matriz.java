package calculadora.model;

import java.util.Arrays;

public class Matriz {
    private int[][] dados;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = new int[this.linhas][this.colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setElemento(int linha, int coluna, int valor) {
        this.dados[linha][coluna] = valor;
    }

    public int getElemento(int linha, int coluna) {
        return this.dados[linha][coluna];
    }

    public Matriz somar(Matriz outra) {
        if (this.linhas != outra.linhas || this.colunas != outra.colunas) {
            throw new IllegalArgumentException("As matrizes devem ter o mesmo tamanho para somar.");
        }

        Matriz resultado = new Matriz(linhas, colunas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado.setElemento(i, j, this.dados[i][j] + outra.getElemento(i, j));
            }
        }
        return resultado;
    }

    public Matriz subtrair(Matriz outra) {
        if (this.linhas != outra.linhas || this.colunas != outra.colunas) {
            throw new IllegalArgumentException("As matrizes devem ter o mesmo tamanho para subtrair.");
        }

        Matriz resultado = new Matriz(linhas, colunas);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado.setElemento(i, j, this.dados[i][j] - outra.getElemento(i, j));
            }
        }
        return resultado;
    }

    public Matriz multiplicar(Matriz outra) {
        if (this.colunas != outra.linhas) {
            throw new IllegalArgumentException(
                    "O número de colunas da primeira matriz deve ser igual ao número de linhas da segunda.");
        }

        Matriz resultado = new Matriz(this.linhas, outra.colunas);
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < outra.colunas; j++) {
                int soma = 0;
                for (int k = 0; k < this.colunas; k++) {
                    soma += this.dados[i][k] * outra.getElemento(k, j);
                }
                resultado.setElemento(i, j, soma);
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] linha : dados) {
            for (int elemento : linha) {
                sb.append(elemento).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
