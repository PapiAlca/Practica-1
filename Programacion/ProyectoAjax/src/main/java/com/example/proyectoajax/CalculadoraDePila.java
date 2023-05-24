package com.example.proyectoajax;

import java.util.Scanner;

public class CalculadoraDePila {
    private String texto;
    private float resultado;

    public CalculadoraDePila() {
        //this.texto = texto;
    }

    public float obtenerResultado() {
        String[] operaciones = texto.split(" ");

        for (String operacion : operaciones) {
            if (operacion.equals("+")) {
                sumar();
            } else if (operacion.equals("*")) {
                multiplicar();
            } else if (operacion.equals("=")) {
                break;
            }
        }

        return resultado;
    }

    private void sumar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número a sumar: ");
        float numero = scanner.nextFloat();
        resultado += numero;
    }

    private void multiplicar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número a multiplicar: ");
        float numero = scanner.nextFloat();
        resultado *= numero;
    }
}