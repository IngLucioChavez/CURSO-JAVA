package org.luciochavez.poointerfaces.imprenta.modelo;

public enum Genero {

    DRAMA("drama"),
    ACCION("acción"),
    AVENTURA("aventura"),
    FANTASIA("fantasia");

    private String genero;

    Genero(String genero) {
        this.genero = genero;
    }

    private String getGenero(){
        return genero;
    }

}
