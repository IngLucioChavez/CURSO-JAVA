package org.luciochavez.hilos.tareaDeSeccion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class AlfanumericoTarea implements Runnable{

    private Tipo tipo;
    private String nombrehilo;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public AlfanumericoTarea(Tipo tipo, String nombrehilo){
        this.tipo = tipo;
        this.nombrehilo = nombrehilo;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(nombrehilo);
        System.out.printf("%s - inicio de tarea...\n", LocalDateTime.now().format(FORMATO));

        try {
            for (int i = tipo.getDesde(); i <= tipo.getHasta(); i++) {
                TimeUnit.MILLISECONDS.sleep(tipo.getTiempo());
                imprimir(tipo.formatear(i));
            }
            imprimir("fin de tarea " + tipo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();   // restaura la bandera de interrupción
            imprimir("tarea interrumpida " + tipo);
        }

        System.out.printf("%s - fin de tarea...\n", LocalDateTime.now().format(FORMATO));

    }

    private void imprimir(String mensaje) {
        System.out.printf("%s [%s] - %s%n",
                LocalDateTime.now().format(FORMATO), Thread.currentThread().getName(), mensaje);
    }

}
