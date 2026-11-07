package modelo.personas;

public class SocioPremium extends Socio{
    public SocioPremium(String numeroSocio, String nombres, String ap, String am) {
        super(numeroSocio, nombres, ap, am);
        this.limitePrestamos = 6;
    }
}
