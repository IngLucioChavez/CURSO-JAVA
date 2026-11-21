package excepciones;

import modelo.personas.Socio;

public class LimitePrestamosException extends BibliotecaException{
    public LimitePrestamosException(Socio socio) {
        super("ERROR - el socio [%s][%s] ha alcanzado su máximo de prestamos permitidos [%s]"
                .formatted(socio.getTipo(),socio.getNombreCompleto(),socio.getLimitePrestamos()));
    }
}
