package com.prog02.prog04_ejer02;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Alexandra Molto Grau
 * PROG04
 * EJERCICIO 2
 */

public class PROG04_Ejer02 {

    public static void main(String[] args) {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numInt = 5; // Intentos por defecto
        int numMax = 10; // Número máximo por defecto
        int numOculto = 0; // Número a adivinar
        boolean configurado = false; // Para verificar si se configuró

        while (true) {
            try {
                System.out.println("\nMenú:");
                System.out.println("1. Configurar");
                System.out.println("2. Jugar");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                int opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1: // Configurar
                        System.out.print("Introduce el número de intentos permitidos: ");
                        numInt = Integer.parseInt(reader.readLine());

                        System.out.print("Introduce el número máximo generado: ");
                        numMax = Integer.parseInt(reader.readLine());

                        configurado = true;
                        System.out.println("Configuración guardada correctamente.");
                        break;

                    case 2: // Jugar
                        if (!configurado) {
                            System.out.println("Usando valores por defecto: intentos = 5, número máximo = 10.");
                        }
                        numOculto = (int) Math.floor(Math.random() * (numMax + 1)); // Generar número aleatorio
                        int intentosRestantes = numInt;
                        boolean adivinado = false;

                        System.out.println("\n¡Empieza el juego! Tienes " + numInt + " intentos para adivinar un número entre 0 y " + numMax + ".");
                        while (intentosRestantes > 0) {
                            System.out.print("Introduce tu número: ");
                            int intento = Integer.parseInt(reader.readLine());
                            
                             // Validación del rango
                            if (intento < 0 || intento > numMax) {
                                System.out.println("Error: El número debe estar entre 0 y " + numMax + ".");
                                continue;
                            }

                            if (intento == numOculto) {
                                System.out.println("¡Has ganado! Has necesitado " + (numInt - intentosRestantes + 1) + " intentos.");
                                adivinado = true;
                                break;
                            } else if (intento < numOculto) {
                                System.out.println("El número oculto es mayor.");
                            } else {
                                System.out.println("El número oculto es menor.");
                            }

                            intentosRestantes--;
                            System.out.println("Intentos restantes: " + intentosRestantes);
                        }

                        if (!adivinado) {
                            System.out.println("¡Perdiste! El número oculto era: " + numOculto + ". Intentos consumidos: " + numMax);
                        }

                        break;

                    case 3: // Salir
                        System.out.println("Saliendo del programa. ¡Hasta la próxima!");
                        return;

                    default:
                        System.out.println("Opción no válida. Por favor, selecciona una opción entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número válido.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
            }
       }     
    }
}
