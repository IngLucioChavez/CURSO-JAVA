package org.luciochavez.hilos.ejemploExecutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

public class EjemploExecutorPool2 {

    public static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws InterruptedException {

        int nucleos = Runtime.getRuntime().availableProcessors();
        System.out.println("nucleos disponibles para JVM: " + nucleos); // 8

        //- se realiza cast para obtener los métodos de ThreadPoolExecutor
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("tamaño del pool: " + executor.getPoolSize());
        System.out.println("tareas en cola: " + executor.getQueue().size());

        Future<String> tarea = executor.submit(new TareaEspera2s());
        Future<String> tarea2 = executor.submit(new TareaEspera2s());
        Future<Integer> tarea3 = executor.submit(new TareaEspera3s());
        executor.shutdown();

        while( !(tarea.isDone() && tarea2.isDone() && tarea3.isDone()) ){
            System.out.println();
            System.out.println("tamaño del pool: " + executor.getPoolSize());
            System.out.println("tareas en cola: " + executor.getQueue().size());
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
