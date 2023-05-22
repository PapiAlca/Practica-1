public class PrimeraConsulta {
    int socioID;
    String nombre;
    String apellido;
    String titulo;

    public PrimeraConsulta(int socioID, String nombre, String apellido, String titulo) {
        this.socioID = socioID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return  "+=================================================================+\n" +
                " -Socio: " + socioID +". \n" +
                " -Nombre: " + nombre +". \n" +
                " -Apellido: " + apellido +". \n" +
                " -Película alquilada: " + titulo +". \n" +
                "+=================================================================+\n"
                ;
    }
}
