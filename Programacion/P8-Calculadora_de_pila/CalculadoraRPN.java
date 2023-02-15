/*
 * Autor: Juan Parejo García
 * Clase Main: CalculadoraRPN
 */

import java.util.*;
public class CalculadoraRPN {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un caracter (+, *, = para obtener el resultado):");

        while (sc.hasNext()) {
            String entrada = sc.next();
            if (entrada.equals("+")) {
                if (pila.size() < 2) {
                    System.out.println("ERROR: la pila no tiene suficientes caracteres para realizar una suma.");
                }
                else {
                        int segundoOperando = pila.pop();
                        int primerOperando = pila.pop();
                        int resultado = primerOperando + segundoOperando;
                        pila.push(resultado);
                        System.out.println("Se realizó la suma: " + primerOperando + " + " + segundoOperando + " = " + resultado);
                    }
            }
            else
                if (entrada.equals("*")) {
                    if (pila.size() < 2) {
                        System.out.println("ERROR: la pila no tiene suficientes caracteres para realizar el producto.");
                    } else {
                        int segundoOperando = pila.pop();
                        int primerOperando = pila.pop();
                        int resultado = primerOperando * segundoOperando;
                        pila.push(resultado);
                        System.out.println("Se realizó la multiplicación: " + primerOperando + " * " + segundoOperando + " = " + resultado);
                    }
                } else if (entrada.equals("=")) {
                    if (pila.size() != 1) {
                        System.out.println("ERROR: la pila tiene más de un operando y no se puede obtener un resultado.");
                    }
                    else {
                        int resultado = pila.pop();
                        System.out.println("El resultado es: " + resultado);
                    }
                    break;
                } else {
                    try {
                        int numero = Integer.parseInt(entrada);
                        pila.push(numero);
                        System.out.println("Se agregó el valor " + numero + " a la pila.");
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR INTRODUZCA UN OPERANDO O UN NÚMERO.");
                    }
                }
            }
        }
    }