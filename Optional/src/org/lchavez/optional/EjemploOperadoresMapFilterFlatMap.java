package org.lchavez.optional;

import org.lchavez.optional.excepciones.NoExisteRegistroException;
import org.lchavez.optional.models.Computador;
import org.lchavez.optional.models.Fabricante;
import org.lchavez.optional.models.Procesador;
import org.lchavez.optional.repositorios.ComputadorRepositorio;
import org.lchavez.optional.repositorios.ComputadorRepositorioInterfaz;

import java.util.NoSuchElementException;

public class EjemploOperadoresMapFilterFlatMap {
    public static void main(String[] args) {

        ComputadorRepositorioInterfaz repo = new ComputadorRepositorio();

        /*
         * Optional<T> es un contenedor de CERO o UN valor. Algunos métodos se llaman
         * como los de Stream (map, flatMap, filter), pero no procesa una secuencia:
         *  - se evalúa de inmediato: no espera una operación terminal;
         *  - se puede consultar varias veces (un Stream solo se consume una vez);
         *  - si está vacío, map, flatMap y filter no ejecutan la función.
         */

        //-- map: transforma el valor; si la función regresa null, queda vacío
        //-- flatMap: se usa si la función YA regresa un Optional;
        //--          evita obtener Optional<Optional<T>>
        //-- filter: conserva el valor si cumple la condición; si no, queda vacío

        // NOTESE!
        //-- en buscar(), el filter anterior a findFirst es de Stream;
        //-- el map posterior ya es de Optional

        //-- map con getProcesador y flatMap con getProcesadorOptional
        //-- llegan al mismo resultado
        try {
            Fabricante fabricante = repo.buscar("AAAA")
                    .map(Computador::getProcesador)
                    .map(Procesador::getFabricante)
                    .filter(f-> f.getNombre().equalsIgnoreCase("CORPA"))
                    .orElseThrow(); // Java 10+

            System.out.println(fabricante.getNombre());

            fabricante = repo.buscar("XXXX")
                    .flatMap(Computador::getProcesadorOptional)
                    .flatMap(Procesador::getFabricanteOptional)
                    .filter(f -> f.getNombre().equalsIgnoreCase("CORPA"))
                    .orElseThrow(); // Java 10+
            System.out.println(fabricante.getNombre());

        } catch( NoSuchElementException e){
            System.out.println("ERROR - no existe el valor buscado");
        }

        try {
            Computador antes = repo.buscar("AAAA")
                    .orElseThrow(()->new NoExisteRegistroException("AAAA"));

            boolean cambio = repo.cambiarProcesador(
                    antes.getId(),
                    new Procesador("AZA",new Fabricante("AZAF")));

            System.out.println(cambio ? "Exito - cambio exitoso": "ERROR - cambio erróneo");
            System.out.println("antes: " + antes);

            repo.buscar("AAAA").ifPresent(c-> System.out.println("después: " + c));

        } catch( NoExisteRegistroException e ){
            System.out.println(e.getMessage());
        }

    }
}
