package org.example;

import java.util.Scanner;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public double pedirNumero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public String pedirOperacion() {
        System.out.print("Ingrese operación (+, -, *, /): ");
        return scanner.next();
    }

    public void mostrarResultado(double resultado) {
        System.out.println("El resultado es: " + resultado);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }
}
