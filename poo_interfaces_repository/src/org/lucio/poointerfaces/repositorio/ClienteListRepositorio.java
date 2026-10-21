package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio
        implements CrudRepositorio, OrdenableRepositorio, PaginableRepositorio{

    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente c = null;
        for(Cliente cli: dataSource){
            if( cli.getId().equals(id) ){
                c = cli;
                break;
            }
        }
        return c;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente c = this.porId(id);
        dataSource.remove(c);
    }

    @Override
    public List<Cliente> listar(String atributo, Direccion dir) {
        return List.of();
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return List.of();
    }
}
