/*
 * Autor Juan Parejo García
 * Clase Main Controlador
 */

import java.util.List;

public class Controlador {
    public static void main(String[] args) {
        // Variables:
        List<Alumno> fichero;
        List<Alumno> ficheroSerializado;
        DAO dao = new AlumnoDAO();

        // Leemos el fichero:
        System.out.println("Lista con el contenido del fichero sin serializar");
        fichero = dao.leerFichero();
        System.out.println(fichero);

        // Salto de línea
        System.out.println("---------------------------------------------------");
        System.out.println("\n");
        System.out.println("---------------------------------------------------");

        // Escribimos el contenido del fichero, en el fichero serializado
        dao.escribirFicheroSerializado(fichero);

        // Leemos el contenido del fichero serializado
        System.out.println("Lista con el contenido del fichero serializado");
        ficheroSerializado = dao.leerFicheroSerializado();
        System.out.println(ficheroSerializado);
    }
}
