package ejemploAutos;

import java.util.Arrays;

public class AutoBuilder implements Comparable<AutoBuilder> {

    private int id;
    private Color color;
    private String marca;
    private TipoAuto tipo;
    private Motor motor;
    private Estanque estanque;
    private Persona propietario;
    private Rueda[] ruedas;
    private int indiceRuedas;

    private static int ultimoId;
    private static int idInstancia = 0;

    public static final int LIMITE_RUEDAS = 5;

    //constructor privado
    private AutoBuilder(Builder builder){
        color = builder.color;
        marca = builder.marca;
        tipo = builder.tipo;
        motor = builder.motor;
        estanque = builder.estanque;
        propietario = builder.propietario;
        ruedas = builder.ruedas;
        indiceRuedas = builder.indiceRuedas;
        id = ++idInstancia;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Estanque getEstanque() {
        return estanque;
    }

    public void setEstanque(Estanque estanque) {
        this.estanque = estanque;
    }

    public int getIndiceRuedas() {
        return indiceRuedas;
    }

    public void setIndiceRuedas(int indiceRuedas) {
        this.indiceRuedas = indiceRuedas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public TipoAuto getTipo() {
        return tipo;
    }

    public void setTipo(TipoAuto tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {

        //validaciones para evitar null pointer
        StringBuilder desc = new StringBuilder("AutoBuilder{");
        if( id != 0 )
            desc.append("\n\tid=" + id);
        if( color != null)
            desc.append("\n\tcolor=" + color);
        if( marca != null )
            desc.append("\n\tmarca=" + marca);
        if( tipo != null )
            desc.append("\n\ttipo=" + tipo);
        if( motor != null )
            desc.append("\n\tmotor=" + motor);
        if( estanque != null )
            desc.append("\n\testanque=" + estanque);
        if( propietario != null )
            desc.append("\n\tpropietario=" + propietario);
        if( ruedas != null && ruedas.length > 0 )
            desc.append("\n\truedas=" + Arrays.toString(ruedas));
        if( indiceRuedas != 0 )
            desc.append("\n\tindiceRuedas=" + indiceRuedas);
        desc.append("\n}");

        return desc.toString();
    }

    @Override
    public int compareTo(AutoBuilder a) {
        return marca.compareTo(a.marca);
    }

    //clase static Builder
    public static class Builder{

        private int id;
        private Color color;
        private String marca;
        private TipoAuto tipo;
        private Motor motor;
        private Estanque estanque;
        private Persona propietario;
        private Rueda[] ruedas;
        private int indiceRuedas = 0;

        //metodo creador de obj principal
        public AutoBuilder build(){
            return new AutoBuilder(this); //llamada constructor privado
        }

        public Builder color(Color color){
            this.color = color;
            return this; //retorno de misma instancia
        }
        public Builder marca(String marca){
            this.marca = marca;
            return this;
        }
        public Builder tipo(TipoAuto tipo){
            this.tipo = tipo;
            return this;
        }
        public Builder motor(Motor motor){
            this.motor = motor;
            return this;
        }
        public Builder estanque(Estanque estanque){
            this.estanque = estanque;
            return this;
        }
        public Builder propietario(Persona propietario){
            this.propietario = propietario;
            return this;
        }
        public Builder ruedas(Rueda[] ruedas){
            this.ruedas = (ruedas != null)? Arrays.copyOf(ruedas,ruedas.length):null;
            return this;
        }
        public Builder rueda(Rueda rueda){
            if(ruedas == null || ruedas.length == 0) {
                ruedas = new Rueda[LIMITE_RUEDAS];
                this.ruedas[indiceRuedas++] = rueda;
            }
            else if( indiceRuedas < LIMITE_RUEDAS)
                this.ruedas[indiceRuedas++] = rueda;
            return this;
        }

    }

}
