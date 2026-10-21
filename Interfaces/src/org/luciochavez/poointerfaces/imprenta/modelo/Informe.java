package org.luciochavez.poointerfaces.imprenta.modelo;

public class Informe extends Hoja implements Imprimible{

    private Persona autor;
    private Persona revisor;

    public Informe(Persona autor, Persona revisor, String contenido) {
        super(contenido);
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String imprimir() {

        StringBuilder stringbuild = new StringBuilder();
        stringbuild.append("Informe \n");
        stringbuild.append(String.format("Revisado por: %s\n",revisor));
        stringbuild.append(String.format("Creador por: %s\n",autor));

        return stringbuild.toString();
    }
}
