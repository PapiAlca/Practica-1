/* Práctica del Tema 5 "Altura de un árbol general" */

//autor: Juan Parejo García

//Clase Objeto: Nodo.
public class Nodo{
	String valor;
	int altura;
	boolean hijo;
	
	//Constructor:
    public Nodo(String valor, int altura, boolean hijo) {
        this.valor = valor;
		this.altura = altura;
		this.hijo = hijo;
    }
	
	//Constructor por defecto o Constructor del primer nodo{
		public Nodo(String valor) {
        this.valor = valor;
		this.altura = 1;
		this.hijo = false;
    }

    //Getters y Setters:
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
	
	public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
	
	public boolean getHijo() {
		return hijo;
	}
	public void setBoolean(boolean hijo) {
		this.hijo = hijo;
	}
	
	//Métodos:
	public boolean esHijoDe(boolean hijo) {
		if (this.altura > 1) {
			hijo = true;
		}
		else {
			hijo = false;
		}
		this.hijo = hijo;
		return hijo;
	}
	
	public void calcularAltura() {
		if (this.hijo == true && this.valor != "0") {
			this.altura += 1;
		}
	}
}