/* Práctica del Tema 5 "Altura de un árbol general" */

//autor: Juan Parejo García

//Clase Objeto: Arbol.
public class Arbol {
    //Variable:
    String cadena;
	int profundidad;
	Nodo standard;

    //Constructor:
    public Arbol(String cadena, int profundidad, Nodo standard) {
        this.cadena = cadena;
		this.profundidad = profundidad;
		this.standard = standard;
    }

    //Getters y Setters:
    public String getCadena() {
        return cadena;
    }
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
	
	public String getProfundidad() {
        return profundidad;
    }
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
	
	public Nodo getStandard() {
        return standard;
    }
    public void setStandard(Nodo standard) {
        this.standard = standard;
    }
}