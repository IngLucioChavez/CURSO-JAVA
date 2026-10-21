package org.lucio.poointerfaces.repositorio;

public enum Direccion {
    ASC("asc"),
    DESC("desc");

    private String direccion;

    Direccion(String dir){
        direccion = dir;
    }

    public String getDireccion(){
        return direccion;
    }

}
