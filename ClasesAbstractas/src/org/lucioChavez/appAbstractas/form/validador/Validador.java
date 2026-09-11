package org.lucioChavez.appAbstractas.form.validador;

abstract public class Validador {
    protected String mensaje = "default";
    abstract public void setMensaje(String mensaje);
    abstract public String getMensaje();
    abstract public boolean esValido(String valor);
}
