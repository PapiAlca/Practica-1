/*
 * Autor Juan Parejo García
 * Clase Main Controlador
 */

import java.util.List;

public class Controlador {
    public static void main(String[] args) {
        // Variables
        DAO<Alumno> dao = new AlumnoDAO();
        List<Alumno> alumnos;

        System.out.println("Leemos el csv y lo guardamos en un Arraylist: ");
        alumnos = AlumnoDAO.getAllAlumnos();

        System.out.println("Escribimos los datos del ArrayList en el fichero serializado, y lo leemos: ");
        AlumnoDAO.escribirAll(alumnos);
    }
}
