package mamiferos.tipos_mamiferos;

import mamiferos.generalidades.Mamifero;

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

    @Override
    public String toString() {
        StringBuilder descripcion = new StringBuilder();
        descripcion.append(super.toString());
        descripcion.append(String.format("mamiferos.tipos_mamiferos.Canino.color: %s \n",color));
        descripcion.append(String.format("mamiferos.tipos_mamiferos.Canino.tamanioColmillos: %s \n",tamanioColmillos));
        return descripcion.toString();
    }
}
