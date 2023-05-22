import java.util.List;

public class SegundaConsulta {
    List<Actor> actores;

    public SegundaConsulta(List<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return  "+==================================================================================================================================+\n" +
                "Estos son los 5 actores más visionados: \n" +
                "-Actor 1: " + actores.get(0).getNombre() + " " + actores.get(0).getApellido() + ", Repe: " + actores.get(0).getContador() + ".\n"+
                "-Actor 2: " + actores.get(1).getNombre() + " " + actores.get(1).getApellido() + ", Repe: " + actores.get(1).getContador() + ".\n"+
                "-Actor 3: " + actores.get(2).getNombre() + " " + actores.get(2).getApellido() + ", Repe: " + actores.get(2).getContador() + ".\n"+
                "-Actor 4: " + actores.get(3).getNombre() + " " + actores.get(3).getApellido() + ", Repe: " + actores.get(3).getContador() + ".\n"+
                "-Actor 5: " + actores.get(4).getNombre() + " " + actores.get(4).getApellido() + ", Repe: " + actores.get(4).getContador() + ".\n"+
                "+==================================================================================================================================+"
                ;
    }
}
