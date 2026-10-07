package mamiferos;

import mamiferos.tipos_mamiferos.Canino;

public class Perro extends Canino {

    private float fuerzaMordida;

    public Perro(){
        fuerzaMordida = 0;
    }

    public float getFuerzaMordida() {
        return fuerzaMordida;
    }

    public void setFuerzaMordida(float fuerzaMordida) {
        this.fuerzaMordida = fuerzaMordida;
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

        StringBuilder descripcion = new StringBuilder(String.format("===========\nPERRO %s \n\n",nombrePropio));
        descripcion.append(super.toString());
        descripcion.append(String.format("mamiferos.Perro.fuerzaMordida: %s \n",fuerzaMordida));
        return descripcion.toString();
    }


}
