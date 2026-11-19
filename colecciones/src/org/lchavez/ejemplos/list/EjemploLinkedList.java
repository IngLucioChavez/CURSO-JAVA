package org.lchavez.ejemplos.list;

import org.lchavez.ejemplos.modelo.Alumno;

import java.util.LinkedList;

public class EjemploLinkedList {
    public static void main(String[] args) {

        LinkedList<Alumno> alumnos = new LinkedList<>();

        alumnos.add(new Alumno("A",10));
        alumnos.add(new Alumno("B",8));
        alumnos.add(new Alumno("C",9));
        alumnos.add(new Alumno("D",5));
        alumnos.add(new Alumno("E",5));
        System.out.println(alumnos);

        alumnos.addFirst(new Alumno("F",6));
        alumnos.addLast(new Alumno("G",6));
        System.out.println(alumnos);

        System.out.println("primero: %s".formatted(alumnos.getFirst())); //- obtiene primero y si no existe lanza exception
        System.out.println("último: %s".formatted(alumnos.getLast())); //- obtiene último y si no existe lanza exception
        System.out.println("índice 2: %s".formatted(alumnos.get(2))); //- obtiene en índice especificado

        //System.out.println("eliminado: %s".formatted(alumnos.removeFirst())); //- elimina regresando el elemtno eliminado con exception sí no encuentra el elemento
        //System.out.println("eliminado: %s".formatted(alumnos.removeLast())); //- elimina regresando el elemento eliminado con exception sí no encuentra el elemento
        //System.out.println("eliminado: %s".formatted(alumnos.pollFirst())); //- elimina regresando el elemento eliminado con null sí no lo encuentra
        //System.out.println("eliminado: %s".formatted(alumnos.pollLast())); //- elimina regresando el elemento eliminado con null sí no lo encuentra
        //System.out.println("eliminado: %s".formatted(alumnos.pop())); //- elimina primer elemento regresando el elemtno eliminado con exception sí no encuentra el elemento
        alumnos.remove(); //- elimina el primero regresando el objeto eliminado
        alumnos.remove(0); //- elimina con indice regresando el objeto eliminado
        alumnos.remove(new Alumno("B",8)); //- elimina con instancia aplicando el equals de la instancia
        alumnos.set(1,new Alumno("Z",10)); //- modifica un elemento en la lista
        System.out.println(alumnos);
        //- contains aplica el equals definido en la clase Alumno
        System.out.println("existe el elemento en la lista?: %s".formatted(alumnos.contains(new Alumno("E",5))));

        alumnos = new LinkedList<>();
        System.out.println("primero: %s".formatted(alumnos.peekFirst())); //- obtiene primero y si no existe retorna null
        System.out.println("último: %s".formatted(alumnos.peekLast())); //- obtiene último y si no existe retorna null

    }
}
