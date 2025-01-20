/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc9;

/**
 *
 * @author Alexandra Molto Grau
 */

// Ejercicio 9

/*
9.-  Un año que se considera bisiesto es aquel que sea divisible por 4 pero no por 100 salvo que sea divisible por 400.
Por esto 1900 no es bisiesto, 1904 sí y 2000 también.  Diseña un programa Java, denominado PROG02_Ejerc9, 
que dado un año indique si es bisiesto o no. NO se puede utilizar el operador condicional if.
*/

// Para activar la entrada por teclado importo el paquete Scanner desde la libreria Java
import java.util.Scanner;

public class PROG02_Ejerc9 {

    public static void main(String[] args) {
        // Defino el objeto "teclado" para poder solicitar la entrada del año a evaluar
        Scanner teclado = new Scanner(System.in);
        
        // Introduzco el mensaje para solicitar el año
        System.out.print("Introduce el año: ");
        
        // Creo la variable anio (por convencion se usa "anio" en lugar de "año") que toma el valor introducido
        int anio = teclado.nextInt();
        
        /* Para verificar si es bisiesto creo una variable "esBisiesto" del tipo "boolean".
	Si es divisible entre 4 y no entre 100 y a su vez es divisible entre 400 cumple la condicion 
	y será verdadero y por tanto bisiesto, sino será falso y no bisiesto. */
        boolean esBisiesto = ( ( anio % 4 ==0) && ( anio % 100 != 0 ) ) || ( anio % 400 == 0 );
	
        /* Creo un condicional que compare el booleano anterior,
        si es verdadero envía la primera salida por comando y si es 
        falso envía la otra salida por comando. */
	if (esBisiesto)
	System.out.println( "El año " + anio + " es bisiesto" );
	else
	System.out.println( "El año " + anio + " no es bisiesto" );
    }
}
