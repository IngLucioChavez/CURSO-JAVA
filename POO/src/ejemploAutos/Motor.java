package ejemploAutos;

public class Motor {

    private Double cilindrada;
    private TipoMotor tipo;

    public Motor(){}

    public Motor(Double cilindrada, TipoMotor tipo) {
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    public Double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public void setTipo(TipoMotor tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "cilindrada=" + cilindrada +
                ", tipo=" + tipo +
                '}';
    }
}
