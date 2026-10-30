package org.lucio.poointerfaces.repositorio.lista;

import org.lucio.poointerfaces.modelo.Cliente;
import org.lucio.poointerfaces.repositorio.AbstractaListRepositorio;
import org.lucio.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio
        extends AbstractaListRepositorio<Cliente> {

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

    @Override
    public int comparar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo) {
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

}
