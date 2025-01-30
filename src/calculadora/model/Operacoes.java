package calculadora.model;

public class Operacoes {
    public double soma(double a, double b) {
        return a + b;
    }

    public double subtrai(double a, double b) {
        return a - b;
    }

    public double multiplica(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        double ret;
        if (b == 0) {
            System.out.println("Erro: Não é possível dividir por zero!");
            ret = Double.NaN;
        }
        return a / b;
    }

    public double potencia(double base, double expoente) {
        return Math.pow(base, expoente);
    }

    public double raizQuadrada(double numero) {
        if (numero < 0) {
            System.out.println("Erro: Número negativo não tem raíz quadrada real!");
            return 0;
        }
        return Math.sqrt(numero);
    }

    public double modulo(double a, double b) {
        return a % b;
    }
}
