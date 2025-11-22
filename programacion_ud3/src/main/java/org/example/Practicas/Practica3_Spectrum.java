package org.example.Practicas;

import java.util.Arrays;
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
        //línea[i] de la matriz contiene vector [j]

        //Calcular cuantas veces se puede repetir el contador por alto y por ancho

        int contador_filas = 0; 
        boolean control = false;
        int j = 0;
        int h = 0;
        String[][] nueva = new String[8][8];
        boolean test = false;

        String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

        todo:
        for (int k = 0 ; k < ancho/8 ; k++){//se va a hacer una vez si el ancho es 8, dos si es 16, 3 si es 24...

            for (int i = 0 ; i < matriz.length ; i++ , h++){
                j=8*k;


                if (i == 0 || i==8 || i==16 || i == 24 || i == 32 || i == 40){ //Cada vez que la matriz 8x8 ha sido creada y comprobada, se resetea la matriz.
                    nueva = new String[8][8];
                    h = 0;
                }

                for (int l = 0 ; l<8 ; l++, j++){

                    nueva[h][l] = matriz[i][j];
                }

                for (String fila[] : nueva){
                    System.out.println(Arrays.toString(fila));
                }

                if (i==7 || i==15 || i == 23 || i == 31 || i == 39) {// Cuando se ha creado una matriz completa se activa el test.
                    test = true;
                }

                if (test){

                    //Comprobador de filas
                    contador_filas=0;
                    for (int x = 0; x < 8; x++) {

                        for (int y = 0; y < letras.length; y++) {

                            if (Arrays.asList(nueva[x]).contains(letras[y])){
                                contador_filas++;
                                System.out.println(contador_filas);
                            }

                            if (contador_filas > 16){
                                control = true;
                                break todo;
                            }
                        }
                    }

                }
                test=false;

            }

        }





        if (control){
            System.out.println("No compatible");
        }else {
            System.out.println("Compatible");
        }










    }
}
