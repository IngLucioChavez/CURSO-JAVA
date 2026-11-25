package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EjemploMapConObj {

    private static Usuario convertirNombreAUusuario(String nombre){
        String[] nom = nombre.trim().split(" ",2);
        if( nom.length < 2 ){
            throw new IllegalArgumentException("se esperaba Nombre Apellido en: " + nombre);
        }
        return new Usuario(nom[1].toUpperCase(Locale.ROOT),nom[0].toUpperCase(Locale.ROOT));
    }

    public static void main(String[] args) {

        //-- Ejemplo: convertir un arreglo de String ("Nombre Apellido") en una lista de objetos Usuario
        String[] nombres = {"Lucio Chávez","Carlos Chávez","Paola Suarez","Juan Silva Gutiérrez"};

        List<Usuario> nombresAUsuario = Arrays.stream(nombres) //-- Arrays.stream(T[]) -> Stream<String>
                .peek(System.out::println) //-- peek: solo para depurar, permite ver el elemento sin modificarlo
                .map(EjemploMapConObj::convertirNombreAUusuario) //- el map requirió varías líneas se extrajo en un método
                .peek(System.out::println)
                //.toList() //- Java 16+: lista inmutable, reemplaza al collect
                .collect(Collectors.toList()); //- Java 8: operación terminal, detona el flujo

        // NOTESE! La salida de los peek sale intercalada
        //-- Cada elemento recorre todo el pipeline antes de pasar al siguiente (procesamiento vertical),
        //-- no se ejecuta una etapa completa para todos y luego la siguiente
        //-> Lucio Chávez
        //-> Usuario{apellidos='CHÁVEZ', nombres='LUCIO'}
        //-> Carlos Chávez ...

        // NOTESE! Locale.ROOT evita que el resultado de toUpperCase dependa del idioma del equipo
        //-- (por ejemplo, la "i" en turco)

        System.out.println("======== impresión de datos de lista");
        nombresAUsuario.forEach(System.out::println);

    }
}
