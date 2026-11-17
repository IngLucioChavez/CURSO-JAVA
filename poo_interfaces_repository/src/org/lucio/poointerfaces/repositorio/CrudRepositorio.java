package org.lucio.poointerfaces.repositorio;

import org.lucio.poointerfaces.repositorio.excepciones.AccesoDatoExeption;
import org.lucio.poointerfaces.repositorio.excepciones.EscrituraDatoException;

import java.util.List;

public interface CrudRepositorio<T> {

    List<T> listar();
    T porId(Integer id) throws AccesoDatoExeption;
    void crear(T o) throws EscrituraDatoException;
    void editar(T o) throws  AccesoDatoExeption;
    void eliminar(Integer id) throws AccesoDatoExeption;

}
