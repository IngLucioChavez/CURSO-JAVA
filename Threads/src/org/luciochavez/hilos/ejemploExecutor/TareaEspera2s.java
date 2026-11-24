package org.luciochavez.hilos.ejemploExecutor;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TareaEspera2s implements Callable<String> {
    @Override
    public String call() throws Exception {

        System.out.printf("%s - inicia tarea\n",EjemploExecutorPool2.formatoFecha.format(LocalDateTime.now()));
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("%s - finaliza tarea\n",EjemploExecutorPool2.formatoFecha.format(LocalDateTime.now()));

        return "resultado tarea";

    }
}
