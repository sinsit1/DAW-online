package com.prog01.prog04_ejer01;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Alexandra MOlto Grau
 * PROG04
 * EJERCICIO 1
 */

public class PROG04_Ejer01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Introduce un número entero menor que 50: ");
            int N = scanner.nextInt();

            // comprobaciones previas, menor que 50 y positivo
            if (N > 50) {
                System.out.println("Error: El número debe ser menor que 50.");
                return;
            }

            if (N <= 0) {
                System.out.println("Error: El número debe ser positivo.");
                return;
            }

            // Secuencia con bucle for (ascendente)
            System.out.println("Secuencia con bucle for (1 a N):");
            for (int i = 1; i <= N; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

            // Secuencia con bucle while (descendente)
            System.out.println("Secuencia con bucle while (N a 1):");
            int i = N;
            while (i >= 1) {
                System.out.print(i + " ");
                i--;
            }
            System.out.println();

            // Secuencia con bucle do-while (pares entre 1 y N)
            System.out.println("Secuencia con bucle do-while (pares entre 1 y N):");
            int j = 1;
            do {
                if (j % 2 == 0) {
                    System.out.print(j + " ");
                }
                j++;
            } while (j <= N);
            System.out.println();

        } catch (InputMismatchException e) {
            System.out.println("Error: Debes introducir un número entero válido.");
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}