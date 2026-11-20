package org.luciochavez.hilos.ejemploExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Ejemplo básico de un {@link ExecutorService} con un único hilo.
 *
 * <p>Se envía una tarea (un {@link Runnable} que simula trabajo durante 5 segundos)
 * al executor, que la ejecuta en su propio hilo, distinto al de {@code main}.
 * Mientras tanto, {@code main} sigue su ejecución en paralelo.
 *
 * <p>Conceptos que muestra:
 * <ul>
 *   <li>{@code submit()}: encola la tarea para que el executor la ejecute.</li>
 *   <li>{@code shutdown()}: el executor deja de aceptar tareas nuevas y termina
 *       las ya enviadas. Sin esta llamada la aplicación no finaliza, porque el hilo
 *       del pool sigue vivo.</li>
 *   <li>{@code awaitTermination()}: bloquea a {@code main} como máximo el tiempo
 *       indicado (2 s) esperando que el executor termine. Como la tarea tarda 5 s,
 *       el tiempo se agota y {@code main} continúa antes de que la tarea acabe.</li>
 * </ul>
 */
public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable tarea = new Runnable() {
            @Override
            public void run() {

                System.out.println("iniciando tarea...");
                try {
                    System.out.println("ejecución de tarea...");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); //- interrupción de proceso
                    throw new RuntimeException(e);
                }
                System.out.println("finalizando tarea");

            }
        };

        executor.submit(tarea);   //- encola la tarea; se ejecuta en el hilo del pool, no en main
        executor.shutdown();      //- no admite tareas nuevas; deja terminar la que está en curso
        System.out.println("continuando con el proceso de main 1");  //- corre en paralelo con la tarea
        executor.awaitTermination(2, TimeUnit.SECONDS);  //- main espera como máximo 2s a que el executor termine
        System.out.println("continuando con el proceso de main 2");

    }
}
