package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploFlatMap {
    public static void main(String[] args) {

        List<String> nombres = List.of(
                "Lucio Chávez",
                "Carlos Chávez",
                "Carlos Chávez",
                "María Delgado",
                "Juan Silva",
                "Dudu Phudu"
        );

        Stream<Usuario> nombresAUsuario= nombres.stream()
                .map(EjemploOptionalSenior::desdeNombreCompleto)
                //-- flatMap(Function<T, Stream<R>>): intermedia; transforma cada elemento en un Stream
                //-- (de 0, 1 o varios elementos) y une todos esos streams en uno solo ("aplana")
                //-- map: 1 elemento -> 1 elemento | flatMap: 1 elemento -> 0..n elementos
                .flatMap(u -> {
                    // NOTESE! Aquí flatMap se usa para filtrar: Stream.of(u) conserva el elemento, Stream.empty() lo descarta
                    //-- es válido, pero para filtrar lo correcto es filter(); flatMap está pensado para aplanar
                    if (u.getNombres().equalsIgnoreCase("carlos")) {
                        return Stream.of(u);
                    }
                    return Stream.empty();
                });
                //-> Usuario{id='2'apellidos='Chávez', nombres='Carlos'}
                //-> Usuario{id='3'apellidos='Chávez', nombres='Carlos'}
                // NOTESE! Los ids 2 y 3 confirman que el id se asigna por contador al construir cada Usuario
                //-- Lucio fue el 1, y cada "Carlos Chávez" es un objeto distinto aunque el nombre se repita

        nombresAUsuario.forEach(System.out::println);
        System.out.println("===================");

        //- Un ejemplo donde flatMap sí es lo que necesitas
        nombres.stream()
                .flatMap(n -> Arrays.stream(n.split(" ")))   // "Lucio Chávez" -> "Lucio", "Chávez"
                .forEach(System.out::println);
        //-> Lucio, Chávez, Carlos, Chávez, Carlos, Chávez, María, Delgado, Juan, Silva, Dudu, Phudu
        //- Con map el resultado sería Stream<String[]> (un arreglo por elemento), sin aplanar

    }
}
