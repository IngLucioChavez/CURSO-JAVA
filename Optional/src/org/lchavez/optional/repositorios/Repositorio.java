package org.lchavez.optional.repositorios;

import org.lchavez.optional.excepciones.NoExisteRegistroException;

import java.util.Optional;

/*
 * Repositorio: abstrae el acceso a los datos; quien lo usa no necesita
 * saber si vienen de una lista, un archivo o una base de datos.
 * Reglas:
 *  - Una búsqueda que puede no hallar nada regresa Optional, nunca null.
 *  - "No encontrado" se expresa con Optional.empty(), no con una excepción.
 *  - Quien llama decide si la ausencia es un error.
 */
public interface Repositorio<T> {

    Optional<T> buscar(String nombre) throws NoExisteRegistroException;

}
