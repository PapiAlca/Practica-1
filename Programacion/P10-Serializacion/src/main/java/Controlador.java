import java.util.List;

public class Controlador {
    public static void main(String[] args) {
        // Variables
        DAO<Alumno> dao = new AlumnoDAO();
        List<Alumno> alumnos;
        List<Alumno> alumnoS;

        System.out.println("Leemos el csv y lo guardamos en un Arraylist: ");
        alumnos = AlumnoDAO.getAllAlumnos();
        System.out.println(alumnos);

        System.out.println("Escribimos los datos del ArrayList en el fichero serializado, y lo leemos: ");
        alumnoS = AlumnoDAO.escribirAll(alumnos);
        System.out.println(alumnoS);
    }
}