package org.lchavez.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {

        // * en un set no puede haber cualquier objeto
        // * sino que el objeto debe implementar la interfaz Comparable y tener el método compareTo()
        //Set<Integer> ts = new TreeSet<>(); // - el orden por default es ASC
        //Set<Integer> ts = new TreeSet<>((a,b) -> { return b.compareTo(a); }); // - cambiando el orden a DESC con compareTo y lambda
        Set<Integer> ts = new TreeSet<>(Comparator.reverseOrder()); // - cambiar el orden a través de Comparator
        ts.add(1);
        ts.add(2);
        ts.add(4);
        ts.add(5);
        ts.add(3);
        ts.add(3); // - false porque es un Set
        System.out.println(ts);

    }
}
