package repositorio.interfaces;

import excepciones.MaterialNoEncontradoException;
import excepciones.PrestamoNoEncontradoException;
import excepciones.RepositorioException;
import excepciones.SocioNoEncontradoException;

import java.util.List;

public interface CrudRepositorioInt<T> {

    List<T> obtenerRegistros();
    T obtenerRegistroPorId(int idRegistro) throws RepositorioException;
    void modificarRegistro(T obj) throws RepositorioException, MaterialNoEncontradoException, PrestamoNoEncontradoException, SocioNoEncontradoException;
    boolean eliminarRegistro(int idRegistro) throws RepositorioException;
    void crearRegistro(T obj) throws RepositorioException;

}
