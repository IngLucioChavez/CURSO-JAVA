package org.luciochavez.apistream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

        int[] numeros = {1,2,3,4,5,6};
        //-- forEach es operación TERMINAL: retorna void, por eso no se puede encadenar nada después
        //-- ni asignar el resultado a Stream<Integer> (error: void cannot be converted to Stream<Integer>)
        /*Stream<Integer> flujo1 = Arrays.stream(numeros).boxed()
                .map(v -> v * 2)
                .forEach(System.out::println);❌*/
        //- Si solo se quiere mostrar datos, se usa el pipeline completo sin asignarlo a una variable ✅
        System.out.println();
        Arrays.stream(numeros)/*.boxed() //- no es necesario ya que la operación map actua sobre el mismo tipo primitivo*/
                .map(v -> v * 2)
                .forEach(System.out::println);
        System.out.println();

        //-- map(Function<T,R>) es operación INTERMEDIA y lazy: devuelve un nuevo Stream
        //-- y no ejecuta nada hasta que se invoca una operación terminal
        Stream<Integer> flujo1 = Arrays.stream(numeros).boxed() //-- boxing: int -> Integer (IntStream -> Stream<Integer>)
                .map(v -> v * 2);
        flujo1.forEach(System.out::println);


        Stream<String> flujo2 = Arrays.stream(numeros).boxed()
                //-- String.formatted existe desde Java 15. En Java 8 se escribe v -> String.format("valor -> [%s]", v)
                .map("valor -> [%s]"::formatted) //- transforma cada elemento del flujo a String
                .peek(System.out::println) //- para inspeccionar como queda el elemento
                .map(v->v.toUpperCase(Locale.ROOT)); //- transforma cada elemento del flujo a mayúsculas, el resultado no depende de la máquina con Locale.ROOT

        //-- ¿Qué operaciones detonan un Stream? Las terminales: forEach, forEachOrdered, collect,
        //-- toList (Java 16+), reduce, count, min, max, sum, toArray, findFirst, findAny,
        //-- anyMatch, allMatch, noneMatch
        // NOTESE! Un Stream solo se consume una vez
        //-- Una segunda operación (terminal o intermedia) sobre flujo2 lanza
        //-- IllegalStateException: stream has already been operated upon or closed
        // flujo2.forEach(System.out::println);

        // NOTESE! El Stream procesa cada elemento por TODO el pipeline antes de pasar al siguiente
        //-- peek se ejecuta durante el collect, no antes
        //-> valor -> [1] ... valor -> [6]   (peek, minúsculas, durante collect)
        //-> VALOR -> [1] ... VALOR -> [6]   (listaDeFlujo2.forEach, ya en mayúsculas)
        //-- collect(Collectors.toList()) en Java 16+ puede ser .toList(), que devuelve una lista inmutable. Collectors.toList() no garantiza ni el tipo ni la mutabilidad de la lista.
        List<String> listaDeFlujo2 = flujo2.collect(Collectors.toList());
        listaDeFlujo2.forEach(System.out::println);


    }
}
