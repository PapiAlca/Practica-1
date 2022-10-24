package T4-POO-CuentaBanco;
//autor: Juan Parejo García

public class CuentaBanco {
    //Variables:
    double saldo;
    int limiteDescubierto;
    String titular;
    double rentabilidad;

    //Constructor:
    public CuentaBanco(float saldo, int limiteDescubierto, String titular, double rentabilidad) {
        this.saldo = saldo;
        this.limiteDescubierto = 0;
        this.titular = titular;
        this.rentabilidad = rentabilidad;
    }

    //Getters y Setters:
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public float getLimiteDescubierto() {
        return limiteDescubierto;
    }
    public void setLimiteDescubierto(int limiteDescubierto) {
        this.limiteDescubierto = limiteDescubierto;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getRentabilidad() {
        return rentabilidad;
    }
    public void setRentabilidad(double rentabilidad) {
        this.rentabilidad = rentabilidad;
    }

    //Métodos:
    public float ingresar(float euros) {
        this.saldo = saldo + euros;
        return euros;
    }

    public float sacar(float euros) {
        this.saldo = saldo - euros;
        return euros;
    }

    public int avisarDescubierto(int saldo) {
        saldo = (this.limiteDescubierto > saldo)? saldo : Integer.valueOf("Te has pasado del límite descubierto, tu saldo es de " +
                " "  + saldo + "€.");
        return saldo;
    }

    public double calcularIntereses(double saldo, double rentabilidad) {
        this.saldo = saldo;
        this.rentabilidad = rentabilidad;
        saldo = saldo - saldo * rentabilidad;
        return saldo;
    }

    public String verSaldo() {
        return "El saldo de la cuenta de " + titular + " es de " + saldo + "€.";
    }
}