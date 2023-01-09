/*
* Autor: Juan Parejo García
* Clase Main MatricesDeTransformacion
*/

import java.util.*;

public class MatricesDeTransformacion {
    static float[] cinematicaInversa2D(int x, int y){
        //Las variables creadas seran tipo double para poder realizar las cuentas con los métodos de la clase math
        double q1Double, q2Double, alpha, beta, D;
        double l = 1;
        /* Cuentas:
          q1 = alpha - beta
          q2 = arctag 2(+-\|1 -D^2, D)
          D = (x^2 + y^2 - l1^2 - l2^2 ) / 2*l1*l2 --> D = (x^2 + y^2 - 2) / 2, porque l = 1
          alpha = arctan2(y, x)
          beta = arctan2(l2*sin(q2), l1+l2 * cos(q2))
         */
        //Las 5 líneas siguientes son basicamente las cuentas que realizaremos a la hora de pasar las coordenadas a grados:
        D = (x*x + y*y - l*l - l*l) / 2;
        q2Double = Math.atan2(Math.sqrt(1 - D*D), D);
        alpha = Math.atan2(y, x);
        beta = Math.atan2(l*Math.sin(q2Double), l+l * Math.cos(q2Double));
        q1Double = alpha - beta;

        //Aqui lo que hago es transformar la medida de los ángulos q1 y q2, de radianes a grados:
        q1Double = (q1Double * 180) / Math.PI;
        q2Double = (q2Double * 180) / Math.PI;

        //Aquí he creado otras dos variables para transformar q1 y q2 de double a float que es lo que nos pide en el enunciado:
        float q1 = (float) q1Double;
        float q2 = (float) q2Double;

        //Por último creamos nuestro array y lo mostramos por pantalla:
        float array[] = {q1, q2};
        System.out.println("El ángulo del primer brazo es " + array[0] + "º.");
        System.out.println("El ángulo del segundo brazo es " + array[1] + "º.");
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta las dos cordenadas: ");
        cinematicaInversa2D(sc.nextInt(), sc.nextInt());
    }
}