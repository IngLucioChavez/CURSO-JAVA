package org.lchavez.optional.repositorios;

import org.lchavez.optional.models.Computador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{

    private final List<Computador> computadores;

    public ComputadorRepositorio() {
        this.computadores = new ArrayList<>();
        computadores.add(new Computador("MMAA","AAAA"));
        computadores.add(new Computador("MMBB","BBBB"));
        computadores.add(new Computador("MMCC","CCCC"));
        computadores.add(new Computador("MMDD","DDDD"));
    }

    @Override
    public Optional<Computador> buscar(String nombre){
        // NOTESE!
        //-- findFirst es una operación terminal de cortocircuito:
        //-- el stream deja de recorrer al hallar la primera coincidencia.
        //-- map solo se ejecuta si el Optional tiene valor.
        return computadores.stream()
                //- nombre.toUpperCase() falla con null y solo funciona si el nombre guardado está en mayúsculas.
                //- Con equalsIgnoreCase se resuelven ambos casos (con null regresa vacío).
                //.filter(c->c.getNombre().equals(nombre.toUpperCase()))
                .filter(c->c.getNombre().equalsIgnoreCase(nombre))
                .peek(System.out::println) //- Hashes distintos en la salida: confirman que peek imprime el original y main la copia.
                .findFirst()
                .map(c->c.copiaDe(c)) //- copia para no exponer el objeto interno
                .or(Optional::empty);

    }
}
