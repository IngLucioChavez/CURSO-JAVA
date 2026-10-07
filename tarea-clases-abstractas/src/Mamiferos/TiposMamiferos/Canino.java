package Mamiferos.TiposMamiferos;

import Mamiferos.Generalidades.Mamifero;

public abstract class Canino extends Mamifero {

    protected String color;
    protected Float tamanioColmillos;

    public Canino() {
        color = "negro";
        tamanioColmillos = 0f;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getTamanioColmillos() {
        return tamanioColmillos;
    }

    public void setTamanioColmillos(Float tamanioColmillos) {
        this.tamanioColmillos = tamanioColmillos;
    }
}
