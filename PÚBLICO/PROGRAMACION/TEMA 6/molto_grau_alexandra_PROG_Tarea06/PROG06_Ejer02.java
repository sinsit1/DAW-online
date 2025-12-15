/**
 *
 * @author Alexandra Molto Grau
 * PROG06
 * Ejercicio 2
 */

import java.util.Scanner;


public class PROG06_Ejer02 {

    public static void main(String[] args) {
        // Crea un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicita una frase al usuario con 10 palabras
        System.out.println("Introduce una frase que contenga exactamente 10 palabras:");
        String frase = scanner.nextLine();

        // Divide la frase en palabras y las almacena en un array
        String[] palabras = frase.split(" ");

        // Verifica que el usuario ingresa exactamente 10 palabras
        if (palabras.length != 10) {
            System.out.println("Error: La frase debe contener exactamente 10 palabras.");
        } else {
            // Muestra cada palabra usando un bucle
            System.out.println("Palabras en el array:");
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
        }

        scanner.close(); // Cierra el escaner
    }
    
}
