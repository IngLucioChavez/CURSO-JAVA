package org.lchavez.optional.models;

import java.util.Optional;

public final class Procesador {

    private final String nombre;
    private final Fabricante fabricante;

    @Override
    public String toString() {
        return "Procesador{" +
                "fabricante=" + fabricante +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Procesador(String nombre, Fabricante fabricante) {
        this.nombre = nombre;
        this.fabricante = fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public Optional<Fabricante> getFabricanteOptional() {
        return Optional.ofNullable(fabricante);
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

}
