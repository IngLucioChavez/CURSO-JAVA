package org.luciochavez.hilos.ejemplos.threads;

import java.util.Arrays;

//- con la implementación de la interfaz Runnable
//- la clase queda con mayor desacoplamiento que heredar de clase Thread
//- permitiendo herencia de otras clases
public class ViajeHilo implements Runnable{

    private String name;
    private int tiempoMili;

    public ViajeHilo(String name, int tiempoMili) {
        this.name = name;
        this.tiempoMili = tiempoMili;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {

        System.out.println("Iniciando proceso [%s] en hilo con INTERFAZ RUNNABLE".formatted(name));

        for(int i =0; i < 10; i ++){
            System.out.printf("%s --> %s\n",i,name);
            try {
                //- random entre número mínimo y máximo + 1
                //Thread.sleep(ThreadLocalRandom.current().nextInt(1000,2001));
                Thread.sleep(tiempoMili);
            } catch (InterruptedException e) {
                throw new RuntimeException("fuchis: " + Arrays.toString(e.getStackTrace()));
            }
        }

        System.out.println("Finalizando proceso [%s] en hilo con INTERFAZ RUNNABLE".formatted(name));

    }
}
