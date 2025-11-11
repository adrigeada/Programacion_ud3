package org.example.split;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class split_ruleta {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        final String[] COLORES = {"rojo","negro"};
        Integer[] numeros= new Integer[37];

        for (int i = 0; i< numeros.length ; i++){

            numeros[i]= i;

        }

//        System.out.println(Arrays.toString(numeros));
        final String[] PAR_IMPAR = {"par","impar"};

        System.out.println("Introduce tu numero de apuesta: ");
        int numero_apuesta = teclado.nextInt();

        if (!Arrays.asList(numeros).contains(numero_apuesta)){ //si el numero que ha escrito no esta contenido en el vector numeros
            System.out.println("El número no es válido");
            return;

        }

        String color_apuesta = "";
        String par_impar_apuesta = "";
        if (numero_apuesta != 0){

            System.out.println("Introduce el color de tu apuesta (rojo,negro): ");
            color_apuesta = teclado.next().toLowerCase();

            if (!Arrays.asList(COLORES).contains(color_apuesta)){ //si el color que introduce no esta contenido en el vector COLORES
                System.out.println("ERROR. El color no es válido");
                return;
            }

            System.out.println("Introduce apuesta par/impar: ");
            par_impar_apuesta = teclado.next().toLowerCase();

            if (!Arrays.asList(PAR_IMPAR).contains(par_impar_apuesta)){ //si lo que escribe no es par o impar (lo contenido en el vector PAR_IMPAR)
                System.out.println("ERROR. La apuesta no es valida (par/impar)");
                return;
            }


        }

        String color_sorteo = COLORES[aleatorio.nextInt(2)]; //va a salir o COLORES [0] o COLORES [1]
        int numero_sorteo = numeros[aleatorio.nextInt(37)];

        String par_impar_sorteo = "";
        if (numero_sorteo%2 == 0){
            par_impar_sorteo = "par";
        }else {
            par_impar_sorteo = "impar";
        }

        System.out.println("Ha salido " + numero_sorteo + " " + color_sorteo + " " + par_impar_sorteo);

        if (numero_sorteo == numero_apuesta && color_sorteo.equals(color_apuesta) && par_impar_sorteo.equals(par_impar_apuesta) ){
            System.out.println("HAS GANADO");
        } else if (numero_sorteo == numero_apuesta) {
            System.out.println("Has acertado el número");
        } else if (color_sorteo.equals(color_apuesta)) {
            System.out.println("Has acertado el color");
        } else if (par_impar_sorteo.equals(par_impar_apuesta)) {
            System.out.println("Has acertado " + par_impar_apuesta);
        }else {
            System.out.println("Has perdido :(");
        }


    }
}
