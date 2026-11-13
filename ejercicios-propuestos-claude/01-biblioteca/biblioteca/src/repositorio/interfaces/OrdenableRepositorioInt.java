package repositorio.interfaces;

import repositorio.enumeraciones.FormasDeOrden;

import java.util.List;

public interface OrdenableRepositorioInt<T> {

    List<T> obtenerRegistros(String campo, FormasDeOrden orden);
    int comparar(String campo, T obj0, T obj1);

}
