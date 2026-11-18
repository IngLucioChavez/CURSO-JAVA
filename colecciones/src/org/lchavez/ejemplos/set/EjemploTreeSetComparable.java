package org.lchavez.ejemplos.set;

import org.lchavez.ejemplos.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {

        // * NOTA! para que se pueda definir un TreeSet de cierto tipo de Objeto
        // * el objeto debe implementar la interfaz Comparable con su método compareTo()
        //- sobreescribiendo el método compareTo de forma DESC que se define en la clase Alumno a través de lambda
        Set<Alumno> sa = new TreeSet<>((a,b) -> Integer.compare(b.getNota(),a.getNota()));
        sa.add(new Alumno("AAA",100));
        sa.add(new Alumno("BBB",75));
        sa.add(new Alumno("XXX",82));
        sa.add(new Alumno("DDD",94));

        System.out.println(sa);

    }
}
