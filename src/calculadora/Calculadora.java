package calculadora;

import calculadora.controller.CalculadoraController;
import calculadora.view.ConsoleView;

public class Calculadora {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        CalculadoraController controller = new CalculadoraController(view);
        controller.iniciar();
    }
}
