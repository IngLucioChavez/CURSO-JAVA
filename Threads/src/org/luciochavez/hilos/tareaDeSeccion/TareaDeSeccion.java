package org.luciochavez.hilos.tareaDeSeccion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TareaDeSeccion {

    public static void main(String[] args) throws InterruptedException {

        try (ExecutorService ejecutor = Executors.newFixedThreadPool(3)) {
            CompletionService<Void> servicio = new ExecutorCompletionService<>(ejecutor);
            List<Future<Void>> futuros = new ArrayList<>();

            //- un hilo por tipo: las 3 tareas corren al mismo tiempo
            for (Tipo tipo : Tipo.values()) {
                futuros.add(servicio.submit(new AlfanumericoTarea(tipo, "tarea-%s".formatted(tipo.toString())),null));
            }
            reporte(futuros);

            for (int i = 0; i < futuros.size(); i++) {
                servicio.take();          // bloquea (sin gastar CPU) hasta que termine la siguiente tarea
                reporte(futuros);
            }
        }   // close() hace shutdown() y espera: ya no hace falta llamarlo a mano
    }

    private static void reporte(List<Future<Void>> futuros) {
        StringBuilder sb = new StringBuilder("======= inspectores =======\n");
        for (int i = 0; i < futuros.size(); i++) {
            sb.append("tarea").append(i + 1).append(" estatus: ").append(futuros.get(i).state()).append('\n');
        }
        System.out.print(sb.append("===========================\n"));
    }
}