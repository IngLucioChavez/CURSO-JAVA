package org.lchavez.ejemplos.set;

import org.lchavez.ejemplos.modelo.Alumno;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {

        /*
            * Ejem1 - conservando los métodos por default de Alumno de equals() y hashCode()
            * Ejem2 - se redefinen los métodos equals() y hashCode() en la clase Alumno para que se compare
            *         a través de los valores de sus propiedades "nombre" y "nota"
         */

        Set<Alumno> sa = new HashSet<>();
        sa.add(new Alumno("AAA",100));
        sa.add(new Alumno("BBB",75));
        sa.add(new Alumno("XXX",82));
        sa.add(new Alumno("DDD",94));
        sa.add(new Alumno("ZZZ",94));
        //- Ejem1 - se agrega al HashSet porque por default se compara con el hashCode() del objeto
        //-         a pesar de que se tienen los mismos valores la referencia del objeto es la misma
        //- Ejem2 - no se agrega ya que el HashSet evalua la unicidad a través del equals y del hashCode
        //-         implementados en la clase Alumno
        sa.add(new Alumno("ZZZ",94));

        System.out.println(sa);

    }
}
