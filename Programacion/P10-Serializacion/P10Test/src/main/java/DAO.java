/*
 * Autor Juan Parejo García
 * Interfaz DAO
 */

import java.util.List;

public interface DAO <T> {
    // Métodos de la interfaz:
    public List<T> leerFichero();
    public List<T> leerFicheroSerializado();
    public void escribirFicheroSerializado(List<T> objetos);

}