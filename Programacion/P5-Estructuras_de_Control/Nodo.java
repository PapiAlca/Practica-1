/*
 * Autor: Juan Parejo García
 * Clase Objeto Nodo
 */

public class Nodo {
    int nodosHijos;
    Nodo[] hijos;
    int altura;

    public Nodo(String[] valores, int valor) {
        nodosHijos = Integer.parseInt(valores[valor]);

        hijos = new Nodo[nodosHijos];

        for(int i=0; i<nodosHijos; i++) {
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
        for (int i=0; i<nodosHijos; i++) {
            profundidad += hijos[i].getProfundidad();
        }
        return profundidad;
    }
}