package org.luciochavez.apistream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {

        //-- Un Stream NO almacena datos ni modifica su fuente: es un flujo de elementos
        //-- procesado por una cadena (pipeline) de operaciones.
        //-- Las operaciones intermedias (map, filter...) devuelven un nuevo Stream;
        //-- la colección o arreglo original queda intacto.
        // NOTESE! Un Stream solo se puede consumir una vez
        //-- Tras una operación terminal (forEach, collect...) queda cerrado;
        //-- reutilizarlo lanza IllegalStateException.

        // NOTESE! Stream.of(arr) con String[] funciona, pero con int[] produce Stream<int[]> (un solo elemento).
        //-- Para primitivos usa Arrays.stream(int[]), que devuelve IntStream
        //- Stream<String> = flujo cuyos elementos son de tipo String
        //- Stream.of(T... values): crea un Stream secuencial; todos los elementos son del mismo tipo T
        Stream<String> nombres = Stream.of("uno","dos","tres","cuatro","cinco");
        //-- forEach es operación terminal: recibe un Consumer (acción por elemento) y retorna void
        nombres.forEach(System.out::println);

        //- creando un Stream a partir de un arreglo
        String[] arr = {"uno","dos","tres","cuatro","cinco"};
        Stream<String> nombres2 = Arrays.stream(arr);
        nombres2.forEach(System.out::println);

        // NOTESE! Stream.<String>builder() lleva el tipo explícito (<String>)
        //-- porque al encadenar .add() el compilador no infiere T desde la variable destino.
        //-- Tras .build() el builder se cierra: otro .add() lanza IllegalStateException.
        //- creando un Stream a partir de un builder, ingresando dato por dato
        Stream<String> nombres3 = Stream.<String>builder()
                .add("uno")
                .add("dos")
                .add("tres")
                .add("cuatro").build();
        nombres3.forEach(System.out::println);

        //- creando Stream a partir de un obj Collection
        List<String> lista = new ArrayList<>();
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");
        lista.add("cuatro");

        /*Stream<String> nombres4 = lista.stream();
        nombres4.forEach(System.out::println);*/
        //- simplificación
        lista.stream().forEach(System.out::println); //- impresión de elemntos en consola


    }
}
