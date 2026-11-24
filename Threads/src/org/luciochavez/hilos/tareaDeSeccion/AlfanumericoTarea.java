package org.luciochavez.hilos.tareaDeSeccion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class AlfanumericoTarea implements Runnable{

    private Tipo tipo;
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public AlfanumericoTarea(Tipo tipo){
        this.tipo = tipo;
    }

    @Override
    public void run() {
        System.out.printf("%s - inicio de tarea...\n", LocalDateTime.now().format(formato));

        switch (tipo){
            case Tipo.LETRA -> {
                for(int i = 65; i <= 90; i++){
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.printf("%s - %s\n",LocalDateTime.now().format(formato),(char)i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            case Tipo.LETRAMINUS -> {
                for(int i = 97; i <= 122; i++){
                    try {
                        TimeUnit.MILLISECONDS.sleep(600);
                        System.out.printf("%s - %s\n",LocalDateTime.now().format(formato),(char)i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            case Tipo.NUMERO -> {
                for(int i=0; i<=10; i++){
                    try {
                        TimeUnit.MILLISECONDS.sleep(700);
                        System.out.printf("%s - %s\n",LocalDateTime.now().format(formato),i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
        System.out.printf("%s - fin de tarea...\n", LocalDateTime.now().format(formato));

    }
}
