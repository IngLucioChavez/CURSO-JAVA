package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.List;
import java.util.stream.Stream;

public class EjemploDistinctDetalle {
    public static void main(String[] args) {

        List<String> nombres = List.of(
                "Lucio Chávez",
                "Carlos Chávez",
                "Carlos Chávez",
                "María Delgado",
                "Juan Silva",
                "Dudu Phudu"
        );

        Stream<Usuario> nombresAUsuario= nombres.stream()
                //.distinct() //- si se pone aquí, el distinct() se basará en el equals() del String
                .map(EjemploOptionalSenior::desdeNombreCompleto)
                .distinct(); //- si se pone aquí, el distinct() se basará en el equals() del obj Usuario
                        //- el equals() de Usuario se basa en nombre y apellido para que dos obj Usuario puedan ser iguales

        nombresAUsuario.forEach(System.out::println);

    }
}
