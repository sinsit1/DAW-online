/**
 *
 * @author alexandra Molto Grau
 * PROG06
 * Ejercicio 3
 */
import java.util.Scanner;

public class PROG06_Ejer03 {
    public static void main(String[] args) {
        // Datos inic del inventario
        int[] mueblesComprados = {30, 50, 200};
        int[] preciosCompra = {120, 60, 15};
        int[] preciosVenta = {250, 100, 25};

        // Crea el array de gastos
        int[][] gastos = new int[3][3];
        for (int i = 0; i < 3; i++) {
            gastos[i][0] = mueblesComprados[i];
            gastos[i][1] = preciosCompra[i];
            gastos[i][2] = mueblesComprados[i] * preciosCompra[i];
        }

        // Muestra el array de gastos en formato de la imagen
        System.out.println("\nGASTOS:");
        System.out.println("\t\t\tSofás\tMesas\tSillas");
        System.out.println("Muebles comprados\t" + gastos[0][0] + "\t" + gastos[1][0] + "\t" + gastos[2][0]);
        System.out.println("Precio de compra\t" + gastos[0][1] + "\t" + gastos[1][1] + "\t" + gastos[2][1]);
        System.out.println("Gastos (en euros)\t" + gastos[0][2] + "\t" + gastos[1][2] + "\t" + gastos[2][2]);

        // Pide las ventas al usuario
        int[] mueblesVendidos = {20, 30, 160}; // Datos del ejemplo
        int[][] ingresos = new int[3][3];
        for (int i = 0; i < 3; i++) {
            ingresos[i][0] = mueblesVendidos[i];
            ingresos[i][1] = preciosVenta[i];
            ingresos[i][2] = mueblesVendidos[i] * preciosVenta[i];
        }

        // Muestra el array de ingresos en formato de la imagen del ejercicio
        System.out.println("\nINGRESOS:");
        System.out.println("\n\t\t\tSofás\tMesas\tSillas");
        System.out.println("Muebles vendidos\t" + ingresos[0][0] + "\t" + ingresos[1][0] + "\t" + ingresos[2][0]);
        System.out.println("Precio de venta\t\t" + ingresos[0][1] + "\t" + ingresos[1][1] + "\t" + ingresos[2][1]);
        System.out.println("Ingresos (en euros)\t" + ingresos[0][2] + "\t" + ingresos[1][2] + "\t" + ingresos[2][2]);

        // Crea el balance
        int[][] balance = new int[2][4];
        for (int i = 0; i < 3; i++) {
            balance[0][i] = mueblesComprados[i] - mueblesVendidos[i]; // Stock restante
            balance[1][i] = ingresos[i][2] - gastos[i][2];          // Beneficio
        }
        //  totales
        balance[0][3] = balance[0][0] + balance[0][1] + balance[0][2];
        balance[1][3] = balance[1][0] + balance[1][1] + balance[1][2];

        // Muestra el array de balance como en la imagen del ejercicio
        System.out.println("\nBALANCE:");
        System.out.println("\n\t\t\tSofás\tMesas\tSillas\tTotal");
        System.out.println("Muebles en stock\t" + balance[0][0] + "\t" + balance[0][1] + "\t" + balance[0][2] + "\t" + balance[0][3]);
        System.out.println("Beneficio\t\t" + balance[1][0] + "\t" + balance[1][1] + "\t" + balance[1][2] + "\t" + balance[1][3]);
    }
}