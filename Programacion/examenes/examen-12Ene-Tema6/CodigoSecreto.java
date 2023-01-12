package examenArray;
/*
 * Autor: Juan Parejo García
 * Clase Objeto: CodigoSecreto
 */
import com.sun.jdi.IntegerValue;

import java.util.*;
public class CodigoSecreto {
    int[] array;
    public CodigoSecreto(int digitos) {
        int[] array = new int[digitos];
        int min = 1;
        int max = 10;
        if (digitos > 0) {
            for (int i=0; i<digitos; i++) {
                int rNum = (int) (Math.random() * (max - min));
                array[i] = rNum;
            }
        }

        this.array = array;
    }

    public int[] convierteCodigo(String s) {
        int[] prueba = array;
        for(int i=0; i<array.length; i++) {
            prueba[i] = Integer.getInteger(s);
        }
        System.out.println(prueba);
        return prueba;
    }

    public boolean pruebaCodigo(int[] c) {
        boolean b = false;
        String[] result = new String[0];
        int num = 0;

        if(b==true) {
            num++;
        }

        if(num<array.length) {
            while(num != array.length) {
                for(int i=0; i<c.length; i++) {
                    if(c[i] > array[i]) {
                        result[i] = "M";
                        b = false;
                    } else {
                        if (c[i] < array[i]) {
                            result[i] = "M";
                            b = false;
                        } else {
                            if(c[i] > array[i]) {
                                result[i] = "";
                                b = true;
                            }
                        }
                    }
                    System.out.println(result);
                }
            }
        }
        return b;
    }

    @Override
    public String toString() {
        return "array=" + Arrays.toString(array) + "";
    }
}