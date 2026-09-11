package org.lucioChavez.appAbstractas.form.validador;

public class LargoValidador extends Validador{

    protected String mensaje = "el mínimo debe ser %d y el máximo %d";
    private int min = 1;
    private int max = Integer.MAX_VALUE;


    public LargoValidador() {
        mensaje = String.format(mensaje,min,max);
    }

    public LargoValidador(int max, int min) {
        this.max = max;
        this.min = min;
        mensaje = String.format(mensaje,min,max);
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return (valor != null && valor.length() >= min && valor.length() <= max);
    }
}
