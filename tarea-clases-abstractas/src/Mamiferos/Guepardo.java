package Mamiferos;

import Mamiferos.TiposMamiferos.Felino;

public class Guepardo extends Felino {

    private String nombrePropio;

    public Guepardo(){
        nombrePropio = "sin nombre propio";
    }

    public String getNombrePropio() {
        return nombrePropio;
    }

    public void setNombrePropio(String nombrePropio) {
        this.nombrePropio = nombrePropio;
    }

    @Override
    public String comer() {
        return String.format("el GUEPARDO %s empieza a COMER",nombrePropio);
    }

    @Override
    public String correr() {
        return String.format("el GUEPARDO %s empieza a CORRER",nombrePropio);
    }

    @Override
    public String dormir() {
        return String.format("el GUEPARDO %s empieza a DORMIR",nombrePropio);
    }

    @Override
    public String comunicarse() {
        return String.format("el GUEPARDO %s empieza a COMUNICARSE de forma %s",nombrePropio,formaComunicarse);
    }

    @Override
    public String toString() {
        StringBuilder descripcion = new StringBuilder(String.format("GUEPARDO %s \n\n",nombrePropio));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.habitat: %s \n",habitat));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.altura: %s \n",altura));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.largo: %s \n",largo));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.peso: %s \n",peso));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.nombre cientifico: %s \n",nombreCientifico));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.forma comunicarse: %s \n",formaComunicarse));
        descripcion.append(String.format("Mamiferos.TiposMamiferos.Felino.tamanioGarras: %s \n",tamanioGarras));
        descripcion.append(String.format("Mamiferos.TiposMamiferos.Felino.velocidad: %s \n",velocidad));

        return descripcion.toString();
    }

}
