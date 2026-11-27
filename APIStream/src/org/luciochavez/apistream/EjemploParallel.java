package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EjemploParallel {
    public static void main(String[] args) {

        List<Usuario> alumnos2a = new ArrayList<>();
        alumnos2a.add(new Usuario("AAA","aaa"));
        alumnos2a.add(new Usuario("BBB","bbb"));
        alumnos2a.add(new Usuario("CCC","ccc"));
        alumnos2a.add(new Usuario("DDD","ddd"));
        alumnos2a.add(new Usuario("EEE","eee"));
        alumnos2a.add(new Usuario("EEE","fff"));
        alumnos2a.add(new Usuario("EEE","ggg"));
        alumnos2a.add(new Usuario("EEE","hhh"));

        Long t1 = System.currentTimeMillis();
        try {
            Usuario alumnoBuscado = alumnos2a.stream()
                    //-- parallel(): marca el pipeline como paralelo; el stream divide sus datos en partes
                    //-- que se procesan a la vez en varios hilos del ForkJoinPool común (y también en el hilo que lo invoca)
                    //-- afecta a TODO el pipeline, esté donde esté: la última llamada entre parallel() y sequential() es la que vale
                    .parallel()
                    //-- peek: muestra qué hilo procesa cada elemento
                    // NOTESE! El orden de la salida del peek NO sigue el orden de la lista (3, 5, 2, 8, 7, 1, 6, 4)
                    //-- en paralelo, el orden de procesamiento no está garantizado; main también procesa elementos
                    .peek(usu->{
                        System.out.println(Thread.currentThread().getName() + " -> " + usu);
                    })
                    .filter(u -> {
                        try{
                            /* sleep(500) simula trabajo costoso */
                            TimeUnit.MILLISECONDS.sleep(500);
                        } catch ( InterruptedException e) {}
                        return u.getNombres().equals("hhh");
                    })
                    // NOTESE! Con 8 elementos de 500 ms, secuencial tardaría unos 4 s; en paralelo tardó ~523 ms
                    //-- los 8 sleeps se ejecutaron a la vez (hay hilos suficientes)
                    //-- con menos núcleos el tiempo crece: ceil(8 / hilos disponibles) x 500 ms
                    .findFirst()
                    // NOTESE! findFirst respeta el orden de encuentro de la lista aunque se procese en paralelo
                    //-- cuesta más que findAny, que retorna cualquier coincidencia y es más barato si el orden no importa
                    .orElseThrow(() -> new IllegalArgumentException("El usuario no existe"));
                    //-> alumnoBuscado = Usuario{id='8'...hhh}
                    //-> tiempo : 523

            System.out.println("alumnoBuscado = " + alumnoBuscado);
        } catch ( IllegalArgumentException e ){
            System.out.println("Alumno no existente");
        }

        Long t2 = System.currentTimeMillis();
        System.out.println("tiempo : " + (t2-t1));



    }
}
