package ejemploAutos;

import java.util.Arrays;

public class Auto {

    private int id;
    private Color color;
    private String marca;
    private TipoAuto tipo;
    private Motor motor;
    private Estanque estanque;
    private Persona propietario;
    private Rueda[] ruedas;
    private int indiceRuedas;

    private static String colorPatente = "naranja";
    private static int ultimoId;

    public static final int LIMITE_RUEDAS = 5;
    public static final int VELOCIDAD_MAXIMA = 120;

    //sobre carga de constructor
    public Auto() {
        id = ++ultimoId;
        ruedas = new Rueda[LIMITE_RUEDAS];
    }
    public Auto(Color color){
        this();
        this.color = color;
    }
    public Auto(Color color, String marca){
        this(color); //referenciado a constructor que recibe solo un param String(color)
        this.marca = marca;
    }
    public Auto(Color color, String marca, TipoAuto tipo) {
        this(color,marca);
        this.tipo = tipo;
    }
    public Auto(Color color, String marca, TipoAuto tipo, Motor motor) {
        this(color,marca,tipo);
        this.motor = motor;
    }
    public Auto(Color color, String marca, TipoAuto tipo, Motor motor, Estanque estanque) {
        this(color,marca,tipo,motor);
        this.estanque = estanque;
    }
    public Auto(Color color, String marca, TipoAuto tipo, Motor motor, Estanque estanque, Persona propietario, Rueda[] ruedas) {
        this(color,marca,tipo,motor,estanque);
        this.propietario = propietario;
        this.ruedas = ruedas;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(TipoAuto tipo) {
        this.tipo = tipo;
    }
    public void setEstanque(Estanque estanque) {
        this.estanque = estanque;
    }

    public String getMarca() {
        return marca;
    }

    public static String getColorPatente() {
        return colorPatente;
    }

    public int getId() {
        return id;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public TipoAuto getTipo() {
        return tipo;
    }

    public Estanque getEstanque() {
        return estanque;
    }


    public Motor getMotor() {
        return motor;
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
        this.ruedas = (ruedas != null ) ? Arrays.copyOf(ruedas,ruedas.length): null;
    }

    public Auto addRueda(Rueda rueda){
        if( indiceRuedas < LIMITE_RUEDAS)
            this.ruedas[indiceRuedas++] = rueda;
        return this;
    }

    //sobreescribiendo equals - polimorfismo
    @Override
    public boolean equals(Object object) {
        //comporbando que object sea instancia de Auto
        if( !(object instanceof Auto a) )
            return false;
        //comprobando x referencia
        if(this == object)
            return true;

        if( color != null && marca != null &&
            color.equals(a.getColor()) && marca.equals(a.getMarca()) ){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder detalle = new StringBuilder();
        detalle.append(String.format("Auto{%n\tcolor=%s,%n\tid=%d,%n\tmarca=%s", color, id, marca));

        if (tipo != null)
            detalle.append(String.format(",%n\ttipo=%s", tipo));
        if (motor != null)
            detalle.append(String.format(",%n\tmotor=%s,%s", motor.getTipo(), motor.getCilindrada()));
        if (estanque != null)
            detalle.append(String.format(",%n\testanque=%d", estanque.getCapacidad()));
        if (propietario != null)
            detalle.append(String.format(",%n\tpropietario=%s", propietario));
        if (ruedas != null && ruedas.length > 0)
            detalle.append(String.format(",%n\truedas=%s", Arrays.toString(ruedas)));

        detalle.append(String.format("%n}"));

        return detalle.toString();
    }
}
