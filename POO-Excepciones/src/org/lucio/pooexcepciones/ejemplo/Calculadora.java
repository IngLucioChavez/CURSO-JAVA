package org.lucio.pooexcepciones.ejemplo;

import org.lucio.pooexcepciones.excepciones.DivisionPorCeroException;

public class Calculadora {

    public Double dividir(int numerador, int divisor) throws DivisionPorCeroException{

        if( divisor == 0 )
            throw new DivisionPorCeroException("division por cero");

        return (double) (numerador/divisor);
    }

}
