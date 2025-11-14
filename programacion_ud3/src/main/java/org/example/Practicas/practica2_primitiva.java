package org.example.Practicas;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class practica2_primitiva {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        String apuesta = "";
        boolean formato = true;
        boolean repetir = true;
        String[] vector_apuesta =new String[7];
        int[] vector_apuesta_int = new int[7];
        int[] sorteo = new int[6];


        do {

            do {

                System.out.println("Introduce los datos de tu boleto:");
                apuesta= teclado.nextLine();

                formato = apuesta.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d");

                if (!formato){
                    System.out.println("El formato está mal, vuelve a introducir tus numeros.");
                }

            }while (!formato); //Controlar que el formato está bien


            //Pasar los datos introducidos a un vector con el split
            vector_apuesta = apuesta.split("[-/]");

//        System.out.println(Arrays.toString(vector_apuesta));

            //Pasar el vector string a int para poder comprobar que los numeros estan entre el 1 y el 49
            for (int i = 0; i< vector_apuesta.length; i++){

                vector_apuesta_int[i] = Integer.parseInt(vector_apuesta[i]);
                if (vector_apuesta_int[i] >49 || vector_apuesta_int[i] < 1){
                    System.out.println("Los números tienen que estar entre el 1 y 49. Vuelve a introducir tu apuesta");
                    repetir= false;
                }//Controlar numeros entre el 1 y el 49

                if (i== vector_apuesta.length-1 && vector_apuesta_int[i]<0 && vector_apuesta_int[i]>9){
                    System.out.println("El reintegro tiene que ser un número entre el 0 y 9");
                    repetir=false;
                }//Controlar que el reintegro está entre el 0 y 9

            }

            System.out.println(Arrays.toString(vector_apuesta_int));

        }while (!repetir);

        //Sacamos 6 números aleatorios y hay que probar que los numeros no estén repetidos. sort+comprobar
        for (int i = 0 ; i< sorteo.length;i++){
            sorteo[i] = aleatorio.nextInt(49)+1;
        }
        System.out.print("Ha salido: ");
        System.out.println(Arrays.toString(sorteo));
        teclado.nextLine();









    }
}
