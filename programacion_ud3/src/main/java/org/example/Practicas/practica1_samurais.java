package org.example.Practicas;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class practica1_samurais {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        int[] equipo = new int[7];
        int[] equipo1 = new int[7];
        int[] equipo2 = new int[7];
        String potencias = "";
        int control_30 = 0;

        for (int j = 1; j<=2;j++){

            System.out.println("Equipo "+j);

            do {
                control_30= 0; //cada vez que se reinicia el bucle, el control vuelve a 0.

                System.out.println("Introduce la potencia de los samurais dividido con comas");
                potencias = teclado.next();

                String[] vetor_potencias = potencias.split(",");
//        System.out.println(Arrays.toString(vetor_potencias));

                //Ahora pasar cada hueco del string a ints. Para poder sumarlos entre si.


                    for (int i = 0; i< equipo.length; i++){

                        equipo[i] = Integer.parseInt(vetor_potencias[i]);

                        if (equipo[i]>24 || equipo[i]<1){
                            System.out.println("Los numeros deben estar entre 1 y 24");
                            control_30=200; //ññññññapa
                        }
                        //Esto lo hago para controlar los numeros mayores de 24 y menores de 1. Lo igualo a 200 para que no salga el mensaje de ERROR, por la suma total mayor de 30.

                        control_30 += equipo[i];

                    }

                    System.out.println(control_30);
//                    System.out.println(Arrays.toString(equipo1));
                    if (control_30==200){
                        System.out.println("Vuelve a empezar");
                    }

                    if (control_30!=30 && control_30!=200){
                        System.out.println("ERROR. La potencia total no suma 30");
                    }

                    if (j==1){
                        equipo1 = equipo.clone(); // Hay que clonarlos para que no sean los tres el mismo. Si solo los igualas, no funciona.
                    }else {
                        equipo2 = equipo.clone();
                    }


            }while(control_30!=30);

        }//Final del for que se hace dos veces para separar los dos equipos.

        System.out.println(Arrays.toString(equipo1));
        System.out.println(Arrays.toString(equipo2));
        //Ya estan los dos equipos hechos guardados en un array int cada uno

        int posicion_inicial = aleatorio.nextInt(8);
        int contador_equipo1=0;
        int contador_equipo2=0;

        if (equipo1[posicion_inicial] > equipo2[posicion_inicial]){
            contador_equipo1++;
        }else {
            contador_equipo2++;
        }




    }
}
