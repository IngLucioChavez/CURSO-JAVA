package Mamiferos;

import Mamiferos.TiposMamiferos.Felino;

public class Leon extends Felino {

    private int numeroManada;
    private float potenciaRegudio;
    private String nombrePropio;

    public Leon(){
        numeroManada = 0;
        potenciaRegudio = 0f;
        nombrePropio = "";
    }

    @Override
    public String comer() {
        return String.format("el LEON %s empieza a COMER",nombrePropio);
    }

    @Override
    public String correr() {
        return String.format("el LEON %s empieza a CORRER",nombrePropio);
    }

    @Override
    public String dormir() {
        return String.format("el LEON %s empieza a DORMIR",nombrePropio);
    }

    @Override
    public String comunicarse() {
        return String.format("el LEON %s empieza a COMUNICARSE de forma %s",nombrePropio,formaComunicarse);
    }

    public String getNombrePropio() {
        return nombrePropio;
    }

    public void setNombrePropio(String nombrePropio) {
        this.nombrePropio = nombrePropio;
    }

    public int getNumeroManada() {
        return numeroManada;
    }

    public void setNumeroManada(int numeroManada) {
        this.numeroManada = numeroManada;
    }

    public float getPotenciaRegudio() {
        return potenciaRegudio;
    }

    public void setPotenciaRegudio(float potenciaRegudio) {
        this.potenciaRegudio = potenciaRegudio;
    }

    @Override
    public String toString() {
        StringBuilder descripcion = new StringBuilder(String.format("LEON %s \n\n",nombrePropio));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.habitat: %s \n",habitat));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.altura: %s \n",altura));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.largo: %s \n",largo));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.peso: %s \n",peso));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.nombre cientifico: %s \n",nombreCientifico));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.forma comunicarse: %s \n",formaComunicarse));
        descripcion.append(String.format("Mamiferos.TiposMamiferos.Felino.tamanioGarras: %s \n",tamanioGarras));
        descripcion.append(String.format("Mamiferos.TiposMamiferos.Felino.velocidad: %s \n",velocidad));
        descripcion.append(String.format("Mamiferos.Leon.numeroManada: %s \n",numeroManada));
        descripcion.append(String.format("Mamiferos.Leon.potenciaRugido: %s \n\n",potenciaRegudio));

        return descripcion.toString();
    }
}
