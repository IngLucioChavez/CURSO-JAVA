package org.lchavez.ejemplos.list;

import org.lchavez.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploIteracionesListSet {
    public static void main(String[] args) {

        //Set<Alumno> setalumnos = new HashSet<>();
        //Set<Alumno> setalumnos = new TreeSet<>();
        List<Alumno> setalumnos = new ArrayList<>();
        //List<Alumno> setalumnos = new LinkedList<>();

        setalumnos.add(new Alumno("A",10));
        setalumnos.add(new Alumno("B",8));
        setalumnos.add(new Alumno("C",9));
        setalumnos.add(new Alumno("D",5));
        setalumnos.add(new Alumno("D",5));

        // NOTESE! las tres primeras formas de iteración con foreach, while/do...while con iterador,
        //--        foreach con lambda se aplican a casi todos los tipos de colecciones a excepción
        //--        de la última forma de iteración que es por índice, esa forma solo la puede implementar
        //--        los Collection List
        System.out.println("==== iterando con foreach ===");
        for(Alumno a:setalumnos){
            System.out.println(a);
        }

        System.out.println("==== iterando con while e iterator ===");
        Iterator<Alumno> iterador = setalumnos.iterator();
        while(iterador.hasNext()){
            Alumno a = iterador.next();
            System.out.println(a);
        }

        System.out.println("==== iterando con foreach lambda ===");
        setalumnos.forEach(System.out::println);

        System.out.println("==== iterando con for normal ===");
        for(int i = 0; i < setalumnos.size(); i++){
            Alumno a = setalumnos.get(i);
            System.out.println(a);
        }



    }
}
