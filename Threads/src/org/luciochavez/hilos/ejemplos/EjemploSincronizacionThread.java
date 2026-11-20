package org.luciochavez.hilos.ejemplos;

import org.luciochavez.hilos.ejemplos.threads.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) {

        new Thread(new ImprimirFrases("Hola ","que tal!")).start();
        new Thread(new ImprimirFrases("¿Quién eres ","tú?")).start();
        new Thread(new ImprimirFrases("Muchas gracias ","amigo!")).start();

    }

    //- synchronized aplica exclusión mutua: solo un hilo a la vez puede ejecutar este método
    //- los demás hilos esperan (estado BLOCKED) hasta que el hilo actual termine y libere el candado
    //- como el método es static, el candado es la clase EjemploSincronizacionThread.class
    //-- El orden no está garantizado. synchronized asegura que no se mezclen,
    //-- pero no decide quién entra primero. En una ejecución puede salir “Hola” primero y en otra “Muchas gracias”. Eso es normal.
    public synchronized static void imprimirFrases(String frase1, String frase2) {
        System.out.print(frase1);
        try {
            //-- Thread.sleep() es un método estático que duerme al hilo que lo ejecuta (Thread.currentThread()),
            //-- no a un objeto Thread en particular.
            //- este sleep se ejecuta en el hilo que lo manda a llamar
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Hilo interrumpido",e);
        }
        System.out.println(frase2);
    }

}