package org.luciochavez.apistream.models;

public class Usuario {

    private String nombres;
    private String apellidos;
    private int id;
    private static int ultimoId;

    public Usuario(String apellidos, String nombres) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.id = ++ultimoId;
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
    public String toString() {
        return "Usuario{" +
                "apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                '}';
    }
}
