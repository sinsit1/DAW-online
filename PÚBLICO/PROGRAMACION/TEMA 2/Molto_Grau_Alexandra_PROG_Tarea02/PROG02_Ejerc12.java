/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc12;

/**
 *
 * @author Alexandra Moltó Grau
 * 
 * Ejercicio 12
 * 
 * 
 * Diseña un programa Java, denominado PROG02_Ejerc12, que realice las siguientes operaciones,
 * en el orden que se muestran. Se indica la variable y el tipo de dato que recibe el valor o
 * resultado de la operación indicada:

 */
public class PROG02_Ejerc12 {

    public static void main(String[] args) {
        System.out.println("------- Conversiones entre enteros y coma flotante -------") ;
        
            float x = 4.5f ;
            float y = 3.0f ;
            int i = 2 ;
            int j = (int)( i * x ) ;
            double dx = 2.0 ;
            double dz = dx * y ;
            
            System.out.println( "Producto de int por float: j = i * x = " + j ) ;
            System.out.println( "Producto de float por double: dz = dx * y = " + dz ) ;
            System.out.println( " " ) ;
            


	System.out.println( "------- Operaciones con byte -------" ) ;
        
            byte bx = -128 ;
            byte by = 1 ;
            byte bz = (byte) (bx - by) ;

            System.out.println( "byte " + bx + " - " + by  + " = " + bz ) ;

            int jInt = (int) (bx - by) ;

            System.out.println( "(int)(" + bx + " - " + by + ") = " + jInt ) ;
            System.out.println( " " ) ;


        System.out.println( "------- Operaciones con short -------" ) ;
        
            short sx = 32767 ;
            short sy = 1 ;
            short sz = (short) ( sx + sy ) ;


            System.out.println( "short " + sx + " + " + sy + " = " + sz ) ;
            System.out.println( " " ) ;
        
        System.out.println("------- Operaciones con char -------") ;
        
            char cx = '\u001F' ;
            char cy = '\u0002' ;
            int z = (int) ( cx + cy ) ; 

            System.out.println( "char: - " + " = " + z ) ;        
            System.out.println( "char(" + cx + ") + " + (int) cy + " = " + z ) ; // 0x000F=15

    }
}
