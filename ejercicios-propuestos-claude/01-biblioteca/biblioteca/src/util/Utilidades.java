package util;

import modelo.materiales.Material;

import java.util.List;

public class Utilidades {
    /**
     * Devuelve el menor de tres elementos según su orden natural (compareTo).
     * Con Material, el menor es el de año más antiguo.
     *
     * <p>La firma usa {@code Comparable<? super T>} y no {@code Comparable<T>}:
     * {@code Libro} no es {@code Comparable<Libro>}, sino {@code Comparable<Material>}
     * (hereda el compareTo de su padre). Con {@code ? super T} basta con que
     * T sea comparable con alguno de sus ancestros, y así se pueden comparar
     * tres Libro sin hacer cast.</p>
     *
     * @param a primer elemento
     * @param b segundo elemento
     * @param c tercer elemento
     * @param <T> tipo de los elementos, comparable con él mismo o con un ancestro
     * @return el menor de los tres; si hay empate, el primero que se encontró
     */
    public static <T extends Comparable<? super T>> T masAntiguo(T a, T b, T c){

        T menor = a;
        if( b.compareTo(menor) < 0 ) menor = b;
        if( c.compareTo(menor) < 0 ) menor = c;
        return menor;

    }

    /**
     * Imprime cada elemento de la lista. Acepta List&lt;Material&gt; o una lista de
     * cualquier subclase (List&lt;Libro&gt;, List&lt;Revista&gt;...).
     *
     * <p>Con {@code ? extends Material} solo se puede leer de la lista; no se puede
     * agregar nada, porque no se sabe de qué subtipo concreto es.</p>
     *
     * @param lista elementos a imprimir
     */
    public static void imprimirTodo(List<? extends Material> lista){

        for(Material m:lista){
            System.out.println(m);
        }

    }

}
