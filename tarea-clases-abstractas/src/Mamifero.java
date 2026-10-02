public abstract class Mamifero {

    private String habitat;
    private Float altura;
    private Float largo;
    private Float peso;
    private String nombreCientifico;

    public Mamifero() {
        habitat = "";
        altura = 0f;
        largo = 0f;
        peso = 0f;
        nombreCientifico = "";
    }

    public abstract String comer();
    public abstract String correr();
    public abstract String dormir();
    public abstract String comunicarse();

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
}
