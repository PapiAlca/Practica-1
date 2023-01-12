package examenArray;
/*
* Autor: Juan Parejo García
* Clase Main: Candado
*/
import java.util.*;
public class Candado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte una dificultad: ");
        CodigoSecreto n1 = new CodigoSecreto(sc.nextInt());



        System.out.println(n1);
    }
}
