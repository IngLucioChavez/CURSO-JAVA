package org.lchavez.optional.repositorios;

import org.lchavez.optional.models.Computador;
import org.lchavez.optional.models.Fabricante;
import org.lchavez.optional.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements ComputadorRepositorioInterfaz{

    private final List<Computador> computadores;

    public ComputadorRepositorio() {
        this.computadores = new ArrayList<>();
        computadores.add(new Computador("MMAA","AAAA",new Procesador("A1A",new Fabricante("CORPA"))));
        computadores.add(new Computador("MMBB","BBBB",new Procesador("B1B",new Fabricante("CORPB"))));
        computadores.add(new Computador("MMCC","CCCC",new Procesador("C1C",new Fabricante("CORPC"))));
        computadores.add(new Computador("MMDD","DDDD",new Procesador("D1D",new Fabricante("CORPD"))));
    }

    @Override
    public Optional<Computador> buscar(String nombre){

        return computadores.stream()
                .filter(c->c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .map(Computador::copia); //- copia para no exponer el objeto interno

    }

    private Optional<Computador> buscarOriginal(int id){

        return computadores.stream()
                .filter(c->c.getId() == id)
                .findFirst();

    }

    @Override
    public boolean cambiarProcesador(int idComputador, Procesador procesador){

        Optional<Computador> original = buscarOriginal(idComputador);

        original.ifPresent(c->c.setProcesador(procesador));

        return original.isPresent();

    }

}
