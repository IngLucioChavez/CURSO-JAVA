package org.lucioChavez.appFacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] itemsFactura;
    private int indiceItems;

    public static final int MAXIMO_ITEMS = 10;
    private static int indiceUltimoFolio;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.itemsFactura = new ItemFactura[MAXIMO_ITEMS]; //definiendo longitud de items
        this.folio = ++indiceUltimoFolio; //generando folio automático
        this.fecha = new Date(); //asignando fecha actual
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFolio() {
        return folio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItemsFactura() {
        return itemsFactura;
    }

    public void addItemFactura(ItemFactura item){
        if( indiceItems < MAXIMO_ITEMS )
            itemsFactura[indiceItems++] = item;
    }

    public double calcularTotal(){
        double total = 0d;
        for(ItemFactura item: itemsFactura){
            // validación ya que una factura puede tener menos de 10 items
            // los demás elementos en el arreglo serán NULL
            if(item == null)
                continue;
            total += item.getCalculoImporte();
        }
        return total;
    }

    public String generarDetalle(){

        StringBuilder detalle = new StringBuilder();
        detalle.append("Factura No. ").append(folio)
                .append("\nCliente: ").append(cliente.getNombre())
                .append("RFC: ").append(cliente.getRfc())
                .append("\nDescripción: ").append(descripcion);

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        detalle.append("\n\tFecha: ").append(formatoFecha.format(fecha))
                .append("\n\n#\tNombre\t$\tCantidad\tTotal")
                .append("\n");

        for(ItemFactura item: itemsFactura){
            if( item == null )
                continue;
            detalle.append(item).append("\t")
                    .append("\n");
        }

        detalle.append("\nGran Total: ").append(String.format("%.2f",calcularTotal()));

        return detalle.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
