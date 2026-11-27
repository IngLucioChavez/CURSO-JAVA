package org.lchavez.optional.models;

public class Computador {

    private String modelo;
    private String nombre;
    private int id;
    private static int idAnterior;

    public Computador(String modelo, String nombre) {
        this.modelo = modelo;
        this.nombre = nombre;
        id = ++idAnterior;
    }

    private Computador(Computador computador){
        this.modelo = computador.modelo;
        this.nombre = computador.nombre;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //- regresa una copia con los mismos datos e id
    public Computador copiaDe(Computador computador){
        return new Computador(computador);
    }

    @Override
    public String toString() {
        return "Computador{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", hash='" + hashCode() + '\'' +
                '}';
    }
}
