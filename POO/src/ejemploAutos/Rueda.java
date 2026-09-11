package ejemploAutos;

public class Rueda {
    private String fabricante;
    private int aro;
    private double ancho;

    public Rueda(double ancho, int aro, String fabricante) {
        this.ancho = ancho;
        this.aro = aro;
        this.fabricante = fabricante;
    }

    public double getAncho() {
        return ancho;
    }

    public int getAro() {
        return aro;
    }

    public String getFabricante() {
        return fabricante;
    }

    @Override
    public String toString() {
        return String.format("{fabricante=%s,aro=%d,ancho=%.2f}",fabricante,aro,ancho);
    }
}
