package org.lchavez.ejemplos.modelo;

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
    //- de forma ASC
    // NOTESE! se utiliza Integer.compare() porque un primitivo no pede implementar el método
    // -- compateTo()
    @Override
    public int compareTo(Alumno o) {
        return Integer.compare(nota,o.nota);
    }
}
