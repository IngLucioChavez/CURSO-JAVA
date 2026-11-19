package org.lchavez.ejemplos.list;

import org.lchavez.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class EjemploListComparableComparator {
    public static void main(String[] args) {

        List<Alumno> setalumnos = new ArrayList<>();

        setalumnos.add(new Alumno("A",10));
        setalumnos.add(new Alumno("B",8));
        setalumnos.add(new Alumno("C",9));
        setalumnos.add(new Alumno("D",5));
        setalumnos.add(new Alumno("D",5));

        //- aplicando ordenación a través de Collections.sort
        //Collections.sort(setalumnos,(a,b) ->{ return Integer.compare(b.getNota(),a.getNota()); });
        //- aplicando ordenación a través de método sort propio de un List reescribiendo el compareTo
        //setalumnos.sort((a,b) -> Integer.compare(b.getNota(),a.getNota()));
        //- aplicando ordenación por sort con lambda
        /*setalumnos.sort(Comparator.comparing((Alumno a) -> {
            return a.getNota();
        }));*/
        //- aplicando ordenación por sort con lambda simplificada
        //setalumnos.sort(Comparator.comparing(Alumno::getNota)); //- forma default ASC
        setalumnos.sort(comparing(Alumno::getNombre).reversed()); //- forma DESC

        setalumnos.forEach(System.out::println);



    }
}
