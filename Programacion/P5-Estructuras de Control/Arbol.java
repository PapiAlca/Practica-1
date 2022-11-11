/* Práctica del Tema 5 "Altura de un árbol general"

-autor: Juan Parejo García

-Clase Objeto: Arbol. */

import java.util.*;
public class Arbol {
    //Variable:
    String cadena;
    int profundidad;
    Nodo standard;
    Scanner sc = new Scanner(System.in);

    //Constructor por defecto:
    public Arbol(Nodo standard) {
        this.cadena = "";
        this.profundidad = 1;
        this.standard = standard;
    }

    //Getters y Setters:
    public String getCadena() {
        return cadena;
    }
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getProfundidad() {
        return profundidad;
    }
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public Nodo getNodo() {
        return standard;
    }
    public void setNodo(Nodo standard) {
        this.standard = standard;
    }

    //Métodos:
    public void rellenarCadena(String cadena) {
        int condicion;
        int condicionfor;
        boolean full = false;
        Nodo primero = null;

        if (primero == null) {
            primero = new Nodo(sc.nextLine());
        }
        else {
            condicionfor = sc.nextInt();
            for(int i=0; condicionfor != 2; i++) {
                switch(condicionfor) {
                    case 1 :
                        if (full!=true) {
                            //Menú:
                            System.out.println(
                                    "-Pulsa 1 para insertar un nodo." + "\"" +
                                            "-Pulsa 2 para salir del menú.");
                            condicion = sc.nextInt();
                            switch (condicion) {
                                case 1:
                                    standard = new Nodo(sc.nextLine(), sc.nextInt(), true);
                                    cadena += standard.valor;
                                    System.out.println("Se ha creado el nodo " + standard + "y ha sido almacenado en la cadena (" + cadena + "), de nuestro Árbol.");
                                    full = false;
                                    break;

                                case 2:
                                    System.out.println("Has salido del menú");
                                    full = true;
                                    break;

                                default:
                                    System.out.println("ERROR, opción desconocida, pulse otra tecla.");
                                    break;
                            }
                        }
                        else {
                            //Insertamos el primer nodo de nuestro Arbol e introducimos su valor a nuestra cadena:
                            System.out.println("Introduce el primer nodo de nuestro Arbol");
                            primero = new Nodo(sc.nextLine());
                            cadena += primero.valor;
                        }
                        //Menú:
                        System.out.println(
                                "-Pulsa 1 para seguir en el bucle for." + "\"" +
                                        "-Pulsa 2 para salir del bucle for.");
                        break;

                    case 2:
                        System.out.println("Saliste del bucle for");
                        break;

                    default:
                        System.out.println("ERROR, opción desconocida, pulse otra tecla.");
                        break;
                }
            }
        }
    }
}