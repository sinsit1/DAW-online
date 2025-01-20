/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc1;

/**
 *
 * @author Alexandra Molto grau
 * 
 * 
 * 1.- Crea un proyecto denominado PROG02_Ejerc1 con una clase clase y método main y declara e inicializa una variable para almacenar cada uno de los siguientes valores. 
    Trata de utilizar el tipo de datos que más se ajuste a los datos. Justifica tu elección.

    Valor máximo no modificable: 1000.
    Si el nuevo estudiante tiene carnet de conducir o no.
    El mes del año en formato numérico (Enero=1, Febrero=2…) y como cadena.
    El nombre y apellidos de una persona.
    Sexo: con dos valores posibles 'H' o 'M'.
    Milisegundos transcurridos desde el 01/01/1980 hasta nuestros días.
    Saldo de una cuenta bancaria.
    Distancia en ‘km’ desde la Tierra a Marte.

    Muestra el valor de cada variable en pantalla de forma que cada valor aparezca en una línea, teniendo en cuenta que NO puedes utilizar la orden println.
 */
// Ejercicio 1

public class PROG02_Ejerc1 {

    public static void main(String[] args) {
        
    /*  1.
        Tipo de dato "short" porque es un numero entero que no va a variar y 
	que por rango puede almacenarse con este tipo de dato ocupando el menor espacio de memoria. */
        short valorMaximo = 1000;
        
    /*  2.
        Al ser un dato booleano, en resumen de si o no, true o false, la mejor opción es el dato tipo "boolean". */
	boolean tieneCarnetConducir = true;
        
    /*  3.1
        El mes del año en formato numérico va a ser un numero entero de una cifra,
        por tanto el tipo de dato mas pequeño y más adecuado es "byte". */    
	byte mesDelAnno = 7; // julio
    /*  3.2
        El mes del año en formato cadena en formato "String", es el más adecuado 
	para almacenar cadenas de texto. */
	String mesDelAnnoCadena = "julio";
        
    /*  4.
        Al ser una cadena de texto de nuevo elijo el tipo "String". */
	String nombreCompleto = "Alexandra Molto Grau";
        
    /*  5.
        El tipo de dato "char" es el que se usa cuando hay que representar un solo caracter. */
	char sexo = 'M';
        
    /*  6.
        Los milisegundos transcurridos desde 01/01/1980 es un numero entero, pero de gran tamaño,
        por lo que lo mejor para su almacenaje es que sea un dato del tipo "long". */
	long milisegundosTranscurridos = 315565462000L;
        
    /*  7.
        Como es un numero que puede tener decimales se puede representar con el tipo "float" o el tipo "double",
	en contabilidad se suele usar "double" porque admite un rango de valores mayor y ofrece más precisión. */    
	double saldoCuenta = 18600.50;
        
    /*  8.
        De nuevo esta distancia en km de tierra a Marte no va a ser un numero entero sino que tendrá decimales, hay dos opciones tipo "double2 o "float",
        la distancia va a variar dependiendo de las órbitas de ambos planetas el rango de valores va a ser siempre alcanzable por el 
	tipo de dato "float" y al ocupar menos espacio de memoria lo más adecuado es usar "float". */
	float distanciaTierraMarte = 164000000.0f;
        
        
        // Mostrar resultados por línea de comandos
	System.out.print( "Valor máximo no modificable = " + valorMaximo + "\n" );
	System.out.print( "¿El alumno nuevo tiene carnet de conducir?: " + tieneCarnetConducir + "\n" );
	System.out.print( "Día del mes en formato numerico: " + mesDelAnno + "\n" );
	System.out.print( "Día del mes en formato cadena: " + mesDelAnnoCadena + "\n" );
	System.out.print( "Nombre completo: " + nombreCompleto + "\n" );
	System.out.print( "Sexo = " + sexo + "\n" );
	System.out.print( "Milisegundos transcurridos desde el 01/01/1980: " + milisegundosTranscurridos + "\n" );
	System.out.print( "Saldo de la cuenta: " + saldoCuenta + "\n" );
	System.out.print( "Distancia entre Marte y La Tierra: " + distanciaTierraMarte + "\n" );
	
    }

}