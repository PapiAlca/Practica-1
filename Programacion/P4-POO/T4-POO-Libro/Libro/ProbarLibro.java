package Libro;
//autor: Juan Parejo García

public class ProbarLibro {
    public static void main(String[] args) {
        Libro n1 = new Libro();
        Libro n2 = new Libro("El Quijote", "Miguel de Cervantes", 5, 0);

        n1.prestamo(1);
        n2.prestamo(1);

        System.out.println(n1);
        System.out.println(n2);

        n1.devolucion(1);
        n2.devolucion(1);

        System.out.println(n1);
        System.out.println(n2);
    }
}
