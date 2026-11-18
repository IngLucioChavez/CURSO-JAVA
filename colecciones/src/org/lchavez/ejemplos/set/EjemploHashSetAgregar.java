package org.lchavez.ejemplos.set;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        // -se declara a través de su interfaz Set
        Set<String> hs = new HashSet<>();
        hs.add("uno");
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cinco");
        hs.add("tres"); // -retorna false porque un HashSet no permite duplicados

        System.out.println(hs); // -> [cinco, uno, dos, tres, cuatro]

        List<String> li = new ArrayList<>();
        li.add("uno");
        li.add("dos");
        li.add("tres");
        li.add("cuatro");
        li.add("cinco");
        li.add("tres"); // -retorna true porque un List permite duplicados

        System.out.println(li); // -> [uno, dos, tres, cuatro, cinco, tres]
        // NOTESE! en un List se muestran los elementos conforme se van ingresando
        // -- pero en un Set se muestran en cualquier orden además de no permitir repetidos



    }
}
