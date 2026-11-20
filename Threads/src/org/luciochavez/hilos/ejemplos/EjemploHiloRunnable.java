package org.luciochavez.hilos.ejemplos;

import org.luciochavez.hilos.ejemplos.threads.ViajeHilo;

public class EjemploHiloRunnable {
    public static void main(String[] args) {

        //- no existe una prioridad de ejecución por eso a veces empieza el hilo1, el hilo3, etc.
        new Thread(new ViajeHilo("hilo1",1000)).start();
        new Thread(new ViajeHilo("hilo2",2000)).start();
        new Thread(new ViajeHilo("hilo3",1500)).start();
        new Thread(new ViajeHilo("hilo4",100)).start();

    }
}
