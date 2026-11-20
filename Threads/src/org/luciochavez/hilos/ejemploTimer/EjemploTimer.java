package org.luciochavez.hilos.ejemploTimer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploTimer {
    public static void main(String[] args) {

        Date tiempoactual = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //- tarea programada para después de cierto tiempo expresado en milisegundos
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Thread.currentThread().setName("TareaProgramada1-5s"); //- definiendo nombre del Proceso
                SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String cadena = "%s - tarea realizada en el hilo: %s".formatted(fd.format(new Date()),Thread.currentThread().getName());
                System.out.println(cadena);
                System.out.println("%s - finaliza tiempo".formatted(fd.format(new Date())));
                timer.cancel(); //- si ya no se utilizará el timer se finaliza

            }
        },5000);

        System.out.println("%s - Iniciando tarea programada para después de 5s...".formatted(df.format(tiempoactual)));

    }
}
