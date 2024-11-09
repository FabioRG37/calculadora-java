package calculadora;

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
        if (b == 0) {
            System.out.println("Erro: Não é possível dividir por zero!");
        }
        return a / b;
    }
}
