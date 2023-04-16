import java.io.*;
import java.util.*;

public class TransmisionDeArchivos {
    private static final String PREAMBULO = "\u00AA\u00AA\u00AA\u00AA\u00AA\u00AA\u00AA";
    private static final String SFD = "\u00AB";
    private static final String DIRECCION_DESTINO = "\u00FF:\u00FF:\u00FF:\u00FF:\u00FF:\u00FF";
    private static String direccionOrigen; // La dirección origen la obtenemos dinámicamente
    private static final int LONGITUD_TRAMA = 60;
    private static final String FIN_LINEA = "\n";

    private static void enviarTramaEthernet(TramaEthernet trama) {
        // Simulamos el envío de la trama Ethernet imprimiéndola en
    }
}