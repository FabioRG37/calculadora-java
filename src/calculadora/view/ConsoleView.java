package calculadora.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Escolha uma operação: +, -, *, /, ^, v, %");
        System.out.println("+ (Soma)");
        System.out.println("- (Subtração)");
        System.out.println("* (Multiplicação)");
        System.out.println("/ (Divisão)");
        System.out.println("^ (Potenciação)");
        System.out.println("v (Radiciação)");
        System.out.println("% (Módulo)");
        System.out.print(">>: ");
    }

    public String obterOperacao() {
        return scanner.nextLine();
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

    public void exibirResultado(double resultado) {
        System.out.printf("O resultado da operação é: %.2f", resultado);
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirHistorico(List<String> historico) {
        System.out.println("\nHistórico de operações:");
        for (String operacao : historico) {
            System.out.println(operacao);
        }
    }

    public void limparBuffer(){
        scanner.nextLine();
    }
}
