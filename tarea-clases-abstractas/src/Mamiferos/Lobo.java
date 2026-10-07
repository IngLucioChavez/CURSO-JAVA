package Mamiferos;

import Mamiferos.TiposMamiferos.Canino;

public class Lobo extends Canino {

    private int numeroCamada;
    private String especie;
    private String nombrePropio;

    public Lobo() {
        numeroCamada = 0;
        especie = "sin especie";
    }


    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getNumeroCamada() {
        return numeroCamada;
    }

    public void setNumeroCamada(int numeroCamada) {
        this.numeroCamada = numeroCamada;
    }

    public String getNombrePropio() {
        return nombrePropio;
    }

    public void setNombrePropio(String nombrePropio) {
        this.nombrePropio = nombrePropio;
    }

    @Override
    public String comer() {
        return String.format("el LOBO de color %s de la camada %d COME",color,numeroCamada);
    }

    @Override
    public String correr() {
        return String.format("el LOBO de color %s de la camada %d CORRE",color,numeroCamada);
    }

    @Override
    public String dormir() {
        return String.format("el LOBO de color %s de la camada %d DUERME",color,numeroCamada);
    }

    @Override
    public String comunicarse() {
        return String.format("el LOBO de color %s de la camada %d se COMUNICA a través de %s",color,numeroCamada,formaComunicarse);
    }

    @Override
    public String toString() {

        StringBuilder descripcion = new StringBuilder(String.format("LOBO %s \n\n",nombrePropio));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.habitat: %s \n",habitat));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.altura: %s \n",altura));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.largo: %s \n",largo));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.peso: %s \n",peso));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.nombre cientifico: %s \n",nombreCientifico));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.forma comunicarse: %s \n",formaComunicarse));
        descripcion.append(String.format("Mamiferos.TiposMamiferos.Canino.color: %s \n",color));
        descripcion.append(String.format("Mamiferos.TiposMamiferos.Canino.tamaño colmillos: %s \n",tamanioColmillos));
        descripcion.append(String.format("Mamiferos.Lobo.numero camada: %s \n",numeroCamada));
        descripcion.append(String.format("Mamiferos.Lobo.especie: %s \n\n",especie));

        return descripcion.toString();
    }
}
