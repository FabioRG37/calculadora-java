package calculadora;

import java.util.Scanner;

public class Menu {
    private Operacoes operacoes;
    private Scanner scanner;

    public Menu() {
        this.operacoes = new Operacoes();
        this.scanner = new Scanner(System.in);
    }

    private double realizaOperacao(String operacao, double numero1, double numero2) {
        switch (operacao) {
            case "+":
                return operacoes.soma(numero1, numero2);
            case "-":
                return operacoes.subtrai(numero1, numero2);
            case "/":
                return operacoes.divide(numero1, numero2);
            case "*":
                return operacoes.multiplica(numero1, numero2);
            default:
                throw new IllegalArgumentException("Operação inválida!");
        }
    }

    public void exibirMenu(){
        System.out.println("Escolha uma operação: ");
        System.out.println("+ (Soma)");
        System.out.println("- (Subtração)");
        System.out.println("* (Multiplicação)");
        System.out.println("/ (Divisão)");
        System.out.print(">>: ");
        String operacao = scanner.nextLine();

        System.out.println("Digite o primeiro número");
        System.out.print(">>: ");
        double numero1 = scanner.nextDouble();

        System.out.println("Digite o segundo número");
        System.out.print(">>: ");
        double numero2 = scanner.nextDouble();

        double resultado = realizaOperacao(operacao, numero1, numero2);
        System.out.println("O resultado da operação é: " + resultado);
    }
}
