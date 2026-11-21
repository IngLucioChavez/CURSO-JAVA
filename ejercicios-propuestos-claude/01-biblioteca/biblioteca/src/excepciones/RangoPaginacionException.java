package excepciones;

public class RangoPaginacionException extends BibliotecaException{
    public RangoPaginacionException() {
        super("ERROR - el rango especificado en la paginación es inválido");
    }
}
