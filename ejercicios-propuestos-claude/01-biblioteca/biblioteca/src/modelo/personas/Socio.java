package modelo.personas;

public class Socio extends Persona{

    private String numeroSocio;
    protected Integer limitePrestamos = 3;

    public Socio(String numeroSocio,String nombres, String ap, String am) {
        this.numeroSocio = numeroSocio;
        super(nombres, ap, am, 0);
    }

    public String getNumeroSocio() {
        return numeroSocio;
    }

    public Integer getLimitePrestamos() {
        return limitePrestamos;
    }


}
