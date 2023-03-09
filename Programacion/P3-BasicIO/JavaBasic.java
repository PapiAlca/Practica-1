//Author: Juan Parejo García
import java.util.Scanner;
public class JavaBasic {
    public static final String ANSI_AZUL = "\u001B[34m";
    public static final String ANSI_ROJO = "\u001B[31m";
    public static void main(String[] args) {
        int operador1, operador2, modulo, resto;

        String username = System.getProperty("user.name");
        System.out.println("El nombre de usuario es : " + username);
        String sistemaname = System.getProperty("os.name");
        System.out.println("El nombre del sistema operativo : " + sistemaname);
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el primer operador");
        operador1=sc.nextInt();
        System.out.println("Introduce el segundo operador");
        operador2=sc.nextInt();

        modulo = operador1/operador2;
        resto = operador1%operador2;
        System.out.println(ANSI_AZUL+operador1+"/"+operador2+ "=" + modulo + ANSI_ROJO + " El resto del modulo es: " + resto);
    }
}