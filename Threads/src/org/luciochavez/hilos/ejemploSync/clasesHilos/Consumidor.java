package org.luciochavez.hilos.ejemploSync.clasesHilos;

import org.luciochavez.hilos.ejemploSync.Panaderia;

import java.util.concurrent.TimeUnit;

public class Consumidor implements Runnable{

    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia){
        this.panaderia = panaderia;
    }

    @Override
    public void run() {

        for(int i =1; i<=10; i++){
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            panaderia.consumirPan();
        }

    }
}
