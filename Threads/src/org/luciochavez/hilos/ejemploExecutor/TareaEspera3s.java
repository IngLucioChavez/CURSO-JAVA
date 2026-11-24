package org.luciochavez.hilos.ejemploExecutor;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TareaEspera3s implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        System.out.printf("%s - inicia tarea\n",EjemploExecutorPool2.formatoFecha.format(LocalDateTime.now()));
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("%s - finaliza tarea\n",EjemploExecutorPool2.formatoFecha.format(LocalDateTime.now()));

        return 100;

    }
}
