package org.luciochavez.hilos.ejemploExecutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.*;

public class EjemploExecutorPool {
    public static void main(String[] args) throws InterruptedException {
        //- EJEM1: con newSingleThreadExecutor hay un solo hilo, así que las 3 tareas se ejecutan en secuencia
        //- las tareas pendientes esperan en la cola interna del executor hasta que el hilo quede libre
        //ExecutorService executor = Executors.newSingleThreadExecutor();
        //- EJEM2: con newFixedThreadPool(3) hay 3 hilos, así que las 3 tareas corren al mismo tiempo
        //- con newFixedThreadPool(2) correrían 2 y la tercera esperaría en la cola hasta que un hilo esté libre
        ExecutorService executor = Executors.newFixedThreadPool(3);
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int nucleos = Runtime.getRuntime().availableProcessors();
        System.out.println("nucleos disponibles para JVM: " + nucleos); // 8

        Callable<String> tareaEspera2s = () -> {

            System.out.printf("%s - inicia tarea\n",formatoFecha.format(LocalDateTime.now()));
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("%s - finaliza tarea\n",formatoFecha.format(LocalDateTime.now()));

            return "resultado tarea";
        };

        Callable<Integer> tareaEspera3s = () -> {

            System.out.printf("%s - inicia tarea\n",formatoFecha.format(LocalDateTime.now()));
            TimeUnit.SECONDS.sleep(3);
            System.out.printf("%s - finaliza tarea\n",formatoFecha.format(LocalDateTime.now()));

            return 100;
        };

        Future<String> tarea = executor.submit(tareaEspera2s);
        Future<String> tarea2 = executor.submit(tareaEspera2s);
        Future<Integer> tarea3 = executor.submit(tareaEspera3s);
        executor.shutdown();

        while( !(tarea.isDone() && tarea2.isDone() && tarea3.isDone()) ){
            System.out.println("tareas en proceso...");
            System.out.println("tarea estatus: " + tarea.state());
            System.out.println("tarea2 estatus: " + tarea2.state());
            System.out.println("tarea3 estatus: " + tarea3.state());
            System.out.println();
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        System.out.println("tareas finalizadas");
        System.out.println("tarea estatus: " + tarea.state());
        System.out.println("tarea2 estatus: " + tarea2.state());
        System.out.println("tarea3 estatus: " + tarea3.state());

    }
}
