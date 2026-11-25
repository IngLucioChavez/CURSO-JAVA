package org.luciochavez.java8.lambdas.model;

import org.luciochavez.java8.lambdas.interfaces.Operacion;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

public final class Calculadora {

    public double ejecutar(double a, double b, double c, Operacion operacion){
        //- requireNonNull evalua que el parametro u objeto pasado no sea nulo
        //- en caso contrarío manda una excepción NullPointerException
        return Objects.requireNonNull(operacion,"operacion").aplicar(a,b,c);
    }

    //- DoubleBinaryOperator: interfaz funcional que recibe dos double y devuelve un double (método applyAsDouble)
    public double ejecutar(double a, double b, DoubleBinaryOperator operacion){
        return Objects.requireNonNull(operacion,"öperacion").applyAsDouble(a,b);
    }

}
