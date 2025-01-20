/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc6;

/**
 *
 * @author Alexandra Moltó Grau
 */
public class PROG02_Ejerc6 {
    /* Enumero el tipo de dato "razaPerros", es necesario hacerlo fuera del método "main".
    Dentro de los corchetes defino distintos valores que puede tener este tipo de dato "razaPerros". */
    public enum razaPerros {Mastín, Terrier, Samoyedo, Pekines, Husky, Galgo};
    
    public static void main(String[] args) {
     
        // Doy un valor de este tipo de dato enumerado para las variables var1 y var2
        razaPerros var1 = razaPerros.Terrier;
	razaPerros var2 = razaPerros.Samoyedo;
        
        // Comparo las dos variables con el comando "compareTo", devuelve -1 si es false
        System.out.println( "Comparar las dos variables: " + var1.compareTo(var2) );
        
        // Obtengo la posición de ambas variables en el enumerado
        System.out.println( "Posicion de la variable var1: " + var1.ordinal() );
        System.out.println( "Posicion de la variable var2: " + var2.ordinal() );
        
        // Muestro todos los valores de la enumeración
        System.out.print( "Valores que contiene el enumerado: " );
        for ( razaPerros d: razaPerros.values() )
	System.out.print( d.toString() + " " );
    }
}
