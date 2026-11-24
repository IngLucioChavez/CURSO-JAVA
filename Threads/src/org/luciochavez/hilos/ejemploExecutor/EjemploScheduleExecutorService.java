package org.luciochavez.hilos.ejemploExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduleExecutorService {
    public static void main(String[] args) {

        //-- try-with-resources se puede usar a partir de java 7+
        //-- pero el ExecutorService se puede asignar a try-with-resources desde java 19+
        try(ScheduledExecutorService ejecutor = Executors.newScheduledThreadPool(3)){

            System.out.println("alguna tarea en el main...");
            //- definiendo tarea programada
            ejecutor.schedule(()->{

                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("hola desde la tarea programada con tiempo de inicio");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            },1500, TimeUnit.MILLISECONDS); //- tarea programada con delay
            //- schedule() ejecuta la tarea UNA sola vez, 1500 ms después de enviarla
            //- (la tarea además duerme 2 s, así que el mensaje sale aprox. a los 3.5 s)

            System.out.println("alguna tarea2 en el main...");

        } //- ejecutor.shutdown(); // lo cierra automáticamente el try-with-resources
        //- al salir del bloque, close() llama a shutdown() y espera a que terminen las tareas
        //- una tarea programada con schedule() sigue ejecutándose aunque se haya llamado a shutdown()

    }
}
