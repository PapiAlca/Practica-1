import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 0 - Declaración de variables
        File ruta = new File("C:\\Users\\daw1\\IdeaProjects\\P7-Carta\\src");
        File cartaArchivo = new File((ruta + "carta.txt"));
        File destinatariosArchivo = new File((ruta + "destinatarios.csv"));
        Map<String, String> parametros;
        List<String> recipientes;


        // 1 - Cargamos el archivo CSV y lo parseamos dentro de una instancia de la clase Parametros
        TrabajarArchivo.leerParametros(destinatariosArchivo);

        // 2 - Cargamos la carta a memoria


        // 3 - Cargamos los datos CSV


        // 4 - Cargamos los datos a parsear según usuario


        // 5 - Ahora realizamos las sustituciones:


        // 6 - Escribimos las cartas y mostramos el resultado

    }
}