package mamiferos;

import mamiferos.tipos_mamiferos.Canino;

public class Perro extends Canino {

    private float fuerzaMordida;

    public static class Builder extends Canino.Builder<Perro.Builder>{

        private float fuerzaMordida = 0;

        public Perro.Builder fuerzaMordida(float fuerzaMordida)      { this.fuerzaMordida = fuerzaMordida; return this; }

        @Override protected Perro.Builder self() { return this; }
        @Override public Perro build()      { return new Perro(this); }

    }

    public Perro(){
        fuerzaMordida = 0;
    }

    private Perro(Builder b){
        super(b);
        this.fuerzaMordida = b.fuerzaMordida;
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
