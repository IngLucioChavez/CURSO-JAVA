package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Producto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Tarea4Seccion {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(5,100));
        productos.add(new Producto(2,2.5));
        productos.add(new Producto(3,20));
        productos.add(new Producto(1,1000));
        productos.add(new Producto(30,75.23));

        // solución Lucio
        /*
        Supplier<Stream<Producto>> flujoProductos = productos::stream;

        double total = flujoProductos.get()
                .mapToDouble(p -> p.getCantidad() * p.getPrecio())
                .reduce(0D,Double::sum);

        System.out.println("total = " + total);

        flujoProductos.get().forEach(System.out::println);
         */

        /*  Mejoras
        * * El Supplier es innecesario aquí: una List ya crea un stream nuevo cada vez que llamas a productos.stream().
        *   El patrón Supplier<Stream<T>> vale la pena cuando solo tienes un stream que no puedes recrear.
        *   Aquí puedes llamar productos.stream() directamente en ambos lugares.
        * * reduce vs sum(): el enunciado no exige reduce. En un DoubleStream, .sum() es lo idiomático y además
        *   usa suma compensada, que acumula menos error de redondeo.
        * * Dónde vive el cálculo: el importe es una regla del producto. Es el principio de "decirle al objeto qué hacer"
        *   en lugar de sacarle sus datos (Tell, Don't Ask), y la regla se reutiliza y se prueba en un solo sitio.
        * * Dinero con double: valores como 75.23 no son exactos en binario, y con muchos productos el error puede acumularse.
        *   El enunciado exige double, así que está bien, pero para código real usa BigDecimal
        * * Formato de salida: System.out.printf(Locale.US, "total = %.2f%n", total) da 3821.90,
        *   con dos decimales y punto decimal fijo, sin importar la configuración regional.
         */

        BigDecimal total = productos.stream()
                .map(Producto::getImporte)
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        System.out.printf(Locale.ROOT,"total = %.5f\n", total);

        productos.stream().forEach(System.out::println);


    }
}
