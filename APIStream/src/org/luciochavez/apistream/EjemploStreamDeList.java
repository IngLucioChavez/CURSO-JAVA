package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamDeList {
    public static void main(String[] args) {

        List<Usuario> alumnos2a = new ArrayList<>();
        List<Usuario> alumnos2b = new ArrayList<>();
        List<Usuario> alumnos2c = new ArrayList<>();
        alumnos2a.add(new Usuario("AAA","aaa"));
        alumnos2a.add(new Usuario("BBB","bbb"));
        alumnos2a.add(new Usuario("CCC","ccc"));
        alumnos2a.add(new Usuario("DDD","ddd"));
        alumnos2a.add(new Usuario("EEE","eee"));
        alumnos2b.add(new Usuario("AAA","aaa"));
        alumnos2b.add(new Usuario("BBB","bbb"));
        alumnos2b.add(new Usuario("CCC","ccc"));
        alumnos2b.add(new Usuario("DDD","ddd"));
        alumnos2b.add(new Usuario("EEE","eee"));
        alumnos2c.add(new Usuario("AAA","aaa"));
        alumnos2c.add(new Usuario("BBB","bbb"));
        alumnos2c.add(new Usuario("CCC","ccc"));
        alumnos2c.add(new Usuario("DDD","ddd"));
        alumnos2c.add(new Usuario("EEE","eee"));

        List<List<Usuario>> alumnosSegundo = new ArrayList<>();
        alumnosSegundo.add(alumnos2a);
        alumnosSegundo.add(alumnos2b);
        alumnosSegundo.add(alumnos2c);
        //-- flatMap(Collection::stream): aplana List<List<Usuario>> en un solo Stream<Usuario>
        //-- cada lista se convierte en un stream y todos se unen (3 listas de 5 -> 15 elementos)

        // NOTESE! distinct se coloca ANTES del map
        //-- si se hiciera después, ya serían Strings con el id incluido ("[1] aaa" vs "[6] aaa")
        //-- y todos serían distintos
        //-- conserva la primera aparición: quedan los ids 1 al 5 (los de alumnos2a)

        Stream<String> flujoAlumnosSegundo = alumnosSegundo.stream()
                .flatMap(Collection::stream)
                //- distinct(): elimina duplicados usando equals() y hashCode() de Usuario
                .distinct()
                //- map: transforma cada Usuario a un String con el formato "[id] nombres" (String.formatted es Java 15+)
                .map(u -> "[%s] %s".formatted(u.getId(),u.getNombres()))
                //- peek: solo para depurar, imprime cada elemento que pasa por el pipeline
                .peek(System.out::println);

        // NOTESE! Hasta aquí no se ha ejecutado nada: el flujo es lazy
        //-- count() es la operación terminal que lo detona, y por eso se imprime en este punto
        flujoAlumnosSegundo.count();



    }
}
