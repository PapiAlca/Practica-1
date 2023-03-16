import java.util.*;
public class Alumno {
    String nombre;
    int[] modulos;
    Scanner sc = new Scanner(System.in);
    public int[] crearModulos(int numModulos) {
        modulos = new int[numModulos];
        if(sc.nextInt()>-2 && sc.nextInt() > 11) {
            for (int i = 0; i < modulos.length; i++) {
                System.out.println("Inserta la nota del módulo " + modulos[i]);
                modulos[i] = sc.nextInt();
            }
        }
    }
    public Alumno(String nombre, int[] modulos) {
        this.nombre = nombre;
        crearModulos();
    }

    public String getNombre() {
        return nombre;
    }
    public int[] getModulos() {
        return modulos;
    }
}
