/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc4;

/**
 *
 * @author Alexandra Moltó Grau
 */

// Ejercicio 2

// Importo la clase Scanner para poder pedir entrada de datos por teclado
import java.util.Scanner;

public class PROG02_Ejerc4 {

    public static void main(String[] args) {
        int edadJubilacion = 65;
           
        // Creo un nuevo objeto "teclado" para pedir la entrada del dato
        Scanner teclado = new Scanner(System.in);

        // Escribo el texto que aparecerá para solicitar ese dato, en este caso la edad
	System.out.print("Introduce una edad: ");

        // La edad introducida, del tipo int se asigna como valor a "edad"
	int edad = teclado.nextInt();

        /* Mediante el operador "?:" creo una condición que me devuelve un "String", dependiendo
        de si se cumple o no la condición dada me dirá si está en edad de jubilacion o no. */
        String verificarJubilacion = (edad >= edadJubilacion) ? "Está jubilado" : "No está jubilado" ;
	
        //Salida por comando con la respuesta
	System.out.println(verificarJubilacion);
    }
}
