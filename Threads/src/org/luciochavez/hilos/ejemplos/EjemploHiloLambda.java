package org.luciochavez.hilos.ejemplos;

import java.util.Arrays;

public class EjemploHiloLambda {
    public static void main(String[] args) throws InterruptedException {

        //- obteniendo referencia del hilo principal
        Thread main = Thread.currentThread();
        //- forma lambda
        Runnable viaje = () -> {
                System.out.println("Iniciando proceso [%s] en hilo con INTERFAZ RUNNABLE".formatted(Thread.currentThread().getName()));

                for(int i =0; i < 10; i ++){
                    System.out.printf("%s --> %s\n",i,Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException("fuchis: " + Arrays.toString(e.getStackTrace()));
                    }
                }
                System.out.println("estado hilo princiapl: %s".formatted(main.getState()));
                System.out.println("Finalizando proceso [%s] en hilo con INTERFAZ RUNNABLE".formatted(Thread.currentThread().getName()));
        };

        Thread hilo1 = new Thread(viaje,"hilo1");
        Thread hilo2 = new Thread(viaje,"hilo2");
        Thread hilo3 = new Thread(viaje,"hilo3");
        Thread hilo4 = new Thread(viaje,"hilo4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        //- el método join() del Thread significa que el hilo actual se enlazará a la ejecución del hilo referenciado
        //- es decir que esperará hasta que la ejecución del hilo referenciado termine para continuar con el proceso
        //- en este caso el hilo prinicipal del main esperará la ejecución de todos los hilos para seguir con su proceso
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();

        System.out.println("continuación de ejecución de método main [%s]".formatted(main.getName()));

    }

}
