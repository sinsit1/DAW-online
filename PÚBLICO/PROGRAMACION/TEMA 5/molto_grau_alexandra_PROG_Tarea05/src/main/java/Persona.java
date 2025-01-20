/**
 * Clase Persona que almacena información sobre una persona, incluyendo DNI, nombre, apellidos, sexo, fecha de nacimiento,
 * carnet de conducir, nacionalidad y dirección. Además, permite obtener información, comparar edades y gestionar instancias.
 * 
 * @author Alexandra Molto Grau
 * @version 1.0
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Persona {
    // Campos de instancia privados
    private String dni;
    private String nombre;
    private String apellidos;
    private char sexo;
    private String fechaNacimiento; // Formato "ddmmaaaa"
    private boolean tieneCarnetConducir;
    private String nacionalidad;
    private String direccion;
    
    // Campo estático para contar las instancias
    private static int contadorInstancias = 0;

    /**
     * Constructor con parámetros para inicializar todos los campos.
     * 
     * @param dni DNI de la persona
     * @param nombre Nombre de la persona
     * @param apellidos Apellidos de la persona
     * @param sexo Sexo de la persona (M/F)
     * @param fechaNacimiento Fecha de nacimiento en formato "ddmmaaaa"
     * @param tieneCarnetConducir Indica si la persona tiene carnet de conducir
     * @param nacionalidad Nacionalidad de la persona
     * @param direccion Dirección de la persona
     */
    public Persona(String dni, String nombre, String apellidos, char sexo, String fechaNacimiento,
                   boolean tieneCarnetConducir, String nacionalidad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.tieneCarnetConducir = tieneCarnetConducir;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        contadorInstancias++; // Incrementar contador de instancias
    }

    /**
     * Constructor sin parámetros. Inicializa todos los campos con valores por defecto.
     */
    public Persona() {
        this.dni = "444555660A";
        this.nombre = "John ";
        this.apellidos = "Doe";
        this.sexo = 'M';
        this.fechaNacimiento = "01011970";
        this.tieneCarnetConducir = false;
        this.nacionalidad = "Española";
        this.direccion = "Calle san Martíkn";
        contadorInstancias++;
    }

    /**
     * Método estático para obtener el número total de instancias creadas.
     * 
     * @return Número de instancias creadas
     */
    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    /**
     * Método para obtener la información de la persona.
     * 
     * @param formato Define el formato de salida: "pausado" o "normal"
     */
    public void getInfo(String formato) {
        if (formato.equalsIgnoreCase("pausado")) {
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.println("DNI: " + dni); sc.nextLine();
            System.out.println("Nombre: " + nombre); sc.nextLine();
            System.out.println("Apellidos: " + apellidos); sc.nextLine();
            System.out.println("Sexo: " + sexo); sc.nextLine();
            System.out.println("Fecha de Nacimiento: " + fechaNacimiento); sc.nextLine();
            System.out.println("Carnet de Conducir: " + (tieneCarnetConducir ? "Sí" : "No")); sc.nextLine();
            System.out.println("Nacionalidad: " + nacionalidad); sc.nextLine();
            System.out.println("Dirección: " + direccion); sc.nextLine();
        } else {
            System.out.println("DNI: " + dni);
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellidos: " + apellidos);
            System.out.println("Sexo: " + sexo);
            System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
            System.out.println("Carnet de Conducir: " + (tieneCarnetConducir ? "Sí" : "No"));
            System.out.println("Nacionalidad: " + nacionalidad);
            System.out.println("Dirección: " + direccion);
        }
    }

    /**
     * Método para comparar la edad con otra persona.
     * 
     * @param otraPersona Objeto Persona con el que se comparará la edad
     */
    public void compararEdad(Persona otraPersona) {
        // Formato de la fecha "ddMMyyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

        try {
            // Convertir las fechas de nacimiento a LocalDate
            LocalDate fechaNacimiento1 = LocalDate.parse(this.fechaNacimiento, formatter);
            LocalDate fechaNacimiento2 = LocalDate.parse(otraPersona.fechaNacimiento, formatter);

            // Calcular las edades
            long edad1 = ChronoUnit.YEARS.between(fechaNacimiento1, LocalDate.now());
            long edad2 = ChronoUnit.YEARS.between(fechaNacimiento2, LocalDate.now());

            // Comparar edades
            if (edad1 > edad2) {
                System.out.println(this.nombre + "("+edad1+") es mayor que " + otraPersona.nombre+"("+edad2+")");
            } else if (edad1 < edad2) {
                System.out.println(this.nombre + "("+edad1+") es menor que " + otraPersona.nombre+"("+edad2+")");
            } else {
                System.out.println(this.nombre + " y " + otraPersona.nombre + " tienen la misma edad.");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar las fechas de nacimiento. Asegúrate de que estén en el formato 'ddMMyyyy'.");
        }
    }

/**
 * Método sobrecargado para comparar la edad con un número.
 *
 * @param edad Edad a comparar
 */
public void compararEdad(int edad) {
    // Formato de la fecha "ddMMyyyy"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

    try {
        // Convertir la fecha de nacimiento de la persona actual a LocalDate
        LocalDate fechaNacimiento = LocalDate.parse(this.fechaNacimiento, formatter);

        // Calcular la edad de la persona actual
        long edadPersona = ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());

        // Comparar la edad de la persona con el número proporcionado
        if (edadPersona > edad) {
            System.out.println(this.nombre + " tiene más de " + edad + " años.");
        } else if (edadPersona < edad) {
            System.out.println(this.nombre + " tiene menos de " + edad + " años.");
        } else {
            System.out.println(this.nombre + " tiene justo " + edad + " años.");
        }
    } catch (Exception e) {
        System.out.println("Error al procesar la fecha de nacimiento. Asegúrate de que esté en el formato 'ddMMyyyy'.");
    }
}

/**
 * Método sobrecargado para comparar la edad con una fecha dada (LocalDate).
 * 
 * @param fechaComparacion Fecha en formato LocalDate con la que se comparará la edad
 */
public void compararEdad(LocalDate fechaComparacion) {
    // Formato de la fecha "ddMMyyyy"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

    try {
        // Convertir la fecha de nacimiento de la persona actual a LocalDate
        LocalDate fechaNacimiento = LocalDate.parse(this.fechaNacimiento, formatter);

        // Calcular la edad de la persona en la fecha de comparación
        long edadPersona = ChronoUnit.YEARS.between(fechaNacimiento, fechaComparacion);

        // Mostrar la edad comparada con la fecha dada
        if (edadPersona < 0) {
            System.out.println("La fecha proporcionada es anterior a la fecha de nacimiento de " + this.nombre);
        } else {
            System.out.println(this.nombre + " tendría " + edadPersona + " años en la fecha " + fechaComparacion);
        }
    } catch (Exception e) {
        System.out.println("Error al procesar la fecha. Asegúrate de que esté en el formato 'ddMMyyyy'.");
    }
}
    
/**
 * Método sobrecargado para comparar la edad con una fecha.
 *
 * @param fecha Fecha en formato "ddmmaaaa" con la que se comparará la edad
 */
public void compararEdad(String fecha) {
    // Formato de la fecha "ddMMyyyy"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

    try {
        // Convertir las fechas de nacimiento y comparación a LocalDate
        LocalDate fechaNacimiento = LocalDate.parse(this.fechaNacimiento, formatter);
        LocalDate fechaComparacion = LocalDate.parse(fecha, formatter);

        // Calcular las edades en la fecha de comparación
        long edadPersona = ChronoUnit.YEARS.between(fechaNacimiento, fechaComparacion);

        // Comparar la edad en la fecha dada
        if (edadPersona < 0) {
            System.out.println("La fecha proporcionada (" + fecha + ") es anterior a la fecha de nacimiento de " + this.nombre);
        } else {
            System.out.println(this.nombre + " tendría " + edadPersona + " años en la fecha " + fecha + ".");
        }
    } catch (Exception e) {
        System.out.println("Error al procesar la fecha. Asegúrate de que esté en el formato 'ddMMyyyy'.");
    }
}


    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public boolean isTieneCarnetConducir() { return tieneCarnetConducir; }
    public void setTieneCarnetConducir(boolean tieneCarnetConducir) { this.tieneCarnetConducir = tieneCarnetConducir; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}
