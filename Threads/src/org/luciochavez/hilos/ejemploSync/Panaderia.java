package org.luciochavez.hilos.ejemploSync;
/**
 * Monitor compartido entre Panadero (productor) y Consumidor.
 *
 * + synchronized: solo un hilo a la vez ejecuta hornear() o consumirPan().
 * + disponible: condición que ordena el trabajo.
 *   true  -> hay un pan listo; el panadero debe esperar.
 *   false -> no hay pan; el consumidor debe esperar.
 * + wait() libera el lock y duerme; notifyAll() despierta a los que esperan.
 * + while y no if: al despertar hay que volver a verificar la condición.
 */
// NOTESE! Reglas importantes sobre wait() y notify()
//-- Solo se puede llamar dentro de un bloque o método synchronized sobre ese mismo objeto.
//-- Si no, lanza IllegalMonitorStateException.
//-- Si nadie está esperando, notify() no hace nada y la notificación se pierde.
//-- Por eso se usa junto con una bandera (disponible): el estado queda guardado aunque nadie haya estado esperando.
//-- Si hay varios hilos esperando, notify() despierta uno solo, sin garantía de cuál.
public class Panaderia {

    private String pan;
    private boolean disponible;

    public synchronized void hornear( String masa ){
        //-- por qué while y no if? Porque cuando un hilo despierta de wait(),
        //-- no hay garantía de que la condición por la que esperaba sea verdadera.
        //-- Con while, el hilo vuelve a verificarla y, si no se cumple, duerme otra vez.
        //-- Con if, la verifica una sola vez y sigue de largo.
        //- mientras este disponible un pan se espera para no hornear
        while(disponible){
            try {
                wait(); //- espera y si despierta desde este punto vuelve a ejecutar por eso el while
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        pan = "%s + otras cosas = pan delicioso".formatted(masa);
        System.out.println("Panadero hornea pan: %s".formatted(pan));
        disponible = true;
        notify(); //- despierta al consumidor que estaba en wait() esperando pan
    }

    public synchronized String consumirPan(){
        //- mientras no exista pan disponible para consumir se debe esperar hasta que exista un pan para consumir
        while(!disponible){
            try {
                wait(); //- espera y si despierta desde este punto vuelve a ejecutar por eso el while
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("cliente consume pan: %s".formatted(pan));
        disponible = false;
        notify(); //- despierta al panadero que estaba en wait() esperando que se consuma
        return pan;
    }

}
