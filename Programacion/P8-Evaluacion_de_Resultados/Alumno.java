import java.util.*;
import java.util.stream.Collectors;

public class Alumno {

    protected static final String[] MODULOS = {"Prog", "BBDD", "SIS"};
    private String nombre;
    private Map<String, Float> notas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        notas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarNota(String modulo, Float nota) {
        notas.put(modulo, nota);
    }

    public Float getNota(String modulo) {
        return notas.getOrDefault(modulo, -1.0f);
    }

    public Float calcularMedia() {
        List<Float> notasValidas = notas.values()
                .stream()
                .filter(nota -> nota != -1.0)
                .collect(Collectors.toList());

        if (notasValidas.isEmpty()) {
            return 0f;
        }

        return notasValidas.stream()
                .reduce(0f, Float::sum) / notasValidas.size();
    }

    public void imprimirEvaluacion() {
        for (String modulo : MODULOS) {
            Float nota = notas.getOrDefault(modulo, -1.0f);
            if (nota == -1.0) {
                System.out.print(" XXX ");
            } else {
                System.out.print(nota + "  ");
            }
        }
        System.out.print("| " + calcularMedia());
        System.out.println("\n");
        System.out.println("=======================================");
    }
}