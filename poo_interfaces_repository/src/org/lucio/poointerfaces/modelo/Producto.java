package org.lucio.poointerfaces.modelo;

import java.util.Objects;

public class Producto extends BaseEntity{

    private String descripcion;
    private Double precio;

    public Producto(String descripcion, Double precio) {
        // importante para ejecutar el constructor del padre y así asignar el id autoincremental
        super();
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", id=" + id +
                '}';
    }
}
