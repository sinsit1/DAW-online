/**
 *
 * @author alexandra Molto Grau
 * PROG06
 * Ejercicio 1
 */

import java.util.Arrays;
import java.util.Random;

public class PROG06_Ejer01 {

    public static void main(String[] args) {
         // crea un array para almacenar los números aleatorios
        int[] numeros = new int[10];
        Random random = new Random();

        // Genera 10 números aleatorios entre 50 y 100 y los almacena en el array
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(51) + 50; // Genera un número aleatorio entre 50 y 100
        }

        // Muestra el array original
        System.out.println("Array original: " + Arrays.toString(numeros));

        // Ordena el array en orden creciente
        Arrays.sort(numeros);

        // muestra el array ordenado
        System.out.println("Array ordenado: " + Arrays.toString(numeros));
   
    }
    
}
