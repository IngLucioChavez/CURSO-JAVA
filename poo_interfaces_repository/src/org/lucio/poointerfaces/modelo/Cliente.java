package org.lucio.poointerfaces.modelo;

import java.util.Objects;

public class Cliente extends BaseEntity{

    private String nombre;
    private String apellido;

    public Cliente(String apellido, String nombre) {
        super();
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

}
