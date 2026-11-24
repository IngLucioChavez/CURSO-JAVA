package org.luciochavez.java8.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploLambdaFunction {
    public static void main(String[] args) {

        //- una lambda con la interfaz Function<recibe, regresa>
        Function<String,String> f1 = "hola %s!!"::formatted;
        //- una lambda con la interfaz BiFunction<recibe,recibe,regresa>
        BiFunction<String,String,String> f2 = "%s + %s"::formatted;

        String saludo = f1.apply("lucio");
        System.out.println("saludo = " + saludo);
        System.out.println(f2.apply("lucio","chávez"));

    }
}
