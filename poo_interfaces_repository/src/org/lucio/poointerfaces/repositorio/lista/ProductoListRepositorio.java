package org.lucio.poointerfaces.repositorio.lista;

import org.lucio.poointerfaces.modelo.Cliente;
import org.lucio.poointerfaces.modelo.Producto;
import org.lucio.poointerfaces.repositorio.AbstractaListRepositorio;
import org.lucio.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) {
        Producto p = this.porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
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
    public int comparar(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "precio" ->
                    resultado = a.getPrecio().compareTo(b.getPrecio());
            case "descripcion" ->
                    resultado = a.getDescripcion().compareTo(b.getDescripcion());
        }
        return resultado;
    }
}
