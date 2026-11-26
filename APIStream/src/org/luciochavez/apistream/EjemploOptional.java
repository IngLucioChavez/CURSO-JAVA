package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.Arrays;
import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {

        String[] nombres = {"Lucio Chávez","Carlos Chávez","Juan Silva","Dudu Phudu","Bubu Pichocho"};

        //-- Optional<T>: contenedor que puede tener o no un valor. Se usa como tipo de retorno
        //-- para decir explícitamente "puede no haber resultado", en lugar de retornar null.

        Optional<Usuario> usu = Arrays.stream(nombres)
                .map(v-> {
                    String[] arr = v.split(" ",2);
                    return new Usuario(arr[1],arr[0]);
                })
                .filter(u-> u.getId() == 2)
                .findFirst(); //- operación terminal con cortocircuito: retorna Optional<Usuario>

        //- orElse(T): retorna el valor o el objeto por defecto
        // NOTESE! El argumento de orElse SIEMPRE se evalúa, haya valor o no
        //-- orElse(new Usuario("xx","xx")) crea el Usuario aunque no se use
        //- orElseGet(Supplier<T>): el Supplier se ejecuta solo si el Optional está vacío (lazy)
        System.out.println(usu.orElseGet(()->new Usuario("xx","xx")));

        //- isPresent(): retorna true si hay valor
        // NOTESE! get() lanza NoSuchElementException si el Optional está vacío
        //-- por eso solo se usa después de validar con isPresent()
        //-> println(usu)       muestra: Optional[Usuario{...}]  /  Optional.empty
        //-> println(usu.get()) muestra: Usuario{...}
        if( usu.isPresent() ){
            //System.out.println(usu); //- si se deja así se especifica la referencia a optional
            System.out.println(usu.get()); //- se obtiene el objeto buscado
        } else {
            System.out.println("ERROR - no existe el usuario buscado");
        }


    }
}
