import modelo.materiales.*;
import util.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class Main{

    void main(String[] args) {

        /*
        Socio s1 = new Socio("0001","lucio","chavez","garcia");
        Socio s2 = new Socio("0002","AAAA","AAAA","AAAA");
        Material l1 = new Libro("libro1",2025,Genero.CIENCIA,100);
        Material l2 = new Libro("libro2",2025,Genero.CIENCIA,100);
        Material l3 = new Libro("libro3",2025,Genero.CIENCIA,100);
        Material l4 = new Libro("libro4",2025,Genero.CIENCIA,100);
        Material l5 = new Libro("libro5",2025,Genero.CIENCIA,100);

        GeneralRepositorioInt<Socio> socioRepo = new SocioRepositorio();
        GeneralRepositorioInt<Material> materialRepo = new MaterialRepositorio();
        GeneralRepositorioInt<Prestamo> prestamoRepo = new PrestamoRepositorio();

        socioRepo.crearRegistro(s1);
        socioRepo.crearRegistro(s2);
        materialRepo.crearRegistro(l1);
        materialRepo.crearRegistro(l2);
        materialRepo.crearRegistro(l3);
        materialRepo.crearRegistro(l4);
        materialRepo.crearRegistro(l5);

        BibliotecaServicio biblioteca = new BibliotecaServicio(socioRepo,prestamoRepo,materialRepo);

        Prestamo p1 = biblioteca.prestar(1, Arrays.asList(1,2),5L);
        System.out.println(p1); //prestamo(1) creado
        Prestamo p2 = null;
        System.out.println(biblioteca.prestar(2,List.of(1),5L)); //null
        System.out.println(biblioteca.prestar(1, Arrays.asList(3,4),5L)); //null
        System.out.println(biblioteca.prestar(1, List.of(1,2),5L)); //null
        p2 = biblioteca.prestar(1, List.of(3),5L);
        System.out.println(p2); //prestamo(2) creado

        System.out.println(biblioteca.devolver(1)); //true

        System.out.println(biblioteca.prestar(1,List.of(4,5),5L)); //prestamo(3) creado

        materialRepo.crearRegistro(new Dvd("Cosmos", 1980, Genero.COSMOLOGIA, 12));
        System.out.println(biblioteca.prestar(1, List.of(6), 5L));   // null
         */

        Libro a = new Libro("A", 2020, Genero.CIENCIA, 10);
        Libro b = new Libro("B", 1990, Genero.CIENCIA, 10);
        Libro c = new Libro("C", 2005, Genero.CIENCIA, 10);

        Libro viejo = Utilidades.masAntiguo(a, b, c);          // B (1990)
        System.out.println(viejo.getTitulo());

        Material mixto = Utilidades.masAntiguo(a, new Revista("R", 1980, Genero.CIENCIA, 5), new Dvd("D", 2001, Genero.CIENCIA, 3));
        System.out.println(mixto.getTitulo());                 // R (1980)

        Utilidades.imprimirTodo(List.of(a, b, c));             // una List<Libro>
        List<Material> materiales = new ArrayList<>(List.of(a, b));
        Utilidades.imprimirTodo(materiales);                   // una List<Material>

    }

}

