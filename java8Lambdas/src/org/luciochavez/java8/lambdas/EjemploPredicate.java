package org.luciochavez.java8.lambdas;

import org.luciochavez.java8.lambdas.model.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        //- un Predicate siempre regresará un boolean Predicate<recibe> pero recibe 1 param
        Predicate<Integer> f1 = a -> a > 10;

        //- un BiPredicate siempre regresará un boolean Predicate<recibe,recibe> pero recibe 2 params
        BiPredicate<String,String> f2 = String::equals;
        BiPredicate<Usuario,Usuario> f3 = (u1,u2) -> u1.getNombre().equals(u2.getNombre());

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("Bubu");
        a.setNombre("Dudu");

        System.out.println("f1.test(50) = " + f1.test(50)); //-> true
        System.out.println("f2.test(\"hola\",\"Hola\") = " + f2.test("hola","Hola")); //-> false
        System.out.println("f3 = " + f3.test(a,b));

    }
}
