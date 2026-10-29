package org.lucio.poointerfaces.repositorio;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T>
        implements OrdenablePaginableCrudRepositorio<T>{

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }

    @Override
    public int total() {
        return dataSource.size();
    }
}
