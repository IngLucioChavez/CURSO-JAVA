package org.luciochavez.apistream;

import java.util.*;
import java.util.stream.Stream;

public class EjemploStreamSenior {

    private static List<String> aLista(Stream<String> flujo){
        return flujo.toList();
    }

    public static void main(String[] args) {

        String[] arr = {"uno","dos","tres","cuatro"};
        List<String> lista = List.of(arr);

        Map<String,Stream<String>> fuentes = new LinkedHashMap<>();
        fuentes.put("of",Stream.of(arr)); //- demostración a partir de of
        fuentes.put("arreglo",Arrays.stream(arr)); //- demostración a partir de arreglo
        //- demostración a partir de builder
        fuentes.put("builder", Stream.<String>builder().add("uno").add("dos").add("tres").build());
        //- demostración a partir de un obj collection
        fuentes.put("collection",lista.stream());

        fuentes.forEach((k,v) -> {
            System.out.println("%s -> %s\n".formatted(k,aLista(v)));
        });


    }
}
