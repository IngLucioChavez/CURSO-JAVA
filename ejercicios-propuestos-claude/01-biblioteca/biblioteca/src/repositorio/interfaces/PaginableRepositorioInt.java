package repositorio.interfaces;

import java.util.List;

public interface PaginableRepositorioInt<T> {

    List<T> obtenerRegistros(int pagina, int numRegistros);

}
