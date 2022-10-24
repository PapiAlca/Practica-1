package T4-POO-Coche;
//autor Juan Parejo García

public class Coche {
    //Variables:
    int velocidad;
    int direccion;
    String color;
    int ruedas;
    boolean estado;

    //Constructor
    public Coche(int velocidad, int direccion, String color, int ruedas, boolean estado) {
        this.velocidad = velocidad;
        this.direccion = direccion;
        this.color = color;
        this.ruedas = ruedas;
        this.estado = estado;
    }

    //Getters y Setters
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDireccion() {
        return direccion;
    }
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getRuedas() {
        return ruedas;
    }
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int acelerar(int cantidad){
        this.velocidad = velocidad + cantidad;
        return velocidad;
    }

    public int frenar(int cantidad) {
        this.velocidad = velocidad - cantidad;
        return velocidad;
    }

    public int girar(int angulo) {
        this.direccion = angulo;
        return angulo;
    }

    public void parar(boolean estado) {
        estado = false;
        this.estado = estado;
        this.velocidad = 0;
    }

    public String repintar(String color) {
        this.color = color;
        return color;
    }

    public String verVelocidad() {
        return "Mi coche va a una velocidad de " + velocidad + " Km/h.";
    }

    public String verDireccion() {
        return "Mi coche va a " + direccion + "º.";
    }

    public String verColor() {
        return "Mi coche es de color " + color + ".";
    }

    public String verNumeroDeRuedas() {
        return "Mi cohe tiene " + ruedas + " ruedas.";
    }
}