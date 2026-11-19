package org.lchavez.ejemplos.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjemploHashMapValoresObjectRecords {
    // NOTESE! los records estan disponibles a partir de Java 16+
    //-- Un record es una clase pensada para guardar datos y lo que escribes entre paréntesis no son solo parámetros:
    //-- Java los convierte en campos.
    //-- * Generan campos private final
    //-- * Genera un constructor que recibe parámetros y los convierte en campos
    //-- * genera métodos con el nombre del campo para leer sus valores
    //-- * también implementa equals(), hashCode() y toString()
    //-- los parámetros de la cabecera sirven para declarar los campos y el constructor a la vez.
    //-- Un record es una clase de verdad y puede tener más cosas.
    //-- lo que no pueden hacer:
    //-- * No pueden tener campos de instancia extra fuera de los que declaras en la cabecera.
    //-- * No pueden extender otra clase, ni ser extendidos (son final).
    //-- * Sus campos no se pueden modificar después de crear el objeto. Para “cambiar” un valor, creas otro record.
    //-- Cuándo pensar en un record?
    //-- Si estás escribiendo una clase que solo tiene campos, constructor, getters, equals, hashCode y toString,
    //-- eso es un record. Si la clase necesita estado que cambia, herencia o lógica compleja, déjala como clase normal.
    record Direccion(String calle, String municipio, String colonia) {}
    record Persona(String nombre, String apellido, int edad, String sexo,
                   List<Direccion> direcciones) {
        Persona {                                    // constructor compacto
            direcciones = List.copyOf(direcciones);  // copia inmutable (Java 10+)
        }
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Lucio", "Chávez", 33, "masculino", List.of(
                new Direccion("aculco", "tlalnepantla", "la romana"),
                new Direccion("tenango", "tlalnepantla", "la loma")));

        System.out.println("nombre -> " + persona.nombre());
        System.out.println("apellido -> " + persona.apellido());
        System.out.println("edad -> " + persona.edad());
        System.out.println("sexo -> " + persona.sexo());

        for (Direccion d : persona.direcciones()) {
            System.out.println("--Dirección--");
            System.out.println("calle -> " + d.calle());
            System.out.println("municipio -> " + d.municipio());
            System.out.println("colonia -> " + d.colonia());
        }

        // toString() automático, útil para depurar
        System.out.println(persona.direcciones().get(0));
        // Direccion[calle=aculco, municipio=tlalnepantla, colonia=la romana]
    }
}
