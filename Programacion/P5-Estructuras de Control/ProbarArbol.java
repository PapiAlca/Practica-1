/* Práctica del Tema 5 "Altura de un árbol general" */

//autor: Juan Parejo García

//Clase Main: ProbarArbol.
import java.util.*;
public class ProbarArbol {
    public static void main(String[] args) {
        //Variables:
        int profundidad = 0;
        Arbol n1 = new Arbol("12300010");

        System.out.println("La cadena de nuestro Árbol es " + n1.cadena + ".");
        for (int i = 0; i < n1.cadena.length(); i++) {
            //leer 1 caracter (charAt());
            n1.cadena.charAt(i);
            System.out.println(n1.cadena.charAt(i));

            //si el num que se está leyendo es 0 dejar de incrementar profundidad y restarle 1, caso contrario incrementar 1 en profundidad.
            if (n1.cadena.charAt(i).equals("0")) {
                profundidad = profundidad - 1;
            }
            else {
                profundidad = profundidad + 1;
            }
        }

        //Mostramos cuanta profundidad tiene nuestro objeto Arbol n1:
        System.out.println("Nuestro Árbol tiene " + profundidad + " de profundidad.");
    }
}