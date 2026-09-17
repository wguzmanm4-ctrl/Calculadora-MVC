package org.example;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        double num1 = vista.pedirNumero("Ingrese el primer número: ");
        double num2 = vista.pedirNumero("Ingrese el segundo número: ");
        String operacion = vista.pedirOperacion();

        try {
            double resultado = 0;
            switch (operacion) {
                case "+": resultado = modelo.sumar(num1, num2); break;
                case "-": resultado = modelo.restar(num1, num2); break;
                case "*": resultado = modelo.multiplicar(num1, num2); break;
                case "/": resultado = modelo.dividir(num1, num2); break;
                default: vista.mostrarError("Operación no válida"); return;
            }
            vista.mostrarResultado(resultado);
        } catch (ArithmeticException e) {
            vista.mostrarError(e.getMessage());
        }
    }
}