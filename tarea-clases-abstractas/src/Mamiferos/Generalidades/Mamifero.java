package Mamiferos.Generalidades;

public abstract class Mamifero {

    protected String habitat;
    protected Float altura;
    protected Float largo;
    protected Float peso;
    protected String nombreCientifico;
    protected String formaComunicarse;

    public Mamifero() {
        habitat = "sin habitat";
        altura = 0f;
        largo = 0f;
        peso = 0f;
        nombreCientifico = "sin nombre cientifico";
        formaComunicarse = "sin forma de comunicarse";
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

    public String getFormaComunicarse() {
        return formaComunicarse;
    }

    public void setFormaComunicarse(String formaComunicarse) {
        this.formaComunicarse = formaComunicarse;
    }
}
