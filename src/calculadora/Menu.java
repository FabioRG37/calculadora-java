package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Operacoes operacoes;
    private Scanner scanner;
    private List<String> historico;

    public Menu() {
        this.operacoes = new Operacoes();
        this.scanner = new Scanner(System.in);
        this.historico = new ArrayList<>();
    }

    public void exibirMenu() {
        boolean continuar = true;
        while (continuar) {

            System.out.println("Escolha uma operação: +, -, *, /, ^, v, %");
            System.out.println("+ (Soma)");
            System.out.println("- (Subtração)");
            System.out.println("* (Multiplicação)");
            System.out.println("/ (Divisão)");
            System.out.println("^ (Potenciação)");
            System.out.println("v (Radiciação)");
            System.out.println("% (Módulo)");
            System.out.print(">>: ");
            String operacao = scanner.nextLine();

            double numero1 = 0, numero2 = 0, resultado = 0;
            boolean operacaoValida = true;

            switch (operacao) {
                case "+":
                    numero1 = obterNumero("primeiro");
                    numero2 = obterNumero("segundo");
                    resultado = operacoes.soma(numero1, numero2);
                    break;
                case "-":
                    numero1 = obterNumero("primeiro");
                    numero2 = obterNumero("segundo");
                    resultado = operacoes.subtrai(numero1, numero2);
                    break;
                case "/":
                    numero1 = obterNumero("primeiro");
                    numero2 = obterNumero("segundo");
                    resultado = operacoes.divide(numero1, numero2);
                    break;
                case "*":
                    numero1 = obterNumero("primeiro");
                    numero2 = obterNumero("segundo");
                    resultado = operacoes.multiplica(numero1, numero2);
                    break;
                case "^":
                    numero1 = obterNumero("base");
                    numero2 = obterNumero("expoente");
                    resultado = operacoes.potencia(numero1, numero2);
                    break;
                case "v":
                    numero1 = obterNumero("raís");
                    resultado = operacoes.raizQuadrada(numero1);
                    break;
                case "%":
                    numero1 = obterNumero("primeiro");
                    numero2 = obterNumero("segundo");
                    resultado = operacoes.modulo(numero1, numero2);
                    break;
                default:
                    System.out.println("Operação inválida!");
                    operacaoValida = false;
            }

            if (operacaoValida) {
                String entradaHistorico = String.format("Operação: %s, Números: %.2f e %.2f, Resultado: %.2f",
                        operacao, numero1, numero2, resultado);
                historico.add(entradaHistorico);
                System.out.println("O resultado da operação é: " + resultado);
            }
            System.out.println("Deseja realizar outra operação? (s/n)");
            System.out.print(">>: ");
            continuar = scanner.next().equalsIgnoreCase("s");
            scanner.nextLine();
        }
        exibirHistorico();
    }

    private double obterNumero(String descricao) {
        System.out.printf("Digite o(a) %S:%n", descricao);
        System.out.print(">>: ");
        return scanner.nextDouble();
    }

    private void exibirHistorico() {
        System.out.println("\nHistórico de operações:");
        for (String operacao : historico) {
            System.out.println(operacao);
        }

    }
}
