/* Práctica del Tema 5 "Altura de un árbol general" */

//autor: Juan Parejo García

//Clase Main: ProbarArbol.
import java.util.*;
public class ProbarArbol {
    public static void main(String[] args) {
        //Variables:
        int profundidad = 0;
        Arbol n1 = new Arbol("12300010");

        System.out.println("La cadena de nuestro Árbol es " + n1.getCadena() + ".");
        for (int i = 0; i < n1.getCadena().length(); i++) {
            //leer 1 caracter (charAt());
            n1.getCadena().charAt(i);
            System.out.println("El nodo " + i +" tiene valor "+n1.getCadena().charAt(i) + ".");

            //si el num que se está leyendo es 0 dejar de incrementar profundidad y restarle 1, caso contrario incrementar 1 en profundidad.
            if (n1.getCadena().charAt(i) == '0') {
                profundidad = profundidad - 1;
                System.out.println("La profundidad es " + profundidad + ".");
            }
            else {
                profundidad = profundidad + 1;
                System.out.println("La profundidad es " + profundidad + ".");
            }
        }

        //Mostramos cuanta profundidad tiene nuestro objeto Arbol n1:
        System.out.println("Nuestro Árbol tiene " + profundidad + " de profundidad.");
    }
}