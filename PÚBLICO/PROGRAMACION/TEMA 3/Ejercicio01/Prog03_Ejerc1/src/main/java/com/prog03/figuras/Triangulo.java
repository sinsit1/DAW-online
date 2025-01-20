/*
    Prog03_ejercicio 1
    @author Alexandra Moltó Grau
    05/11/2024
 */

package com.prog03.figuras;
/* Importo el paquete DecimalFormat para mas adelante poder modificar el formato
de los datos que quiero que aparezcan por consola. */
import java.text.DecimalFormat;

public class Triangulo {
    
    private float base;
    private float altura;
    private float anguloIzq;
    private float anguloDer;
    
    // constructor que inicializa a 0
    public Triangulo(){
        this.base = 0;
        this.altura = 0;
        this.anguloIzq =0;
        this.anguloDer = 0;
    }
    
    // constructor que inicializa segun los parámetros pasados
    public Triangulo( float base, float altura, float anguloIzq, float anguloDer){
        this.base = base;
        this.altura = altura;
        this.anguloIzq = anguloIzq;
        this.anguloDer = anguloDer;
    }

    //  3.1.-- Métodos para actualizar y obtener el valor de cada atributo.
    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getAnguloIzq() {
        return anguloIzq;
    }

    public void setAnguloIzq(float anguloIzq) {
        this.anguloIzq = anguloIzq;
    }

    public float getAnguloDer() {
        return anguloDer;
    }

    public void setAnguloDer(float anguloDer) {
        this.anguloDer = anguloDer;
    }
    
    //  3.2.-- float getArea(): devuelve el área del triángulo.
    public String getArea(){
        DecimalFormat formato = new DecimalFormat("0.00");
        // Obtengo un "String" con el formato modificado para poder mostrarlo en la salida por consola
        // FUERZO 2 DECIMALES
        return formato.format((this.base*this.altura) / 2);
    }
    
    //  3.3.-- float getAnguloSup(): devuelve el ángulo superior.
    public float getAnguloSup(){
        return 180 - anguloDer - anguloIzq;
    }
    
    //  3.4.-- String toString(): devuelve una cadena conteniendo su área (con dos números decimales), su altura y el ángulo superior
    @Override
    public String toString(){
        return "Area: " + this.getArea() + ", Altura: " + this.getAltura() + " Ángulo superior: " + this.getAnguloSup() ;
    }
 
    //  3.5.-- boolean isEquilatero(): devuelve un booleano indicando si el triángulo es equilátero.
    public boolean isEquilatero(){
       return this.getAnguloDer() == 60 && this.getAnguloIzq() == 60;
    }
    
 
}
