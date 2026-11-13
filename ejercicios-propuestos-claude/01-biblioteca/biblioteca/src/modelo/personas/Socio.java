package modelo.personas;

public class Socio extends Persona{

    private String numeroSocio;
    protected Integer limitePrestamos = 3;
    protected Integer prestamosRegistrados = 0;

    public Socio(String numeroSocio,String nombres, String ap, String am) {
        super(nombres, ap, am, 0);
        this.numeroSocio = numeroSocio;
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

    public Integer getPrestamosRegistrados(){
        return prestamosRegistrados;
    }

    public void addNumeroPrestamos(){
        if( prestamosRegistrados >= limitePrestamos )
            return;
        else
            ++prestamosRegistrados;
    }

    public void disNumeroPrestamos(Integer numeroPrestamos){
        prestamosRegistrados = Math.max(0,prestamosRegistrados - numeroPrestamos);
    }

    @Override
    public String toString() {

        StringBuilder text = new StringBuilder();
        text.append(String.format("=== %s ===\n",this.tipo()));
        text.append(super.toString());
        text.append(String.format("Numero Socio: %s\n",numeroSocio));

        return text.toString();
    }
}
