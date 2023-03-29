/*
 * Autor: Juan Parejo García
 * Clase Main Arbol
 */
import java.util.Scanner;
public class Arbol {
    public static void main(String[] args) {
        int arboles;
        String arbol;
        String[] espacios;
        int profundidad;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta el número de árboles que hay: ");
        arboles = sc.nextInt();

        while(arboles!=0) {
            System.out.println("Inserta los valores de tu arbol: ");
            sc.useDelimiter("\n");
            arbol = sc.next();
            arboles--;

            espacios = arbol.split(" ");

            Nodo primero = new Nodo(espacios, 0);
            profundidad = primero.getAltura();
            System.out.println("La profundidad del arbol es: " + profundidad);
        }
    }
}
