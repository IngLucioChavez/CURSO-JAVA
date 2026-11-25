package org.luciochavez.java8.lambdas.interfaces;

/**
 * *Interfaz funcional: tiene exactamente un método abstracto ({@link #aplicar}).
 * *Puede tener métodos {@code default} y {@code static}, y los métodos públicos
 * *de {@code Object} (equals, toString...) no cuentan.
 * *<p>
 * *Una expresión lambda es la implementación de ese único método abstracto.
 * *{@code @FunctionalInterface} es opcional: solo hace que el compilador lo verifique.
 */
@FunctionalInterface
public interface Operacion {

    double aplicar(double a, double b, double c);

}
