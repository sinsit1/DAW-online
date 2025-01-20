/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc5;

/**
 *
 * @author Alexandra Moltó Grau
 */

// Importo la clase Scanner para poder pedir entrada de datos por teclado
import java.util.Scanner;

public class PROG02_Ejerc5 {

    public static void main(String[] args) {
        // Creo un nuevo objeto "teclado" para pedir la entrada del dato
        Scanner teclado = new Scanner(System.in);
        // Escribo el texto que aparece para solicitar los segundos
        System.out.print("Introduce una cantidad de segundos: ");
        // El dato introducido, del "float" int se asigna como valor a "segundos"
        float segundos = teclado.nextFloat();

        // Salida de la solución por línea de comandos
        System.out.println( "Esa cantidad de segundos introducida contiene:" );
        System.out.println( " - Minutos: " + ( segundos / 60/*minutos*/ ) );
        System.out.println( " - Horas: " + ( segundos / 60/*minutos*/ / 60 /*horas*/ ) );
        System.out.println( " - Días: " + ( segundos / 60 /*minutos*/ / 60 /*horas*/ / 24 /*dias*/) );
}
}
