package org.lchavez.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado {
    public static void main(String[] args) {

        String[] numeros = {"uno","dos","tres","cuatro","cinco","tres","uno","seis"};

        Set<String> unicos = new HashSet<>();
        for(String elemento: numeros){
            if( !unicos.add(elemento) ){
                System.out.println("Elemento duplicado: %s".formatted(elemento));
            }
        }
        System.out.println(unicos);

    }
}
