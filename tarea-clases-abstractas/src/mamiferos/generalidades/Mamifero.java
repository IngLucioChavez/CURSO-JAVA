package mamiferos.generalidades;

public abstract class Mamifero {

    protected String habitat;
    protected Float altura;
    protected Float largo;
    protected Float peso;
    protected String nombreCientifico;
    protected String formaComunicarse;
    protected String nombrePropio;

    protected abstract static class Builder<T extends Builder<T>>{

        private String habitat = "sin habitat";
        private Float altura = 0f;
        private Float largo = 0f;
        private Float peso = 0f;
        private String nombreCientifico = "sin nombre cientifico";
        private String formaComunicarse = "sin forma de comunicarse";
        private String nombrePropio = "sin nombre propio";

        public T habitat(String habitat)                 { this.habitat = habitat; return self(); }
        public T altura(Float altura)                    { this.altura = altura; return self(); }
        public T largo(Float largo)                      { this.largo = largo; return self(); }
        public T peso(Float peso)                        { this.peso = peso; return self(); }
        public T nombreCientifico(String n)              { this.nombreCientifico = n; return self(); }
        public T formaComunicarse(String f)            { this.formaComunicarse = f; return self(); }
        public T nombrePropio(String f)            { this.nombrePropio = f; return self(); }

        protected abstract T self();
        public abstract Mamifero build();

    }

    public Mamifero() {
        habitat = "sin habitat";
        altura = 0f;
        largo = 0f;
        peso = 0f;
        nombreCientifico = "sin nombre cientifico";
        formaComunicarse = "sin forma de comunicarse";
        nombrePropio = "sin nombre propio";
    }

    protected Mamifero(Builder<?> b) {
        this.habitat = b.habitat;
        this.altura = b.altura;
        this.largo = b.largo;
        this.peso = b.peso;
        this.nombreCientifico = b.nombreCientifico;
        this.formaComunicarse = b.formaComunicarse;
        this.nombrePropio = b.nombrePropio;
    }

    public abstract String comer();
    public abstract String correr();
    public abstract String dormir();
    public abstract String comunicarse();

    public String getNombrePropio() {
        return nombrePropio;
    }

    public void setNombrePropio(String nombrePropio) {
        this.nombrePropio = nombrePropio;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getLargo() {
        return largo;
    }

    public void setLargo(Float largo) {
        this.largo = largo;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getFormaComunicarse() {
        return formaComunicarse;
    }

    public void setFormaComunicarse(String formaComunicarse) {
        this.formaComunicarse = formaComunicarse;
    }

    @Override
    public String toString() {

        StringBuilder descripcion = new StringBuilder();
        descripcion.append(String.format("mamiferos.generalidades.Mamifero.habitat: %s \n",habitat));
        descripcion.append(String.format("mamiferos.generalidades.Mamifero.altura: %s \n",altura));
        descripcion.append(String.format("mamiferos.generalidades.Mamifero.largo: %s \n",largo));
        descripcion.append(String.format("mamiferos.generalidades.Mamifero.peso: %s \n",peso));
        descripcion.append(String.format("mamiferos.generalidades.Mamifero.nombreCientifico: %s \n",nombreCientifico));
        descripcion.append(String.format("mamiferos.generalidades.Mamifero.formaComunicarse: %s \n",formaComunicarse));
        return descripcion.toString();

    }
}
