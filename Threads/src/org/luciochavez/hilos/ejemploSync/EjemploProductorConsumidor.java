package org.luciochavez.hilos.ejemploSync;

import org.luciochavez.hilos.ejemploSync.clasesHilos.Consumidor;
import org.luciochavez.hilos.ejemploSync.clasesHilos.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        /**
         * Ejemplo del patrón productor-consumidor con wait() y notify().
         * Un Panadero (productor) hornea 10 panes y un Consumidor los consume.
         * Cada pan horneado debe consumirse antes de hornear el siguiente:
         *  + Si no hay pan disponible, el consumidor espera.
         *  + Si el pan aún no se consume, el panadero espera.
         *
         * Ambos hilos comparten una misma Panaderia, que actúa como monitor:
         * controla el acceso exclusivo (synchronized) y la condición
         * "hay pan disponible" que coordina el orden entre los hilos.
         * */
        Panaderia panaderia = new Panaderia();
        new Thread(new Panadero(panaderia)).start();
        new Thread(new Consumidor(panaderia)).start();

    }
}
