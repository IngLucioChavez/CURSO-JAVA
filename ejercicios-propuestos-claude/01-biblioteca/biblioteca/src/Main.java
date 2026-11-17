import modelo.Prestamo;
import modelo.materiales.Genero;
import modelo.materiales.Libro;
import modelo.materiales.Material;
import modelo.personas.Persona;
import modelo.personas.Socio;
import repositorio.MaterialRepositorio;
import repositorio.PrestamoRepositorio;
import repositorio.SocioRepositorio;
import repositorio.interfaces.GeneralRepositorioInt;
import servicios.BibliotecaServicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{

    void main(String[] args) {

        Persona s1 = new Socio("0001","lucio","chavez","garcia");
        Material l1 = new Libro("libro1",2025,Genero.CIENCIA,100);
        Material l2 = new Libro("libro2",2025,Genero.CIENCIA,100);
        Material l3 = new Libro("libro3",2025,Genero.CIENCIA,100);
        Material l4 = new Libro("libro4",2025,Genero.CIENCIA,100);
        Material l5 = new Libro("libro5",2025,Genero.CIENCIA,100);

        GeneralRepositorioInt<Socio> socioRepo = new SocioRepositorio();
        GeneralRepositorioInt<Material> materialRepo = new MaterialRepositorio();
        GeneralRepositorioInt<Prestamo> prestamoRepo = new PrestamoRepositorio();

        socioRepo.crearRegistro((Socio)s1);
        materialRepo.crearRegistro(l1);
        materialRepo.crearRegistro(l2);
        materialRepo.crearRegistro(l3);
        materialRepo.crearRegistro(l4);
        materialRepo.crearRegistro(l5);

        BibliotecaServicio biblioteca = new BibliotecaServicio(socioRepo,prestamoRepo,materialRepo);

        Prestamo p1 = biblioteca.prestar(1, Arrays.asList(1,2),5L);
        Prestamo p2 = null;
        System.out.println(p1); //prestamo(1) creado
        System.out.println(biblioteca.prestar(1, Arrays.asList(3,4),5L)); //null
        System.out.println(biblioteca.prestar(1, List.of(1,2),5L)); //null
        p2 = biblioteca.prestar(1, List.of(3),5L);
        System.out.println(p2); //prestamo(2) creado

        System.out.println(biblioteca.devolver(1)); //true

        System.out.println(biblioteca.prestar(1,List.of(4,5),5L)); //prestamo(3) creado



    }

}

