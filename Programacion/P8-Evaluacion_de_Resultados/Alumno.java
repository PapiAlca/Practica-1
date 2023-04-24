/*
-Autor: Juan Parejo García
-Clase Objeto Alumno
*/

import java.util.Map;

public class Alumno {
    static int i = 0;

    //Variables:
    int id;
    String nombre;

    //Constructor
    public Alumno (String nombre) {
        this.id = i++;
        this.nombre = nombre;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "[ID: " + getId() + "]" +
                "[Nombre: " + getNombre() + "]";
    }
}