package Mamiferos.TiposMamiferos;

import Mamiferos.Generalidades.Mamifero;

public abstract class Felino extends Mamifero {

    protected Float tamanioGarras;
    protected Integer velocidad;

    public Felino() {
        tamanioGarras = 0f;
        velocidad = 0;
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



}
