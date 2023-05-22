import java.util.Objects;

public class Actor implements Comparable<Actor> {
    String nombre, apellido;
    int contador;

    public Actor(String nombre, String apellido, int contador) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }
    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(nombre, actor.nombre) && Objects.equals(apellido, actor.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }

    @Override
    public int compareTo(Actor o) {
        return Integer.compare(o.contador, contador);
    }
}
