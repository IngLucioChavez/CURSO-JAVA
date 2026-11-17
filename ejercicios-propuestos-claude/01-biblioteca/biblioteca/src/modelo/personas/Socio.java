package modelo.personas;

import modelo.interfaces.Copiable;

public class Socio extends Persona implements Copiable<Socio> {

    private String numeroSocio;
    protected Integer limitePrestamos = 3;

    public Socio(String numeroSocio,String nombres, String ap, String am) {
        super(nombres, ap, am, 0);
        this.numeroSocio = numeroSocio;
    }

    protected Socio(Socio otro){
        super(otro);
        this.numeroSocio = otro.numeroSocio;
        this.limitePrestamos = otro.limitePrestamos;
    }

    public String getNumeroSocio() {
        return numeroSocio;
    }

    public Integer getLimitePrestamos() {
        return limitePrestamos;
    }

    protected String tipo(){
        return "Socio Estándar";
    }

    @Override
    public String toString() {

        StringBuilder text = new StringBuilder();
        text.append(String.format("=== %s ===\n",this.tipo()));
        text.append(super.toString());
        text.append(String.format("Numero Socio: %s\n",numeroSocio));

        return text.toString();
    }

    @Override
    public Socio copiar() {
        return new Socio(this);
    }
}
