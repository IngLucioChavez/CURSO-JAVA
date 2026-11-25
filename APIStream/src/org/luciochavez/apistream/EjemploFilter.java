package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.Arrays;

public class EjemploFilter {
    public static void main(String[] args) {

        String[] nombres = {"Lucio Chávez","Carlos Chávez","Paola Suarez","Juan Silva Gutiérrez"};

        Usuario usu = Arrays.stream(nombres)
                .map(EjemploMapConObj::convertirNombreAUusuario)
                //- método que ejecuta un Predicate<recibe> -> boolean
                .filter(u -> u.getId() == 2)
                .findFirst()
                .orElse(null); //- si no encuentra un Usuario asigna null

        System.out.println(usu);
        //-> con 20 en filter() -> null
        //-> con 2 en filter() -> Usuario{apellidos='CHÁVEZ', nombres='CARLOS'}

    }
}
