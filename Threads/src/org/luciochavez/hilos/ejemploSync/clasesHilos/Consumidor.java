package org.luciochavez.hilos.ejemploSync.clasesHilos;

import org.luciochavez.hilos.ejemploSync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Consumidor implements Runnable{

    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia){
        this.panaderia = panaderia;
    }

    @Override
    public void run() {

        for(int i =1; i<=10; i++){
            panaderia.consumirPan();
            // al quitar está sección obligamos a que un consumidor consuma hasta que este disponible un pan
            /*try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100,500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }

    }
}
