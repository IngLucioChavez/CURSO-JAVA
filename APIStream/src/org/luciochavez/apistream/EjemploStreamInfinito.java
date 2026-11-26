package org.luciochavez.apistream;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStreamInfinito {
    public static void main(String[] args) {

        //-- Stream.generate(Supplier<T>): fuente de creación que produce un stream INFINITO;
        //-- cada elemento sale de llamar a get() del Supplier (no depende del elemento anterior)
        // NOTESE! Un stream infinito necesita una operación de cortocircuito (limit, takeWhile en Java 9+, findFirst...)
        //-- sin limit(10), el forEach no terminaría nunca
        // NOTESE! AtomicInteger porque una lambda solo puede capturar variables "effectively final"
        //-- un int normal no se podría incrementar dentro de la lambda; AtomicInteger sí y además es thread-safe
        AtomicInteger numero = new AtomicInteger(0);

        Stream<String> flujo = Stream.generate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500); //- simula un elemento costoso de producir
                return "hola! " + (numero.getAndIncrement() + 1);
            } catch (InterruptedException e) {
                return "x";
            }
        }).limit(10); //- intermedia con cortocircuito: solo 10 elementos

        // NOTESE! Hasta aquí no se ha ejecutado nada (ni un solo sleep): el flujo es lazy
        flujo.forEach(System.out::println); //- terminal: detona el flujo
        //-> hola! 1  (cada 500 ms)
        //-> ...
        //-> hola! 10
        // NOTESE! "continuación" se imprime hasta el final: el stream NO es asíncrono
        //-- forEach bloquea el hilo main hasta terminar (unos 5 s = 10 x 500 ms)
        System.out.println("continuación");
        //-> continuación

    }
}
