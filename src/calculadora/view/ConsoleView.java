package calculadora.view;

import calculadora.model.Fracao;
import calculadora.model.Matriz;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Escolha o tipo de operação:");
        System.out.println("1. Operações com Decimais");
        System.out.println("2. Operações com Frações");
        System.out.println("3. Operações com Matrizes");
        System.out.println("4. Expressões");
        System.out.println("5. Salvar Histórico");
        System.out.println("6. Limpar Histórico");
        System.out.println("7. Carregar Histórico");
        System.out.print(">>: ");
    }

    public void exibirMenuOperacoesDecimais() {
        System.out.println("Escolha uma operação com decimais: +, -, *, /, ^, v, %");
        System.out.println("+ (Soma)");
        System.out.println("- (Subtração)");
        System.out.println("* (Multiplicação)");
        System.out.println("/ (Divisão)");
        System.out.println("^ (Potenciação)");
        System.out.println("v (Radiciação)");
        System.out.println("% (Módulo)");
        System.out.print(">>: ");
    }

    public void exibirMenuOperacoesFracao() {
        System.out.println("Escolha uma operação com frações: +, -, *, /");
        System.out.println("+ (Soma)");
        System.out.println("- (Subtração)");
        System.out.println("* (Multiplicação)");
        System.out.println("/ (Divisão)");
        System.out.print(">>: ");
    }

    public void exibirMenuOperacoesMatrizes() {
        System.out.println("Escolha uma operação com matrizes: +, -, *");
        System.out.println("+ (Soma)");
        System.out.println("- (Subtração)");
        System.out.println("* (Multiplicação)");
        System.out.print(">>: ");
    }

    public int obterTipoOperacao() {
        return scanner.nextInt();
    }

    public String obterOperacao() {
        return scanner.nextLine();
    }

    public int obterNumerador(String descricao) {
        System.out.printf("Digite o numerador da %s fração:%n", descricao);
        System.out.print(">>: ");
        return scanner.nextInt();
    }

    public int obterDenominador(String descricao) {
        System.out.printf("Digite o denominador da %s fração:%n", descricao);
        System.out.print(">>: ");
        return scanner.nextInt();
    }

    public boolean continuar() {
        this.exibirMensagem("Deseja realizar outra operação? (s/n)");
        System.out.print(">>: ");
        boolean response = scanner.next().equalsIgnoreCase("s");
        return response;
    }

    public double obterNumero(String descricao) {
        while (true) {
            try {
                System.out.printf("Digite o(a) %S:%n", descricao);
                System.out.print(">>: ");
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            }
        }
    }

    public int obterDimensao(String tipo, String descricao) {
        System.out.printf("Digite o numero de %s da %s matriz:%n",tipo , descricao);
        System.out.print(">>: ");
        return scanner.nextInt();
    }

    public void obterElementosMatriz(Matriz matriz, String descricao) {
        System.out.printf("Digite os elementos da %s matriz:%n", descricao);
        for (int i = 0; i < matriz.getLinhas(); i++) {
            for (int j = 0; j < matriz.getColunas(); j++) {
                System.out.printf("Elemento [%d][%d]: ", i + 1, j + 1);
                matriz.setElemento(i, j, scanner.nextInt());
            }
        }
    }

    public String obterExpressao() {
        System.out.println("Digite a expressão a ser calculada (use parênteses e operadores)");
        System.out.print(">>: ");
        return scanner.nextLine();
    }

    public String obterNomeArquivo(String acao) {
        System.out.printf("Digite o nome do arquivo para %s (com extensão .txt).%n", acao);
        System.out.print(">>: ");
        return scanner.nextLine();
    }

    public void exibirResultadoDecimal(double resultado) {
        System.out.printf("O resultado da operação é: %.2f%n", resultado);
    }

    public void exibirResultadoFracao(Fracao resultado) {
        System.out.println("O resultado da operação com frações é: " + resultado);
    }

    public void exibirResultadoMatriz(Matriz m1, Matriz m2, String op, Matriz result) {
        System.out.printf("O resultado da operação '%s' com as matrizes:%nMatriz 1:%n%s%nMatriz 2:%n%s%nResultado:%n%s",op, m1, m2, result);
    }

    public void exibirResultadoExpressao(String expressao, double resultado){
        System.out.printf("O resultado da expressão %s é %s%n", expressao, resultado);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirHistorico(List<String> historico) {
        System.out.println("\nHistórico de operações carregadas:");
        for (String operacao : historico) {
            System.out.println(operacao);
        }
    }

    public void limparBuffer() {
        scanner.nextLine();
    }
}
