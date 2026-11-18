package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.BaseEntity;
import org.lucio.poointerfaces.modelo.Cliente;
import org.lucio.poointerfaces.repositorio.excepciones.EscrituraDatoException;
import org.lucio.poointerfaces.repositorio.excepciones.LecturaDatoException;
import org.lucio.poointerfaces.repositorio.excepciones.RegistroDuplicadoException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity>
        implements OrdenablePaginableCrudRepositorio<T>{

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        dataSource = new ArrayList<>();
    }

    @Override
    public T porId(Integer id) throws LecturaDatoException {

        if( id == null || id <= 0 )
            throw new LecturaDatoException("id inválido debe ser mayor a 0");

        T c = null;
        for(T cli: dataSource){
            if( cli.getId() != null && cli.getId().equals(id) ){
                c = cli;
                break;
            }
        }

        if( c == null )
            throw new LecturaDatoException("No existe registro con id %s".formatted(id));

        return c;
    }

    @Override
    public void eliminar(Integer id) throws LecturaDatoException{
        T c = porId(id);
        dataSource.remove(c);
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public void crear(T t) throws EscrituraDatoException{

        if( t == null )
            throw new EscrituraDatoException("objeto nulo imposible crear");
        // validación para no permitir registros duplicados
        if( dataSource.contains(t) )
            throw new RegistroDuplicadoException("el objeto con id %s ya existe".formatted(t.getId()));

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
