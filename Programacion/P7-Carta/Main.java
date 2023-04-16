/*
 * Autor: Juan Parejo García
 * Clase Main Main
 */

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 0 - Declaración de variables
        String separator = System.getProperty("file.separator");
        String archivoTXT = "carta.txt";
        String archivoCSV = "destinatarios.csv";
        String rutaArchivo = System.getProperty("user.dir") + separator;
        Map<String, String> parametros;
        List<String> recipientes;

        // 1 - Cargamos el archivo CSV y lo parseamos dentro de una instancia de la clase Parametros:
        System.out.println("+--------------------+");
        System.out.println("| Realizando  Paso 1 |");
        System.out.println("+--------------------+");

        TrabajarArchivo.leerParametros(new File(archivoCSV), TrabajarArchivo.countLines(new File(archivoCSV)));

        System.out.println("+------------------+");
        System.out.println("| Paso 1 realizado |");
        System.out.println("+------------------+");

        /*// 2 - Cargamos la carta a memoria:
        TrabajarArchivo.leerArchivo(cartaArchivo);
        System.out.println("+------------------+");
        System.out.println("| Paso 2 realizado |");
        System.out.println("+------------------+");

        // 3 - Cargamos los datos CSV
        TrabajarArchivo.leerArchivo(destinatariosArchivo);
        System.out.println("+------------------+");
        System.out.println("| Paso 3 realizado |");
        System.out.println("+------------------+");

         4 - Cargamos los datos a parsear según usuario
        TrabajarArchivo.leerModulos(destinatariosArchivo);
        TrabajarArchivo.leerAlumno(destinatariosArchivo, TrabajarArchivo.countLines(destinatariosArchivo));
        System.out.println("+------------------+");
        System.out.println("| Paso 4 realizado |");
        System.out.println("+------------------+");
         */

        // 5 - Ahora realizamos las sustituciones:


        // 6 - Escribimos las cartas y mostramos el resultado


    }
}