package org.luciochavez.hilos.ejemploSync.clasesHilos;

import org.luciochavez.hilos.ejemploSync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{

    private Panaderia panaderia;

    public Panadero(Panaderia panaderia){
        this.panaderia = panaderia;
    }

    @Override
    public void run() {

        for(int i = 1; i <= 10; i++){
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100,500));
                panaderia.hornear("pan num %s".formatted(i));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
