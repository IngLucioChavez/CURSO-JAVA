package org.lchavez.optional;

import org.lchavez.optional.models.Computador;
import org.lchavez.optional.repositorios.ComputadorRepositorio;

public class EjemploMetodosOrElse {
    public static void main(String[] args) {

        ComputadorRepositorio repo = new ComputadorRepositorio();

        // NOTESE!
        //-- orElse(valor): regresa el contenido del Optional o, si está vacío, el valor dado.
        //-- porDefecto() se ejecuta SIEMPRE, porque Java evalúa el argumento
        //-- antes de llamar a orElse, aunque después no se use.
        Computador pc = repo.buscar("AAAA").orElse(porDefecto());
        System.out.println(pc);
        System.out.println();
        // NOTESE!
        //-- orElseGet(Supplier): el Supplier solo se ejecuta si el Optional está vacío.
        pc = repo.buscar("AAAA").orElseGet(EjemploMetodosOrElse::porDefecto);
        System.out.println(pc);
        System.out.println();

        /*
         * ¿Cuál usar?
         *  - orElse: la alternativa ya existe o es muy barata (constante, literal).
         *  - orElseGet: hay que crearla, consultarla o produce efectos secundarios.
         */

    }

    public static Computador porDefecto(){
        System.out.println("por defecto!!");
        return new Computador("MMXX","porDefecto");
    }

}
