package org.lucio.pooexcepciones.ejemplo;

import org.lucio.pooexcepciones.excepciones.DivisionPorCeroException;
import org.lucio.pooexcepciones.excepciones.FormatonumeroException;

public class Calculadora {

    public Double dividir(int numerador, int divisor) throws DivisionPorCeroException{

        if( divisor == 0 )
            throw new DivisionPorCeroException("division por cero");

        return (double) (numerador/divisor);
    }

    public Double dividir(String numerador, String divisor)
            throws DivisionPorCeroException,FormatonumeroException {

        try{
            int num = Integer.parseInt(numerador);
            int div = Integer.parseInt(divisor);

            return dividir(num,div);
        } catch (NumberFormatException e){
            throw new FormatonumeroException("ERROR - ingresar valores que sean correctos");
        }


    }

}
