/*
 * Autor: Juan Parejo García
 * Clase Objeto TrabajarArchivo
 */

import java.io.*;
import java.util.*;

/**
 * La clase TrabajarArchivo nos ofrece una capa de abstracción para leer/escribir y procesar archivos
 * */
public class TrabajarArchivo {
    /** El método stático countLines() nos devuelve el número líneas del archivo
     * @param file File que queremos contar el número de líneas
     * @return lineas. Entero con el número de líneas del archivo pasado (incluye el encabezado)
     * */
    static int countLines(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lineaCont = 0;
        String linea;
        while ((linea = reader.readLine()) != null) {
            lineaCont++;
        }
        reader.close();
        return lineaCont;
    }

    /** El método estático leerParametros nos parsea un archivo CSV y nos lo devuelve como un objeto de la clase Parametros
     *
     * @param file archivo CSV con los campos String nombre, email, saldo y oferta
     * @param i será el número de líneas que tiene el archivo
     *
     * @return Parametros. Objeto con 4 atributos String (nombre, email, saldo y oferta)
     * @throws IOException
     * * */

    public static List<Parametros> cargarParametros(File file, int i) throws IOException {
        List<Parametros> parametrosList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String header = br.readLine();
            String[] headerFields = header.split(",");
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length < headerFields.length) {
                    System.out.println("La línea " + line + " no contiene suficientes valores.");
                    continue;
                }
                String nombre = fields[0].trim();
                String email = fields[1].trim();
                String saldo = fields[2].trim();
                String oferta = fields[3].trim();
                Parametros parametros = new Parametros(nombre, email, saldo, oferta);
                parametrosList.add(parametros);
            }
            return parametrosList;
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /** Método estático leerArchivo devuelve un String con el archivo completo
     *
     * @param file - File a leer
     * @return String con el contenido
     */
    static String cargarArchivo(File file) throws IOException {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(file));
            StringBuilder cadena = new StringBuilder();
            String linea = null;

            while ((linea = lector.readLine()) != null) {
                cadena.append(linea).append("\n");
            }
            lector.close();
            String contenido = cadena.toString();
            return contenido;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** método stático escribeArchivo
     *
     * @param texto - String con el texto a escribir
     * @param nombreArchivo - String con el nombre del archivo
     * @return boolean si todo ok o no
     */
    static boolean escribirArchivo(String texto, String nombreArchivo){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            writer.write(texto);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}