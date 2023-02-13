package Ejercicio1;
public class Equipo {
    //Variables
    String nombre;
    int puntuacion;

    //Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getPuntuacion() {
        return puntuacion;
    }

    //Setters
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "|Nombre: " + nombre + "|Puntuación: " + puntuacion + "|";
    }
}
