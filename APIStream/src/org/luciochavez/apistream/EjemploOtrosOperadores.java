package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploOtrosOperadores {
    public static void main(String[] args) {

        /*
         * Un pipeline de Stream tiene 3 fases:
         *   fuente -> operaciones intermedias (0 o más) -> operación terminal (1)
         * - Intermedias (map, filter, peek...): retornan Stream y son lazy, no ejecutan nada por sí solas
         * - Terminales (forEach, collect, count...): NO retornan Stream, detonan el flujo y lo cierran
         * Regla práctica: si el método retorna Stream es intermedio; si retorna otra cosa, es terminal
         */
        // NOTESE! Sin operación terminal el pipeline nunca se ejecuta
        //-- por ejemplo, un peek sin terminal no imprime nada

        List<String> nombres = List.of( //- List.of es Java 9+; en Java 8: Arrays.asList(...)
                "Lucio Chávez",
                "Carlos Chávez",
                "Carlos Chávez",
                "María Delgado",
                "Juan Silva",
                "Dudu Phudu"
        );

        //-- ¿Para qué sirve un Supplier<T>? Es una interfaz funcional con un método get()
        //-- que no recibe nada y retorna un T. Aquí guarda la "receta" para crear un Stream nuevo
        // NOTESE! Un Stream solo se consume una vez; cada fuente.get() ejecuta de nuevo el map
        //-- y crea Usuarios nuevos. Si el id se genera con un contador, cada get() produce ids distintos
        Supplier<Stream<Usuario>> fuente = () -> {
            return nombres.stream().map(EjemploOptionalSenior::desdeNombreCompleto);
        };
        System.out.println("================ filter");
        //- filter(Predicate): intermedia, conserva los usuarios con id 5
        //- findFirst(): terminal con cortocircuito, retorna Optional<Usuario>
        // NOTESE! El map siguiente es Optional.map, no Stream.map
        //-- transforma el Usuario a String solo si el Optional tiene valor; orElse da el texto por defecto
        System.out.println(fuente.get()
                .filter(u-> u.getId() == 5)
                .findFirst()
                .map(Usuario::toString)
                .orElse("no existe usuario"));

        System.out.println("================ distinct");
        //- distinct(): intermedia con estado, elimina duplicados conservando la primera aparición
        // NOTESE! distinct usa equals() y hashCode() del objeto
        //-- si Usuario no los sobrescribe, compara por referencia y no elimina nada
        //-- si equals incluye el id (autogenerado), dos "Carlos Chávez" tampoco serían iguales
        fuente.get()
                .distinct()
                .forEach(System.out::println);

        System.out.println("================ reduce");
        //-- reduce(identidad, acumulador): terminal, combina todos los elementos en uno solo
        // NOTESE! La identidad "" es el primer valor de "a", por eso el resultado empieza con " - "
        //-- replaceAll es un método de String (reduce ya retornó un String), quita espacios y guiones de los extremos
        String resultado = fuente.get()
                .map(Usuario::getApellidos)
                .reduce("",(a,b)->{
                    return String.format("%s - %s",a,b);
                })
                .replaceAll("^[\\s-]+|[\\s-]+$", "");
        System.out.println(resultado);
        //-> Chávez - Chávez - Chávez - Delgado - Silva - Phudu
        //- Alternativa más simple y eficiente: .collect(Collectors.joining(" - "))

        System.out.println("================ sum()");
        //-- reduce(0, Integer::sum): 0 es la identidad (neutro de la suma); Integer::sum equivale a (a, b) -> a + b
        Stream<Integer> numeros = Stream.of(1,2,3,4,5);
        Integer suma = numeros.reduce(0,Integer::sum);
        System.out.println("suma = " + suma); //-> suma = 15

        System.out.println("================ range()");
        //-- IntStream.iterate(semilla, hasNext, next) (Java 9+) equivale a un for: for (v = 2; v <= 20; v += 2)
        //- genera 2, 4, 6... 20 (el 20 se incluye porque la condición es <=)
        //- Java 8: IntStream.iterate(2, v -> v + 2).limit(10)
        IntStream numeros1 = IntStream.iterate(2,v -> v <= 20, v -> v + 2);

        // NOTESE! numeros1 solo se puede consumir una vez
        //-- las dos líneas comentadas son alternativas a sum(); si se descomenta una, la siguiente terminal lanza IllegalStateException
        //numeros1.forEach(System.out::println);
        //System.out.println("con reduce(): " + numeros1.reduce(0, Integer::sum));
        //-- sum() es terminal y propio de los streams primitivos (IntStream, LongStream, DoubleStream); Stream<Integer> no lo tiene
        System.out.println("con sum(): " + numeros1.sum()); //-> con sum(): 110

        System.out.println("================ IntSummaryStatistics()");
        // NOTESE! range(a, b) EXCLUYE b: va del 1 al 9. Para incluir el 10 se usa rangeClosed(1, 10)
        IntStream numeros2 = IntStream.range(1,10); //- rango del 1 al 9
        //-- summaryStatistics() es terminal: calcula count, sum, min, max y average en UNA sola pasada
        //-- (si llamaras min(), max() y sum() por separado tendrías que crear un stream nuevo para cada una)
        IntSummaryStatistics estadisticas = numeros2.summaryStatistics();
        //-> min: 1 | max: 9 | promedio: 5.0 | sumatoria: 45 | total elementos: 9
        // NOTESE! Con un stream vacío getMin() retorna Integer.MAX_VALUE y getMax() Integer.MIN_VALUE

        System.out.println("min: " + estadisticas.getMin());
        System.out.println("max: " + estadisticas.getMax());
        System.out.println("promedio: " + estadisticas.getAverage());
        System.out.println("sumatoria: " + estadisticas.getSum());
        System.out.println("total elementos: " + estadisticas.getCount());

    }
}
