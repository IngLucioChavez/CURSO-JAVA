package excepciones;

import modelo.materiales.Material;

public class MaterialNoDisponibleException extends BibliotecaException{
    public MaterialNoDisponibleException(Material material) {
        super("ERROR - el material [%s] con id [%s] no se encuentra disponible".formatted(material.getTitulo(),material.getId()));
    }
}
