package org.luciochavez.poointerfaces.imprenta.modelo;

public class Informe extends Hoja{

    private String autor;
    private String revisor;

    public Informe(String autor, String revisor, String contenido) {
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
