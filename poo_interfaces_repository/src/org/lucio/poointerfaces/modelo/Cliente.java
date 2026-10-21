package org.lucio.poointerfaces.modelo;

import java.util.Objects;

public class Cliente {

    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoId;

    public Cliente() {
        id = ++ultimoId; //para generar el id automático
    }

    public Cliente(String apellido, String nombre) {
        this();
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(String.format("Cliente[%s]:\n",id));
        sb.append(String.format("nombre: %s\n",nombre));
        sb.append(String.format("apellido: %s\n",apellido));

        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente cliente)) return false;
        // Objects.equals es un metodo helper
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
