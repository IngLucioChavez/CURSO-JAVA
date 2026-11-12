package interfaces;

import modelo.Prestamo;

public interface Renovable {

    static final Integer diasPermitidos = 2;

    default void extenderDias(Prestamo prestamo){

    }

    static Integer getDiasPermitidos(){
        return Renovable.diasPermitidos;
    }

}
