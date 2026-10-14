package org.luciochavez.poointerfaces.imprenta;

import org.luciochavez.poointerfaces.imprenta.modelo.*;

public class EjemploImprenta {

    public static void main(String[] args) {

        Curriculum cv = new Curriculum("Lucio Chavez","ITICS","informe laboral...");
        cv.addExperiencia("PGR - Desarrollador FullStack")
                .addExperiencia("TouchesBegan - Desarrollador FullStack")
                .addExperiencia("Totalpat - Desarrollador FullStack")
                .addExperiencia("Totalpat - Gerente de Sistemas")
                .addExperiencia("Totalpat - Arquitecto de Software")
                .addExperiencia("Facil Group - Desarrollador FullStack");

        Informe info = new Informe("Juan Silva","Carlos Alam","Contendio Reporte");

        Libro libro = new Libro("Deitel",Genero.FANTASIA,"Patrones de Diseño");
        libro.addPagina(new Pagina("contenido página 1"))
                .addPagina(new Pagina("contenido página 2"))
                .addPagina(new Pagina("contenido página 3"));

        imprimir(cv);
        imprimir(info);
        imprimir(libro);

    }

    //metodo que implementa la acción de imprimir de un objeto que implementa la interfaz de Imprimible
    //cualquier objeto que implementa la interfaz imprimible
    //ya que una interfaz define lo que una clase puede hacer
    public static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }

}
