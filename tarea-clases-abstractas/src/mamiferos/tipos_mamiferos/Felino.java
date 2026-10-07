package mamiferos.tipos_mamiferos;

import mamiferos.generalidades.Mamifero;

public abstract class Felino extends Mamifero {

    protected Float tamanioGarras;
    protected Integer velocidad;

    protected abstract static class Builder<T extends Builder<T>> extends Mamifero.Builder<T>{

        private Float tamanioGarras = 0f;
        private Integer velocidad = 0;

        public T tamanioGarras(Float v){ this.tamanioGarras = v; return self(); }
        public T velocidad(Integer v){ this.velocidad = v; return self(); }

        @Override
        public abstract Felino build();

    }

    public Felino() {
        tamanioGarras = 0f;
        velocidad = 0;
    }

    protected Felino(Builder<?> b){
        super(b);
        this.tamanioGarras = b.tamanioGarras;
        this.velocidad = b.velocidad;
    }

    public Float getTamanioGarras() {
        return tamanioGarras;
    }

    public void setTamanioGarras(Float tamanioGarras) {
        this.tamanioGarras = tamanioGarras;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {

        StringBuilder descripcion = new StringBuilder();
        descripcion.append(super.toString());
        descripcion.append(String.format("mamiferos.tipos_mamiferos.Felino.tamanioGarras: %s \n",tamanioGarras));
        descripcion.append(String.format("mamiferos.tipos_mamiferos.Felino.velocidad: %s \n",velocidad));
        return descripcion.toString();

    }
}
