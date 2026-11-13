package modelo.materiales;

import modelo.interfaces.Imprimible;

public class Dvd extends Material implements Imprimible {

    private Integer numeroCanciones = 0;

    public Dvd(String titulo, Integer anio, Genero genero, Integer numeroCanciones) {
        super(titulo, anio, genero);
        this.numeroCanciones = numeroCanciones;
    }

    protected Dvd(Dvd otro){
        super(otro);
        this.numeroCanciones = otro.numeroCanciones;
    }

    @Override
    public void actualizarDesde(Material otro){
        super.actualizarDesde(otro);
        if( otro instanceof Dvd dvd ){
            this.numeroCanciones = dvd.numeroCanciones;
        }
    }

    public Integer getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(Integer numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    @Override
    public String obtenerTipo() {
        return "DVD";
    }

    @Override
    public String toString() {

        StringBuilder texto = new StringBuilder();
        texto.append(String.format("Tipo: %s\n",this.obtenerTipo()));
        texto.append(String.format("numero de canciones: %s\n",numeroCanciones));
        texto.append(super.toString());

        return texto.toString();
    }

    @Override
    public Material copiar() {
        return new Dvd(this);
    }
}
