package org.luciochavez.hilos.ejemploTimer;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploTimerPeriodo {
    public static void main(String[] args) {

        Toolkit tool = Toolkit.getDefaultToolkit(); //- para reproducir un sonido del SO
        Date tiempoactual = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //-- Un entero atómico (AtomicInteger) es un int cuyas operaciones de lectura y modificación se ejecutan
        //-- como una sola operación indivisible, sin necesidad de synchronized.
        //-- Sirve para contadores o valores numéricos compartidos entre hilos.
        //- entero atómico para utilizar en el proceso principal y dentro de otros procesos
        AtomicInteger contador = new AtomicInteger(1);
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Thread.currentThread().setName("TareaProgramada2-periodica");
                SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                int i = contador.getAndIncrement();
                if( i <= 3 ){
                    tool.beep(); //- sonido de SO cada vez que se ejecute una tarea
                    String cadena = "%s - [%s]tarea realizada en el hilo: %s".formatted(fd.format(new Date()),i,Thread.currentThread().getName());
                    System.out.println(cadena);
                } else {
                    System.out.println("%s - finaliza tiempo".formatted(fd.format(new Date())));
                    timer.cancel();
                }

            }
        },0,3000); //- se tarda 1s en ejecución principal y se repite cada 3s

        System.out.println("%s - Iniciando tarea programada de forma periodica...".formatted(df.format(tiempoactual)));

    }
}
