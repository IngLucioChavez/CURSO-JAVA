package org.lchavez.ejemplos.list;

import org.lchavez.ejemplos.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjemploListIterator {
    public static void main(String[] args) {

        LinkedList<Alumno> alumnos = new LinkedList<>();

        alumnos.add(new Alumno("A",10));
        alumnos.add(new Alumno("B",8));
        alumnos.add(new Alumno("C",9));
        alumnos.add(new Alumno("D",5));
        alumnos.add(new Alumno("E",5));
        System.out.println(alumnos);

        //- es posible aplicar el Iterator pero este solo opera hacía delante
        //Iterator<Alumno> lii = alumnos.iterator();
        //- ListIterator opera hacía atrás y hacía delante
        ListIterator<Alumno> lii = alumnos.listIterator();

        System.out.println("===== hacía delante =====");
        while(lii.hasNext()){
            System.out.println(lii.next());
        }
        System.out.println("===== hacía atrás =====");
        while(lii.hasPrevious()){
            System.out.println(lii.previous());
        }


    }
}
