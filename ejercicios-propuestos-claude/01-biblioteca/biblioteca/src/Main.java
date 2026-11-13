import modelo.Prestamo;
import modelo.materiales.*;
import modelo.personas.Socio;
import modelo.personas.SocioPremium;
import repositorio.MaterialRepositorio;
import repositorio.SocioRepositorio;
import repositorio.enumeraciones.FormasDeOrden;
import repositorio.interfaces.GeneralRepositorioInt;

import java.util.List;

public class Main{

    void main(String[] args) {

        GeneralRepositorioInt<Material> repoMat = new MaterialRepositorio();
        Libro l = new Libro("Java", 2020, Genero.PROGRAMACION, 500);
        Revista r = new Revista("Muy Interesante", 2023, Genero.CIENCIA, 90);
        Dvd d = new Dvd("Cosmos", 1980, Genero.COSMOLOGIA, 12);
        repoMat.crearRegistro(l);
        repoMat.crearRegistro(r);
        repoMat.crearRegistro(d);

        l.setTitulo("Cambiado");                                          // alterar el objeto del Main
        System.out.println(repoMat.obtenerRegistroPorId(l.getId()).getTitulo());   // "Java": el repo no cambió

        Libro leido = (Libro) repoMat.obtenerRegistroPorId(l.getId());    // la copia conserva el tipo concreto
        leido.setPaginas(999);
        System.out.println(repoMat.modificarRegistro(leido));             // true
        System.out.println(((Libro) repoMat.obtenerRegistroPorId(l.getId())).getPaginas());   // 999

        Dvd intruso = new Dvd("X", 2000, Genero.TERROR, 5);
        intruso.setId(l.getId());                                         // mismo id, distinto tipo
        System.out.println(repoMat.modificarRegistro(intruso));           // false
        System.out.println(repoMat.obtenerRegistroPorId(l.getId()).getTitulo());   // "Java": no se alteró

        repoMat.obtenerRegistros("titulo", FormasDeOrden.ASC)
                .forEach(m -> System.out.println(m.getTitulo()));          // Cosmos, Java, Muy Interesante
        repoMat.obtenerRegistros("anio", FormasDeOrden.DESC)
                .forEach(m -> System.out.println(m.getAnio()));            // 2023, 2020, 1980

    }

}

