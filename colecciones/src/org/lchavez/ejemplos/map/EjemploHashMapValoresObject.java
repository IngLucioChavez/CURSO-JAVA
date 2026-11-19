package org.lchavez.ejemplos.map;

import java.util.*;

public class EjemploHashMapValoresObject {
    public static void main(String[] args) {

        //- un Map es una estructura de llave y valor semejante a una estructura JSON
        Map<String,Object> persona = new HashMap<>();
        persona.put("nombre","Lucio");
        persona.put("apellido","Chávez");
        persona.put("edad","33");
        persona.put("sexo","masculino");
        persona.put("direcciones",null);

        List<Map<String,String>> direcciones = new ArrayList<>();
        Map<String,String> direccion = new HashMap<>();
        direccion.put("calle","aculco");
        direccion.put("municipio","tlalnepantla");
        direccion.put("colonia","la romana");
        direcciones.add(direccion);
        direccion = new HashMap<>();
        direccion.put("calle","tenango");
        direccion.put("municipio","tlalnepantla");
        direccion.put("colonia","la loma");
        direcciones.add(direccion);

        persona.replace("direcciones",direcciones);

        //- recorriendo los valores del mapa con una vista set
        for (Map.Entry<String, Object> e : persona.entrySet()) {
            if (e.getValue() instanceof List<?> lista) { //- validando que algún valor es de tipo List
                imprimirLista(lista); //- método para imprimir lista
            } else {
                System.out.println("%s -> %s".formatted(e.getKey(), e.getValue()));
            }
        }

    }

    static void imprimirLista(List<?> lista) {
        for (Object item : lista) { //- iteracion de los objetos en la lista
            if (item instanceof Map<?, ?> mapa) { //- validando que alguno de los objetos sea un Map
                System.out.println("--Dirección--");
                //- recorriendo el Map con foreach lambda java 8
                mapa.forEach((k, v) -> System.out.println("%s -> %s".formatted(k, v)));
            } else {
                System.out.println(item);   // cubre List<String>, números, etc.
            }
        }
    }
}
