/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc10;

/**
 *
 * @author Alexandra Moltó Grau
 * 
 * Ejercicio 10
 * 
 * 10.-  Diseña un programa Java denominado PROG02_Ejerc10 que dados dos números de tipo entero: numero1 y numero2,
 * con valores 2 y 7 respectivamente, haga la división de numero2 entre numero1. El mensaje de salida
 * será “El resultado de la división es: “. Muestra el resultado  con dos decimales. 
 * 
 */

/* Importo el paquete DecimalFormat para mas adelante poder modificar el formato
de los datos que quiero que aparezcan por consola. */

import java.text.DecimalFormat;


public class PROG02_Ejerc10 {

    public static void main(String[] args) {
        int val1 = 2;
        int val2 = 7;
        
        DecimalFormat formato = new DecimalFormat("0.00");

        String res = formato.format((double) val2/val1);

        System.out.println( "El resultado de la división es: " + res );

    }
}
