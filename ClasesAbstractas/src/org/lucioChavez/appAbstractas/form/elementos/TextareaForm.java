package org.lucioChavez.appAbstractas.form.elementos;

public class TextareaForm extends ElementoForm {

    private int filas, columnas;

    public TextareaForm(String nombreCampo) {
        super(nombreCampo);
    }

    public TextareaForm(String nombreCampo, int columnas, int filas) {
        super(nombreCampo);
        this.columnas = columnas;
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    @Override
    public String dibujarHTML() {
        return "<textarea name='"+nombreCampo+"' cols='"+columnas+"' rows='"+filas+"'>"+valorCampo+"</textarea>";
    }
}
