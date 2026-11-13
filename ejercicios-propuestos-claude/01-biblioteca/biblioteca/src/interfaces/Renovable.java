package interfaces;

import modelo.Prestamo;

public interface Renovable {

    Long DIAS_PERMITIDOS = Prestamo.MAX_DIAS_EXTENSION;

    default boolean extenderDias(Prestamo prestamo){

        if( !prestamo.getMateriales().contains(this))
            return false;
        return prestamo.extender(Renovable.getDiasPermitidos());

    }

    static Long getDiasPermitidos(){
        return Renovable.DIAS_PERMITIDOS;
    }

}
