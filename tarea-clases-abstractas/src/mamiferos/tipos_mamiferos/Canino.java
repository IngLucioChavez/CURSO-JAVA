package mamiferos.tipos_mamiferos;

import mamiferos.generalidades.Mamifero;

public abstract class Canino extends Mamifero {

    protected String color;
    protected Float tamanioColmillos;

    protected abstract static class Builder<T extends Builder<T>> extends Mamifero.Builder<T>{

        private String color = "sin color";
        private Float tamanioColmillos = 0f;

        public T color(String color)                  { this.color = color; return self(); }
        public T tamanioColmillos(Float t)            { this.tamanioColmillos = t; return self(); }

        @Override
        public abstract Canino build();

    }

    public Canino() {
        color = "sin color";
        tamanioColmillos = 0f;
    }

    protected Canino(Builder<?> b) {
        super(b);   // Mamifero llena sus propios campos
        this.color = b.color;
        this.tamanioColmillos = b.tamanioColmillos;
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
