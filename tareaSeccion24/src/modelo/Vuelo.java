package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Vuelo implements Comparable<Vuelo>{

    private String claveVuelo;
    private Ciudad origen;
    private Ciudad destino;
    private LocalDate fechaLlegada;
    private LocalTime horaLllegada;
    private Integer numeroPasajeros;
    private Date fechaCompleta;

    public Vuelo(String claveVuelo, Ciudad destino, LocalDate fechaLlegada, LocalTime horaLllegada, Integer numeroPasajeros, Ciudad origen) {
        this.claveVuelo = claveVuelo;
        this.destino = destino;
        this.fechaLlegada = fechaLlegada;
        this.horaLllegada = horaLllegada;
        this.numeroPasajeros = numeroPasajeros;
        this.origen = origen;
        //- esta implementación es obsoleta:
        //- Este constructor de Date está obsoleto y funciona distinto de lo que esperas.
        //- El año se cuenta desde 1900 y el mes empieza en 0. Con eso, 2021-08-31 queda como septiembre (se desborda a octubre) del año 3921.
        /*this.fechaCompleta = new Date(fechaLlegada.getYear(),fechaLlegada.getMonthValue(),fechaLlegada.getDayOfMonth(),
                horaLllegada.getHour(),horaLllegada.getMinute(),horaLllegada.getSecond());*/
        this.fechaCompleta = Date.from(LocalDateTime.of(fechaLlegada,horaLllegada).atZone(ZoneId.systemDefault()).toInstant());
    }

    public String getClaveVuelo() {
        return claveVuelo;
    }

    public void setClaveVuelo(String claveVuelo) {
        this.claveVuelo = claveVuelo;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public LocalTime getHoraLllegada() {
        return horaLllegada;
    }

    public void setHoraLllegada(LocalTime horaLllegada) {
        this.horaLllegada = horaLllegada;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(Integer numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }



    @Override
    public boolean equals(Object object) {
        if( this == object ) return true;
        if (!(object instanceof Vuelo vuelo)) return false;
        return Objects.equals(claveVuelo, vuelo.claveVuelo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(claveVuelo);
    }

    @Override
    public int compareTo(Vuelo o) {
        return fechaCompleta.compareTo(o.fechaCompleta);
    }

    @Override
    public String toString() {
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("+++ Vuelo [ %s ] +++\n".formatted(claveVuelo))
                .append("fecha llegada Completa: %s\n".formatted(formatoFecha.format(fechaCompleta)))
                .append("fecha llegada: %s\n".formatted(fechaLlegada))
                .append("hora llegada: %s\n".formatted(horaLllegada))
                .append("origen: %s\n".formatted(origen.getNombre()))
                .append("destino: %s\n".formatted(destino.getNombre()))
                .append("numero pasajeros: %s\n".formatted(numeroPasajeros))
                .append("++++++++++++++++++++++++++++\n");

        return sb.toString();
    }
}
