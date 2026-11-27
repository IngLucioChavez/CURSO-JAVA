package org.luciochavez.apistream;

import java.util.stream.IntStream;

public class Tarea1Seccion {
    public static void main(String[] args) {

        // Solución Lucio
        /*Double suma = IntStream.iterate(1, v->v+1)
                .limit(100)
                .boxed()
                .filter(v->v % 10 != 0)
                .map(v->v.doubleValue() / 2)
                .reduce(0D,Double::sum);*/

        /*
        * MEJORAS
        * * Origen: el enunciado habla de un arreglo de 100 int. iterate + limit funciona, pero IntStream.rangeClosed(1, 100)
        *   expresa mejor "del 1 al 100". iterate se usa cuando cada elemento depende del anterior.
        * * Boxing innecesario: .boxed() crea 100 objetos Integer y luego conviertes a double.
        *   Puedes quedarte en primitivos con mapToDouble.
        * * Double suma: usa double, un tipo primitivo, ya que el resultado nunca es nulo.
         */

        // Solución optimizada pensamiento Sr
        double suma = IntStream.rangeClosed(1,100)
                .mapToDouble(v->v/2.0)
                .reduce(0D,Double::sum);

        //-- IntStream.rangeClosed(a, b) incluye b (range lo excluye); genera los enteros del 1 al 100
        //-- filter: descarta los divisibles entre 10 (v % 10 == 0)
        //-- mapToDouble: pasa de IntStream a DoubleStream sin boxing (con boxed() se crearían 100 Integer)
        // NOTESE! v / 2 con enteros haría división entera (7 / 2 = 3); por eso se divide entre 2.0
        //-- reduce(identidad, acumulador): 0D es el neutro de la suma; Double::sum equivale a (a, b) -> a + b
        //-> suma = 2250.0
        // NOTESE! Aquí el resultado es exacto porque dividir entre 2 y sumar son operaciones exactas en binario
        //-- con otros divisores (por ejemplo 3 o 0.1) la suma de doubles acumula error de redondeo

        System.out.println("suma = " + suma);

    }
}
