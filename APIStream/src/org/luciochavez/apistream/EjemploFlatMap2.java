package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Factura;
import org.luciochavez.apistream.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploFlatMap2 {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("AAA","AAA");
        Usuario u2 = new Usuario("BBB","BBB");

        u1.addFactura(new Factura("fac1",u1));
        u1.addFactura(new Factura("fac2",u1));

        u2.addFactura(new Factura("fac3",u2));
        u2.addFactura(new Factura("fac4",u2));

        List<Usuario> usuarios = Arrays.asList(u1,u2);
        //- unión de dos lista en una sola
        List<Factura> facturas = new ArrayList<>();
        facturas.addAll(u1.getFacturas());
        facturas.addAll(u2.getFacturas());

        //- obteniendo facturas a partir de usuarios
        //-- relación 1 -> N: cada Usuario tiene una lista de Facturas
        //-- flatMap convierte la lista de cada usuario en un Stream<Factura> y los une en uno solo
        Stream<Factura> flujoFacturas = usuarios.stream()
                .flatMap(u-> u.getFacturas().stream());

        flujoFacturas.forEach(System.out::println);

        //- obteniendo usuarios a partir de facturas
        //-- relación 1 -> 1: cada Factura tiene un solo Usuario
        // NOTESE! Aquí flatMap(f -> Stream.of(...)) no es necesario; equivale a map(Factura::getUsuario)
        //-- la regla: un elemento produce un resultado -> map; produce 0..N resultados -> flatMap
        Stream<Usuario> flujoUsuarios = facturas.stream()
                .map(Factura::getUsuario)
                //.flatMap(f -> Stream.of(f.getUsuario()))
                .distinct();
        // NOTESE! distinct elimina el Usuario repetido (u1 aparece en fac1 y fac2, u2 en fac3 y fac4)
        //-- aquí funciona incluso por referencia, porque son los MISMOS objetos y no copias con igual contenido
        //-> Usuario{id='1'...AAA}
        //-> Usuario{id='2'...BBB}

        flujoUsuarios.forEach(System.out::println);

    }
}
