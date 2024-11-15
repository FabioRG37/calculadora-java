package calculadora.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Expressao {
    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static boolean ehOperador(char c) {
        return "+-*/%^".indexOf(c) != -1;
    }

    public static List<String> paraPosFixa(String expressao) {
        Stack<Character> operadores = new Stack<>();
        List<String> saida = new ArrayList<>();
        StringBuilder numero = new StringBuilder();

        for (char c : expressao.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                numero.append(c);
            } else {
                if (numero.length() > 0) {
                    saida.add(numero.toString());
                    numero.setLength(0);
                }

                if (ehOperador(c)) {
                    while (!operadores.isEmpty() && operadores.peek() != '(' &&
                            precedencia(operadores.peek()) >= precedencia(c)) {
                        saida.add(String.valueOf(operadores.pop()));
                    }
                    operadores.push(c);
                } else if (c == '(') {
                    operadores.push(c);
                } else if (c == ')') {
                    while (!operadores.isEmpty() && operadores.peek() != '(') {
                        saida.add(String.valueOf(operadores.pop()));
                    }
                    if (!operadores.isEmpty() && operadores.peek() == '(') {
                        operadores.pop();
                    } else {
                        throw new IllegalArgumentException("Parêntese desbalanceado!");
                    }
                }
            }
        }
        if (numero.length() > 0) {
            saida.add(numero.toString());
        }

        while (!operadores.isEmpty()) {
            if (operadores.peek() == '(' || operadores.peek() == ')') {
                throw new IllegalArgumentException("Parêntese desbalanceado!");
            }
            saida.add(String.valueOf(operadores.pop()));
        }
        return saida;
    }

    public static double avaliarPosFixa(List<String> posFixa) {
        Stack<Double> operandos = new Stack<>();

        for (String token : posFixa) {
            if (ehOperador(token.charAt(0)) && token.length() == 1) {
                double b = operandos.pop();
                double a = operandos.pop();
                switch (token.charAt(0)) {
                    case '+':
                        operandos.push(a + b);
                        break;
                    case '-':
                        operandos.push(a - b);
                        break;
                    case '*':
                        operandos.push(a * b);
                        break;
                    case '/':
                        operandos.push(a / b);
                        break;
                    case '%':
                        operandos.push(a % b);
                        break;
                    case '^':
                        operandos.push(Math.pow(a, b));
                        break;
                }
            } else {
                operandos.push(Double.parseDouble(token));
            }
        }
        return operandos.pop();
    }
}
