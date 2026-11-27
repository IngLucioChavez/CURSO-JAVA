package org.luciochavez.apistream;

import java.util.Arrays;
import java.util.function.Function;

public class Tarea2Seccion {
    public static void main(String[] args) {

        int[] numeros = {-5,52,-36,98,89,74,52,456,123,7,8,-6,-8,-1};

        // Solución Lucio
        /*
        int mayor = Arrays.stream(numeros)
                .reduce(0, Math::max);
         */

        /* Detalles
        * * No implementaste Function<T,R>: El enunciado pide expresamente usar la interfaz funcional Function<T,R>
        *       junto con stream y reduce. Tu código llama a reduce directamente en main, sin ninguna Function.
        *       Lo que se espera es una función que reciba el arreglo (T = int[]) y retorne el mayor (R = Integer)
        * * La identidad 0 es incorrecta para "el mayor": La identidad debe ser el elemento neutro de la operación.
        *       Para max es Integer.MIN_VALUE, no 0. Con 0, un arreglo de negativos da un resultado que ni siquiera está en el arreglo.
        */

        Function<int[],Integer> mayor = nums -> Arrays.stream(nums)
                .reduce(Integer.MIN_VALUE, Math::max);

        System.out.println("mayor = " + mayor.apply(numeros)); //-> 800

    }
}
