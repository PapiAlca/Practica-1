import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransmisionDeArchivos {
    public static void main(String[] args) {
        String archivoTXT;
        int tamanoTrama, numeroTrama, numeroCaracteres;
        StringBuilder contenidoTrama;

        archivoTXT = "datos.txt";
        //TramaEthernet n1 = new TramaEthernet( "##########################", 001);

        tamanoTrama = 60;
        numeroTrama = 1;
        numeroCaracteres = 0;
        contenidoTrama = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoTXT))) {

            // Leer archivo caracter por caracter
            int c;
            while ((c = br.read()) != -1) {

                // Incrementar contador de caracteres
                numeroCaracteres++;

                // Agregar caracter a la trama
                contenidoTrama.append((char) c);

                // Si llegamos al tamano maximo de la trama, crear objeto Trama y reiniciar variables
                if (numeroCaracteres == tamanoTrama) {
                    Trama trama = new Trama(contenidoTrama.toString(), numeroTrama);
                    System.out.println(trama);
                    numeroTrama++;
                    numeroCaracteres = 0;
                    contenidoTrama = new StringBuilder();
                }
            }

            // Si quedan caracteres por agregar a la trama, crear objeto Trama con esos caracteres
            if (numeroCaracteres > 0) {
                Trama trama = new Trama(contenidoTrama.toString(), numeroTrama);
                System.out.println(trama);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}