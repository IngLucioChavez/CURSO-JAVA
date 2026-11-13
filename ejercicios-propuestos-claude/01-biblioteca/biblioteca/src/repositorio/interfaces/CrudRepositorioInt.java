package repositorio.interfaces;

import java.util.List;

public interface CrudRepositorioInt<T> {

    List<T> obtenerRegistros();
    T obtenerRegistroPorId(int idRegistro);
    boolean modificarRegistro(T obj);
    boolean eliminarRegistro(int idRegistro);
    boolean crearRegistro(T obj);

}
