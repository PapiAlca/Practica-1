//autor: Juan Parejo García

import java.util.Scanner;
public class E2 {
    public static void main(String[] args) {
        //Variables:
        int num1, num2, resto, mayor, menor, cociente;

        //1.- Sacar por pantalla el primer argumento recibido:
        System.out.printf("Hola soy " + args[0]);

        //2.- Sacar por pantalla el nombre del usuario del sistema:
        System.out.println("Hola soy " + System.getProperty("user.name"));

        //3.- Leer 2 números enteros insertados por el usuario:
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        num2 = sc.nextInt();

        System.out.println("El primer número es: " + num1 + ", el segundo número es: " + num2 + ".");

        //4.- Hallar el resto de la división de los dos números introducidos anterior mente:
        resto = num1%num2;
        System.out.println("El resto de la división de " + num1 + " entre " + num2 + " es: " + resto + ".");

        //5.- Hallar la división sabiendo que el número mayor será el dividendo y el menor el divisor:
        mayor = (num1 > num2)? num1 : num2;
        menor = (num1 <= num2)? num1 : num2;
        cociente = mayor / menor;

        System.out.println("El cociente de la división de " + mayor + " entre " + menor + " = " + cociente + ".");

        //6.- Mostrar el valor de la variable de entorno turbo:
        System.out.println("La variable de entorno turbo tiene un valor de: " + System.getProperty("turbo"));
    }
}