package org.luciochavez.hilos.ejemplos.threads;

public class ClaseHiloThread extends Thread{

    public ClaseHiloThread(String name) {
        super(name); //- nombre de hilo
    }

    @Override
    public void run() {

        System.out.println("Se INICIA el hilo %s".formatted(getName()));

        for(int i= 1; i <=10; i++){
            System.out.println("numero: %s".formatted(i));
        }

        System.out.println("Se FINALIZA hilo %s".formatted(getName()));

    }
}
