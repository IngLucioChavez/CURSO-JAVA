package Mamiferos;

import Mamiferos.TiposMamiferos.Canino;

public class Perro extends Canino {

    private String nombrePropio;
    private float fuerzaMordida;

    public Perro(){
        nombrePropio = "sin nombre";
        fuerzaMordida = 0;
    }

    public float getFuerzaMordida() {
        return fuerzaMordida;
    }

    public void setFuerzaMordida(float fuerzaMordida) {
        this.fuerzaMordida = fuerzaMordida;
    }

    public String getNombrePropio() {
        return nombrePropio;
    }

    public void setNombrePropio(String nombrePropio) {
        this.nombrePropio = nombrePropio;
    }

    @Override
    public String comer() {
        return String.format("el PERRO %s COME",nombrePropio);
    }

    @Override
    public String correr() {
        return String.format("el PERRO %s CORRE",nombrePropio);
    }

    @Override
    public String dormir() {
        return String.format("el PERRO %s DUERME",nombrePropio);
    }

    @Override
    public String comunicarse() {
        return String.format("el PERRO %s se comunica a través de %s",nombrePropio,formaComunicarse);
    }

    @Override
    public String toString() {

        StringBuilder descripcion = new StringBuilder(String.format("PERRO %s \n\n",nombrePropio));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.habitat: %s \n",habitat));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.altura: %s \n",altura));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.largo: %s \n",largo));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.peso: %s \n",peso));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.nombre cientifico: %s \n",nombreCientifico));
        descripcion.append(String.format("Mamiferos.Generalidades.Mamifero.forma comunicarse: %s \n",formaComunicarse));
        descripcion.append(String.format("Mamiferos.TiposMamiferos.Canino.color: %s \n",color));
        descripcion.append(String.format("Mamiferos.TiposMamiferos.Canino.tamaño colmillos: %s \n",tamanioColmillos));
        descripcion.append(String.format("Mamiferos.Perro.fuerzaMordida: %s \n",fuerzaMordida));

        return descripcion.toString();
    }


}
