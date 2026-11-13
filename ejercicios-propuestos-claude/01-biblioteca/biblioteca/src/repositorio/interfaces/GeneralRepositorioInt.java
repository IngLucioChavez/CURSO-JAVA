package repositorio.interfaces;

public interface GeneralRepositorioInt<T>
        extends CrudRepositorioInt<T>, OrdenableRepositorioInt<T>, PaginableRepositorioInt<T>, ContableRepositorioInt{
}
