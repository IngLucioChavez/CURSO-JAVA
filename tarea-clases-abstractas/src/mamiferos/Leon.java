package mamiferos;

import mamiferos.tipos_mamiferos.Felino;

public class Leon extends Felino {

    private int numeroManada;
    private float potenciaRugido;

    public static class Builder extends Felino.Builder<Leon.Builder>{

        private int numeroManada = 0;
        private float potenciaRugido = 0f;

        public Leon.Builder numeroManada(int n){ this.numeroManada = n; return this; }
        public Leon.Builder potenciaRugido(float p){ this.potenciaRugido = p; return this; }

        @Override protected Builder self(){ return this; }
        @Override public Leon build() { return new Leon(this); }

    }

    public Leon(){
        numeroManada = 0;
        potenciaRugido = 0f;
    }

    private Leon(Builder b){
        super(b);
        this.numeroManada = b.numeroManada;
        this.potenciaRugido = b.potenciaRugido;
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

    public int getNumeroManada() {
        return numeroManada;
    }

    public void setNumeroManada(int numeroManada) {
        this.numeroManada = numeroManada;
    }

    public float getPotenciaRugido() {
        return potenciaRugido;
    }

    public void setPotenciaRugido(float potenciaRugido) {
        this.potenciaRugido = potenciaRugido;
    }

    @Override
    public String toString() {
        StringBuilder descripcion = new StringBuilder(String.format("===========\nLEON %s \n\n",nombrePropio));
        descripcion.append(super.toString());
        descripcion.append(String.format("mamiferos.Leon.numeroManada: %s \n",numeroManada));
        descripcion.append(String.format("mamiferos.Leon.potenciaRugido: %s \n\n",potenciaRugido));
        return descripcion.toString();
    }
}
