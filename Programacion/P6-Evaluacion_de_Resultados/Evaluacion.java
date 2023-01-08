/*
-Autor: Juan Parejo García
-Clase Main Evaluacion
*/
public class Evaluacion {
    public static void main(String[] args) {
        Alumno n1, n2, n3;

        n1 = new Alumno("Juan", 5, -1, -1, 6, 7, 8);
        n2 = new Alumno("Rodrigo", 7, -1, -1, -1, 5, 6);
        n3 = new Alumno("Julian", 7, 3, 4, 9, 5, 4);
        Alumno[] alumnos = {n1, n2, n3};

        System.out.println(n1.getSumaAlumno() + " " + n1.getCuentaAlumno() + " " + n1.getMediaAlumno());
    }
}