/* Práctica del Tema 5 "Altura de un árbol general"

-autor: Juan Parejo García

-Clase Main: ProbarArbol.*/

import java.util.*;
public class ProbarArbol {
    public static void main(String[] args) {
        //Variables:
        Scanner sc = new Scanner(System.in);
        //Creamos un Nodo con ningún valor:
        Nodo stnd = new Nodo(null);
        //Creamos un Arbol con el nodo que creamos:
        Arbol n1 = new Arbol(stnd);

        n1.rellenarCadena(n1.getCadena());
    }
}