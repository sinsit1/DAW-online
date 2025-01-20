package com.prog03.prog04_ejer03;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Alexandra MOlto Grau
 * PROG04
 * EJERCICIO 03
 */

public class PROG04_Ejer03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1; // Inicializamos con un valor no válido

        try {
            // Seguimos pidiendo un número hasta que sea positivo
            while (n <= 0) {
                System.out.print("Introduce un número entero positivo para las filas del triángulo: ");
                try {
                    n = scanner.nextInt();
                    if (n <= 0) {
                        System.out.println("Error: El número debe ser mayor de 0");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debes introducir un número entero válido.");
                    scanner.next(); // Limpiar el buffer para evitar un bucle infinito
                }
            }

            // Generar el triángulo
            System.out.println("\nTriángulo de asteriscos:");
            for (int i = 1; i <= n; i++) {
                // Calcular y agregar espacios para centrar asteriscos
                for (int j = 0; j < n - i; j++) {
                    System.out.print(" ");
                }
                // Calcular y agregar los asteriscos
                for (int k = 0; k < (2 * i - 1); k++) {
                    System.out.print("*");
                }
                // Cambiar de línea después de imprimir cada fila
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
