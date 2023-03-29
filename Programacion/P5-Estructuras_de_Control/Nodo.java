/*
* Autor: Juan Parejo García
* Clase Objeto Nodo
*/
public class Nodo {
    int hijo;
    Nodo[] hijos;
    int altura;

    public Nodo(String[] valores, int valor) {
        this.hijo = Integer.parseInt(valores[valor]);

        hijos = new Nodo[hijo];

        for(int i=0; i<hijo; i++) {
            hijos[i] = new Nodo(valores, valor+1);
            altura = Math.max(altura, hijos[i].getAltura());
            valor += hijos[i].getProfundidad();
        }
    }

    public int getAltura() {
        return altura + 1;
    }

    public int getProfundidad() {
        int profundidad=1;
        for (int i=0; i<hijo; i++) {
            profundidad += hijos[i].getProfundidad();
        }
        return profundidad;
    }
}
