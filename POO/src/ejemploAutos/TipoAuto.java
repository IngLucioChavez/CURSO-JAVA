package ejemploAutos;

public enum TipoAuto {
    SEDAN("sedan","auto mediano",4),
    PICKUP("pickup","auto pequeño",2),
    HATCHBACK("hatchback","auto compacto",4),
    COUPE("coupe","auto pequeño",2),
    CONVERTIBLE("convertible","auto deportivo",4),
    FURGON("furgon","auto utilitario",2);

    // propiedades de un ENUM siempre son final
    private final String nombre;
    private final int numeroPuertas;
    private final String descripcion;

    TipoAuto(String descripcion, String nombre, int numeroPuertas) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.numeroPuertas = numeroPuertas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    @Override
    public String toString(){
        return String.format("%s,%s,%d puertas",descripcion,nombre,numeroPuertas);
    }
}
