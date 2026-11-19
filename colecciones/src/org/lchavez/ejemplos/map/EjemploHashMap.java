package org.lchavez.ejemplos.map;

import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {
    public static void main(String[] args) {

        //- un Map es una estructura de llave y valor semejante a una estructura JSON
        Map<String,String> persona = new HashMap<>();
        persona.put("nombre","Lucio");
        persona.put("apellido","Chávez");
        persona.put("edad","33");
        persona.put("sexo","masculino");
        System.out.println(persona);  //-> {apellido=Chávez, sexo=masculino, nombre=Lucio, edad=33}
        //- obteniendo valores a través de la llave
        System.out.print("Nombre completo: %s %s\n".formatted(persona.get("nombre"),persona.get("apellido")));
        //-> Nombre completo: Lucio Chávez

    }
}
