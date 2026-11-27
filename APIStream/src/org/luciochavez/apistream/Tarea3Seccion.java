package org.luciochavez.apistream;

import java.util.Arrays;

public class Tarea3Seccion {
    public static void main(String[] args) {

        String[][] lenguajes = {
                {"java", "groovy"},
                {"php"},
                {"c#", "python", "groovy"},
                {"java", "javascript", "kotlin"},
                {"javascript"},
                {}
        };

        String[] lenguajesSinRepetir = Arrays.stream(lenguajes)
                .flatMap(Arrays::stream)
                .distinct()
                .toArray(String[]::new);
        //-- toArray(IntFunction<A[]> generador): operación terminal que retorna un arreglo A[] con los elementos del flujo
        //-- String[]::new equivale a n -> new String[n]: recibe el tamaño y crea el arreglo de ese tamaño
        // NOTESE! El generador es necesario porque, por el borrado de tipos, el Stream no puede crear un String[] por sí solo
        //-- toArray() sin parámetros retorna Object[]

        System.out.println(Arrays.toString(lenguajesSinRepetir));

    }
}
