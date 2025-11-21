package org.example.Practicas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practica3_Spectrum {
    static void main() {

        Scanner teclado = new Scanner(System.in);

        int ancho = 0;
        int alto = 0;
        boolean repetir = false;


        do {
            repetir = false;
            System.out.println("Introduce la resolución de tu pantallas (ancho x alto)");
            System.out.println("Ancho");
            try {

                ancho = teclado.nextInt();
                System.out.println("Largo");
                alto = teclado.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Tienes que introducir números enteros");
            }


            //Validar que los introducidos son divisibles entre 8

            if (ancho % 8 != 0 || alto % 8 != 0){
                System.out.println("Los números introducidos no son válidos");
                repetir = true;
                continue;
            }

            if (ancho <8 || ancho > 48 || alto <8  || alto > 48){
                System.out.println("Los números introducidos no son válidos");
                repetir= true;
            }

        }while (repetir);

        teclado.nextLine();

        //Introducimos línea por línea la matriz y controlamos que cada letra introducida en cada línea esté dentro del rango A-O
        System.out.println("Introduce línea a línea los colores de tu imagen: ");

        String[][] matriz = new String[alto][ancho];
//        String[] linea = new String[matriz[0].length];

        fuera:
        for (int i = 0; i < matriz.length; i++) {

            System.out.println("Escribe línea " +(i+1));
            String[] linea = teclado.next().split(""); //Se saca un vector String de lo introducido

            if (linea.length == ancho){ //Se controla que el vector que se crea tenga la misma longitud que la matriz

                for (int j = 0; j < matriz[i].length; j++) {
                    if (linea[j].matches("[A-O]")){ //Se controla que cada letra introducida esté en el rango de [A-O]
                        matriz[i][j] = linea[j];


                    }else {
                        System.out.println("Has introducido un valor de pixel incorrecto");
                        i--;
                        continue fuera;
                    }


                }
            }else {
                System.out.println("La línea introducida tiene que tener los mismos carácteres que el ancho");
                i--;
            }

            //Si alguna de las dos condiciones no se cumple, se vuelve al for de fuera y se resta 1 al contador para poder escribirlo otra vez

        }

        //Imprimimos la matriz que hemos creado

        for (String linea[] : matriz){
            for (String columna : linea){
                System.out.print(columna);
            }
            System.out.println();
        }


//Crear un vector con todos los numeros posibles. Preguntar contains. Si es si sube un contador. si el contador es mayor que 3 no es válido ?¿










    }
}
