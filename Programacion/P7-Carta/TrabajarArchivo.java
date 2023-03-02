import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
     * @param CSV archivo CSV con los campos String nombre, email, saldo y oferta
     * @param i lee la fila i del archvivo
     * @return Parametros. Objeto con 4 atributos String (nombre, email, saldo y oferta)
     * */
    static Parametros leerParametros(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String linea;
        int i = 10;
        int lineaCont = 0;
        while ((linea = reader.readLine()) != null) {
            lineaCont++;
            if (lineaCont == i) {
                String[] campos = linea.split(",");
                Parametros parametros = new Parametros(campos[0], campos[1], campos[2], campos[3]);
                reader.close();
                return parametros;
            }
        }
        reader.close();
        return null;
    }

    /**
     * El método estático leerModulos nos parsea un archivo CSV y nos lo devuelve un array con el nombre de los módulos (primer campo vacío)
     *
     * @param CSV archivo CSV con un campo vacío (o con "nombre") y un número indefinido de columnas con el nombre de cada módulo <String>
     * @return String[].
     */
    static String[] leerModulos(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] campos = linea.split(",");
            String[] modulos = new String[campos.length - 1];
            for (int i = 1; i < campos.length; i++) {
                modulos[i - 1] = campos[i];
            }
            reader.close();
            return modulos;
        }
        reader.close();
        return null;
    }

    /**
     * El método estático leerAlumno nos parsea un archivo CSV y nos lo devuelve un objeto de la clase Alumno
     *
     * @param CSV archivo CSV con los campos String nombre y un número indefinido de columnas con las notas de cada módulo <float>
     * @param i   lee la fila i del archvivo
     * @return Alumno. Objeto con 2 atributos nombre <String> y array notas <float>
     */
    static Alumno leerAlumno(File file, int i) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String linea;
        int lineaCont = 0;
        while ((linea = reader.readLine()) != null) {
            lineaCont++;
            if (lineaCont == i) {
                String[] campos = linea.split(",");
                String nombre = campos[0];
                float[] notas = new float[campos.length - 1];
                for (int j = 1; j < campos.length; j++) {
                    notas[j - 1] = Float.parseFloat(campos[j]);
                }
                reader.close();
                return new Alumno(nombre, notas);
            }
        }
        reader.close();
        return null;
    }

    /** Método estático leerArchivo devuelve un String con el archivo completo
     *
     * @param file - File a leer
     * @return String con el contenido
     */
    static String leerArchivo(File file) throws IOException {
        String contenido = new String(Files.readAllBytes(Paths.get(file)));
        return contenido;
    }

    /** método stático escribeArchivo
     *
     * @param texto - String con el texto a escribir
     * @param nombreArchivo - String con el nombre del archivo
     * @return boolean si todo ok o no
     */
    static boolean escribeArchivo(String texto, String nombreArchivo){
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