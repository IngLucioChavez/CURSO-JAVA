package org.luciochavez.hilos.ejemplos;

import java.util.Arrays;

public class EjemploHiloLambda {
    public static void main(String[] args) {

        //- forma normal o manual con definición de clase anónima a través de la interfaz Runnable
        /*Runnable viaje = new Runnable() {
            @Override
            public void run() {
                System.out.println("Iniciando proceso [%s] en hilo con INTERFAZ RUNNABLE".formatted(Thread.currentThread().getName()));

                for(int i =0; i < 10; i ++){
                    System.out.printf("%s --> %s\n",i,Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("fuchis: " + Arrays.toString(e.getStackTrace()));
                    }
                }

                System.out.println("Finalizando proceso [%s] en hilo con INTERFAZ RUNNABLE".formatted(Thread.currentThread().getName()));
            }
        };*/

        //- forma lambda
        Runnable viaje = () -> {
                System.out.println("Iniciando proceso [%s] en hilo con INTERFAZ RUNNABLE".formatted(Thread.currentThread().getName()));

                for(int i =0; i < 10; i ++){
                    System.out.printf("%s --> %s\n",i,Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("fuchis: " + Arrays.toString(e.getStackTrace()));
                    }
                }

                System.out.println("Finalizando proceso [%s] en hilo con INTERFAZ RUNNABLE".formatted(Thread.currentThread().getName()));
        };
        //- ejecución asíncrona de hilos - ejecución en forma paralela (PARALELISMO)
        new Thread(viaje,"hilo1").start();
        new Thread(viaje,"hilo2").start();
        new Thread(viaje,"hilo3").start();
        new Thread(viaje,"hilo4").start();

    }

}
