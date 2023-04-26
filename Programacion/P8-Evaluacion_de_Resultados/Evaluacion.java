import java.util.*;

public class Evaluacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Alumno> alumnos = new ArrayList<>();
        Float[] mediasModulos = null;
        Random rnd = new Random();

        System.out.println("Escribe los nombres de los alumnos:");
        String[] nombres = scanner.nextLine().split(" ");

        for (String nombre : nombres) {
            alumnos.add(new Alumno(nombre));
        }

        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = alumnos.get(i);
            System.out.println("Escribimos las notas de " + alumno.getNombre() + ":");
            for (String modulo : Alumno.MODULOS) {
                Float nota = (float) rnd.nextInt(11) -1;

                if (nota != -1) {
                    alumno.agregarNota(modulo, nota);
                }
            }
        }

        System.out.println("Evaluación :");
        System.out.print("        Prog   BBDD   SIS   | Media\n");
        for (Alumno alumno : alumnos) {
            System.out.print(alumno.getNombre() + "         ");
            alumno.imprimirEvaluacion();
            System.out.println();
        }

        HashMap<String, Float> medias = new HashMap<String, Float>();
        for (String modulo : Alumno.MODULOS) {
            Float sum = 0f;
            int count = 0;
            for (Alumno alumno : alumnos) {
                Float nota = alumno.getNota(modulo);
                if (nota != -1) {
                    sum += nota;
                    count++;
                }
            }
            Float media = (count > 0) ? sum / count : -1;
            medias.put(modulo, media);
        }

        System.out.print("Media Modulos:   ");
        mediasModulos = new Float[Alumno.MODULOS.length];
        for (int i = 0; i < Alumno.MODULOS.length; i++) {
            Float media = medias.get(Alumno.MODULOS[i]);
            System.out.printf("%4.2f  ", media);
            mediasModulos[i] = media;
        }
        System.out.println();

        float mediaTotal = 0;
        int count = 0;
        for (Float media : mediasModulos) {
            if (media != -1) {
                mediaTotal += media;
                count++;
            }
        }

        System.out.println("La media total de los módulos es: " + (mediaTotal / count));
    }
}