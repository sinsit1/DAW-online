/*
    Prog03_ejercicio 1
    @author Alexandra Moltó Grau
    05/11/2024
 */

package Estanteria;

import java.time.LocalDate;
import java.time.Month;

public class Principal {

    public static void main(String[] args) {

        // Instancia un objeto de la clase Libro denominado objLibro1 con el primer constructor.
        Libro objLibro1 = new Libro("El señor de los anillos", Libro.enumGenero.FICCIÓN);
        
        // Actualiza los atributos autor y fechaPublicacion para dicho objeto.
        objLibro1.setAutor(" J. R. R. Tolkien, ");
        objLibro1.setFechaPublicacion(LocalDate.of(1954, 7, 29));
        
        
        System.out.println("Primer libro, inicializado con el primer constructor ");
        
        // Muestra el Libro por pantalla en formato largo.
        System.out.println(objLibro1.toString());
        
        // Muestra un mensaje por pantalla indicando si el libro es un clásico (puedes utilizar el operador de comparación ternario. Punto 5.3 de la Unidad 2).
        System.out.println(objLibro1.isClasico() ? "Es un clásico\n" : "No es un clásico\n");
        

        System.out.println("Segundo libro, inicializado con el segundo constructor ");
        
        // Instancia otro objeto de la clase Libro denominado objLibro2 con el segundo constructor.
        Libro objLibro2  = new Libro("La historia interminable", "Michael Ende, ", Libro.enumGenero.FANTASÍA, LocalDate.of(1979, 9, 1) ); 
        
        // Muestra el Libro por pantalla en formato largo
        System.out.println(objLibro2.toString());
        
        // Muestra un mensaje por pantalla indicando si el libro es un clásico.
        System.out.println(objLibro2.isClasico() ? "Es un clásico" : "No es un clásico");
        
        // Muestra un mensaje por pantalla indicando si la fecha es verano o no.
        System.out.println( esVerano(objLibro2.getFechaPublicacion()) ? "La fecha es verano" : "La fecha NO es verano");
   
    }
    
    public static boolean esVerano(LocalDate fecha) {
        // Define el rango de fechas de verano
        LocalDate inicioVerano = LocalDate.of(fecha.getYear(), Month.JUNE, 21);
        LocalDate finVerano = LocalDate.of(fecha.getYear(), Month.SEPTEMBER, 22);
        
        // Comprueba si la fecha está dentro del rango
        return (fecha.isEqual(inicioVerano) || fecha.isAfter(inicioVerano)) &&
               (fecha.isEqual(finVerano) || fecha.isBefore(finVerano));
    }

}
