package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.BaseEntity;
import org.lucio.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T extends BaseEntity> {

    List<T> listar(String atributo, Direccion dir);

    default int comparar(String campo, T a, T b){
        return 0;
    }

}
