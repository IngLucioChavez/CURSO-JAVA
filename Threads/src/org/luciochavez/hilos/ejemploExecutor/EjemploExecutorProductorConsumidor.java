package org.luciochavez.hilos.ejemploExecutor;

import org.luciochavez.hilos.ejemploSync.Panaderia;
import org.luciochavez.hilos.ejemploSync.clasesHilos.Consumidor;
import org.luciochavez.hilos.ejemploSync.clasesHilos.Panadero;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EjemploExecutorProductorConsumidor {

    public static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws InterruptedException {

        int nucleos = Runtime.getRuntime().availableProcessors();
        System.out.println("nucleos disponibles para JVM: " + nucleos); // 8

        //- se realiza cast para obtener los métodos de ThreadPoolExecutor
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        Panaderia panaderia = new Panaderia();
        Panadero panadero = new Panadero(panaderia);
        Consumidor consumidor = new Consumidor(panaderia);

        Future<?> futuro1 = executor.submit(panadero);
        Future<?> futuro2 = executor.submit(consumidor);

    }
}
