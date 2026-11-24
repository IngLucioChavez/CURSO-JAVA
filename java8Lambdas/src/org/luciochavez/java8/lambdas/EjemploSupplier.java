package org.luciochavez.java8.lambdas;

import org.luciochavez.java8.lambdas.model.Usuario;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploSupplier {
    public static void main(String[] args) {

        //- un consumer recibe un param y retorna void
        Consumer<Usuario> mostrarNombreUsuario = (u) -> {
            System.out.println("nombre de usuario: " + u.getNombre());
        };

        //- un biconsumer recibe dos params y retorna void
        /*BiConsumer<Usuario,String> definirNombreUsuario = (u,n) -> {
            u.setNombre(n);
        };*/
        //- Referencia a método: el 1er param (Usuario) es el receptor y el 2do (String) es el argumento de setNombre
        BiConsumer<Usuario,String> definirNombreUsuario = Usuario::setNombre;

        //- un Supplier no recibe parámetros y devuelve un valor de tipo T mediante get()
        /*Supplier<Usuario> crearUsuario = () -> {
            return new Usuario();
        };*/
        //-- Es una referencia a constructor. El compilador elige el constructor cuyos parámetros
        //-- coinciden con la interfaz funcional. Con Supplier (sin parámetros) usa el constructor vacío.
        //-- Con otra interfaz usaría otro constructor
        //- simplificación - por omisión se manda a llamar al new
        Supplier<Usuario> crearUsuario = Usuario::new;

        //- aplicando implementaciones de lambdas
        Usuario usuario = crearUsuario.get();
        definirNombreUsuario.accept(usuario,"lucio chávez");
        mostrarNombreUsuario.accept(usuario);

    }
}
