package org.luciochavez.apistream.models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Producto {

    private double precio;
    private int cantidad;
    private int id;
    private static int idAnterior;
    private static final NumberFormat formatoMoneda =
            NumberFormat.getCurrencyInstance(Locale.of("es","MX")); // Java 19+
    /*
    private static final NumberFormat formatoMoneda =
            NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-MX")); // Java 7+
     */

    public Producto(int cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
        id = ++idAnterior;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getImporte(){
        return BigDecimal.valueOf(precio).multiply(BigDecimal.valueOf(cantidad));
    }

    public String getImporteFormateado(){
        return formatoMoneda.format(getImporte());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", importe=" + getImporteFormateado() +
                '}';
    }
}
