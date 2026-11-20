package org.luciochavez.hilos.ejemploSync;

import org.luciochavez.hilos.ejemploSync.clasesHilos.Consumidor;
import org.luciochavez.hilos.ejemploSync.clasesHilos.Panadero;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Ejemplo implementando lambdas con java 8 donde las lambdas son funciones anónimas
 * que solo se ejecutan en tiempo de ejecución para ahorrar crear objetos con métodos
 */
public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {

        Panaderia panaderia = new Panaderia();
        //- simulación de panadero
        new Thread(()->{
            for(int i = 1; i <= 10; i++){
                panaderia.hornear("pan num %s".formatted(i));
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100,2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        //-simulación de consumidor
        new Thread(()->{
            for(int i =1; i<=10; i++){
                panaderia.consumirPan();
            }
        }).start();

    }
}
