package org.lchavez.optional;

import javax.swing.*;
import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {

        String nombre = "lucio";

        Optional<String> op = Optional.of(nombre); //- no admite nulos

        System.out.println("valor presente?:" + op.isPresent());
        System.out.println("valor: " + op.get());
        op.ifPresent(v-> System.out.println("-> hola " + v));

        Optional<String> op2 = Optional.ofNullable(null);

        System.out.println("valor presente?:" + op2.isPresent());
        //System.out.println("valor: " + op2.get()); //- genera exception NoSuchElement - por qué no hay valor presente
        //- toUpperCase() afecta tanto al valor como al texto alternativo. Si solo quieres convertir el valor
        //System.out.println("valor: " + op2.orElse("no existe valor").toUpperCase());
        System.out.println("valor: " + op2.map(String::toUpperCase).orElse("no existe valor"));
        // desde java 9+ ifPresentOrElse - cómo traducir esto a Java 8 en una misma línea o stream?
        op2.ifPresentOrElse(v -> System.out.println("valor: " + v),()-> System.out.println("no existe valor"));

        // NOTESE!
        //-- map transforma el valor solo si existe; orElse da la alternativa.
        //-- Así se imprime una sola vez, sin ifPresentOrElse (Java 8+)
        //-- Esto sirve cuando ambos casos producen un valor.
        //-- Si cada caso ejecuta acciones distintas (guardar, enviar, registrar), en Java 8 es más claro un if/else
        System.out.println(op2.map(v -> "valor: " + v).orElse("no existe valor"));
        //-> no existe valor

    }
}
