package excepciones;

public class SocioNoEncontradoException extends BibliotecaException {
    public SocioNoEncontradoException(int idSocio) {
        super("ERROR - el socio con id [%s] no fue encontrado".formatted(idSocio));
    }
}
