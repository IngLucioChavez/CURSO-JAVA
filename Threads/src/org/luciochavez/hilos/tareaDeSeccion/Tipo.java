package org.luciochavez.hilos.tareaDeSeccion;

import java.util.function.Function;
import java.util.function.IntFunction;

public enum Tipo {
    LETRA_MAYUSCULA('A', 'Z', 500L, v -> String.valueOf((char) v)),
    LETRA_MINUSCULA('a', 'z', 600L, v -> String.valueOf((char) v)),
    NUMERO(0, 10, 700L, String::valueOf);

    private int desde;
    private int hasta;
    private Long tiempo;
    private IntFunction<String> formato;

    Tipo(int desde, int hasta, Long tiempo, IntFunction<String> formato) {
        this.desde = desde;
        this.formato = formato;
        this.hasta = hasta;
        this.tiempo = tiempo;
    }

    public int getDesde() {
        return desde;
    }

    public IntFunction<String> getFuncion() {
        return formato;
    }

    public int getHasta() {
        return hasta;
    }

    public Long getTiempo() {
        return tiempo;
    }

    public String formatear(int valor) { return formato.apply(valor); }

}
