/*
-Autor: Juan Parejo García
-Clase Objeto Alumno
*/

public class Alumno {
    //Variables:
    String nombre;
    float notaBBDD;
    float notaEntorno;
    float notaFol;
    float notaLenguaje;
    float notaProg;
    float notaSistemas;

    //Constructor
    public Alumno (String nombre, float notaBBDD, float notaEntorno, float notaFol, float notaLenguaje, float notaProg, float notaSistemas) {
        this.nombre = nombre;
        this.notaBBDD = notaBBDD;
        this.notaEntorno = notaEntorno;
        this.notaFol = notaFol;
        this.notaLenguaje = notaLenguaje;
        this.notaProg = notaProg;
        this.notaSistemas = notaSistemas;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public float getNotaBBDD() {
        return notaBBDD;
    }
    public float getNotaEntorno() {
        return notaEntorno;
    }
    public float getNotaFol() {
        return notaFol;
    }
    public float getNotaLenguaje() {
        return notaLenguaje;
    }
    public float getNotaProg() {
        return notaProg;
    }
    public float getNotaSistemas() {
        return notaSistemas;
    }

    //Métodos:
    public float getSumaAlumno() {
        float suma = 0;
        if (getNotaBBDD() != -1) {
            suma += getNotaBBDD();
            }
        if (getNotaEntorno() != -1) {
            suma += getNotaEntorno();
        }
        if (getNotaFol() != -1) {
            suma += getNotaFol();
        }
        if (getNotaLenguaje() != -1) {
            suma += getNotaLenguaje();
        }
        if (getNotaProg() != -1) {
            suma += getNotaProg();
        }
        if (getNotaSistemas() != -1) {
            suma += getNotaSistemas();
        }
        return suma;
    }

    public float getNumeroAsignaturas() {
        int cuenta = 0;

        if (getNotaBBDD()!=-1) cuenta++;
        if (getNotaEntorno()!=-1) cuenta++;
        if (getNotaFol()!=-1) cuenta++;
        if (getNotaLenguaje()!=-1) cuenta++;
        if (getNotaSistemas()!=-1) cuenta++;
        if (getNotaProg()!=-1) cuenta++;

        return cuenta;
    }

    public float getMediaAlumno() {
        float media;

        media = 0;
        media = getSumaAlumno() / getNumeroAsignaturas();
        return media;
    }

    @Override
    public String toString() {
        return "-Alumno: " + getNombre() + ". " +
                "[Nota de Base de Datos: " + getNotaBBDD() + "] " +
                "[Nota de Entornos: " + getNotaEntorno() + "] " +
                "[Nota de FOL: " + getNotaFol() + "] " +
                "[Nota de Lenguaje: " + getNotaLenguaje() + "] " +
                "[Nota de Programación: " + getNotaProg() + "] " +
                "[Nota de Sistemas: " + getNotaSistemas() + "] " +
                "[Media total de las asignaturas " + getMediaAlumno() + "]"
                ;
    }
}