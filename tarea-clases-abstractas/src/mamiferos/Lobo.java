package mamiferos;

import mamiferos.tipos_mamiferos.Canino;

public class Lobo extends Canino {

    private int numeroCamada;
    private String especie;

    public static class Builder extends Canino.Builder<Builder>{

        private int numeroCamada = 0;
        private String especie = "sin especie";

        public Builder camada(int camada)      { this.numeroCamada = camada; return this; }
        public Builder especie(String especie) { this.especie = especie; return this; }

        @Override protected Builder self() { return this; }
        @Override public Lobo build()      { return new Lobo(this); }

    }

    public Lobo() {
        numeroCamada = 0;
        especie = "sin especie";
    }

    private Lobo(Builder b) {
        super(b);   // Canino -> Mamifero
        this.numeroCamada = b.numeroCamada;
        this.especie = b.especie;
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

    @Override
    public String comer() {
        return String.format("el LOBO %s de la camada %d COME",nombrePropio,numeroCamada);
    }

    @Override
    public String correr() {
        return String.format("el LOBO %s de la camada %d CORRE",nombrePropio,numeroCamada);
    }

    @Override
    public String dormir() {
        return String.format("el LOBO %s de la camada %d DUERME",nombrePropio,numeroCamada);
    }

    @Override
    public String comunicarse() {
        return String.format("el LOBO %s de la camada %d se COMUNICA a través de %s",nombrePropio,numeroCamada,formaComunicarse);
    }

    @Override
    public String toString() {

        StringBuilder descripcion = new StringBuilder(String.format("===========\nLOBO %s \n\n",nombrePropio));
        descripcion.append(super.toString());
        descripcion.append(String.format("mamiferos.Lobo.numeroCamada: %s \n",numeroCamada));
        descripcion.append(String.format("mamiferos.Lobo.especie: %s \n\n",especie));
        return descripcion.toString();
    }
}
