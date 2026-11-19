package org.lchavez.ejemplos.modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {

    private String nombre;
    private int nota;

    public Alumno() {
    }

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                '}';
    }

    //- se define el compareTo para que se compare a través del dato nota
    //- de forma ASC en el treeSet
    // NOTESE! se utiliza Integer.compare() porque un primitivo no pede implementar el método
    // -- compareTo()
    @Override
    public int compareTo(Alumno o) {
        return Integer.compare(nota,o.nota);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Alumno alumno)) return false;
        if( this == object ) return true;
        return nota == alumno.nota && Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}
