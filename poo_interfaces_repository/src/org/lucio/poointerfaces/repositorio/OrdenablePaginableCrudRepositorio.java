package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.BaseEntity;

public interface OrdenablePaginableCrudRepositorio<T extends BaseEntity>
        extends CrudRepositorio<T>, OrdenableRepositorio<T>, PaginableRepositorio<T>, ContableRepositorio{
}
