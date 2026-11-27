package org.lchavez.optional;

import org.lchavez.optional.models.Computador;
import org.lchavez.optional.repositorios.ComputadorRepositorio;

import java.util.Optional;

public class EjemploRepositorioOptional {
    public static void main(String[] args){

        ComputadorRepositorio repo = new ComputadorRepositorio();

        Optional<Computador> search = repo.buscar("aaaa");

        System.out.println("búsqueda: " + search.map(Computador::toString).orElse("No existe"));

    }
}
