package repositorio.interfaces;

import excepciones.RangoPaginacionException;

import java.util.List;

public interface PaginableRepositorioInt<T> {

    List<T> obtenerRegistros(int pagina, int numRegistros) throws RangoPaginacionException;

}
