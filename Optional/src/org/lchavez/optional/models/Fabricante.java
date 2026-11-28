package org.lchavez.optional.models;

public final class Fabricante {

    private final String nombre;

    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Fabricante{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

}
