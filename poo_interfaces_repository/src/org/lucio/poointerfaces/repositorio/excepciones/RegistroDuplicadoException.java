package org.lucio.poointerfaces.repositorio.excepciones;

public class RegistroDuplicadoException extends EscrituraDatoException{
    public RegistroDuplicadoException(String message) {
        super(message);
    }
}
