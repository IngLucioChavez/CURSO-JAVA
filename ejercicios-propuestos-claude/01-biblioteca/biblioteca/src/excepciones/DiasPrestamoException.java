package excepciones;

import modelo.Prestamo;

public class DiasPrestamoException extends ArgumentoException{
    public DiasPrestamoException(Long diasPrestamo) {
        super("ERROR - días [%s] especificados para préstamo fuera de rango, máximo días permitido [%s]".formatted(diasPrestamo, Prestamo.MAX_DIAS_PRESTAMO));
    }
}
