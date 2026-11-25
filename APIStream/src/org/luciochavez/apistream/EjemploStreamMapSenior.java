package org.luciochavez.apistream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamMapSenior {
    public static void main(String[] args) {

        int[] numeros = {1,2,3,4,5,6};

        System.out.println("==== multiplicando números * 2");
        Arrays.stream(numeros).map(v-> v*2).forEach(System.out::println);
        System.out.println("====================");

        //- Supplier: cada get() crea un stream nuevo, así se reutiliza el pipeline sin IllegalStateException
        Supplier<IntStream> fuente = () -> Arrays.stream(numeros);

        //-- mapToObj: Es un método de los streams primitivos (IntStream, LongStream, DoubleStream).
        //-- Transforma cada elemento primitivo en un objeto y devuelve un Stream<R>.
        //-- Es decir, sirve para salir del mundo primitivo hacia el mundo de objetos.
        // NOTESE! map en un IntStream solo puede devolver int; para cambiar de tipo se usa mapToObj
        //-- evita el boxing intermedio de .boxed().map(...)
        List<String> etiquetas = fuente.get()
                .mapToObj("valor -> [%s]"::formatted) // Java 15
                .map(s -> s.toUpperCase(Locale.ROOT))
                .toList(); // Java 16

        int sumaDobles = fuente.get().map(v -> v *2).sum();

        Stream.of(1,2,3)
                .peek(v -> System.out.println("A -> " + v))
                .map(v ->v *2 )
                .peek(v-> System.out.println("B -> " + v))
                .toList();
        //-> A 1, B 2, A 2, B 4, A 3, B 6   (intercalado, no "todos los A y luego todos los B")

    }
}
