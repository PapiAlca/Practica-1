/*
-Autor: Juan Parejo García

-Clase Objeto Lector
*/
public class Lector{
	//Variables
	int numero;
	String nombre;
	boolean moroso;
	
	//Constructor de la clase Lector:
	public Lector(int numero, String nombre){
		this.numero = numero;
		this.nombre = nombre;
		this.moroso = false;
	}
	//Getters y Setter solo del atributo boolean moroso ya que puede cambiar a true o false. Los demás atributos no cambiaran.
	public boolean getMoroso() {
		return this.moroso;
	}
	public void setMoroso(boolean moroso) {
		this.moroso = moroso;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}