package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio
        implements OrdenablePaginableCrudRepositorio{

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
            if( cli.getId() != null && cli.getId().equals(id) ){
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
    public List<Cliente> listar(String campo, Direccion dir) {
        // se realiza una nueva lista con los datos de la lista original
        // esto se hace para que no se modifique la lista original de registros
        // que el metodo sea inmutable y regrese una nueva lista con los datos/registros ordenados
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);

        // FORMA DE METODO ANONIMO
        // creación de clase ánonima temporal
        // se puede referencias a campo y dir por el scope del metodo
        /*listaOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {
                int resultado = 0;
                if (dir.getDireccion().equals(Direccion.ASC.getDireccion())) {
                    resultado = comparar(a,b);
                } else if (dir.getDireccion().equals(Direccion.DESC.getDireccion())) {
                    resultado = comparar(b,a);
                }
                return resultado;
            }

            // metodo privado ya que solo será ocupado en está implementación
            // ánonima y única
            private int comparar(Cliente a,Cliente b){
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
        });*/


        // FORMA DE LAMBDA
        listaOrdenada.sort((a, b) -> {
                int resultado = 0;
                if (dir.getDireccion().equals(Direccion.ASC.getDireccion())) {
                    // forma para utilizar con el metodo privado de la clase
                    //resultado = comparar(campo,a,b);
                    // forma para utilizar con el metodo definido de forma default en la interface
                    resultado = comparar(campo,a,b);
                } else if (dir.getDireccion().equals(Direccion.DESC.getDireccion())) {
                    // forma para utilizar con metodo privado de la clase
                    //resultado = comparar(campo,b,a);
                    // forma para utilizar con el metodo definido de forma default en la interface
                    resultado = comparar(campo,b,a);
                }
                return resultado;
        });

        return listaOrdenada;
    }

    // metodo privado para ocupar en la lambda del sort de la list
    // este metodo se mueve a la interfaz OrdenableRepositorio de forma estática
    /*private static int comparar(String campo, Cliente a,Cliente b){
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
    }*/

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }

    @Override
    public int total() {
        return dataSource.size();
    }
}
