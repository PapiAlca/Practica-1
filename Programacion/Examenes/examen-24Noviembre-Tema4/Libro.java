/*
-Autor: Juan Parejo García

-Clase Objeto Libro
*/
public class Libro{
	//Variables
	int codigo;
	String titulo;
	String autor;
	boolean estado;
	
	//Constructor de la clase Libro:
	public Libro(int codigo, String titulo, String autor){
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.estado = false;
	}
	
	/* No implementaremos sus getters y setters ya que los valores de esta clase 
	no cambiaran. Escepto un getter que nos pide el ejercicio */
	
	public boolean getEstado() {
		return this.estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}