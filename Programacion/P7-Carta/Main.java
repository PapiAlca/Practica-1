import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 0 - Declaración de variables
        File ruta = new File("C:\\Users\\daw1\\IdeaProjects\\P7-Carta\\src");
        File cartaArchivo = new File((ruta + "\\carta.txt"));
        File destinatariosArchivo = new File((ruta + "\\destinatarios.csv"));
        Map<String, String> parametros;
        List<String> recipientes;

        String moduloDestinatariosArchivo;

        // 1 - Cargamos el archivo CSV y lo parseamos dentro de una instancia de la clase Parametros:
        TrabajarArchivo.leerParametros(destinatariosArchivo, TrabajarArchivo.countLines(destinatariosArchivo));
        System.out.println("+------------------+");
        System.out.println("| Paso 1 realizado |");
        System.out.println("+------------------+");

        // 2 - Cargamos la carta a memoria:
        TrabajarArchivo.leerArchivo(cartaArchivo);
        System.out.println("+------------------+");
        System.out.println("| Paso 2 realizado |");
        System.out.println("+------------------+");

        // 3 - Cargamos los datos CSV
        moduloDestinatariosArchivo = TrabajarArchivo.leerArchivo(destinatariosArchivo);
        System.out.println("+------------------+");
        System.out.println("| Paso 3 realizado |");
        System.out.println("+------------------+");

        // 4 - Cargamos los datos a parsear según usuario
        TrabajarArchivo.leerModulos(destinatariosArchivo);
        TrabajarArchivo.leerAlumno(destinatariosArchivo, TrabajarArchivo.countLines(destinatariosArchivo));
        System.out.println("+------------------+");
        System.out.println("| Paso 4 realizado |");
        System.out.println("+------------------+");

        // 5 - Ahora realizamos las sustituciones:


        // 6 - Escribimos las cartas y mostramos el resultado


    }
}