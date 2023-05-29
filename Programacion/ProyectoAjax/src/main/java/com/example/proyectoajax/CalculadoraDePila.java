package com.example.proyectoajax;

import java.util.Scanner;

public class CalculadoraDePila {
    public float obtenerResultado(String texto) {
        String[] operaciones = texto.split(" ");
        boolean esPrimero = false;
        int total = 0;
        int siguiente = 0;

        for (String operacion : operaciones) {
            if(!esPrimero) {
                total = Integer.parseInt(operacion);
                esPrimero = true;
            }
            else {
                if(!operacion.equals("+") && !operacion.equals("*")){
                    siguiente = Integer.parseInt(operacion);
                }
                else {
                    if (operacion.equals("*")) {
                        total = total * siguiente;
                    }
                    else {
                        if (operacion.equals("+")) {
                            total = total + siguiente;
                        }
                        else {
                            System.out.println("ERROR DE SINTAXIS");
                        }
                    }
                }
            }
        }
        return total;
    }


}