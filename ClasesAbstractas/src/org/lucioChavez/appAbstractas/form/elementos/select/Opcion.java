package org.lucioChavez.appAbstractas.form.elementos.select;

public class Opcion {

    private int valor;
    private String descripcion;
    private boolean selected;

    public Opcion() {
    }

    public Opcion(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public Opcion(String descripcion, int valor, boolean selected) {
        this(descripcion,valor);
        this.selected = selected;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isSelected() {
        return selected;
    }

    public Opcion setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
