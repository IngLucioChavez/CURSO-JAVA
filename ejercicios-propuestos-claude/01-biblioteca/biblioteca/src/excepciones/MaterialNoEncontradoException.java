package excepciones;

public class MaterialNoEncontradoException extends BibliotecaException{
    public MaterialNoEncontradoException(int idMaterial) {
        super("ERROR - el material con id [%s] no fue encontrado".formatted(idMaterial));
    }
}
