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
        
    public float getCuentaAlumno() {
        float cuenta = 0;
        boolean revisarCuenta = false;
        while (revisarCuenta != true) {
            if (cuenta < 6) {
                if(getNotaBBDD() == -1) {
                    cuenta++;
                }
                if (getNotaEntorno() == -1) {
                    cuenta++;
                }
                if (getNotaFol() == -1) {
                    cuenta++;
                }
                if (getNotaLenguaje() == -1) {
                    cuenta++;
                }
                if (getNotaProg() == -1) {
                    cuenta++;
                }
                if (getNotaSistemas() == -1) {
                    cuenta++;
                }
            }
            else {
                revisarCuenta = true;
            }
            cuenta = - cuenta;
        }
        return cuenta;
    }

    //Método float para conseguir la media de los alumnos:
    public float getMediaAlumno() {
        float media;

        media = getSumaAlumno() / getCuentaAlumno();
        return media;
    }

    @Override
    public String toString() {
        return  "[Nombre: " + getNombre() + "] " +
                "[Nota BBDD: " + getNotaBBDD() + "] " +
                "[Nota Entorno: " + getNotaEntorno() + "] " +
                "[Nota Fol: " + getNotaFol() + "] " +
                "[Nota Lenguaje: " + getNotaLenguaje() + "] " +
                "[Nota Programación: " + getNotaProg() + "] " +
                "[Nota Sistemas: " + getNotaSistemas() + "] " +
                "[Nota Media: " + getMediaAlumno() + "]";
    }
}