import excepciones.*;
import modelo.materiales.*;
import modelo.personas.Socio;
import repositorio.MaterialRepositorio;
import repositorio.PrestamoRepositorio;
import repositorio.SocioRepositorio;
import servicios.BibliotecaServicio;
import util.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class Main{

    //-- Una interfaz funcional es una interfaz con exactamente un método abstracto.
    //-- Por eso se le puede asignar una lambda (() -> ...): la lambda es la implementación de ese único método.
    //-- Qué hace la anotación @FunctionalInterface
    //-- Es opcional: cualquier interfaz con un solo método abstracto ya funciona con lambdas.
    //-- La anotación solo le pide al compilador que verifique que cumple la regla.
    //-- Si luego alguien agrega un segundo método abstracto, el compilador marca error en lugar de dejar que se
    //-- rompan en silencio las lambdas que la usan.
    @FunctionalInterface
    interface Prueba { void ejecutar() throws BibliotecaException; }

    void main(String[] args) {

        var socios = new SocioRepositorio();
        var materiales = new MaterialRepositorio();
        var prestamos = new PrestamoRepositorio();

        try {
            socios.crearRegistro(new Socio("0001", "lucio", "chavez", "garcia")); // id = 1
            socios.crearRegistro(new Socio("0002", "ana", "perez", "lopez")); // id = 2
            for (int i = 1; i <= 5; i++)
                materiales.crearRegistro(new Libro("libro" + i, 2025, Genero.CIENCIA, 100)); // id = 1 a 5
            materiales.crearRegistro(new Dvd("Cosmos", 1980, Genero.COSMOLOGIA, 12));   // id 6, no prestable
        } catch (RepositorioException e) {
            System.out.println(e.getMessage());
        }

        var biblioteca = new BibliotecaServicio(socios, prestamos, materiales);

        probar("prestar 1,2 al socio 1",            null,                              () -> biblioteca.prestar(1, List.of(1, 2), 5L));
        probar("socio inexistente",                 SocioNoEncontradoException.class,  () -> biblioteca.prestar(99, List.of(1), 5L));
        probar("material inexistente",              MaterialNoEncontradoException.class, () -> biblioteca.prestar(1, List.of(99), 5L));
        probar("material ya prestado",              MaterialNoDisponibleException.class, () -> biblioteca.prestar(2, List.of(1), 5L));
        probar("DVD no prestable",                  MaterialNoDisponibleException.class, () -> biblioteca.prestar(2, List.of(6), 5L));
        probar("excede el límite (2 + 2 > 3)",      LimitePrestamosException.class,    () -> biblioteca.prestar(1, List.of(3, 4), 5L));
        probar("lista vacía",                       ArgumentoException.class,          () -> biblioteca.prestar(1, List.of(), 5L));
        probar("ids repetidos",                     ArgumentoException.class,          () -> biblioteca.prestar(1, List.of(3, 3), 5L));
        probar("días fuera de rango",               DiasPrestamoException.class,       () -> biblioteca.prestar(2, List.of(3), 50L));
        probar("renovar material del préstamo",     null,                              () -> biblioteca.renovar(1, 1));
        probar("renovar material que no está",      MaterialNoEncontradoException.class, () -> biblioteca.renovar(1, 5));
        probar("devolver préstamo inexistente",     PrestamoNoEncontradoException.class, () -> biblioteca.devolver(99));
        probar("devolver préstamo 1",               null,                              () -> biblioteca.devolver(1));
        probar("devolver préstamo 1 otra vez",      PrestamoException.class,           () -> biblioteca.devolver(1));
        probar("volver a prestar 1,2 tras devolver", null,                             () -> biblioteca.prestar(1, List.of(1, 2), 5L));

    }

    //- este método implementa una prueba que debe lanzar una excepción y reporta si es la excepción esperada o no
    private void probar(String nombre, Class<? extends BibliotecaException> esperada, Prueba prueba) {
        Class<?> obtenida = null;
        try {
            prueba.ejecutar();
        } catch (BibliotecaException e) {
            obtenida = e.getClass();
        } finally {
            String marca = (obtenida == esperada) ? "✔" : "✘";
            System.out.printf("%s %-45s esperada=%s obtenida=%s%n", marca, nombre,
                    esperada == null ? "ninguna" : esperada.getSimpleName(),
                    obtenida == null ? "ninguna" : obtenida.getSimpleName());
        }
    }

}

