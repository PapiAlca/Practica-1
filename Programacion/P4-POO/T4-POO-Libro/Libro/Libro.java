package Libro;
//autor: Juan Parejo García

import java.util.*;
public class Libro {
    //Variables:
    String titulo, autor;
    int ejemplar, ejemplar_prestado;
    Scanner sc = new Scanner(System.in);

    //Constructor por parámetros:
    public Libro(String titulo, String autor, int ejemplar, int ejemplar_prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplar = ejemplar;
        this.ejemplar_prestado = ejemplar_prestado;
    }

    //Constructor que da valores:
    public Libro() {
        this.titulo = sc.nextLine();
        this.autor = sc.nextLine();
        this.ejemplar = sc.nextInt();
        this.ejemplar_prestado = sc.nextInt();
    }

    //Getters y Setters:
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplar() {
        return ejemplar;
    }
    public void setEjemplar(int ejemplar) {
        this.ejemplar = ejemplar;
    }

    public int getEjemplar_prestado() {
        return ejemplar_prestado;
    }
    public void setEjemplar_prestado(int ejemplar_prestado) {
        this.ejemplar_prestado = ejemplar_prestado;
    }

    //Métodos:
    public boolean prestamo(int ejemplar_prestado) {
        if(ejemplar_prestado < this.ejemplar && this.ejemplar_prestado >=0 && this.ejemplar_prestado <= this.ejemplar) {
            this.ejemplar_prestado =+ ejemplar_prestado++;
            System.out.println("Se ha concedido el préstamo del libro " + titulo + " del autor " + autor + ".");
            return true;
        }
        else {
            System.out.println("No se ha concedido el préstamo del libro " + titulo + " del autor " + autor + ", no quedan ejemplares.");
            return false;
        }
    }

    public boolean devolucion(int ejemplar_prestado) {
        if(ejemplar_prestado < this.ejemplar && this.ejemplar_prestado <= this.ejemplar) {
            this.ejemplar_prestado =- ejemplar_prestado--;
            System.out.println("Se ha devuelto el libro " + titulo + " del autor " + autor + ".");
            return true;
        }
        else {
            System.out.println("No se ha devuelto el libro " + titulo + " del autor " + autor + ", ya que están todos sus ejemplares.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "El libro " + titulo + " de autor " + autor + ", se han prestado " + ejemplar_prestado + "/" + ejemplar + " Prestados/Totales.";
    }
}