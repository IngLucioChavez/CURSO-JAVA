package org.lchavez.optional;

import org.lchavez.optional.excepciones.NoExisteRegistroException;
import org.lchavez.optional.models.Computador;
import org.lchavez.optional.repositorios.ComputadorRepositorio;
import org.lchavez.optional.repositorios.Repositorio;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class EjemploElseThrow {
    public static void main(String[] args) throws NoExisteRegistroException {

        Repositorio<Computador> repo = new ComputadorRepositorio();

        String buscado = "AAAA";
        Optional<Computador> compu = repo.buscar(buscado);
        //- get() solo se debe usar después de comprobar que hay un valor,
        //- ya que lanza NoSuchElementException si el Optional está vacío.
        //- orElseThrow(supplier) permite elegir la excepción que se lanza.
        //System.out.println(compu.get());
        try {
            System.out.println(compu.orElseThrow(() -> new NoExisteRegistroException(buscado)));
        } catch( NoExisteRegistroException e ){
            System.out.println(e.getMessage());
        }

        //- obtiene la extensión de un nombre de archivo
        //- si filter deja el Optional vacío, map no se ejecuta
        //- orElseThrow() sin argumentos (Java 10+) lanza NoSuchElementException
        // NOTESE!
        //-- lastIndexOf busca el último punto; el filtro descarta
        //-- nombres que terminan en punto, como "hola."
        //- extensiones permitidas, en mayúsculas
        Set<String> extensionesValidas =
                new HashSet<>(Arrays.asList("PDF", "XLSX", "DOC", "DOCX","XML"));
        String nombreArchivo = "hola_lucio.xml";
        String extension = Optional.of(nombreArchivo)
                .filter(cad->cad.contains("."))
                .map(cad->cad.substring(cad.lastIndexOf(".")+1).toUpperCase())
                .filter(extensionesValidas::contains)
                .orElseThrow(()->new IllegalArgumentException("extensión inválida " + nombreArchivo));

        System.out.println(extension);

    }
}
