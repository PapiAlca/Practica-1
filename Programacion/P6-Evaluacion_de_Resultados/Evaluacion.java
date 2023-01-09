/*
-Autor: Juan Parejo García
-Clase Main Evaluacion
*/
public class Evaluacion {
    //Método para conseguir la media del módulo BBDD:
    public static float getMediaBBDD(Alumno[] a) {
        float suma, media;
        int cuenta;

        suma=0;
        cuenta=0;
        for(int i=0; i< a.length; i++) {
            if(a[i].getNotaBBDD()!=-1) {
                suma += a[i].getNotaBBDD();
                cuenta++;
            }
        }
        media = suma/cuenta;
        return media;
    }

    //Método para conseguir la media del módulo Entornos:
    public static float getMediaEntorno(Alumno[] a) {
        float suma, media;
        int cuenta;

        suma=0;
        cuenta=0;
        for(int i=0; i< a.length; i++) {
            if(a[i].getNotaEntorno()!=-1) {
                suma += a[i].getNotaEntorno();
                cuenta++;
            }
        }
        media = suma/cuenta;
        return media;
    }

    //Método para conseguir la media del módulo FOL:
    public static float getMediaFol(Alumno[] a) {
        float suma, media;
        int cuenta;

        suma=0;
        cuenta=0;
        for(int i=0; i< a.length; i++) {
            if(a[i].getNotaFol()!=-1) {
                suma += a[i].getNotaFol();
                cuenta++;
            }
        }
        media = suma/cuenta;
        return media;
    }

    //Método para conseguir la media del módulo Lenguaje:
    public static float getMediaLenguaje(Alumno[] a) {
        float suma, media;
        int cuenta;

        suma=0;
        cuenta=0;
        for(int i=0; i< a.length; i++) {
            if(a[i].getNotaLenguaje()!=-1) {
                suma += a[i].getNotaLenguaje();
                cuenta++;
            }
        }
        media = suma/cuenta;
        return media;
    }

    //Método para conseguir la media del módulo Programación:
    public static float getMediaProg(Alumno[] a) {
        float suma, media;
        int cuenta;

        suma=0;
        cuenta=0;
        for(int i=0; i< a.length; i++) {
            if(a[i].getNotaProg()!=-1) {
                suma += a[i].getNotaProg();
                cuenta++;
            }
        }
        media = suma/cuenta;
        return media;
    }

    //Método para conseguir la media del módulo Sistemas:
    public static float getMediaSistemas(Alumno[] a) {
        float suma, media;
        int cuenta;

        suma=0;
        cuenta=0;
        for(int i=0; i< a.length; i++) {
            if(a[i].getNotaFol()!=-1) {
                suma += a[i].getNotaFol();
                cuenta++;
            }
        }
        media = suma/cuenta;
        return media;
    }
    public static void main(String[] args) {
        Alumno n1, n2, n3;
        int i;

        n1 = new Alumno("Juan", 5, -1, -1, 6, 7, 8);
        n2 = new Alumno("Rodrigo", 7, -1, -1, -1, 5, 6);
        n3 = new Alumno("Julian", 7, 3, 4, 9, 5, 4);
        Alumno[] alumnos = {n1, n2, n3};

        //Método para conseguir la media Total de los módulos:
        for(i=0; i< alumnos.length; i++) {
            System.out.println(alumnos[i]);
        }
        System.out.println("[Media BBDD: "+getMediaBBDD(alumnos)+"] [Media Entorno: "+getMediaEntorno(alumnos)+"] " +
                "[Media FOL: "+getMediaFol(alumnos)+"] [Media Lenguaje: "+getMediaLenguaje(alumnos)+"] [Media Programación: "
                +getMediaProg(alumnos)+"] [Media Sistemas: "+getMediaSistemas(alumnos)+"]");
        System.out.println("[Media total: " +(getMediaBBDD(alumnos)+getMediaEntorno(alumnos)+getMediaFol(alumnos)+getMediaLenguaje(alumnos)+getMediaProg(alumnos))/6 + "]" );
    }
}