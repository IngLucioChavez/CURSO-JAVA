package modelo.personas;

public class SocioPremium extends Socio{
    public SocioPremium(String numeroSocio, String nombres, String ap, String am) {
        super(numeroSocio, nombres, ap, am);
        this.limitePrestamos = 6;
    }

    protected SocioPremium(SocioPremium otro){
        super(otro);
    }

    @Override
    protected String tipo() {
        return "Socio Premium";
    }

    @Override
    public Socio copiar(){
        return new SocioPremium(this);
    }

}
