package org.luciochavez.hilos.ejemploExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduleExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        try(ScheduledExecutorService ejecutor = Executors.newScheduledThreadPool(3)){
            //- EJEM2: CountDownLatch es una cuenta regresiva segura para hilos, inicia en 5
            //- es de un solo uso: cuando llega a 0 no se puede reiniciar
            //CountDownLatch contador = new CountDownLatch(5);
            //- EJEM3 - contador entero con valor atómico
            AtomicInteger contador = new AtomicInteger(5);
            System.out.println("alguna tarea en el main...");
            //- EJEM1 - definiendo tarea programada con delay de 1s y se repite cada 2s hasta finalizar el ejecuto
            //- scheduleAtFixedRate: primera ejecución a 1s; luego una cada 2s, medidos desde el INICIO de cada ejecución
            //- se repite hasta shutdown() o hasta que una ejecución lance una excepción
            Future<?> inspector = ejecutor.scheduleAtFixedRate(()->{

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("hola desde la tarea programada con tiempo de inicio");
                    //contador.countDown(); //- EJEM2 - disminuye en 1 cada vez que se ejecuta la tarea
                    contador.getAndDecrement(); //- EJEM3 - disminuye en 1 cada vez que se ejecuta la tarea
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            },1000, 2000, TimeUnit.MILLISECONDS);

            //contador.await(); //- EJEM2 - espera hasta que el contador llegue a 0
            //- EJEM3 - se genera ciclo para validar el valor del contador y cuando llegue a cero cancelar
            //- la tarea
            while( contador.get() >= 0){
                if( contador.get() == 0 ){
                    inspector.cancel(true); //- cancela tarea periodica
                    break;
                }
            }

            System.out.println("alguna tarea2 en el main...");

            //TimeUnit.SECONDS.sleep(10); //- EJEM 1 - definiendo tiempo de espera antes de finalizar ejecutor
        } //- EJEM 1 - termina el ejecutor con shutdown() y si no se define el tiempo de espera antes de finalizar no se podrá
        //- observar su comportamiento

    }
}
