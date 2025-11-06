package org.example.Bateria_vectores;

public class Ejercicio9 {
    static void main() {
        String[] vector = {"me", "cago", "en", "los", "vectores", "de", "los", "cojones"};
        int longitud = 0;
        int longitud2 = 0;
        int resultado = 0;

        for (int i = 0; i< vector.length-1; i++) {
            longitud = vector[i].length();
            longitud2 = vector[i + 1].length();

        }
    }
}
