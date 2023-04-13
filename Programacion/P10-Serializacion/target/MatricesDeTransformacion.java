/*
 * Autor: Juan Parejo García
 * Clase Main MatricesDeTransformacion
 */

import java.util.*;

public class MatricesDeTransformacion {
    static String[][] cinematicaInversa2D(int a, int b){
        String[][] array = new String[10][10];

        System.out.println("Array: ");
        for (int y=array.length-1; y>=0 ; y--) {
            System.out.println();
            for (int x=0; x< array[0].length; x++) {
                //array[y][x] = "("+ y + ", "+ x + ")";
                array[y][x] = "   "+x+"-"+y;
                System.out.print( array[y][x] );
                //System.out.print("("+ y + ", "+ x + ")");
            }
            System.out.println();
        }
        System.out.println("\n");
        System.out.println("Coordenadas pedidas:");
        System.out.println(array[a][b]);
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta las dos cordenadas: ");
        cinematicaInversa2D(sc.nextInt(), sc.nextInt());
    }
}