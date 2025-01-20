/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc7;

/**
 *
 * @author Alexandra Moltó Grau

 */

/* Importo el paquete DecimalFormat para mas adelante poder modificar el formato
de los datos que quiero que aparezcan por consola. */
import java.text.DecimalFormat;


public class PROG02_Ejerc7 {

    public static void main(String[] args) {
        // Declaro e inicializo la variable C1
        double C1 = 1.50;  
        // Declaro e inicializo la variable C2
        double C2 = 7;
        double C3 = 8;
        
        // Resuelvo "x" en la ecuación. La inicializo con el valor de la división de las variables anteriores
        double x = -(C2*C3)/C1;
        
        // Cambio el formato del valor "x" y lo personalizo para que solo tenga 2 decimales
        DecimalFormat formato = new DecimalFormat("#.##");
        // Obtengo un "String" con el formato modificado para poder mostrarlo en la salida por consola
	String resultadoDosDecimales = formato.format(x);
        
        // Resultado del valor de "x" por consola
        System.out.println( "El valor de x es: " + resultadoDosDecimales );
    }
}
