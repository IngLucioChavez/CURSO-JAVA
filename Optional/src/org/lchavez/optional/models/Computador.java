package org.lchavez.optional.models;

import java.util.Optional;

public class Computador {

    private String modelo;
    private String nombre;
    private Procesador procesador;
    private final int id;
    private static int idAnterior;

    public Computador(String modelo, String nombre, Procesador procesador) {
        this.modelo = modelo;
        this.nombre = nombre;
        this.procesador = procesador;
        id = ++idAnterior;
    }

    private Computador(Computador computador){
        this.modelo = computador.modelo;
        this.nombre = computador.nombre;
        this.procesador = computador.procesador;
        this.id = computador.id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Optional<Procesador> getProcesadorOptional() {
        return Optional.ofNullable(procesador);
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    //- regresa una copia con los mismos datos e id
    public Computador copia(){
        return new Computador(this);
    }

    @Override
    public String toString() {
        return "Computador{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", hash='" + hashCode() + '\'' +
                "\n, procesador='" + procesador + '\'' +
                '}';
    }
}
