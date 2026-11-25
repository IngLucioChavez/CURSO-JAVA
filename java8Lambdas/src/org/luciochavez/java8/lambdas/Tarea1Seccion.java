package org.luciochavez.java8.lambdas;

import java.util.Locale;
import java.util.function.Function;

public class Tarea1Seccion {
    public static void main(String[] args) {

        Function<String,String> quitarSeparadores = s -> s.replaceAll("[ ,.]","");
        //- Locale.ROOT: ignora la configuración regional del sistema, así el resultado es predecible
        Function<String,String> pasarAMayusculas = s -> s.toUpperCase(Locale.ROOT);
        //- andThen compone funciones: f.andThen(g) ejecuta f y pasa su resultado a g, es decir, g(f(x)).
        //- Su inverso es compose: f.compose(g) hace f(g(x))
        Function<String,String> transformar = quitarSeparadores.andThen(pasarAMayusculas);

        System.out.println(transformar.apply("Hola lucho, eres chido!."));

    }
}
