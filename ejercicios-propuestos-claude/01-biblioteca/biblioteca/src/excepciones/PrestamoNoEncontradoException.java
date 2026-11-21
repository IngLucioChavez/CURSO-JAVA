package excepciones;

public class PrestamoNoEncontradoException extends BibliotecaException{
    public PrestamoNoEncontradoException(int idPrestamo) {
        super("ERROR - el préstamo con id [%s] no fue encontrado".formatted(idPrestamo));
    }
}
