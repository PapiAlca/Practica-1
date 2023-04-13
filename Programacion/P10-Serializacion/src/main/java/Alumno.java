/*
 * Autor Juan Parejo García
 * Clase Objeto Alumno
 */

import java.io.Serializable;

public class Alumno implements Serializable {
    // Variables:
    String nombre, email, dni, f_nacimiento;

    // Constructor
    public Alumno(String nombre, String email, String dni, String f_nacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.f_nacimiento = f_nacimiento;
    }

    // Método toString
    @Override
    public String toString() {
        return  "\n" +
                "==============================================" + "\n" +
                "·Nombre: " + nombre + "." + "\n" +
                "·Email: " + email + "." + "\n" +
                "·DNI: " + dni + "." + "\n" +
                "·Fecha de nacimiento: " + f_nacimiento + "." + "\n" +
                "==============================================" + "\n";
    }
}
