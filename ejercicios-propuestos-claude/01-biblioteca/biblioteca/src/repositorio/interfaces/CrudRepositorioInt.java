package repositorio.interfaces;

import excepciones.RepositorioException;

import java.util.List;

public interface CrudRepositorioInt<T> {

    List<T> obtenerRegistros();
    T obtenerRegistroPorId(int idRegistro);
    void modificarRegistro(T obj) throws RepositorioException;
    boolean eliminarRegistro(int idRegistro) throws RepositorioException;
    void crearRegistro(T obj) throws RepositorioException;

}
