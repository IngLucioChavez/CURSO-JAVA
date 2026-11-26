package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class EjemploAnyMatch {
    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("ChÁvez","Lucio"));
        usuarios.add(new Usuario("Chávez","Carlos"));
        usuarios.add(new Usuario("Silva","Juan"));
        usuarios.add(new Usuario("Phudu","Dudu"));

        //-- Predicate<T>: interfaz funcional con un método test(T) que retorna boolean.
        //-- Es lo que reciben filter, anyMatch, allMatch y noneMatch.

        //- anyMatch(Predicate): operación terminal con cortocircuito, retorna boolean
        //- true en cuanto encuentra el primer elemento que cumple; no recorre el resto
        boolean existe = usuarios.stream()
                .peek(System.out::println)
                .anyMatch(u -> u.getId() == 2);

        // NOTESE! El peek solo imprime hasta el elemento que cumple la condición
        //-- anyMatch corta el recorrido al encontrar el primero (cortocircuito),
        //-- por eso no se imprimen los usuarios posteriores
        //-> Usuario{id=1...}
        //-> Usuario{id=2...}   (aquí se detiene)

        //- filter(Predicate): operación intermedia, retorna un nuevo Stream<T> con los elementos que cumplen
        //- count(): operación terminal, retorna un long con el total de elementos del flujo
        long count = usuarios.stream()
                .filter(u-> "Chávez".equalsIgnoreCase(u.getApellidos()))
                .count();

        // NOTESE! Cada usuarios.stream() crea un Stream nuevo
        //-- por eso se pueden usar dos pipelines sobre la misma lista sin IllegalStateException

        System.out.println("existe?: " + existe);
        System.out.println("count?: " + count);

    }
}
