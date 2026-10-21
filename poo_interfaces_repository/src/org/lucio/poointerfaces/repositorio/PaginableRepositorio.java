package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {

    List<Cliente> listar(int desde, int hasta);

}
