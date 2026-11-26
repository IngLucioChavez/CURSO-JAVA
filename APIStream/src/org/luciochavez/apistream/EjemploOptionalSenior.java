package org.luciochavez.apistream;

import org.luciochavez.apistream.models.Usuario;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class EjemploOptionalSenior {
    public static void main(String[] args) {

        String[] nombres = {"Lucio Chávez","Carlos Chávez","Juan Silva","Dudu Phudu","Bubu Pichocho"};
        int idBuscado = 2;

        Optional<Usuario> usu = Arrays.stream(nombres)
                .map(EjemploOptionalSenior::desdeNombreCompleto)
                .filter(u-> u.getId() == idBuscado)
                .findFirst();

        // NOTESE! ifPresentOrElse es un método de Optional, no de Usuario
        //-- Firma (Java 9+): ifPresentOrElse(Consumer<? super T> accionSiExiste, Runnable accionSiVacio)
        //-- Solo se ejecuta UNA de las dos acciones; el Runnable no recibe parámetros
        usu.ifPresentOrElse(
                System.out::println, //- acción en caso de presencia
                ()-> System.out.println("el usuario no existe") //- acción en caso de ausencia
        );
        //-> Usuario{apellidos='Chávez', nombres='Carlos'}

        //- Java 8: sin ifPresentOrElse
        //-- Optional.map(Function): si hay valor lo transforma y lo vuelve a envolver en un Optional;
        //-- si está vacío, no ejecuta la función y sigue vacío
        // NOTESE! orElse exige el mismo tipo que el Optional
        //-- por eso se hace map(Usuario::toString) antes: Optional<Usuario> -> Optional<String>
        //-- orElse(T) RETORNA el valor del Optional si existe, o el argumento si está vacío; no imprime
        System.out.println();
        System.out.println(
                usu.map(Usuario::toString)
                .orElse("no existe") //- orElse() es de un Optional<> - si es presente imprime valor de Optional
                                    //- sí no imprime el valor que se le pasa en el parámetro
        );
        //-> Usuario{apellidos='Chávez', nombres='Carlos'}

        // NOTESE! Un Optional se puede usar varias veces (a diferencia de un Stream)
        //-- aquí se consulta dos veces la misma variable sin IllegalStateException

    }

    public static Usuario desdeNombreCompleto(String nombre){
        String[] arr = nombre.split(" ",2);
        return new Usuario(arr[1],arr[0]);
    }

}
