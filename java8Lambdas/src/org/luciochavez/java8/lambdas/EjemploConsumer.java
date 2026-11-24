package org.luciochavez.java8.lambdas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class EjemploConsumer {
    public static void main(String[] args) {

        //- Consumer<T> es una interfaz funcional: recibe un T (accept) y retorna void.
        //- La lambda es su implementación.
        Consumer<Date> fun1param = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        fun1param.accept(new Date()); //- invocación de método abstracto accept de la interfaz el cual ejecuta la lambda

        //- definiendo lambda que acepta dos params y retorna void
        BiConsumer<String, Integer> fun2param = (nombre,edad) -> {
            System.out.println("%s tiene %s años".formatted(nombre,edad));
        };
        fun2param.accept("lucio",33); //- forma de ejecutar lambda con 2 params

    }
}
