import java.util.Arrays;

public class MetodosExamen {
    public static void ordenar(int[] vector) {
        //Creamos un array tipo int para guardar los datos
        int[] nuevoArray = new int[vector.length];
        int menor;

        System.out.println("Nuestro Array");
        System.out.println("=============");
        System.out.println(Arrays.toString(vector));
        System.out.println("=============");

        /* Con este bucle for lo que haremos será ver el tamaño de los números y ordenarlos de menor a mayor
         metiendolos en el nuevo array creado */
        System.out.println("Ordenando array");
        System.out.println("===============");
        for(int i=0; i<vector.length; i++){
            menor = vector[0];

            if (vector[i]<menor){
                menor = vector[i];
                nuevoArray[i] = menor;
            }
            else{
                if (vector[i]>menor){
                    menor +=1;
                }
            }
        }


        System.out.println("Array ordenado");
        System.out.println("==============");
        System.out.println(Arrays.toString(vector));
        /*for(int i=0; i<vector.length; i++) {
            System.out.println(vector[i]);
        }*/
        System.out.println("==============");
    }
}
