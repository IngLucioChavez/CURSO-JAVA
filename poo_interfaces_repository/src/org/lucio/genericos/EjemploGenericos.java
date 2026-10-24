package org.lucio.genericos;

import org.lucio.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {

    static void main() {

        // se puede definir una lista sin especificar el tipo genérico con el que operará
        //List clientes = new ArrayList();

        List<Cliente> clientes = new ArrayList();
        clientes.add(new Cliente("Chávez","Lucio"));

        // esta forma no marca error de sintaxis pero si marcará error en tiempo de ejecución
        // String lucio = (String) clientes.iterator().next();

        // al no definir el tipo generico con el que opera la lista se debe hacer un cast
        // Cliente lucio = (Cliente) clientes.iterator().next();

        // al especificar el tipo con el que operará la lista no es necesario hacer el cast
        Cliente lucio = clientes.iterator().next();

        Cliente[] clientesArreglo = {
                new Cliente("Chávez","Carlos"),
                new Cliente("Silva","Juan")
        };
        Integer[] numeros = {1,2,3,4};

        // definiendo el metodo de forma genérica se puede reutilizar para varios tipos de objetos
        // no solo especificamente para Cliente
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

    }
    // al definir el metodo de está forma solo se convertirá un arreglo de objetos Cliente
    // a lista pero puede existir la necesidad que se reciba el arreglo de otro tipo de objetos
    // y se convierta también a una lista - para ello se ocupan los genéricos - para hacer que los métodos
    // sean más reutilizables
    // NOTA! un metodo genérico debe indicar primero el tipo(s) genérico(s) con el que operará
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


}
