package calculadora.controller;

import calculadora.model.Fracao;
import calculadora.model.Operacoes;
import calculadora.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraController {
    private final Operacoes operacoes;
    private final ConsoleView view;
    private final List<String> historico;

    public CalculadoraController(ConsoleView view) {
        this.operacoes = new Operacoes();
        this.view = view;
        this.historico = new ArrayList<>();
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            view.exibirMenu();
            int tipoOperacao = view.obterTipoOperacao();
            view.limparBuffer();

            if (tipoOperacao == 1) {
                executarOperacoesDecimais();
            } else if (tipoOperacao == 2) {
                executarOperacoesFracoes();
            } else {
                System.out.println("Tipo de operação inválida!");
            }

            continuar = view.continuar();
            view.limparBuffer();
        }
        view.exibirHistorico(historico);
    }

    private void executarOperacoesDecimais(){
        view.exibirMenuOperacoesDecimais();
        String operacao = view.obterOperacao();

        double numero1 = 0, numero2 = 0, resultado = 0;
        boolean operacaoValida = true;

        switch (operacao) {
            case "+":
                numero1 = view.obterNumero("primeiro");
                numero2 = view.obterNumero("segundo");
                resultado = operacoes.soma(numero1, numero2);
                break;
            case "-":
                numero1 = view.obterNumero("primeiro");
                numero2 = view.obterNumero("segundo");
                resultado = operacoes.subtrai(numero1, numero2);
                break;
            case "/":
                numero1 = view.obterNumero("primeiro");
                numero2 = view.obterNumero("segundo");
                resultado = operacoes.divide(numero1, numero2);
                break;
            case "*":
                numero1 = view.obterNumero("primeiro");
                numero2 = view.obterNumero("segundo");
                resultado = operacoes.multiplica(numero1, numero2);
                break;
            case "^":
                numero1 = view.obterNumero("base");
                numero2 = view.obterNumero("expoente");
                resultado = operacoes.potencia(numero1, numero2);
                break;
            case "v":
                numero1 = view.obterNumero("radicando");
                resultado = operacoes.raizQuadrada(numero1);
                break;
            case "%":
                numero1 = view.obterNumero("primeiro");
                numero2 = view.obterNumero("segundo");
                resultado = operacoes.modulo(numero1, numero2);
                break;
            default:
                System.out.println("Operação inválida!");
                operacaoValida = false;
        }

        if (operacaoValida) {
            String entradaHistorico;
            if (operacao.equals("v")) {
                entradaHistorico = String.format("Operação: %s, Números: %.2f, Resultado: %.2f",
                        operacao, numero1, resultado);
            } else {
                entradaHistorico = String.format("Operação: %s, Números: %.2f e %.2f, Resultado: %.2f",
                        operacao, numero1, numero2, resultado);
            }
            historico.add(entradaHistorico);
            view.exibirResultadoDecimal(resultado);
        }
    }

    private void executarOperacoesFracoes(){
        view.exibirMenuOperacoesFracao();
        String operacao = view.obterOperacao();

        Fracao fracao1 = new Fracao(view.obterNumerador("primeira"), view.obterDenominador("primeira"));
        Fracao fracao2 = new Fracao(view.obterNumerador("segunda"), view.obterDenominador("segunda"));
        Fracao resultado = null;

        boolean operacaoValida = true;

        switch (operacao) {
            case "+":
                resultado = fracao1.somar(fracao2);
                break;
            case "-":
                resultado = fracao1.subtrair(fracao2);
                break;
            case "/":
                resultado = fracao1.dividir(fracao2);
                break;
            case "*":
                resultado = fracao1.multiplicar(fracao2);
                break;
            default:
                System.out.println("Operação inválida!");
                operacaoValida = false;
        }

        if (resultado != null) {
            String entradaHistorico = String.format("Operação: %s, Frações: %s e %s, Resultado: %s"
                    , operacao, fracao1, fracao2, resultado);
            historico.add(entradaHistorico);
            view.exibirResultadoFracao(resultado);
        }
    }
}
