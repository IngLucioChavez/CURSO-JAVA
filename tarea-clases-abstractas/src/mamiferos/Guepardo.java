package mamiferos;

import mamiferos.tipos_mamiferos.Felino;

public class Guepardo extends Felino {

    public static class Builder extends Felino.Builder<Guepardo.Builder>{

        @Override protected Builder self(){ return this; }
        @Override public Guepardo build(){ return new Guepardo(this); }

    }

    public Guepardo(){}

    private Guepardo(Builder b){
        super(b);
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
        StringBuilder descripcion = new StringBuilder(String.format("===========\nGUEPARDO %s \n\n",nombrePropio));
        descripcion.append(super.toString());
        return descripcion.toString();
    }

}
