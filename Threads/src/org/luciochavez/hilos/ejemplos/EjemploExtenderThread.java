package org.luciochavez.hilos.ejemplos;

import org.luciochavez.hilos.ejemplos.threads.ClaseHiloThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        //-- cada hilo correo en su procesador en PARALELO
        Thread hilo = new ClaseHiloThread("hilo1");
        Thread hilo2 = new ClaseHiloThread("hilo2");

        System.out.println(hilo.getState()); //-> NEW
        hilo.start();
        hilo2.start();
        System.out.println(hilo.getState()); //-> RUNNABLE
        //- no es una pausa en el hilo sino una pausa en el método main
        //Thread.sleep(1000);
        System.out.println(hilo.getState()); //-> TERMINATED



    }
}
