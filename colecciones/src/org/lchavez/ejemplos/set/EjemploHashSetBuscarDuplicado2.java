package org.lchavez.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado2 {
    public static void main(String[] args) {

        String[] numeros = {"uno","dos","tres","cuatro","cinco","tres","uno","seis"};

        Set<String> unicos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();
        for(String elemento: numeros){
            if( !unicos.add(elemento) ){
                duplicados.add(elemento);
            }
        }
        unicos.removeAll(duplicados); // -elimina elementos que se encuentran en el Set unicos
        System.out.println("Unicos: %s \nDuplicados: %s".formatted(unicos,duplicados));

    }
}
