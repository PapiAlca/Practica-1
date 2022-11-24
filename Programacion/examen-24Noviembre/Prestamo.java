/*
-Autor: Juan Parejo García

-Clase Objeto Prestamo
*/
import java.time.*;
public class Prestamo {
	//Variables
	Lector lector;
	Libro libro;
	LocalDate fechaPrestamo;
	LocalDate fechaDevolucion;
	
	//Constructor de la clase Libro:
	public Prestamo(Lector lec, Libro lib, LocalDate fechaPrestamo){
		this.lector = lec;
		this.libro = lib;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = null;
	}
	
	//Constructor de la clase Libro por defecto:
	public Prestamo(Lector lec){
		this.lector = lec;
		this.libro = null;
		this.fechaPrestamo = null;
		this.fechaDevolucion = null;
	}
	
	/* No implementaremos sus getters y setters ya que los valores de esta 
	clase no cambiaran, exceptuando los de las variables LocalDate que usaremos metodos de la clase importada. */
	
	public void devolver(Libro lib, Lector lec) {
		fechaDevolucion = LocalDate.now();
		Period dif = Period.between(fechaPrestamo, fechaDevolucion);
		if(dif.getDays() > 15){
			lec.setMoroso(false);
		}
		lib.setEstado(true);
	}
	/* devolver() lo que hace es añadir la fecha de devolucion cuando se llame y luego se hace la diferencia. 
	Si la diferencia dá más de 15 días se le pondrá moroso al lector */
	
	public boolean prestable(Libro lib) {
		if (fechaDevolucion != null) {
			fechaPrestamo = LocalDate.now(); //Crea la fecha de prestamo en el caso de que se haya devuelto el libro.
			System.out.println("Su fecha de préstamo es " + this.fechaPrestamo + " deberás traer el libro en un plazo de 15 días, no seas moroso.");
			lib.setEstado(true);
		}
		else {
			System.out.println("Este libro lo tiene otra persona, espera o escoge otro");
			lib.setEstado(true);
		}
		return lib.getEstado();
	}
}