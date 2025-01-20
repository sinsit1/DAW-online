/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc11;

/**
 *
 * @author Alexandra Moltó Grau
 * 
 * Ejercicio 11
 * 
 * Diseña un programa Java denominado PROG02_Ejerc11 que dado un carácter indique su código Unicode (valor numérico asociado).
 * El mensaje de salida será “La letra X, corresponde al valor Z“, donde X será el carácter/ y
 * Z el valor numérico asociado. Hazlo para los caracteres ‘B’ y ‘K’.
 */


public class PROG02_Ejerc11 {

    public static void main(String[] args) {
        char letraB = 'B';
        char letraK = 'K';
        
        System.out.println("La letra "+ letraB +" corresponde al valor " + (int) letraB);
        System.out.println("La letra "+ letraK +" corresponde al valor " + (int) letraK);

    }
}
