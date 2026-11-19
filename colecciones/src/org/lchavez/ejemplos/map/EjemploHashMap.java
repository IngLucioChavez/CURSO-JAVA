package org.lchavez.ejemplos.map;

import java.util.*;

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

        //System.out.println(persona.remove("apellido")); //- elimina regresando el valor del campo referenciado a través de su llave
        System.out.println(persona.remove("apellido","roe")); //- elimina regresando 4edda1aun boolean, elimina si llave y valor coinciden con lo almacenado
        System.out.println(persona.containsKey("edad")); //- verifica si existe el campo con la llave indicada retorna boolean
        System.out.println(persona.containsValue("33")); //- verifica si existe algún campo con el valor indicado retorna boolean

        //- obteniendo valores del Map
        Collection<String> valores = persona.values();
        for(String val: valores){
            System.out.println(val);
        }
        //- obteniendo llaves del Map
        Set<String> llaves = persona.keySet();
        for(String llave: llaves){
            System.out.println(llave);
        }

        //- forma1 de iterar un Map obteniendo llave y valor en la misma iteración
        for(Map.Entry<String, String> par: persona.entrySet()){
            System.out.println("%s => %s".formatted(par.getKey(),par.getValue()));
        }

        //- forma2 de iterar Map obteniendo llave y valor
        for(String llave: persona.keySet()){
            System.out.println("%s -> %s".formatted(llave,persona.get(llave)));
        }
        //- forma3 de iterar Map obteniendo llave y valor con lambda Java 8
        persona.forEach((llave,valor) -> System.out.println("%s => %s".formatted(llave,valor)));

        System.out.println("total: %s".formatted(persona.size()));
        System.out.println("vacío?: %s".formatted(persona.isEmpty()));
        //- modifica el valor de un campo a través de la llave retorna el valor anterior
        System.out.println("modificado: %s".formatted(persona.replace("nombre","LUCHO")));
        System.out.println(persona);

    }
}
