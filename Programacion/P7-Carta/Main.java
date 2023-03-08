import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 0 - Declaración de variables
        File ruta = new File("C:\\Users\\daw1\\IdeaProjects\\P7-Carta\\src");
        File cartaArchivo = new File((ruta + "\\carta.txt"));
        File destinatariosArchivo = new File((ruta + "\\destinatarios.csv"));
        ArrayList <Parametros> csvParametros = new ArrayList<Parametros>();

        // 1 - Cargamos el archivo CSV y lo parseamos dentro de una instancia de la clase Parametros:
        System.out.println("+------------------+");
        System.out.println("|      Paso 1      |");
        System.out.println("+------------------+");
        for (int i=1; i<=TrabajarArchivo.countLines(destinatariosArchivo); i++){
            System.out.println(TrabajarArchivo.leerParametros(destinatariosArchivo, i));
            csvParametros.add(TrabajarArchivo.leerParametros(destinatariosArchivo, i));
            System.out.println("Se ha añadido un parámetro");
        }

        System.out.println("+------------------+");
        System.out.println("| Paso 1 realizado |");
        System.out.println("+------------------+");

        // 2 - Cargamos la carta a memoria:
        System.out.println("+------------------+");
        System.out.println("|      Paso 2      |");
        System.out.println("+------------------+");

        TrabajarArchivo.leerArchivo(cartaArchivo);

        System.out.println("+------------------+");
        System.out.println("| Paso 2 realizado |");
        System.out.println("+------------------+");

        // 3 - Cargamos los datos CSV
        System.out.println("+------------------+");
        System.out.println("|      Paso 3      |");
        System.out.println("+------------------+");

        for(int i=0; i<csvParametros.toArray().length; i++) {
            System.out.println(csvParametros);
        }

        System.out.println("+------------------+");
        System.out.println("| Paso 3 realizado |");
        System.out.println("+------------------+");

        /*
        // 4 - Cargamos los datos a parsear según usuario
        System.out.println("+------------------+");
        System.out.println("|      Paso 4      |");
        System.out.println("+------------------+");



        System.out.println("+------------------+");
        System.out.println("| Paso 4 realizado |");
        System.out.println("+------------------+");

        // 5 - Ahora realizamos las sustituciones:
        System.out.println("+------------------+");
        System.out.println("|      Paso 5      |");
        System.out.println("+------------------+");




        // 6 - Escribimos las cartas y mostramos el resultado:
        System.out.println("+------------------+");
        System.out.println("|      Paso 6      |");
        System.out.println("+------------------+");



        */
    }
}