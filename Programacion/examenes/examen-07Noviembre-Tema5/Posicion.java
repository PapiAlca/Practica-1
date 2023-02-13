/* Examen 7 de Noviembre, Tema 4, autor: Juan Parejo García

Netflix
Queremos crear un clon personal de Netflix. Para ello deberemos crear la Clase Serie que nos gestione las series con los atributos
(todas las series tienen el mismo num de temporadas):

String nombre.
int temporadas, capítulos.
Posicion: objeto con los atributos int temporada, int capitulo e int posicion (en minutos).
Para ello deberemos:

[1p] Crear un constructor de Serie con TODOS los atributos (el por defecto no).
[2p] Crear la Clase Posicion con su constructor por defecto y con TODOS los atributos.
[1p] Crear los getters y setters de la Clase Posicion.
[1,5p] Sobreescribe el método toString de la Clase Serie, asegurándote que llama al toString de la clase Posicion.
Crea una clase para probar tus clases Serie y Posicion:
[0,5p] Invoca al constructor de Posicion con los valores de ir visionando por la temporada 3, capítulo 2, minuto 15.
[0,5p] Invoca al constructor de Seriepasándole los datos 'The Wire', 5 temporadas, 10 capítulos y el objeto posición del punto 1.
[1p] Invoca al constructor por defecto de Posicion y luego utilizar los setters para actualizar a temporada 4, capítulo 6, minuto 27.
[0,5p] Invoca al constructor de Serie pasándole los datos 'IT Crew', 4 temporadas, 6 capítulos y la posición del punto 3.
[1p] Imprime por pantalla los datos de las 2 series (invocanto a los toString sobreescritos).
[1p] Documentación del proyecto (en las Clases).
Tiempo: 130 minutos => Hora máxima del commit 17:10 CEST del 7 de noviembre de 2022

Instrucciones:

Debes crear y subir tu exámen a tu repositorio con un README.md con tu nombre y apellidos y la estructura de archivos utilizada.
Debes adjuntar 3 archivos fuente: ExT4.java, Serie.java y Posicion.java. la corrección será automática por lo que si no se llaman
EXACTAMENTE así no funcionará.
Sólo puedes utilizar el CLI y el bloc de notas o notepad++. Está expresamente prohivido el uso de cualquier otra herramie
 */
//Clase Posicion de la clase Serie:
public class Posicion {
    //Variables de la clase Posicion:
    int temporada, capitulo, posicion;

    //Constructor de la clase Posicion:
    public Posicion(int temporada, int capitulo, int posicion) {
        this.temporada = temporada ;
        this.capitulo = capitulo;
        this.posicion = posicion;
    }

    //Getters y Setters de la clase Posicion:
    public int getTemporada() {
        return temporada;
    }
    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getCapitulo() {
        return capitulo;
    }
    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    //Métodos de la clase Posicion:
    @Override
    public String toString() {
        return "En esta serie me he quedado en el minuto " + posicion + " del capítulo " + capitulo + " de la temporada " + temporada + ".";
    }
}
