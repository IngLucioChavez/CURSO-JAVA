package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {

    List<Cliente> listar(String atributo, Direccion dir);

}
