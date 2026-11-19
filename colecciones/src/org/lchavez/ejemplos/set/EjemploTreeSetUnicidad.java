package org.lchavez.ejemplos.set;

import org.lchavez.ejemplos.modelo.Alumno;

import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetUnicidad {
    public static void main(String[] args) {

        /*
            * Ejem1 - conservando el compareTo de la clase Alumno en donde la unicidad en el
            *         treeSet se basa en el compareTo definido por default en la clase Alumno
            * Ejem2 - se modifica el compareTo a través del comparator en el instanciamiento del
            *         treeSet donde la unicidad de basa en el atributo "nombre"
         */

        //Set<Alumno> sa = new TreeSet<>((a,b) -> Integer.compare(a.getNota(),b.getNota())); // - Ejem1
        Set<Alumno> sa = new TreeSet<>((a,b) -> a.getNombre().compareTo(b.getNombre())); // - Ejem2
        sa.add(new Alumno("AAA",100));
        sa.add(new Alumno("BBB",75));
        sa.add(new Alumno("XXX",82));
        sa.add(new Alumno("DDD",94));
        //- Ejem1 - no se asigna porque la unicidad se basa en la nota a través del Comparator/compareTo()
        //- Ejem2 - si se asigna cuando la unicidad se basa en el nombre a través del Comparator definido en la inicialización
        //-         del TreeSet, es decir se reescribe el método compareTo()
        sa.add(new Alumno("ZZZ",94));

        System.out.println(sa);

    }
}
