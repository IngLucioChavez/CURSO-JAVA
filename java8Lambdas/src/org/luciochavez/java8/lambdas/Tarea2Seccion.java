package org.luciochavez.java8.lambdas;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class Tarea2Seccion {
    public static void main(String[] args) {

        /*Function<String, Map<String,Integer>> f1 = cadena -> {
            List<String> palabras = List.of(cadena.split("[ ]"));
            Map<String,Integer> resultado = new HashMap<>();

            palabras.forEach(p->{
                Integer asignacion = resultado.put(p,1);
                if( asignacion != null ){
                    resultado.replace(p, ++asignacion);
                }
            });

            return resultado;
        };*/
        //-optimización pensamiento Senior
        Function<String,Map<String,Integer>> f1 = cadena -> {
            Map<String, Integer> conteo = new LinkedHashMap<>();
            for (String palabra : cadena.toLowerCase(Locale.ROOT).split("\\s+")) {
                //- merge() añade el valor con la clave sí no existe y con el valor inicial,
                //-     en caso de que no exista recalcula el valor utilizando el valor antiguo
                //-     y aplicando la función lambda que se le pase
                conteo.merge(palabra, 1, Integer::sum);  // si no existe pone 1; si existe suma 1
            }
            return conteo;
        };

        System.out.println(f1.apply("hola hola hola mundo loco desquiciado fuchis fuchis fuchis y más fuchis"));

    }
}
