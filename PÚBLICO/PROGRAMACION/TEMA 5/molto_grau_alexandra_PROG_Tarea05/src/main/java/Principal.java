/**
 * Clase Principal que prueba la ejecución de los métodos de la clase Persona.
 * 
 * @author Alexandra Molto Grau
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        // Creación de dos objetos Persona
        Persona persona1 = new Persona("12345678Z", "Ana", "Martínez", 'F', "12051990", true, "Española", "Calle Mayor, 10");
        Persona persona2 = new Persona();

        // 1. Mostrar información de persona1 con formato "normal"
        System.out.println("Información de persona1 (normal):");
        persona1.getInfo("normal");

        // 2. Mostrar información de persona2 con formato "pausado"
        System.out.println("\nInformación de persona2 (pausado):");
        persona2.getInfo("pausado");

        // 3. Comparar edades entre persona1 y persona2 (por objeto)
        System.out.println("\nComparación de edades entre persona1 y persona2:");
        persona1.compararEdad(persona2);

        // 4. Comparar la edad de persona1 con un número (edad a comparar)
        System.out.println("\nComparación de edad de persona1 con 35 años:");
        persona1.compararEdad(35);

        // 5. Comparar la edad de persona2 con una fecha específica
        System.out.println("\nComparación de edad de persona2 con la fecha 01/01/2025:");
        persona2.compararEdad("01012025");

        // 6. Comparar la edad de persona1 con una fecha específica (utilizando un LocalDate)
        System.out.println("\nComparación de edad de persona1 con la fecha 01/01/2025 usando LocalDate:");
        persona1.compararEdad(java.time.LocalDate.of(2025, 1, 1));

        // 7. Comprobar número total de instancias creadas de la clase Persona
        System.out.println("\nNúmero total de instancias de Persona: " + Persona.getContadorInstancias());
    }
}
