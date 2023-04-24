/*
-Autor: Juan Parejo García
-Clase Main Evaluacion
*/
import java.util.*;

public class Evaluacion {
    public static void main(String[] args) {
        // Mapas para las notas de los módulos
        int sumaA;
        Map<Integer, Float> notasBBDD = new HashMap<>();
        Map<Integer, Float> notasProg = new HashMap<>();
        Map<Integer, Float> notasSistemas = new HashMap<>();
        List<Map<Integer, Float>> notasAsig = new ArrayList<>();

        notasAsig.add(notasBBDD);
        notasAsig.add(notasProg);
        notasAsig.add(notasSistemas);

        sumaA = 0;

        Alumno n1, n2, n3;
        int i;

        n1 = new Alumno("Juan");
        n2 = new Alumno("Rodrigo");
        n3 = new Alumno("Julian");
        Alumno[] alumnos = {n1, n2, n3};

        Random rnd = new Random();

        //Método para conseguir la media Total de los módulos:
        for(i=0; i< alumnos.length; i++) {
            for (Map<Integer, Float> mapa : notasAsig) {
                mapa.put(alumnos[i].getId(), (float) rnd.nextInt(11) -1);
            }
        }
        System.out.println("============================================================");
        System.out.println("Notas de los estudiantes: ");
        for(i=0; i<alumnos.length; i++) {
            System.out.print(alumnos[i]);
        }

        System.out.println("\n");
        System.out.println(notasAsig);
        System.out.println("============================================================");
        System.out.println("Media de cada alumno");
        for(i=0; i<alumnos.length; i++) {
            System.out.println(AlumnosMetodos.getMediaAlumno(alumnos[i].getId(), notasAsig));
        }

        System.out.println("============================================================");
        System.out.println("Media de cada módulo");
        for(i=0; i<notasAsig.size(); i++) {
            float valor = AlumnosMetodos.getMediaModulo(notasAsig.get(i));
            System.out.println(valor);
            sumaA += valor;
        }

        float mediaA = sumaA /((float) notasAsig.size());
        System.out.println("============================================================");
        System.out.println("Media general");
        System.out.println(mediaA);
        System.out.println("============================================================");
    }
}