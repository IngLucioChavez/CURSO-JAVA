package org.luciochavez.java8.lambdas;

import org.luciochavez.java8.lambdas.interfaces.Operacion;
import org.luciochavez.java8.lambdas.model.Calculadora;

import java.util.LinkedHashMap;
import java.util.Map;

public class EjemploLambdaPersonalizada {
    public static void main(String[] args) {

        //- un LinkedHashMap respeta el orden en que se insertaron los valores
        Map<String, Operacion> operaciones = new LinkedHashMap<>();
        operaciones.put("suma", (a,b,c)->a+b+c);
        operaciones.put("producto", (a,b,c)->a*b*c);
        operaciones.put("resta-producto", (a,b,c)->(a-b)*c);

        Calculadora cal = new Calculadora();
        operaciones.forEach((nombre,operacion) ->
            System.out.println(nombre + " = " + cal.ejecutar(10D,20D,30D, operacion))
        );

        // Resta y división con lambda, sin clase anónima
        System.out.println("resta y división: " + cal.ejecutar(100D,200D,(a,b)->a/b));

    }
}
