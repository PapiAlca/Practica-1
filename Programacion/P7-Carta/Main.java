/*
 * Autor: Juan Parejo García
 * Clase Main Main
 */

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 0 - Declaración de variables
        String archivoTXT = "carta.txt";
        String archivoCSV = "destinatarios.csv";
        List<Parametros> destinatarios;
        String cartaTXT;

        // 1 - Cargamos el archivo CSV y lo parseamos dentro de una instancia de la clase Parametros:
        System.out.println("+--------------------+");
        System.out.println("| Realizando  Paso 1 |");
        System.out.println("+--------------------+");

        System.out.println("\n");
        System.out.println("Cargamos el archivo CSV y lo parseamos dentro de una instancia de la clase Parametros: ");
        destinatarios = TrabajarArchivo.cargarParametros(new File(archivoCSV), TrabajarArchivo.countLines(new File(archivoCSV)));

        System.out.println("+--------------------+");
        System.out.println("|  Paso 1 realizado  |");
        System.out.println("+--------------------+");


        // 2 - Cargamos la carta a memoria:
        System.out.println("+--------------------+");
        System.out.println("| Realizando  Paso 2 |");
        System.out.println("+--------------------+");

        System.out.println("\n");
        System.out.println("Cargamos la carta a memoria: ");
        cartaTXT = TrabajarArchivo.cargarArchivo(new File(archivoTXT));

        System.out.println("+--------------------+");
        System.out.println("|  Paso 2 realizado  |");
        System.out.println("+--------------------+");


        // 3 y 4 - Cargamos los datos CSV, y cargamos los datos a parsear según usuario:
        System.out.println("+------------------------+");
        System.out.println("| Realizando  Paso 3 y 4 |");
        System.out.println("+------------------------+");

        System.out.println("\n");
        System.out.println("Cargamos los datos del archivo .csv: ");
        System.out.println(destinatarios);

        System.out.println("+------------------------+");
        System.out.println("|  Paso 3 y 4 realizado  |");
        System.out.println("+------------------------+");


        // 5 - Ahora realizamos las sustituciones:
        System.out.println("+--------------------+");
        System.out.println("| Realizando  Paso 5 |");
        System.out.println("+--------------------+");

        System.out.println("\n");
        System.out.println("Realizamos las sustituciones en cada carta: ");
        List<String> cartaRellena = new ArrayList<>();
        for (int i=0; i<destinatarios.size(); i++) {
            String nombre, email, saldo, oferta, temp;
            temp = cartaTXT;

            nombre = destinatarios.get(i).getNombre();
            email = destinatarios.get(i).getEmail();
            saldo = destinatarios.get(i).getSaldo();
            oferta = destinatarios.get(i).getOferta();

            temp = temp.replace("$$nombre$$", nombre);
            temp = temp.replace("$$email$$", email);
            temp = temp.replace("$$saldo$$", saldo);
            temp = temp.replace("$$oferta$$", oferta);

            cartaRellena.add(temp);
        }

        System.out.println("+--------------------+");
        System.out.println("|  Paso 5 realizado  |");
        System.out.println("+--------------------+");


        // 6 - Escribimos las cartas y mostramos el resultado
        System.out.println("+--------------------+");
        System.out.println("| Realizando  Paso 6 |");
        System.out.println("+--------------------+");

        System.out.println("\n");
        System.out.println("Escribimos las cartas, en sus respectivos archivos: ");
        for(int i=0; i<cartaRellena.size(); i++) {
            TrabajarArchivo.escribirArchivo(cartaRellena.get(i), destinatarios.get(i).getNombre()+".txt");
            System.out.println("\n");
            System.out.println(cartaRellena.get(i));
        }

        System.out.println("+--------------------+");
        System.out.println("|  Paso 6 realizado  |");
        System.out.println("+--------------------+");
    }
}