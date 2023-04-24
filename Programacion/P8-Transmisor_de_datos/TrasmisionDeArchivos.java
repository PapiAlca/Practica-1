import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TrasmisionDeArchivos {
    public static void main(String[] args) {
        String archivoTXT;
        int tamanoTrama, numeroTrama, numeroCaracteres;
        StringBuilder contenidoTrama;

        archivoTXT = "datos.txt";

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
                char cha = (char) c;
                contenidoTrama.append((cha == '\n')?"\\n": (cha == '\r')? "\\r": cha);

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