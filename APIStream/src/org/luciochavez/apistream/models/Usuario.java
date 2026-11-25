package org.luciochavez.apistream.models;

public class Usuario {

    private String nombres;
    private String apellidos;

    public Usuario(String apellidos, String nombres) {
        this.apellidos = apellidos;
        this.nombres = nombres;
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
