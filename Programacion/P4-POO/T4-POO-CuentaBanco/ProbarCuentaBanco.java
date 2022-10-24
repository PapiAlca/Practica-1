package T4-POO-CuentaBanco;
//autor: Juan Parejo García

public class ProbarCuentaBanco {
    public static void main(String[] args) {
        CuentaBanco num1 = new CuentaBanco(500, 30, "Juan", 0.01);
        CuentaBanco num2 = new CuentaBanco(250, 30, "Luis", 0.01);

        num1.sacar(300);
        num2.ingresar(300);
        num2.calcularIntereses(num2.saldo, num2.rentabilidad);
        System.out.println(num1.verSaldo());
        System.out.println(num2.verSaldo());
        num1.sacar(300);
        num2.ingresar(300);
        num2.calcularIntereses(num2.saldo, num2.rentabilidad);
        System.out.println(num1.verSaldo());
        System.out.println(num2.verSaldo());
    }
}
