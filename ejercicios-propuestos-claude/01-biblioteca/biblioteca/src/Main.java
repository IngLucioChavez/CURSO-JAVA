import modelo.Prestamo;
import modelo.materiales.Genero;
import modelo.materiales.Libro;
import modelo.personas.Socio;

import java.util.List;

public class Main{

    void main(String[] args) {

        Socio socio1 = new Socio("1111","Lucio","Chavez","García");
        Libro li1 = new Libro("Java", 2020, Genero.PROGRAMACION, 500);
        Libro li2 = new Libro("Dune", 1965, Genero.FANTASIA, 600);
        Libro li3 = new Libro("It", 1986, Genero.TERROR, 900);
        Libro li4 = new Libro("Cosmos", 1980, Genero.COSMOLOGIA, 400);

        Prestamo p1 = new Prestamo(socio1,7L);
        p1.addMaterial(li1);
        p1.addMaterial(li2);
        System.out.println(socio1.getPrestamosRegistrados());

        System.out.println(li2.extenderDias(p1)); // true
        System.out.println(li3.extenderDias(p1)); // false li3 no existe en p1
        System.out.println(p1.devolver(List.of(li1,li2))); //true
        System.out.println(p1.devolver(List.of(li2,li1))); //false ya devuelto
        System.out.println(socio1.getPrestamosRegistrados()); // 0
        System.out.println(p1.estaVencido()); // false

        Prestamo p2 = new Prestamo(socio1,5L);
        p2.addMaterial(li1);
        p2.addMaterial(li3);
        System.out.println(p2.addMaterial(li2)); // true
        System.out.println(p2.addMaterial(li4)); // false limite 3
        System.out.println(li1.prestar(socio1,1L)); // null límite 3

        System.out.println(p2.extender(50L));     // false (excede MAX_DIAS_EXTENSION)
        System.out.println(p2.addMaterial(li1));  // false (ya está en p2)
        // new Prestamo(socio1, 1000L);           // debe lanzar IllegalArgumentException

    }

}

