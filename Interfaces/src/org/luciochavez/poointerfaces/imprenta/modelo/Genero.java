package org.luciochavez.poointerfaces.imprenta.modelo;

public enum Genero {

    DRAMA("drama"),
    ACCION("acción"),
    AVENTURA("aventura"),
    FANTASIA("fantasia"),
    PROGRAMACION("programación");

    private String genero;

    Genero(String genero) {
        this.genero = genero;
    }

    protected String getGenero(){
        return genero;
    }

}
