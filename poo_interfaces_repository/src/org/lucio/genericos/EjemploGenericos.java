package org.lucio.genericos;

import org.lucio.poointerfaces.modelo.Cliente;
import org.lucio.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {

    static void main() {

        List<Cliente> clientes = new ArrayList();
        clientes.add(new Cliente("Chávez","Lucio"));

        Cliente lucio = clientes.iterator().next();

        Cliente[] clientesArreglo = {
                new Cliente("Chávez","Carlos"),
                new Cliente("Silva","Juan")
        };
        Integer[] numeros = {1,2,3,4};

        List<Cliente> listaClientes = fromArrayToList(clientesArreglo);
        List<Integer> listaEnteros = fromArrayToList(numeros);

        System.out.println("------Impresión de lista de Clientes------------");
        listaClientes.forEach(System.out::println);
        System.out.println("------Impresión de lista de Enteros------------");
        listaEnteros.forEach(System.out::println);

        System.out.println("------Convirtiendo un arreglo de Strings e imprimiento un arreglo------------");
        List<String> nombres = fromArrayToList(
                new String[]{"uno","dos","tres"},
                numeros
        );

        List<ClientePremium> listaClientesPremium = fromArrayToList(new ClientePremium[]{
           new ClientePremium("a1","n1"),
           new ClientePremium("a2","n2"),
           new ClientePremium("a3","n3"),
        });

        imprimirClientes(clientes);
        imprimirClientes(listaClientes);
        imprimirClientes(listaClientesPremium);

        System.out.println("Máximo de 1,5,6: " + calculandoMayor(1,5,6));
        System.out.println("Máximo de 3.9,1.1,5.4: " + calculandoMayor(3.9f,1.1f,5.4f));
        System.out.println("Máximo de uno,dos,tres: " + calculandoMayor("uno","dos","tres"));

    }
    // para limitar un metodo genérico se define con extends
    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    // para limitar a objetos de tipo Cliente y su descendencia como ClientePremium
    // con el & se limita aún más, donde se quiere decir que además debe implementar la Interfaz Comparable
    public static <T extends Cliente> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    // metodo que implementa genéricos pero sin limitaciones
    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T,G> List<T> fromArrayToList(T[] c, G[] g){
        System.out.println("imprimiendo arreglo de tipo generico");
        for(G elemento: g){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }
    // con el comodín/wildcard se puede tratar en el metodo a cualquier tipo de cliente
    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T calculandoMayor(T a, T b, T c){
        T max = a;
        if( b.compareTo(max) > 0 ){
            max = b;
        }
        if( c.compareTo(max) > 0 ){
            max = c;
        }
        return max;
    }


}
