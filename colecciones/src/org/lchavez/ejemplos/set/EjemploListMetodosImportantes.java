package org.lchavez.ejemplos.set;

import org.lchavez.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class EjemploListMetodosImportantes {
    public static void main(String[] args) {

        List<Alumno> alumnos = new ArrayList<>();

        alumnos.add(new Alumno("A",10));
        alumnos.add(new Alumno("B",8));
        alumnos.add(new Alumno("C",9));
        alumnos.add(new Alumno("D",5));
        alumnos.add(new Alumno("E",5));

        System.out.println("tamaño: %s".formatted(alumnos.size())); //- obtener tamaño de la lista
        System.out.println("vacío?: %s".formatted(alumnos.isEmpty())); //- saber si está vacía

        alumnos.add(2,new Alumno("F",5)); //- agregar un elemento en posición con reindexación
        alumnos.set(0,new Alumno("F",5)); //- modificar un elemento en posición
        System.out.println(alumnos);

        alumnos.remove(new Alumno("F",5)); //- eliminar elemento por instancia donde se aplica el equals definido en Alumno
        alumnos.remove(1); //- eliminación por índice
        System.out.println(alumnos);

        //- comparación a través de equals
        System.out.println("existe elemento: %s".formatted(alumnos.contains(new Alumno("F",5)))); // false

        //- convirtiendo una lista en array
        Object[] a = alumnos.toArray();
        for(int i = 0; i < a.length; i++){
            System.out.println("%s en [%s]".formatted(a[i],i)); //-> Alumno{nombre='B', nota=8} en [0], ...
        }

    }
}
