package org.lucio.pooexcepciones.excepciones;

// heredar de Exception significa que sera una clase de excepción checked
// es decir nos obliga a tratar la excepción, si fuera heredada de RunTimeException
// no estaríamos obligados tratar la excepción ya que RunTimeExcepction es unchecked
public class DivisionPorCeroException extends Exception{
    public DivisionPorCeroException(String message) {
        super(message);
    }
}
