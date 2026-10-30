package org.lucio.poointerfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {

    List<T> listar();
    T porId(Integer id);
    void crear(T o);
    void editar(T o);
    void eliminar(Integer id);

}
