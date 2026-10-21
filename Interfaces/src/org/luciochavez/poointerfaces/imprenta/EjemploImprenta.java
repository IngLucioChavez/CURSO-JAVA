package org.luciochavez.poointerfaces.imprenta;

import org.luciochavez.poointerfaces.imprenta.modelo.*;

public class EjemploImprenta {

    public static void main(String[] args) {

        Curriculum cv = new Curriculum(new Persona("Chávez","Lucio"),"ITICS","informe laboral...");
        cv.addExperiencia("PGR - Desarrollador FullStack")
                .addExperiencia("TouchesBegan - Desarrollador FullStack")
                .addExperiencia("Totalpat - Desarrollador FullStack")
                .addExperiencia("Totalpat - Gerente de Sistemas")
                .addExperiencia("Totalpat - Arquitecto de Software")
                .addExperiencia("Facil Group - Desarrollador FullStack");

        Informe info = new Informe(new Persona("Silva","Juan"),new Persona("Chávez","Carlos"),"Contendio Reporte");

        Libro libro = new Libro(new Persona("Deitel","Deitel"),Genero.PROGRAMACION,"Patrones de Diseño");
        libro.addPagina(new Pagina("contenido página 1"))
                .addPagina(new Pagina("contenido página 2"))
                .addPagina(new Pagina("contenido página 3"));

        Imprimible.imprimir(cv);
        Imprimible.imprimir(info);
        Imprimible.imprimir(libro);
        System.out.println(Imprimible.HOLA + "\n");

        // creando obj genérico a partir de una interfaz
        // obj de una clase anónima
        Imprimible ObjGenerico = new Imprimible() {
            @Override
            public String imprimir() {
                return "ejecutando método imprimir de un objeto genérico";
            }
        };
        Imprimible.imprimir(ObjGenerico);

    }

    //metodo que implementa la acción de imprimir de un objeto que implementa la interfaz de Imprimible
    //cualquier objeto que implementa la interfaz imprimible
    //ya que una interfaz define lo que una clase puede hacer
    /*public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }*/

}
