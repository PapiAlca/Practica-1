/*
-Autor: Juan Parejo García

-Clase Main Main
*/
import java.util.*;
public class Main{
	public static void main(String[] args) {
		//Variables:
		Scanner sc = new Scanner(System.in);
		int condicion;
		
		//Objetos:
		Libro n1, n2, n3;
		Lector a, b, c;
		Prestamo num1, num2, num3, num4;
		
		n1 = new Libro(1, "El camino", "Miguel Delibes");
		n2 = new Libro(2, "Cien años de soledad", "Gabriel García Márquez");
		n3 = new Libro(3, "Rayuela", "Julio Cortázar");
		
		a = new Lector(1, "Juan");
		b = new Lector(2, "Luis");
		c = new Lector(3, "Rodrigo");
		
		//Apartado 4 b Prestar dos libros  a un lector y el ultimo a otro:
		num1 = new Prestamo(a);
		num1.prestable(n1);
		
		num2 = new Prestamo(a);
		num2.prestable(n2);
		
		num3 = new Prestamo(b);
		num3.prestable(n3);
		
		//Apartado 4 c Prestar un libro que ya esté prestado:
		num4 = new Prestamo(c);
		num4.prestable(n1);
		
		//Apartado 4 d Intentar devolver u libro que tenga 15 días de retraso:
		num3.dif.setDays(16);
		
		//Ponemos de manera manual la diferencias de dias a 15 porque no han pasado 15 días:
		num3.devolver(n2, a);
		
	}
}