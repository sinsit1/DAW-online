/*
    Prog03_ejercicio 1
    @author Alexandra Moltó Grau
    05/11/2024
 */

package Estanteria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author alexa
 */
public class Libro {
    //Declara en el fichero de la clase un tipo enumerado, denominado enumGenero, para los distintos Géneros de libros: (FICCIÓN, CIENCIA_FICCIÓN, FANTASÍA, HISTORIA, ROMÁNTICA, NOVELA_NEGRA)
    public enum enumGenero { FICCIÓN, CIENCIA_FICCIÓN, FANTASÍA, HISTORIA, ROMÁNTICA, NOVELA_NEGRA };
    private String titulo;
    private String autor;
    private enumGenero genero;
    public LocalDate fechaPublicacion;
    
    // Implementa un constructor que inicialice el titulo y el genero a los valores recibidos por parámetro y los demás atributos a 0 o cadena vacía en caso de que sea un String “”. Observa su cabecera en el siguiente código:
    public Libro(String titulo, enumGenero genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = "";
        this.fechaPublicacion = null;
    }
    
    // Declara otro constructor que inicialice todos los atributos de la clase. Su cabecera podría ser la siguiente:
    public Libro(String titulo, String autor, enumGenero genero, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Implementa los métodos que permitan acceder y modificar cada uno de los atributos de la clase. Los nombres de dichos métodos serán: getXXX () para obtener el valor del atributo XXX y setXXX (v) para actualizar el atributo XXX con el valor v. Puedes observar la cabecera de algún método en el siguiente código:
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public enumGenero getGenero() {
        return genero;
    }

    public void setGenero(enumGenero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaPublicacion() {
        
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    // Implementa un método que devuelva true si el libro es considerado un clásico (consideramos  un clásico a cualquier libro anterior al 2000) y false en caso contrario. Observa su cabecera en el siguiente código:
    public boolean isClasico(){
        return this.fechaPublicacion.getYear() < 2000;
    }
    
    // Me he creado este helper para transformar un LocalDate en un string con la forma que necesitamos
    public String formatDateToDDMMYYYY(){
        DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.getFechaPublicacion().format(formatPattern);
    }
    
    // Implementa un método que devuelva una cadena con la fecha en formato largo, por ejemplo, Título: Dune, Autor: Frank Herbert, Género: CIENCIA_FICCIÓN, Fecha de publicación: 01/08/1965. Observa su cabecera:
    @Override
    public String toString (){
        return "Título: "+ this.getTitulo() +", Autor: "+ this.getAutor() +" Género: "+ this.getGenero() +", Fecha de publicación: " + this.formatDateToDDMMYYYY();
    }


}
