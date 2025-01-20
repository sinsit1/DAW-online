/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejerc8;

/**
 *
 * @author Alexandra Moltó Grau
 */

// Ejercicio 

/**8.- Diseña un programa Java denominado PROG02_Ejerc8 que dado el número de alumnos matriculados en Programación, 
número de alumnos matriculados  en Entornos de Desarrollo y número de alumnos matriculados en Base de datos.
El programa deberá mostrar el % de alumnos matriculados en cada uno de los tres módulos. Se supone que un alumno 
sólo puede estar matriculado en un módulo. Muestra solo dos decimales en los porcentajes.
*/

/* Importo el paquete DecimalFormat para mas adelante poder modificar el formato
de los datos que quiero que aparezcan por consola. */

import java.text.DecimalFormat;

public class PROG02_Ejerc8 {

    public static void main(String[] args) {
        // Asigno a cada asignatura un numero de alumnos
        int alumnosProgramacion = 30;
        int alumnosEntornos = 50;
        int alumnosBasesDatos = 20;
        
        /* Para que el resultado tenga decimales al operar mas adelante "totalAlumnos" tiene que ser de tipo "double",
        la conversión de int a double se realiza automaticamente. */
        double totalAlumnos = alumnosProgramacion + alumnosEntornos + alumnosBasesDatos;
        
        // Calculo los porcentajes para cada asignatura
        double porcentajeProgramacion = ( alumnosProgramacion / (totalAlumnos) ) *100;
        double porcentajeEntornos = ( alumnosEntornos / (totalAlumnos) ) *100;
        double porcentajeBasesDatos = ( alumnosBasesDatos / (totalAlumnos) ) *100;
        
        // Cambio el formato del valor de los porcentajes y lo personalizo para que solo tenga 2 decimales
        DecimalFormat formato = new DecimalFormat("#.##");
        
        // Creo una nueva variable "String" para cada porcentaje con el nuevo formato
        String porcentajeProgramacionDosDecimales = formato.format(porcentajeProgramacion);
        String porcentajeEntornosDosDecimales = formato.format(porcentajeEntornos);
        String porcentajeBasesDatosDosDecimales = formato.format(porcentajeBasesDatos);
        
        // Salida de resultado por comandos
        System.out.println("El porcentaje de alumnos matriculados en cada asignatura es el siguiente:" );
	System.out.println(" - Programacion: " + porcentajeProgramacionDosDecimales + "%" );
	System.out.println(" - Entornos: " + porcentajeEntornosDosDecimales + "%" );
	System.out.println(" - Bases de Datos: " + porcentajeBasesDatosDosDecimales + "%" );
    }
}
