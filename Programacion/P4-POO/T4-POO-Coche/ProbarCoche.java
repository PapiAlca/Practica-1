package T4-POO-Coche;
//autor: Juan Parejo García

public class Main {
    public static void main(String[] args) {
        Coche Ford = new Coche(0, 0, "Azul", 4, true);

        Ford.acelerar(100);
        System.out.println(Ford.verVelocidad());
        Ford.frenar(30);
        System.out.println(Ford.verVelocidad());
        Ford.girar(30);
        System.out.println(Ford.verDireccion());
        Ford.acelerar(40);
        System.out.println(Ford.verVelocidad());
        Ford.frenar(70);
        System.out.println(Ford.verVelocidad());
        Ford.girar(-45);
        System.out.println(Ford.verDireccion());


        System.out.println(Ford.verVelocidad());
        System.out.println(Ford.verDireccion());
        System.out.println(Ford.verColor());
        System.out.println(Ford.verNumeroDeRuedas());
        Ford.parar(false);
    }
}
