/*
 * Autor Juan Parejo García
 * Interfaz DAO
 */
import java.util.List;

public interface DAO <T> {
    /**
     *
     * @return
     */
    public static List<Alumno> getAllAlumnos() {
        return null;
    }

    public static void escribirAll(List<Alumno> fichero) {}
}