package org.luciochavez.hilos.tareaDeSeccion;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class TareaDeSeccion {
    public static void main(String[] args) throws InterruptedException {

        try(ThreadPoolExecutor ejecutor =(ThreadPoolExecutor) Executors.newFixedThreadPool(3)){

            AlfanumericoTarea tarea1 = new AlfanumericoTarea(Tipo.LETRA);
            AlfanumericoTarea tarea2 = new AlfanumericoTarea(Tipo.NUMERO);
            AlfanumericoTarea tarea3 = new AlfanumericoTarea(Tipo.LETRAMINUS);

            //- definiendo tareas en paralelo donde 2 de ellas se ejecutarán en paralelo
            Future<?> inspector1 = ejecutor.submit(tarea1);
            Future<?> inspector2 = ejecutor.submit(tarea2);
            Future<?> inspector3 = ejecutor.submit(tarea3);

            reporteInspectores(inspector1,inspector2,inspector3);
            ejecutor.shutdown();

            Boolean ins1 = true, ins2 = true, ins3 = true;
            do {

                if(ins1 && inspector1.isDone()){
                    reporteInspectores(inspector1,inspector2,inspector3);
                    ins1 = false;
                }
                if(ins2 && inspector2.isDone()){
                    reporteInspectores(inspector1,inspector2,inspector3);
                    ins2 = false;
                }
                if(ins3 && inspector3.isDone()){
                    reporteInspectores(inspector1,inspector2,inspector3);
                    ins3 = false;
                }

            } while(!(inspector1.isDone() && inspector2.isDone() && inspector3.isDone()));

        }

    }

    public static void reporteInspectores(Future<?> inspector1, Future<?> inspector2, Future<?> inspector3){
        System.out.print(
                """ 
                ======= inspectores =======
                tarea1 estatus: %s
                tarea2 estatus: %s
                tarea3 estatus: %s
                ===========================
                """.formatted(inspector1.state(),inspector2.state(),inspector3.state())
        );
    }

}
