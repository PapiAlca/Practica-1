package Ejercicio1;
import java.util.ArrayList;

public class Equipos {
    public static void main(String[] args) {
        Equipo n1 = new Equipo("Real");
        Equipo n2 = new Equipo("Barça");
        Equipo n3 = new Equipo("Porcinos");
        Equipo n4 = new Equipo("Jey Jey");

        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        equipos.add(n1);
        equipos.add(n2);
        equipos.add(n3);
        equipos.add(n4);

        for(int i=0; i<equipos.size(); i++) {
            System.out.println(equipos.get(i));
        }
    }
}
