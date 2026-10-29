package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.BaseEntity;
import org.lucio.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity>
        implements OrdenablePaginableCrudRepositorio<T>{

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        dataSource = new ArrayList<>();
    }

    @Override
    public T porId(Integer id) {
        T c = null;
        for(T cli: dataSource){
            if( cli.getId() != null && cli.getId().equals(id) ){
                c = cli;
                break;
            }
        }
        return c;
    }

    @Override
    public void eliminar(Integer id) {
        T c = porId(id);
        dataSource.remove(c);
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
