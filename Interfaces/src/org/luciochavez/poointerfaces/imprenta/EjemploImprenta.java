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

        //cv e info pueden pasarse al metodo imprimir porque ambos heredan de Hoja
        imprimir(cv);
        imprimir(info);

    }

    //metodo que implementa la acción de imprimir de un objeto que hereda de Hoja
    public static void imprimir(Hoja imprimible){
        System.out.println(imprimible.imprimir());
    }

}
