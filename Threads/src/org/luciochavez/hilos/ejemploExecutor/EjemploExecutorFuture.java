package org.luciochavez.hilos.ejemploExecutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        //-- DateTimeFormatter es inmutable y seguro para hilos (Java 8+)
        //-- SimpleDateFormat guarda estado interno mutable: usarlo desde varios hilos puede dar fechas corruptas
        //SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //- Callable<V> devuelve un resultado del tipo V (aquí String) y puede lanzar excepciones comprobadas
        //- el resultado se obtiene a través de un Future con get()
        Callable<String> tarea = () -> {

            System.out.println(LocalDateTime.now().format(formatoFecha) + " - iniciando tarea...");
            try {
                System.out.println(LocalDateTime.now().format(formatoFecha) + " - ejecución de tarea...");
                TimeUnit.SECONDS.sleep(8);
            } catch (InterruptedException e) {
                //- restaura la bandera de interrupción del hilo, que se limpia al lanzarse InterruptedException
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println(LocalDateTime.now().format(formatoFecha) + " - finalizando tarea");

            return "resultado final de la tarea";
        };

        //- un Future representa el resultado pendiente de una tarea que corre en otro hilo
        //- permite consultar su estado (isDone, isCancelled), esperar el resultado (get) o cancelarla (cancel)
        //- Future<?> lo devuelve submit(Runnable): la tarea no produce resultado, get() devuelve null
        //- Future<String> lo devuelve submit(Callable<String>): get() entrega el String al finalizar la tarea
        //Future<?> resultado = executor.submit(tarea);
        Future<String> resultado = executor.submit(tarea);
        executor.shutdown();

        while(!resultado.isDone()){
            System.out.println( LocalDateTime.now().format(formatoFecha) + " - Procesando tarea...");
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println( LocalDateTime.now().format(formatoFecha) + " - termino?: " + resultado.isDone());
        System.out.println( LocalDateTime.now().format(formatoFecha) + " - resultado de la tarea: " + resultado.get());
        System.out.println(LocalDateTime.now().format(formatoFecha) + " - Finalizó la tarea");

    }
}
