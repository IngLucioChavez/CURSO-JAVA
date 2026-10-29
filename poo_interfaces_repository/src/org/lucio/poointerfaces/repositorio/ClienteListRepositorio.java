package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio
        extends AbstractaListRepositorio<Cliente>{

    @Override
    public Cliente porId(Integer id) {
        Cliente c = null;
        for(Cliente cli: dataSource){
            if( cli.getId() != null && cli.getId().equals(id) ){
                c = cli;
                break;
            }
        }
        return c;
    }

    @Override
    public void eliminar(Integer id) {
        Cliente c = this.porId(id);
        dataSource.remove(c);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);


        // FORMA DE LAMBDA
        listaOrdenada.sort((a, b) -> {
                int resultado = 0;
                if (dir.getDireccion().equals(Direccion.ASC.getDireccion())) {
                    resultado = comparar(campo,a,b);
                } else if (dir.getDireccion().equals(Direccion.DESC.getDireccion())) {
                    resultado = comparar(campo,b,a);
                }
                return resultado;
        });

        return listaOrdenada;
    }

}
