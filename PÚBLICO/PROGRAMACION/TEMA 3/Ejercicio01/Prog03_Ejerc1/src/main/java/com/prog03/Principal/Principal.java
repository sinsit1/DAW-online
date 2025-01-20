/*
    Prog03_ejercicio 1
    @author Alexandra Moltó Grau
    05/11/2024
 */

package com.prog03.Principal;

import com.prog03.figuras.Triangulo;

public class Principal {

    public static void main(String[] args) {
        Triangulo t1 = new Triangulo();
        Triangulo t2 = new Triangulo(5, 10, 30, 30);
        
        
        // Modificamos la base y la altura de T1
        t1.setBase(20);
        t1.setAltura(10);

        System.out.println("TRIANGULO 1: ");
        // base de T1
        System.out.println("Base triangulo 1: " + t1.getBase());
        // Triangulo 2 ¿es equilatero?
        System.out.println("¿Triangulo 1 es equilatero? " + t1.isEquilatero());
        // info de T1
        System.out.println("Triangulo 1 toString: " + t1.toString());
        
        System.out.println("------------------------------------------------------------------------------");
        
        System.out.println("TRIANGULO 2: ");
        // base de T2
        System.out.println("Base triangulo 2: " + t2.getBase());
        // Triangulo 2 ¿es equilatero?
        System.out.println("¿Triangulo 2 es equilatero? " + t2.isEquilatero());
        // info de Triangulo 2
        System.out.println("Triangulo 2 toString" + t2.toString());
    }
    
}
