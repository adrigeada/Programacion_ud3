package org.example.Bateria_vectores;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio1 {
    static void main() {
        Random aleatorio = new Random();

        int[] vector = new int[8];

        System.out.println(Arrays.toString(vector));

        for (int i = 0; i<vector.length ; i++){
            vector[i]= aleatorio.nextInt(501);

        }

        System.out.println(Arrays.toString(vector));


    }
}
