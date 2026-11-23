package modelo.interfaces;

import excepciones.ArgumentoException;
import excepciones.PrestamoException;
import modelo.Prestamo;

public interface Renovable {

    Long DIAS_PERMITIDOS = Prestamo.MAX_DIAS_EXTENSION;

    default void extenderDias(Prestamo prestamo) throws PrestamoException, ArgumentoException {

        if( !prestamo.getMateriales().contains(this))
            throw new PrestamoException("ERROR - el material especificado no está dentro de la lista de materiales del préstamo");
        prestamo.extender(Renovable.getDiasPermitidos());

    }

    static Long getDiasPermitidos(){
        return Renovable.DIAS_PERMITIDOS;
    }

}
