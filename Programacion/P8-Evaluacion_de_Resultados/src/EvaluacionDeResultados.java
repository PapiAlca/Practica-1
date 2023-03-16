/*
* Autor: Juan Parejo García
* Clase Main. EvaluaconDeResultados
*/

import java.util.*;
public class EvaluacionDeResultados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de alumnos: ");
        int numAlumnos = sc.nextInt();

        for(int i=0; i<numAlumnos; i++) {
            System.out.println("Crea al alumno en este orden: nombre, num de modulos, notas de los módulos:");
            new Alumno(sc.nextLine(), sc.nextInt());
        }

        /*
        System.out.print("Introduce el número de módulos: ");
        int numModulos = sc.nextInt();
        Map<Integer, Map<Integer, Integer>> notas = new HashMap<>();

        // Pedimos las notas de cada alumno para cada módulo
        for (int i = 1; i <= numAlumnos; i++) {
            System.out.println("Alumno " + i + ":");
            Map<Integer, Integer> notasAlumno = new HashMap<>();
            for (int j = 1; j <= numModulos; j++) {
                System.out.print("Nota del módulo " + j + ": ");
                notasAlumno.put(j, sc.nextInt());
            }
            notas.put(i, notasAlumno);
        }

        // Calculamos la media de notas de cada alumno
        double[] mediasAlumnos = new double[numAlumnos];
        double numSinModulos = 0;
        for (int i = 1; i <= numAlumnos; i++) {
            Map<Integer, Integer> notasAlumno = notas.get(i);
            int suma = 0;

            for (int j = 1; j <= numModulos; j++) {
                if(notasAlumno.get(j) !=-1) {
                    suma += notasAlumno.get(j);
                }
                else {
                    suma += 0;
                    numSinModulos++;
                }
            }
            mediasAlumnos[i - 1] = (double) suma / (numModulos-numSinModulos);
        }

        // Calculamos la media de notas de cada módulo
        double[] mediasModulos = new double[numModulos];
        for (int j = 1; j <= numModulos; j++) {
            int suma = 0;
            for (int i = 1; i <= numAlumnos; i++) {
                Map<Integer, Integer> notasAlumno = notas.get(i);
                suma += notasAlumno.get(j);
            }
            mediasModulos[j - 1] = (double) suma / numAlumnos;
        }

        // Calculamos la media global
        double sumaTotal = 0;
        for (int i = 1; i <= numAlumnos; i++) {
            Map<Integer, Integer> notasAlumno = notas.get(i);
            for (int j = 1; j <= numModulos; j++) {
                sumaTotal += notasAlumno.get(j);
            }
        }
        double mediaGlobal = sumaTotal / (numAlumnos * numModulos);

        // Mostramos los resultados
        System.out.println("Media de notas por alumno:");
        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("Alumno " + (i + 1) + ": " + mediasAlumnos[i]);
        }

        System.out.println("Media de notas por módulo:");
        for (int j = 0; j < numModulos; j++) {
            System.out.println("Módulo " + (j + 1) + ": " + mediasModulos[j]);
        }

        System.out.println("Media global: " + mediaGlobal); */
    }
}