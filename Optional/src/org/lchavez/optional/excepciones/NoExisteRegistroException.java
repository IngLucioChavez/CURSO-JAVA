package org.lchavez.optional.excepciones;

public class NoExisteRegistroException extends Exception{
    public NoExisteRegistroException(String param) {
        super("ERROR - no existe registro con el parámetro: [%s]".formatted(param));
    }
}
