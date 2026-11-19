package org.lchavez.ejemplos.map;

import com.sun.source.tree.Tree;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {

        //- un Map es una estructura de llave y valor semejante a una estructura JSON
        //Map<String,Object> persona = new TreeMap<>((a,b) -> b.compareTo(a)); //- ordena de forma DESC a través del valor de la llave
        //Map<String,Object> persona = new TreeMap<>(Comparator.reverseOrder()); //- cambia el orden a DESC a través del valor de la llave
        Map<String,Object> persona = new TreeMap<>(Comparator.comparing(String::length)); //- compara conforme al tamaño de letras del valor de la llave
        persona.put("nombre","Lucio");
        persona.put("apellido","Chávez");
        persona.put("edad","33");
        persona.put("sexo","masculino");

        Map<String,String> direccion = new HashMap<>();
        direccion.put("calle","tenango");
        direccion.put("numero","5");
        direccion.put("colonia","la loma");
        direccion.put("municipio","Tlalnepantla");
        direccion.put("estado","Estado de México");

        persona.put("direccion",direccion);

        System.out.println("persona = " + persona);

    }
}
