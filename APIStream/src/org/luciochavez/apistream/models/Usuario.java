package org.luciochavez.apistream.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private String nombres;
    private String apellidos;
    private int id;
    private static int ultimoId;
    private List<Factura> facturas;

    public Usuario(String apellidos, String nombres) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.id = ++ultimoId;
        this.facturas = new ArrayList<>();
    }

    public void addFactura(Factura factura){
        facturas.add(factura);
    }

    public List<Factura> getFacturas(){
        return facturas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario usuario)) return false;
        return Objects.equals(nombres, usuario.nombres) && Objects.equals(apellidos, usuario.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombres, apellidos);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + "'" +
                "apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                '}';
    }
}
