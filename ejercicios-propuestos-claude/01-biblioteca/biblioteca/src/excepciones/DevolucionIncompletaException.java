package excepciones;

import modelo.Prestamo;

public class DevolucionIncompletaException extends BibliotecaException{
    public DevolucionIncompletaException(Prestamo prestamo) {
        super("ERROR - la devolución para el préstamo con id [%s] no procede por faltantes de materiales".formatted(prestamo.getId()));
    }
}
